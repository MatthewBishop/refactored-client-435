package org.runejs.client.audio.core;

/**
 * This is a duplicate class that was created so the audio engine will be standalone.
 *
 */
public class Node {

    public long key;
    public Node next;
    public Node previous;

    public boolean hasPrevious() {
        return previous != null;
    }

    public void remove() {
        if(previous != null) {
            previous.next = next;
            next.previous = previous;
            previous = null;
            next = null;
        }
    }
}
