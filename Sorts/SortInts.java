package Sorts;

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

    
}