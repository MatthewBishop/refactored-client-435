package org.runejs.client.audio;

/**
 * This is a duplicate class that was created so the audio engine will be standalone.
 *
 */
class _Node {

   long key;
   _Node next;
   _Node previous;

   boolean hasPrevious() {
        return previous != null;
    }

   void remove() {
        if(previous != null) {
            previous.next = next;
            next.previous = previous;
            previous = null;
            next = null;
        }
    }
}
