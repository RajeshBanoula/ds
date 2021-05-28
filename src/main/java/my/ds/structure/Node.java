package my.ds.structure;

public class Node<E> {

    Node<E> next;
    E element;

    public Node(E element, Node<E> node) {
        this.element = element;
        this.next = node;
    }

}
