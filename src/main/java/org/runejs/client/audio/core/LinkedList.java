package org.runejs.client.audio.core;

/**
 * This is a duplicate class that was created so the audio engine will be standalone.
 *
 */
public class LinkedList {

	public Node aClass40_1056 = new Node();
    private Node aClass40_1068;

    public LinkedList() {

        aClass40_1056.previous = aClass40_1056;
        aClass40_1056.next = aClass40_1056;

    }

    public Node first() {
        Node class40 = aClass40_1056.next;
        if(aClass40_1056 == class40) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.next;
        return class40;
    }

    public void pushBack(Node node) {
        if(node.previous != null)
            node.remove();
        node.previous = aClass40_1056.previous;
        node.next = aClass40_1056;
        node.previous.next = node;
        node.next.previous = node;
    }

    public void method905(Node arg1) {
        if(arg1.previous != null)
            arg1.remove();
        arg1.next = aClass40_1056.next;
        arg1.previous = aClass40_1056;
        arg1.previous.next = arg1;
        arg1.next.previous = arg1;
    }

    public void clear() {
        for(; ; ) {
            Node class40 = aClass40_1056.next;
            if(class40 == aClass40_1056)
                break;
            class40.remove();
        }
    }

    public Node next() {
        Node class40 = aClass40_1068;
        if(aClass40_1056 == class40) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.next;
        return class40;
    }

    public void method911(Node arg1, Node arg2) {
        if(arg2.previous != null)
            arg2.remove();
        arg2.next = arg1;
        arg2.previous = arg1.previous;
        arg2.previous.next = arg2;
        arg2.next.previous = arg2;
    }

}