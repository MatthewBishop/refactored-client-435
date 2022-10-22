package org.runejs.client.audio;

/**
 * This is a duplicate class that was created so the audio engine will be standalone.
 *
 */
class _LinkedList {

	_Node tail = new _Node();
    private _Node current;

   _LinkedList() {

        tail.previous = tail;
        tail.next = tail;

    }

   _Node peek() {
        _Node class40 = tail.next;
        if(tail == class40) {
            current = null;
            return null;
        }
        current = class40.next;
        return class40;
    }

   void pushBack(_Node node) {
        if(node.previous != null)
            node.remove();
        node.previous = tail.previous;
        node.next = tail;
        node.previous.next = node;
        node.next.previous = node;
    }

   void pushFront(_Node arg1) {
        if(arg1.previous != null)
            arg1.remove();
        arg1.next = tail.next;
        arg1.previous = tail;
        arg1.previous.next = arg1;
        arg1.next.previous = arg1;
    }

   void clear() {
        for(; ; ) {
            _Node class40 = tail.next;
            if(class40 == tail)
                break;
            class40.remove();
        }
    }

   _Node next() {
        _Node class40 = current;
        if(tail == class40) {
            current = null;
            return null;
        }
        current = class40.next;
        return class40;
    }

   void addBefore(_Node before, _Node inserted) {
        if(inserted.previous != null)
            inserted.remove();
        inserted.next = before;
        inserted.previous = before.previous;
        inserted.previous.next = inserted;
        inserted.next.previous = inserted;
    }

}