package collection;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AbstrDoubleList<T> implements DoubleList<T>, Serializable {

    private Node head;
    private Node tail;
    private Node actual;

    private int size;

    @Override
    public void zrus() {
        head = tail = actual = null;
        size = 0;
    }

    @Override
    public boolean jePrazdny() {
        return size == 0;
    }

    public boolean isNotEmpty() {
        return size != 0;
    }

    @Override
    public int getMohutnost() {
        return size;
    }

    @Override
    public void vlozPrvni(T data) throws NullPointerException {
        try {
            isDataNull(data, "Data is null");
        } catch (NullPointerException e) {
            System.out.println("Your input data is null");
        }
        final Node newNode = new Node(data, head, null);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void vlozPosledni(T data) throws NullPointerException {
        try {
            isDataNull(data, "Data is null");
        } catch (NullPointerException e) {
            System.out.println("Your input data is null");
        }
        final Node newNode = new Node(data, null, tail);
        if (tail == null) {
            tail = newNode;
            head = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void vlozNaslednika(T data) throws KolekceException, NullPointerException {
        try {
            isDataNull(data, "Data is null");
        } catch (NullPointerException e) {
            System.out.println("Your input data is null");
        }
        isActualNull("Actual element is null");
        if (actual == tail) {
            vlozPosledni(data);
        } else {
            final Node nextNode = actual.next;
            final Node newNode = new Node(data, nextNode, actual);
            actual.next = newNode;
            if (nextNode == null) {
                tail = newNode;
            } else {
                nextNode.prev = newNode;
            }
            size++;
        }
    }

    @Override
    public void vlozPredchudce(T data) throws KolekceException, NullPointerException {
        try {
            isDataNull(data, "Data is null");
        } catch (NullPointerException e) {
            System.out.println("Your input data is null");
        }
        isActualNull("Actual element is null");
        if (actual == head) {
            vlozPrvni(data);
        } else {
            final Node prevNode = actual.prev;
            final Node newNode = new Node(data, actual, prevNode);
            actual.prev = newNode;
            if (prevNode == null) {
                head = newNode;
            } else {
                prevNode.next = newNode;
            }
            size++;
        }
    }

    @Override
    public T zpristupniAktualni() throws NoSuchElementException, KolekceException {
        isEmptyListNSEE("Empty list");
        isActualNull("Actual element is null");
        return actual.element;
    }

    @Override
    public T zpristupniPrvni() throws NoSuchElementException {
        isEmptyListNSEE("Empty list");
        actual = head;
        return head.element;
    }

    @Override
    public T zpristupniPosledni() throws NoSuchElementException {
        isEmptyListNSEE("Empty list");
        actual = tail;
        return tail.element;
    }

    @Override
    public T zpristupniNaslednika() throws NoSuchElementException, KolekceException {
        isActualNull("Actual element is null");
        if (actual.next == null) {
            throw new NoSuchElementException("Next element after actual is null");
        }
        actual = actual.next;
        return actual.element;
    }

    @Override
    public T zpristupniPredchudce() throws NoSuchElementException, KolekceException {
        isActualNull("Actual element is null");
        if (actual.prev == null) {
            throw new NoSuchElementException("Next element after actual is null");
        }
        actual = actual.prev;
        return actual.element;
    }

    @Override
    public T odeberAktualni() throws KolekceException, NoSuchElementException {
        isEmptyListNSEE("Enmpty list");
        isActualNull("Actual element is null");
        final T element = actual.element;
        unlink(actual);
        return element;
    }

    @Override
    public T odeberPrvni() throws KolekceException {
        isEmptyListKE("Empty list");
        if (head == actual) {
            if (head.next != null) {
                actual = head.next;
            }
        }
        final T element = head.element;
        final Node next = head.next;
        head.element = null;
        head.next = null;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.prev = null;
        }
        size--;
        return element;
    }

    @Override
    public T odeberPosledni() throws KolekceException {
        isEmptyListKE("Empty list");
        if (tail == actual) {
            if (tail.prev != null) {
                actual = tail.prev;
            }
        }
        final T element = tail.element;
        final Node prev = tail.prev;
        tail.element = null;
        tail.prev = null;
        tail = prev;
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }
        size--;
        return element;
    }

    @Override
    public T odeberNaslednika() throws KolekceException, NoSuchElementException {
        isEmptyListNSEE("Empty list");
        if (head.next == null) {
            throw new NoSuchElementException("List contains only one element.");
        }
        isActualNull("Actual element is null");
        if (actual.next == null) {
            throw new NoSuchElementException("Next element is null.");
        }
        if (head == tail) {
            final T element = head.element;
            zrus();
            return element;
        }
        if (actual.next == tail) {
            return odeberPosledni();
        } else {
            final T element = actual.next.element;
            actual.next.next.prev = actual;
            actual.next = actual.next.next;
            size--;
            return element;
        }
    }

    @Override
    public T odeberPredchudce() throws KolekceException, NoSuchElementException {
        isEmptyListNSEE("Empty list");
        if (tail.prev == null) {
            throw new NoSuchElementException("List contains only one element.");
        }
        isActualNull("Actual element is null");
        if (actual.prev == null) {
            throw new NoSuchElementException("Previous element is null");
        }
        if (head == tail) {
            final T element = head.element;
            zrus();
            return element;
        }
        if (actual.prev == head) {
            return odeberPrvni();
        } else {
            final T element = actual.prev.element;
            actual.prev.prev.next = actual;
            actual.prev = actual.prev.prev;
            size--;
            return element;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node currentNode = head;
            Node deletedNode = null;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (currentNode == null) {
                    throw new NoSuchElementException("The list is ended");
                }
                final T element = currentNode.element;
                deletedNode = currentNode;
                currentNode = currentNode.next;
                return element;
            }

            @Override
            public void remove() {
                unlink(deletedNode);
            }
        };
    }

    private void unlink(final Node node) {
        final Node next = node.next;
        final Node prev = node.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.element = null;
        actual = head;
        size--;
    }

    private void isEmptyListNSEE(final String message) {
        if (jePrazdny()) {
            throw new NoSuchElementException(message);
        }
    }

    private void isEmptyListKE(final String message) {
        if (jePrazdny()) {
            throw new KolekceException(message);
        }
    }

    private void isActualNull(final String message) {
        if (actual == null) {
            throw new KolekceException(message);
        }
    }

    private void isDataNull(final T data, final String message) {
        if (data == null) {
            throw new NullPointerException(message);
        }
    }

    private class Node implements Serializable {

        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
