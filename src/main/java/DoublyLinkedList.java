/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/**
 *
 * @author DEI-ISEP
 * @param <E> Generic list element type
 */
public class DoublyLinkedList<E> implements Iterable<E>, Cloneable {

// instance variables of the DoublyLinkedList
    private final Node<E> header;     // header sentinel
    private final Node<E> trailer;    // trailer sentinel
    private int size = 0;       // number of elements in the list
    private int modCount = 0;   // number of modifications to the list (adds or removes)

    /**
     * Creates both elements which act as sentinels
     */
    public DoublyLinkedList() {

        header = new Node<>(null, null, null);      // create header
        trailer = new Node<>(null, header, null);   // trailer is preceded by header
        header.setNext(trailer);                    // header is followed by trailer
    }

    /**
     * Returns the number of elements in the linked list
     *
     * @return the number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty
     *
     * @return true if the list is empty, and false otherwise
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns (but does not remove) the first element in the list
     *
     * @return the first element of the list
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.next.getElement();
    }

    /**
     * Returns (but does not remove) the last element in the list
     *
     * @return the last element of the list
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.prev.getElement();
    }

// public update methods
    /**
     * Adds an element e to the front of the list
     *
     * @param e element to be added to the front of the list
     */
    public void addFirst(E e) {
        // place just after the header
        Node next_reference = header.getNext();
        Node header1 = new Node(e, null, null);
        header.setNext(header1);
        header1.setPrev(header);
        header1.setNext(next_reference);
        next_reference.setPrev(header1);
        size++;
        modCount++;
    }

    /**
     * Adds an element e to the end of the list
     *
     * @param e element to be added to the end of the list
     */
    public void addLast(E e) {
        // place just before the trailer
        Node last_reference = trailer.getPrev();
        Node trailer1 = new Node(e, null, null);
        trailer.setPrev(trailer1);
        trailer1.setNext(trailer);
        trailer1.setPrev(last_reference);
        last_reference.setNext(trailer1);
        size++;
        modCount++;
    }

    /**
     * Removes and returns the first element of the list
     *
     * @return the first element of the list
     */
    public E removeFirst() {
        if (size() != 0) {
            Node first_reference = header.getNext().getNext();
            E remove_node = header.getNext().getElement();
            header.setNext(first_reference);
            first_reference.setPrev(header);
            size--;
            modCount++;
            return remove_node;
        }
        return null;
    }

    /**
     * Removes and returns the last element of the list
     *
     * @return the last element of the list
     */
    public E removeLast() {
        if(size() != 0){
           Node last_reference = trailer.getPrev().getPrev();
        E remove_last_node = trailer.getPrev().getElement();
        trailer.setPrev(last_reference);
        last_reference.setNext(trailer);
        size--;
        modCount++;
        return remove_last_node; 
        }
        return null;
    }

// private update methods
    /**
     * Adds an element e to the linked list between the two given nodes.
     */
    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node between_node = new Node(e, null, null);
        predecessor.setNext(between_node);
        between_node.setPrev(predecessor);
        between_node.setNext(successor);
        successor.setPrev(between_node);
        size++;
        modCount++;
    }

    /**
     * Removes a given node from the list and returns its content.
     */
    public E remove(Node<E> node) {
        Node previous_ref = node.getPrev();
        Node next_ref = node.getNext();
        previous_ref.setNext(next_ref);
        next_ref.setPrev(previous_ref);
        return node.getElement();

    }

// Overriden methods        
    @Override
    public boolean equals(Object obj) {
        DoublyLinkedList <String> outro = (DoublyLinkedList<String>) obj;
        if(this.size!= outro.size)
           return false;
        Node first = this.header.getNext();
        Node second = outro.header.getNext();
        do{
            if(first.getElement() != second.getElement())
                return false;
            first = first.getNext();
            second = second.getNext();
        }while(second.getNext() != outro.trailer || first.getNext() != this.trailer);
                return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        if(this.isEmpty()) {
            return null;
        }
        DoublyLinkedList <Object> clone = new DoublyLinkedList<>();
        Node first = this.header.getNext();
        Node second = clone.header.getNext();
        do {
            clone.addBetween(first.getElement(), second.getPrev(), second.getNext());
            first = first.getNext();
            second = second.getNext();            
        }while(first.getNext() != this.trailer);
        return clone;
    }

//---------------- nested DoublyLinkedListIterator class ----------------        
    private class DoublyLinkedListIterator implements ListIterator<E> {

        private DoublyLinkedList.Node<E> nextNode, prevNode, lastReturnedNode; // node that will be returned using next and prev respectively
        private int nextIndex;  // Index of the next element
        private int expectedModCount;  // Expected number of modifications = modCount;

        public DoublyLinkedListIterator() {
            this.prevNode = header;
            this.nextNode = header.getNext();
            lastReturnedNode = null;
            nextIndex = 0;
            expectedModCount = modCount;
        }

        final void checkForComodification() {  // invalidate iterator on list modification outside the iterator
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public E next() throws NoSuchElementException {
            checkForComodification();

            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public E previous() throws NoSuchElementException {
            checkForComodification();

            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() throws NoSuchElementException {
            checkForComodification();

            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void set(E e) throws NoSuchElementException {
            if (lastReturnedNode == null) {
                throw new NoSuchElementException();
            }
            checkForComodification();

            lastReturnedNode.setElement(e);
        }

        @Override
        public void add(E e) {
            checkForComodification();

            throw new UnsupportedOperationException("Not supported yet.");
        }

    }    //----------- end of inner DoublyLinkedListIterator class ----------

//---------------- Iterable implementation ----------------
    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    public ListIterator<E> listIterator() {
        return new DoublyLinkedListIterator();
    }

//---------------- nested Node class ----------------
    private static class Node<E> {

        private E element;      // reference to the element stored at this node
        private Node<E> prev;   // reference to the previous node in the list
        private Node<E> next;   // reference to the subsequent node in the list

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) { // Not on the original interface. Added due to list iterator implementation
            this.element = element;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    } //----------- end of nested Node class ----------

}
