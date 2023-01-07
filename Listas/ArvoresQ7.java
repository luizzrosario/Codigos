import java.util.Arrays;

public class ArvoresQ7 {
    public static void heapify(int[] vetor, int tam, int tipo) {
        // Percorre os nós do meio para trás e aplica heapify recursivamente em cada um
        // deles
        for (int i = tam / 2 - 1; i >= 0; i--) {
            heapify(vetor, tam, i, tipo);
        }
        // Percorre o vetor do final para o início
        for (int i = tam - 1; i >= 0; i--) {
            // Troca o primeiro elemento (raiz) com o último elemento
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            // Aplica heapify na raiz
            heapify(vetor, i, 0, tipo);
        }
    }

    private static void heapify(int[] vetor, int tam, int indice, int tipo) {
        // Índice do maior elemento (ou menor, dependendo do tipo de heap) entre o nó
        // atual, o filho esquerdo e o filho direito
        int maior = indice;
        int esq = 2 * indice + 1;
        int dir = 2 * indice + 2;

        // Verifica qual é o maior elemento (ou menor, dependendo do tipo de heap) entre
        // o nó atual, o filho esquerdo e o filho direito
        if (tipo == 1) {
            if (esq < tam && vetor[esq] > vetor[maior]) {
                maior = esq;
            }
            if (dir < tam && vetor[dir] > vetor[maior]) {
                maior = dir;
            }
        } else {
            if (esq < tam && vetor[esq] < vetor[maior]) {
                maior = esq;
            }
            if (dir < tam && vetor[dir] < vetor[maior]) {
                maior = dir;
            }
        }

        // Se o nó atual não é o maior elemento (ou menor, dependendo do tipo de heap),
        // troca com o maior elemento (ou menor) e aplica heapify recursivamente
        if (maior != indice) {
            int temp = vetor[indice];
            vetor[indice] = vetor[maior];
            vetor[maior] = temp;

            heapify(vetor, tam, maior, tipo);
        }
    }

    public static void main(String[] args) {
        int[] vetor = { 5, 3, 2, 1, 4, 7, 10, 20, 30, 8, 9};
        int tam = vetor.length;

        heapify(vetor, tam, 1); // transforma o vetor em um minheap

        System.out.println("MinHeap: " + Arrays.toString(vetor));

        heapify(vetor, tam, 2); // transforma o vetor em um maxheap

        System.out.println("MaxHeap: " + Arrays.toString(vetor));
    }
}
