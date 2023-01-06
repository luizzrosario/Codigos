package Listas.Estruturas;

public class List<T> {
    // O array que armazena os elementos da lista
    private T[] elementos;

    // O número de elementos da lista
    private int size;

    // Construtor que cria uma lista vazia com o tamanho inicial especificado
    @SuppressWarnings("unchecked") // Faz o programa parar de reclamar do casting da array de objetos
    public List(int initialCapacity) {
        elementos = (T[]) new Object[initialCapacity]; // Casting de uma array de objetos para uma de elemento genérico
        size = 0;
    }

    // Construtor que cria uma lista vazia com tamanho inicial padrão de 10
    public List() {
        this(10);
    }

    // Adiciona um elemento à lista
    public void add(T elemento) {
        // Verifica se o array precisa ser redimensionado
        if (size == elementos.length) {
            resize();
        }
        elementos[size] = elemento;
        size++;
    }

    // Remove o elemento na posição especificada e o retorna
    public T remove(int index) {
        // Verifica se o índice é válido
        if (index < 0 || index >= size) {
            System.out.println("Índice inválido");
            return null;
        }
        // Armazena o elemento a ser removido
        T elemento = elementos[index];
        // Desloca os elementos para trás para preencher o espaço vago
        for (int i = index; i < size - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        size--;
        // Retorna o elemento removido
        return elemento;
    }

    // Retorna o elemento na posição especificada
    public T get(int index) {
        // Verifica se o índice é válido
        if (index < 0 || index >= size) {
            System.out.println("Índice inválido");
            return null;
        }
        return elementos[index];
    }

    // Retorna o tamanho atual da lista
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // Redimensiona o array para o dobro do tamanho atual caso falte espaço (não
    // precisar fazer várias vezes)
    @SuppressWarnings("unchecked") // Tirar o erro
    private void resize() {
        T[] temp = (T[]) new Object[elementos.length * 2];
        // Passa todos os elementos da array para a maior
        for (int i = 0; i < elementos.length; i++) {
            temp[i] = elementos[i];
        }
        elementos = temp;
    }

    // Põe em string o conteudo da lista
    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += elementos[i];
            if (i < size - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }
}
