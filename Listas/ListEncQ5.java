package Listas;

import Listas.Estruturas.*;

public class ListEncQ5 {
    public static boolean ehPalindromoIterativo(DoubleLinkedList<Character> list) {
        // Pega o char head e o char tail da lista para serem analisados
        Node<Character> head = list.head;
        Node<Character> tail = list.tail;

        /*
         * Enquanto o head e o tail forem diferentes e até o anterior ao head não ser o
         * tail (já que uma hora ultrapassamos a metade em ambos os lados, o tail vai
         * pra frente e o head fica atrás), continuamos analisando
         * Caso o data do Nó seja diferente retorna falso
         * Se não, fechamos o loop e retornamos true
         */
        while (head != tail && head.prev != tail) {
            if (head.data != tail.data) {
                return false;
            }
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }

    // Sobrecarga que é utilizada pra recursão
    public static boolean ehPalindromoRecursivo(Node<Character> head, Node<Character> tail) {
        // Se o head e o tail forem iguais ou o anterior ao head for o tail (pelo msm
        // motivo que expliquei no iterativo) retornamos true
        if (head == tail || head.prev == tail) {
            return true;
        }
        // Se o data dos analisados por diferente, retornamos false
        if (head.data != tail.data) {
            return false;
        }
        // Se nenhum dos ifs for ativado, avançamos 1 no head e pegamos o anterior ao
        // tail
        return ehPalindromoRecursivo(head.next, tail.prev);
    }

    // função real
    public static boolean ehPalindromoRecursivo(DoubleLinkedList<Character> list) {
        return ehPalindromoRecursivo(list.head, list.tail);
    }

    public static void main(String[] args) {
        DoubleLinkedList<Character> list = new DoubleLinkedList<>();
        list.addLast('O');
        list.addLast('M');
        list.addLast('I');
        list.addLast('S');
        list.addLast('S');
        list.addLast('I');
        list.addLast('S');
        list.addLast('S');
        list.addLast('I');
        list.addLast('M');
        list.addLast('O');

        DoubleLinkedList<Character> list2 = new DoubleLinkedList<>();
        list2.addLast('B');
        list2.addLast('A');
        list2.addLast('H');
        list2.addLast('I');
        list2.addLast('A');

        System.out.println("Iterativa:");

        if (ehPalindromoIterativo(list)) {
            System.out.println("A palavra " + list.toString() + " é um palíndromo");
        } else {
            System.out.println("A palavra " + list.toString() + " não é um palíndromo");
        }
        if (ehPalindromoIterativo(list2)) {
            System.out.println("A palavra " + list2.toString() + " é um palíndromo");
        } else {
            System.out.println("A palavra " + list2.toString() + " não é um palíndromo");
        }

        System.out.println("Recursiva:");
        if (ehPalindromoRecursivo(list)) {
            System.out.println("A palavra " + list.toString() + " é um palíndromo");
        } else {
            System.out.println("A palavra " + list.toString() + " não é um palíndromo");
        }
        if (ehPalindromoRecursivo(list2)) {
            System.out.println("A palavra " + list2.toString() + " é um palíndromo");
        } else {
            System.out.println("A palavra " + list2.toString() + " não é um palíndromo");
        }
    }
}
