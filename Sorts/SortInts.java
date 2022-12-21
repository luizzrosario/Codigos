package Sorts;

import java.util.Arrays;

public class SortInts {

    public static void selectionSort(int l[]) {
        int tam = l.length;
        int aux;
        for (int j = 0; j < tam - 1; j++) {
            int minIndex = j;
            for (int i = j; i < tam; i++) {
                if (l[i] < l[minIndex]) {
                    minIndex = i;
                }
            }
            if (l[j] > l[minIndex]) {
                aux = l[j];
                l[j] = l[minIndex];
                l[minIndex] = aux;
            }
        }
    }
    // Complexidade O(n²)
    // Espaço: O(n)

    public static void bubbleSort(int l[]) {
        int tam = l.length;
        int aux;
        for (int j = 0; j < tam - 1; j++) {
            for (int i = 0; i < tam - 1; i++) {
                if (l[i] > l[i + 1]) {
                    aux = l[i + 1];
                    l[i + 1] = l[i];
                    l[i] = aux;
                }
            }
        }
    }
    // Complexidade O(n²)
    // Espaço: O(n)

    public static void insertionSort(int l[]) {
        int tam = l.length;
        for (int i = 1; i < tam; i++) {
            int analisado = l[i];
            int j = i - 1;
            while (j >= 0 && l[j] > analisado) {
                l[j + 1] = l[j];
                j = j - 1;
            }
            l[j + 1] = analisado;
        }
    }
    // Complexidade O(n²)
    // Espaço: O(n)

    public static void mergeSort(int l[]) {
        int inicio = 0;
        int fim = l.length;
        mergeSort(l, inicio, fim);
    }

    private static void mergeSort(int l[], int inicio, int fim) {
        if (fim - inicio > 1) {
            int meio = (fim + inicio) / 2;
            mergeSort(l, inicio, meio);
            mergeSort(l, meio, fim);
            merge(l, inicio, meio, fim);
        }
    }

    private static void merge(int l[], int inicio, int meio, int fim) {
        int esquerda[] = Arrays.copyOfRange(l, inicio, meio);
        int direita[] = Arrays.copyOfRange(l, meio, fim);
        int esqTopo = 0;
        int dirTopo = 0;
        for (int i = inicio; i < fim; i++) {
            if (esqTopo >= esquerda.length) {
                l[i] = direita[dirTopo];
                dirTopo++;
            } else if (dirTopo >= direita.length) {
                l[i] = esquerda[esqTopo];
                esqTopo++;
            } else if (esquerda[esqTopo] < direita[dirTopo]) {
                l[i] = esquerda[esqTopo];
                esqTopo++;
            } else {
                l[i] = direita[dirTopo];
                dirTopo++;
            }
        }
    }

    public static void quickSort(int l[]) {
        int inicio = 0;
        int fim = l.length - 1; // -1 porque O ultimo vai ser o pivô
        quickSort(l, inicio, fim);
    }

    private static void quickSort(int l[], int inicio, int fim) {
        if (inicio < fim) {
            int p = particao(l, inicio, fim);
            quickSort(l, inicio, p - 1);
            quickSort(l, p + 1, fim);
        }
    }

    private static int particao(int l[], int inicio, int fim) {
        int pivo = l[fim];
        int barraMenores = inicio;
        int aux;
        for (int barraMaiores = inicio; barraMaiores < fim; barraMaiores++) {
            if (l[barraMaiores] <= pivo) {
                aux = l[barraMaiores];
                l[barraMaiores] = l[barraMenores];
                l[barraMenores] = aux;
                barraMenores++;
            }
        }
        aux = l[barraMenores];
        l[barraMenores] = l[fim];
        l[fim] = aux;
        return barraMenores;
    }
}