package Listas.Estruturas;

public class DoubleLinkedList<T> {
    // Estrutura da lista
    public Node<T> head;
    public Node<T> tail;
    public int size;

    // Contrutor
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Adicionar primeiro
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Adiciona por ultimo
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Remove o primeiro
    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T element = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return element;
    }

    // Remove o ultimo
    public T removeLast() {
        if (tail == null) {
            return null;
        }
        T element = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return element;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> node = head;
        while (node != null) {
            str += node.data;
            node = node.next;
        }
        return str;
    }
}
