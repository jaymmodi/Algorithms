package Sorting;

public class MergeSortOldVersion {

    public static void mergeSort(int A[], int start, int end) {
        int mid;
        if (end > start) {
            mid = (start + end) / 2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            merge(A, start, mid, end);

        }
    }

    public static void merge(int A[], int start, int mid, int end) {
        int lengthOfArray1 = mid - start + 1;
        int lengthOfArray2 = end - mid;
        int left[] = new int[lengthOfArray1];
        int right[] = new int[lengthOfArray2];
        for (int i = 0; i < lengthOfArray1; i++) {
            left[i] = A[start + i];

        }
        for (int j = 0; j < lengthOfArray2; j++) {
            right[j] = A[j + mid + 1];
        }
        int i = 0, j = 0, k = start;
        while (i < lengthOfArray1 && j < lengthOfArray2) {
            if (left[i] <= right[j]) {
                A[k] = left[i];
                i++;
            } else {
                A[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < lengthOfArray1) {
            A[k] = left[i];
            i++;
            k++;
        }
        while (j < lengthOfArray2) {
            A[k] = right[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {

        int array[] = { 4, 9, 2, 1, 8, 7 };
        // merge(array, 0, 2, 5);
        mergeSort(array, 0, 5);
        System.out.println("over");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
