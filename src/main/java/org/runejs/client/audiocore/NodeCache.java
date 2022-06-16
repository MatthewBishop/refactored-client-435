package org.runejs.client.audiocore;

public class NodeCache {

    private CachedNode cachedNode = new CachedNode();
    private int remaining;
    private int size;
    private HashTable hashTable;
    private NodeQueue nodeQueue = new NodeQueue();

    public NodeCache(int size) {
        this.size = size;
        int i;
        i = 1;
        while(i + i < size) {
            i += i;
        }
        remaining = size;

        hashTable = new HashTable(i);
    }


    public void put(long key, CachedNode node) {
        if(remaining == 0) { // no more space, make some room
            CachedNode cachedNode = nodeQueue.pop();
            cachedNode.remove();
            cachedNode.clear();
            if(cachedNode == this.cachedNode) {
                cachedNode = nodeQueue.pop();
                cachedNode.remove();
                cachedNode.clear();
            }
        } else {
            remaining--;
        }

        hashTable.put(key, node);
        nodeQueue.push(node);
    }

    public CachedNode get(long key) {
        CachedNode cachedNode = (CachedNode) hashTable.getNode(key);
        if(cachedNode != null)
            nodeQueue.push(cachedNode);
        return cachedNode;
    }

    public void remove(long key) {
        CachedNode cachedNode = (CachedNode) hashTable.getNode(key);
        if(cachedNode == null)
            return;
        cachedNode.remove();
        cachedNode.clear();
        remaining++;
    }

    public void clear() {
        for(; ; ) {
            CachedNode cachedNode = nodeQueue.pop();
            if(cachedNode == null)
                break;
            cachedNode.remove();
            cachedNode.clear();
        }
        remaining = size;
    }
    
    private static class HashTable {
        private int size;
        private Node lastFetchedNode;
        private Node[] nodes;
        private HashTable(int size) {
            this.size = size;
            nodes = new Node[size];

            for(int i = 0; size > i; i++) {
                Node node = nodes[i] = new Node();
                node.next = node;
                node.previous = node;
            }
        }

        private void put(long key, Node node) {
            if(node.previous != null) {
                node.remove();
            }
            Node node1 = nodes[(int) ((long) (-1 + size) & key)];
            node.next = node1;
            node.key = key;
            node.previous = node1.previous;
            node.previous.next = node;
            node.next.previous = node;
        }

        private Node getNode(long key) {
            Node node = nodes[(int) ((long) (size + -1) & key)];
            for(lastFetchedNode = node.next; node != lastFetchedNode; lastFetchedNode = lastFetchedNode.next) {
                if(lastFetchedNode.key == key) {
                    Node foundNode = lastFetchedNode;
                    lastFetchedNode = lastFetchedNode.next;
                    return foundNode;
                }
            }
            lastFetchedNode = null;
            return null;
        }
    }

    private class NodeQueue {

        private CachedNode head = new CachedNode();

        private NodeQueue() {
            head.previousCachedNode = head;
            head.nextCachedNode = head;
        }

        private CachedNode pop() {
            CachedNode nextNode = this.head.nextCachedNode;
            if(nextNode == this.head) {
                return null;
            }
            nextNode.clear();
            return nextNode;
        }

        private void push(CachedNode cachedNode) {
            if(cachedNode.previousCachedNode != null) {
                cachedNode.clear();
            }
            cachedNode.nextCachedNode = head;
            cachedNode.previousCachedNode = head.previousCachedNode;
            cachedNode.previousCachedNode.nextCachedNode = cachedNode;
            cachedNode.nextCachedNode.previousCachedNode = cachedNode;
        }
    }

}
