import Sorts.SortInts;
import java.util.Random;

public class Teste {
    public static void main(String[] args) {
        Random random = new Random();
        int[] list = new int[20];

        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextInt(101);
        }

        for (int i = 0; i < list.length; i++) {
            System.out.print("|" + list[i]);
        }
        System.out.println();

        // SortInts.selectionSort(list);
        SortInts.bubbleSort(list);

        for (int i = 0; i < list.length; i++) {
            System.out.print("|" + list[i]);
        }
    }

}
