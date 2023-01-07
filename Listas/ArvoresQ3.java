import Estruturas.*;

public class ArvoresQ3<T>{
    public static void main(String[] args) {
        BinaryTree<Integer> arvore = new BinaryTree<Integer>();

        arvore.insert(4);
        arvore.insert(6);
        arvore.insert(3);
        arvore.insert(1);
        arvore.insert(5);
        arvore.insert(2);
        arvore.insert(8);
        arvore.insert(7);


        System.out.println(arvore.alturaArvoreBinaria());
        System.out.println(arvore.getSize());
        arvore.printInOrder();
        arvore.printPostOrder();
        arvore.printPreOrder();
    }
}