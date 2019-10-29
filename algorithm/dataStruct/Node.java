public class Node {
    Object element;
    Node next;

    public Node (Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return this.element;
    }

    public Node getNext() {
        return this.next;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
