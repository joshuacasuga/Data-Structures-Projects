
//
//  Name:       Casuga, Joshua
//  Project:    #5
//  Due:        12/9/2022
//  Course:     cs-2400-01-f22
//
//  Description: A LinkedList class that includes implementation for an iterator.
//
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    public LinkedListWithIterator() {
        initializeDataFields();
    }

    private Node getNodeAt(int givenPosition) {
        Node currentNode = firstNode;
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode);
        }
        numberOfEntries++;
    }

    public void add(int newPosition, T newEntry) {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);
            if (newPosition == 1) {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
            numberOfEntries++;
            ;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    }

    public T remove(int givenPosition) {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 1) {
                result = firstNode.getData();
                firstNode = firstNode.getNextNode();
            } else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData();
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
            }
            numberOfEntries--;
            return result;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }
    }

    public void clear() {
        initializeDataFields();
    }

    public T replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }
    }

    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return getNodeAt(givenPosition).getData();
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    public boolean contains(T anEntry) {
        // TODO Auto-generated method stub
        return false;
    }

    public int getLength() {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public Iterator<T> iterator() {
        return new IteratorForLinkedList();
    }

    public Iterator<T> getIterator() {
        return iterator();
    }

    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    private class IteratorForLinkedList implements Iterator<T> {
        private Node nextNode;

        private IteratorForLinkedList() {
            nextNode = firstNode;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            T result;
            if (hasNext()) {
                result = nextNode.getData();
                nextNode = nextNode.getNextNode();
            } else {
                throw new NoSuchElementException("Illegal call to next(); " +
                        "iterator is after end of list.");
            }
            return result;
        }
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        private T getData() {
            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }
}
