package Listas;

import java.util.Arrays;

public class OrdenacaoQ1 {
    // Classe pessoa
    public static class Pessoa {
        int matricula;
        String nome;
        float nota;

        public Pessoa(int matricula, String nome, float nota) {
            this.matricula = matricula;
            this.nome = nome;
            this.nota = nota;
        }

        @Override
        public String toString() {
            String str = "\nMatricula: " + matricula + " | Nome: " + nome + " | Nota: " + nota;
            return str;
        }
    }

    // Comparador que vai dizer qual parte a gente vai analisar
    // 1 - Matricula, 2 - Nome e 3 - Nota
    private static int compare(Pessoa p1, Pessoa p2, int modo) {
        switch (modo) {
            case 1: // matricula
                return Integer.compare(p1.matricula, p2.matricula);
            case 2: // nome
                return p1.nome.compareTo(p2.nome); // Como o String já tem o compareTo, ele é diferente
            case 3: // nota
                return Float.compare(p1.nota, p2.nota);
            default:
                return 0;
        }
    }

    // Pra não fazer tanto swap nas ordenações
    private static void swap(Pessoa[] array, int i, int j) {
        Pessoa temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /* -- SelectionSort -- */
    public static void selectionSort(Pessoa[] array, int modo) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (compare(array[j], array[minIndex], modo) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    /* -- InsertionSort -- */
    public static void insertionSort(Pessoa[] array, int modo) {
        for (int i = 1; i < array.length; i++) {
            Pessoa key = array[i];
            int j = i - 1;
            while (j >= 0 && compare(array[j], key, modo) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /* -- MergeSort -- */
    public static void mergeSort(Pessoa[] array, int modo) {
        mergeSort(array, 0, array.length - 1, modo);
    }

    // Divisão da array
    private static void mergeSort(Pessoa[] array, int left, int right, int modo) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, modo);
            mergeSort(array, mid + 1, right, modo);
            merge(array, left, mid, right, modo);
        }
    }

    // Merge
    private static void merge(Pessoa[] array, int left, int mid, int right, int modo) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        Pessoa[] leftArray = new Pessoa[leftSize];
        Pessoa[] rightArray = new Pessoa[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (compare(leftArray[i], rightArray[j], modo) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /* -- QuickSort -- */
    public static void quickSort(Pessoa[] array, int modo) {
        quickSort(array, 0, array.length - 1, modo);
    }

    // Divisão do Quick
    private static void quickSort(Pessoa[] array, int left, int right, int modo) {
        if (left < right) {
            int pivotIndex = partition(array, left, right, modo);
            quickSort(array, left, pivotIndex - 1, modo);
            quickSort(array, pivotIndex + 1, right, modo);
        }
    }

    // Partição do quick
    private static int partition(Pessoa[] array, int left, int right, int modo) {
        int pivotIndex = (left + right) / 2;
        Pessoa pivot = array[pivotIndex];
        swap(array, pivotIndex, right); // Move o pivô pro fim enquanto compara
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (compare(array[i], pivot, modo) < 0) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, storeIndex, right); // Movo o pivo pra posição certa
        return storeIndex;
    }

    /* -- HeapSort -- */
    // Usei heapfy por praticidade
    public static void heapSort(Pessoa[] array, int modo) {
        int n = array.length;

        // build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, modo);
        }

        // sort
        for (int i = n - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0, modo);
        }
    }

    private static void heapify(Pessoa[] array, int n, int i, int modo) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && compare(array[left], array[largest], modo) > 0) {
            largest = left;
        }
        if (right < n && compare(array[right], array[largest], modo) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest, modo);
        }
    }

    public static void main(String[] args) {
        Pessoa[] alunos = {
                new Pessoa(123456, "Aabraão", 8.5f),
                new Pessoa(789101, "Zezinho", 7.0f),
                new Pessoa(987654, "Eudasilva", 0f),
                new Pessoa(220903, "Luiz", 6.5f)
        };

        System.out.println("\nSelection matricula");
        selectionSort(alunos, 1); // Selection (Por matricula)
        System.out.println(Arrays.toString(alunos));

        System.out.println("\nInsertion nome");
        insertionSort(alunos, 2); // Insertion (Por nome)
        System.out.println(Arrays.toString(alunos));

        System.out.println("\nMerge nome");
        mergeSort(alunos, 2); // Merge (por nome)
        System.out.println(Arrays.toString(alunos));

        System.out.println("\nQuick matricula");
        quickSort(alunos, 1); // Quick (Por matricula)
        System.out.println(Arrays.toString(alunos));

        System.out.println("\nHeap nota");
        heapSort(alunos, 3); // Heap (Por nota)
        System.out.println(Arrays.toString(alunos));
    }
}
