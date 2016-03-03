package Sorting;

/**
 * Created by jmmodi on 9/12/2015.
 */
public class QuickSort {


    public static void main(String[] args) {
        int a[] = {1, 9, 7, 5,5,3,4,9,3,5,7,6,9,8,4,23,1,7};
        quickSort(a, 0, a.length - 1);
        for (int i = 0; i <a.length ; i++) {
            System.out.println("a[i] = " + a[i]);
        }
    }

    private static void quickSort(int[] a, int start, int end) {
        if (end > start) {
            int partitionIndex = partition(a, start, end);
            quickSort(a, start, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {

        int pivot = a[end];
        int pIndex = start;

        for (int i = start; i <= end - 1; i++) {
            if (a[i] <= pivot) {

                int temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;

                pIndex++;
            }
        }

        int temp = a[pIndex];
        a[pIndex] = a[end];
        a[end] = temp;

        return pIndex;
    }



}
