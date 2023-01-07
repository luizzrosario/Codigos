import Estruturas.*;

public class ArvoresQ6 {
    public static void main(String[] args) {
        /* Arvore aleatória */
        BinaryTree<Integer> arvore = new BinaryTree<>();
        arvore.insert(10);
        arvore.insert(5);
        arvore.insert(15);
        arvore.insert(3);
        arvore.insert(7);
        arvore.insert(12);
        arvore.insert(20);
        int resultado = arvore.verificaHeap();
        System.out.println("Arvore 1: "+resultado);


        BinaryTree<Integer> maxHeap = new BinaryTree<>();
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(3);
        int resultado2 = maxHeap.verificaHeap();
        System.out.println("Arvore 1: "+resultado2);
    }
}