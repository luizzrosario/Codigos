package Estruturas;

public class Stack<T> extends List<T> {
  // Construtor que cria uma pilha vazia com tamanho inicial padrão de 10
  public Stack() {
    super();
  }

  // Adiciona um elemento na pilha
  public void push(T elemento) {
    add(elemento);
  }

  // Remove e retorna um elemento da pilha
  public T pop() {
    // Verifica se a pilha está vazia
    if (isEmpty()) {
      System.out.println("Pilha vazia");
      return null;
    }
    return remove(size() - 1);
  }

  // Olha o elemento do topo da pilha
  public T topo() {
    // Verifica se a pilha está vazia
    if (isEmpty()) {
      return null;
    }
    // Retorna o último elemento da pilha
    return get(size() - 1);
  }

  // Diz se a pilha está vazia
  public boolean isEmpty() {
    return super.isEmpty();
  }

  // Retorna o tamanho da pilha
  public int size() {
    return super.size();
  }

  // toString da pilha
  public String toString() {
    return super.toString();
  }
}
