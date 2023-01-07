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
        int result = arvore.verificaHeap(arvore.root);
        if (result == 0) {
            System.out.println("A arvore não é um heap");
        } else if (result == -1) {
            System.out.println("A arvore é um min heap");
        } else if (result == 1) {
            System.out.println("A arvore é um max heap");
        }

        BinaryTree<Integer> maxHeap = new BinaryTree<>();
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(3);
        result = maxHeap.verificaHeap(maxHeap.root);
        if (result == 0) {
            System.out.println("A arvore não é um heap");
        } else if (result == -1) {
            System.out.println("A arvore é um min heap");
        } else if (result == 1) {
            System.out.println("A arvore é um max heap");
        }

        BinaryTree<Integer> minHeap = new BinaryTree<>();
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(1);
        maxHeap.insert(2);
        result = minHeap.verificaHeap(minHeap.root);
        if (result == 0) {
            System.out.println("A arvore não é um heap");
        } else if (result == -1) {
            System.out.println("A arvore é um min heap");
        } else if (result == 1) {
            System.out.println("A arvore é um max heap");
        }
    }
}