/* LinkList class shall have two instance variables as well.
an IntegerNode named "head" an integer named numberOfObjects representing the
number of items in the linked list
 */
public class LinkedList <T> implements List<T> {

    public class Node {

        private Object data;

        private Node next;

        public Node() {
            this.data = 0;
            this.next = null;
        }

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private int size = 0;
    private Node head = null;

    public LinkedList() { //constructor sets the size to 0 and head to null
        size = 0;
        head = null;
    }

    public Node getNode(int pos) {
        Node node = head;
        for (int i = 0; i < pos; i++) {
            node = node.getNext();
        }
        return node;
    }



    @Override
    public void add(int pos, T item) {

            if (pos == 0) {
                Node node = new Node();
                node.data = item;
                node.next = head;
                head = node;
                size++;
            }

            else {
                Node previous = getNode(pos - 1);
                Node node = new Node();
                node.data = item;
                node.next = previous.next;
                previous.next = node;
                ++size;
            }
        }

    @Override
    public void add(T item) {
        Node intone = new Node(item);
        intone.setNext(head);
        head = intone;
        size++;
    }

    @Override
    public T get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Size Greater");
            }
        Node curr = getNode(pos);
        return (T) curr.data;
    }

    @Override
    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Size Greater");
        }

        if (pos == 0) {
            Node curr = head;
            head = head.getNext();
            --size;
            return (T) curr.data;
            }

        else {
            Node previous = getNode(pos-1);
            Node curr = previous.next;
            previous.next = curr.next;
            --size;
            return (T) curr.data;
            }
    }

    public String toString() {
        String listString = "";
        Node current = head;
        while (current != null) {
            listString += current.getData() + "\n";
            current = current.getNext();
        }
        return listString;
    }



    @Override
    public int size() {
        return size;
    }


}

