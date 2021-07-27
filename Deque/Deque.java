/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int n;
    private Node first, last;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) { // push
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (isEmpty()) {
            last = first;
        }
        else {
            oldfirst.prev = first;
        }
        n++;

        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item");
        }
    }

    // add the item to the back
    public void addLast(Item item) { // enqueue
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.prev = oldlast;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }
        n++;
        if (item == null) throw new NullPointerException();
    }

    // remove and return the item from the front
    public Item removeFirst() {


        if (isEmpty()) throw new NoSuchElementException();

        Item item = first.item;
        first = first.next;

        n--;

        if (isEmpty()) {
            last = first;
        }
        else {
            first.prev = null;
        }

        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {

        if (isEmpty()) throw new NoSuchElementException();

        Item item = last.item;
        last = last.prev;
        n--;
        if (isEmpty()) {
            first = last;
        }
        else {
            last.next = null;
        }

        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();

    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            if (null == current)
                throw new NoSuchElementException();

            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();

        }


    }

    public static void main(String[] args) {

        Deque<String> dq = new Deque<String>();
        StdOut.println(dq.isEmpty());
        StdOut.println(dq.size());


        dq.addLast("Data");
        dq.addLast("Structures");
        StdOut.println(dq.size());
        StdOut.println(dq.removeFirst());
        StdOut.println(dq.removeFirst());

        dq.addFirst("Love");
        dq.addFirst("Computer");
        dq.addFirst("Program");
        StdOut.println(dq.removeLast());
        StdOut.println(dq.removeLast());
        StdOut.println(dq.removeLast());
        StdOut.println(dq.size());

    }
}
