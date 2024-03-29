package linkedlist;

public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;


    public void add(T item) {
        Node<T> node = new Node(item);

        if (first == null) {
            first = node;
            last = node;
            node.prev = null;
            node.next = null;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        first = null;
        size = 0;
        return;
    }

    public T getIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + getSize());
        }

        int i = -1;
        Node<T> cur = first;

        while (cur != null) {
            if (i == index - 1) {
                return cur.getValue();
            }
            cur = cur.getNext();
            i++;
        }
        return null;
    }

    public void remove(int index) {

        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + getSize());
        }
        int i = -1;
        Node<T> cur = first;

        while (cur != null) {
            if(index != 0) {

                if (i == index - 1) {
                    if (cur.prev != null) {
                        cur.prev.next = cur.next;
                    }
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    }
                }
            }else{
                first = first.next;
                break;
            }
            cur = cur.next;
            i++;
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> cur = first;

        if (cur != null) {
            sb.append(cur.getValue() + " -> ");
            while (cur.getNext() != null) {
                sb.append(cur.getNext().getValue() + " -> ");
                cur = cur.getNext();
            }
            String result = sb.substring(0, sb.length() - 4);
            return result;
        }
        return null;

    }

    public class Node<T> {
        T value;
        Node<T> next ;
        Node<T> prev ;


        public Node(T value) {
            this.value = value;


        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}