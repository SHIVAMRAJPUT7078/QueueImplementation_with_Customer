package definition;

import adt.QueueADT;

import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueADT<E> {
    private Node<E> front = null;
    private Node<E> rear = null;
    private int size = 0;

    public int sizeOfList() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean addFirst(E item) {
        if (front == null) {
            Node<E> node = new Node<>(null, item, front);
            front = node;
            rear = node;
        } else {
            Node<E> node = new Node<>(null, item, front);
            front.previous = node;
            front = node;

        }
        size++;
        return true;
    }

    private boolean addAfter(Node<E> node, E item) {
        Node<E> nextNode = node.getNext();
        if (nextNode == null) {
            Node<E> newNode = new Node<>(node, item, null);
            node.next = newNode;
            rear = newNode;
        } else {
            Node<E> newNode = new Node<>(node, item, nextNode);
            node.next = newNode;
            nextNode.previous = newNode;
        }
        size++;
        return true;
    }


    public void printFirst() {
        //E data = front.getData();
        System.out.println(front.getData());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        Node<E> currentNode = front;
        for (int i = 0; i < size && currentNode != null; i++) {
            E data = currentNode.getData();
            sb.append(data);
            sb.append(i < size - 1 ? ", " : "");
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }


    private Node<E> getNode(int index) {
        Node<E> response = front;
        for (int i = 0; i < index && response != null; i++) {
            response = response.getNext();
        }
        return response;
    }


    /*private boolean add(int index, E item) {
return false;
    }
*/
    public boolean add(E item) {
        return add(size, item);
    }

    public boolean add(int index, E item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            return addFirst(item);
        } else {
            return addAfter(getNode(index - 1), item);
        }
    }

    @Override
    public E remove() {
        E response = null;
        Node<E> temp = front;
        if (temp != null) {
            response = temp.getData();
            front = front.getNext();
            size--;
        }
        return response;
    }

    @Override
    public E peek() {
        E response = null;
        if (this.isEmpty()) {
            throw new NoSuchElementException("No element in the queue");
        } else {
            Node<E> frontNode = front;
            response = frontNode.getData();
        }
        return response;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    private static class Node<E> {
        private E data;
        private Node<E> previous;
        private Node<E> next;

        private Node(Node<E> previous, E data, Node<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        private E getData() {
            return data;
        }

        private Node<E> getPrevious() {
            return previous;
        }

        private Node<E> getNext() {
            return next;
        }
    }
}
