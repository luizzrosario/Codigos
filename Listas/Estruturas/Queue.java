package Estruturas;

public class Queue<T> {
    private List<T> elementos;

    public Queue(int initialCapacity) {
        elementos = new List<>(initialCapacity);
    }

    public Queue() {
        this(10);
    }

    // Adiciona um elemento ao final da fila
    public void enqueue(T elemento) {
        elementos.add(elemento);
    }

    // Remove o elemento no início da fila
    public T dequeue() {
        return elementos.remove(0);
    }

    // Retorna o elemento no início da fila, sem removê-lo
    public T peek() {
        return elementos.get(0);
    }

    public int size() {
        return elementos.size();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    @Override
    public String toString() {
        return elementos.toString();
    }
}
