package Misc;

public class LongestMountain {
    public static void main(String[] args) {
        int a[] = {2, 1, 4, 7, 3, 2, 5}; //5
        System.out.println(longestMountain(a));

        int b[] = {2, 2, 2}; //0
        System.out.println(longestMountain(b));

        int c[] = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0}; //11
        System.out.println(longestMountain(c));

        int d[] = {0, 1, 2, 3}; //0
        System.out.println(longestMountain(d));

        int e[] = {3, 2, 1, 0}; //0
        System.out.println(longestMountain(e));

        int f[] = {0, 1, 0, 1}; //3
        System.out.println(longestMountain(f));

        int h[] = {1, 1, 0, 0, 1, 0}; //3
        System.out.println(longestMountain(h));

        int i[] = {2, 0, 2, 2, 3}; //0
        System.out.println(longestMountain(i));

        int j[] = {2, 3, 3, 2, 0, 2}; //0
        System.out.println(longestMountain(j));

        int k[] = {875, 884, 239, 731, 723, 685}; //4
        System.out.println(longestMountain(k));
    }

    public static int longestMountain(int[] A) {
        if (A.length <= 2) {
            return 0;
        }

        if (A.length == 3) {
            if (A[0] < A[1] && A[1] > A[2]) {
                return 3;
            }
        }

        int mountainStartIndex = Integer.MAX_VALUE;
        int mountainEndIndex = 0;
        int mountainSize = 0;

        if (A[1] > A[0]) {
            mountainStartIndex = 0;
        }

        int index = 1;
        while (index <= A.length - 2) {
            if ((A[index - 1] >= A[index] && A[index] < A[index + 1])) {
                if (mountainStartIndex == Integer.MAX_VALUE) {
                    mountainStartIndex = index;
                } else {
                    if (A[index] != A[index - 1]) {
                        mountainEndIndex = index;
                        int size = mountainEndIndex - mountainStartIndex + 1;
                        if (size > mountainSize) {
                            mountainSize = size;
                        }

                        mountainStartIndex = mountainEndIndex;
                    }
                }
            } else if (A[index] == A[index + 1]) {
                mountainStartIndex = Integer.MAX_VALUE;
            }
            index++;
        }

        if (A[A.length - 2] > A[A.length - 1]) {
            if (mountainSize > 0 && mountainEndIndex == A.length - 2) {
                mountainSize++;
            } else if (mountainSize == 0 && mountainStartIndex != Integer.MAX_VALUE) {
                mountainEndIndex = A.length - 1;

                mountainSize = mountainEndIndex - mountainStartIndex + 1;
            }

        }
        return mountainSize;
    }
}
