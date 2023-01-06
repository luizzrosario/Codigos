package Listas;

import java.util.Random;

import Listas.Estruturas.Stack;

public class PilhaQ4 {
    public static void embaralhar(Stack<Integer> p1, Stack<Integer> p2, Stack<Integer> p3) {
        // Cria uma pilha vazia
        Stack<Integer> baralho = new Stack<>();

        // Adiciona elementos das pilhas 1, 2 e 3 à quarta pilha de forma aleatória
        Random random = new Random();
        while (!p1.isEmpty() || !p2.isEmpty() || !p3.isEmpty()) {
            int pilhaNumero = random.nextInt(3) + 1;
            if (pilhaNumero == 1 && !p1.isEmpty()) {
                baralho.push(p1.pop());
            } else if (pilhaNumero == 2 && !p2.isEmpty()) {
                baralho.push(p2.pop());
            } else if (pilhaNumero == 3 && !p3.isEmpty()) {
                baralho.push(p3.pop());
            }
        }

        // Imprime a quarta pilha
        System.out.println(baralho.toString());
    }

    public static void main(String[] args) {
        final int TAM = 52;

        Stack<Integer> p1 = new Stack<>();
        Stack<Integer> p2 = new Stack<>();
        Stack<Integer> p3 = new Stack<>();

        // Adiciona cartas (representadas como inteiros de 1 a 52)
        // "aleatoriamente" nas pilhas
        // (Não tão aleatoriamente pois têm o padrão das menores entrarem primeiro e
        // maiores por ultimo. Mas, serve.)
        Random random = new Random();
        for (int i = 0; i < TAM; i++) {
            int pilhaNumero = random.nextInt(3) + 1;
            if (pilhaNumero == 1) {
                p1.push(i);
            } else if (pilhaNumero == 2) {
                p2.push(i);
            } else {
                p3.push(i);
            }
        }

        embaralhar(p1, p2, p3);
    }
}
