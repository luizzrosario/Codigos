import Estruturas.*;

public class ArvoresQ3<T> {
    public static void main(String[] args) {
        BinaryTree<Integer> arvore = new BinaryTree<Integer>();

        arvore.insert(10);
        arvore.insert(5);
        arvore.insert(15);
        arvore.insert(2);
        arvore.insert(6);
        arvore.insert(14);
        arvore.insert(17);

        System.out.println("Altura: " +arvore.alturaArvoreBinaria());
        System.out.println("Tamanho: "+arvore.getSize());
        System.out.println("\nOrdens: (A raiz é o 10) ");
        arvore.printInOrder();
        arvore.printPostOrder();
        arvore.printPreOrder();
    }
}