package Listas.Estruturas;

public class CircularLinkedList<T> {
    // Classe Node (só vai servir pra essa lista mesmo já que só tem o next)
    private static class Node<T> {
        private T data;
        private Node<T> next;

        // Construtor (só precisa ser chamado de 1 forma)
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    // Só tem 2 partes: O head e o tamanho, o head que vai apontar pro proximo e o proximo pro resto.
    private Node<T> head;
    private int size;

    // Construtor
    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    // Retorna o tamanho
    public int size() {
        return size;
    }

    // Verifica se estiver vazia
    public boolean isEmpty() {
        return size == 0;
    }

    // Adiciona um elemento 
    public void add(T element) {
        // Se estiver vazia o elemento vira direto o head
        if (head == null) {
            head = new Node<>(element, null);
            head.next = head;
        } else {
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = new Node<>(element, head);
        }
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indice inválido");
            return null;
        }
        T element;
        if (index == 0) {
            element = head.data;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            element = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indice inválido");
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}
