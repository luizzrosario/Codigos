package Listas;
import java.util.Scanner;

import Listas.Estruturas.CircularLinkedList;

public class ListEncQ4 {
    public static void sorteioDoJosephus(CircularLinkedList<String> soldados, int n) {
        // Enquanto a lista tiver mais de um elemento, remover os elementos de acordo com o intervalo n
        int index = 0;
        while (soldados.size() > 1) {
            // Aquela equação para fazer o indice circular a lista corretamente
            index = (index + n - 1) % soldados.size(); 
            System.out.println(soldados.remove(index) + " morreu.");
        }
        System.out.println("Quem viveu foi: " + soldados.get(0));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os nomes dos soldados: (0 para parar)");
        CircularLinkedList<String> soldados = new CircularLinkedList<>();
        /*  Loop para pegar todos os nomes e adicionar a lista de soldados até o nome ser igual a '0', então quebra o loop e segue com o código */
        while (true) {
            String name = sc.nextLine();
            if (name.equals("0")) {
                break;
            }
            soldados.add(name);
        }
        System.out.println("Qual o valor do n:");
        int n = sc.nextInt();
        sorteioDoJosephus(soldados, n);
        sc.close();
    }
}
