package Arrays;

import java.util.Arrays;

public class BinarySearch2 {

    public static void main(String[] args) {
        int a[] = {55, 10, 9};
        Arrays.sort(a);

        System.out.println(search(a, 9));
    }

    private static boolean search(int[] a, int key) {
        return binaryHelper(a, 0, a.length - 1, key);
    }

    private static boolean binaryHelper(int[] a, int start, int end, int key) {
        if (start == end) {
            return a[start] == key;
        }

        int mid = (start + end) / 2;

        if (a[mid] == key) {
            return true;
        } else if (a[mid] > key) { // left
            return binaryHelper(a, 0, mid - 1, key);
        } else {
            return binaryHelper(a, mid + 1, end, key);
        }
    }
}
