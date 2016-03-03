package HackerRankTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Candies {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array;
        int numberOfStudents;
        try {
            numberOfStudents = Integer.parseInt(br.readLine());
            if (numberOfStudents < 0) {
                System.out.println("0");
            } else {
                array = new int[numberOfStudents];
                int i = 0;
                while (i <= numberOfStudents - 1) {
                    int number = Integer.parseInt(br.readLine());
                    if (number <= 0) {
                        System.out.println("0");
                        break;
                    }

                    array[i] = number;
                    i++;
                }
                if (array.length == 0) {
                    System.out.println("0");
                } else if (array.length == 1) {
                    System.out.println("1");
                } else {

                    int[] candiePerStudent = new int[numberOfStudents];
                    int start = 0;
                    int end = numberOfStudents - 1;
                    int minNumberIndex = findMinimum(array, start, end);
                    findMinimumNumberOfCandies(array, candiePerStudent, start, end, minNumberIndex);
//                    findMinimumNewMethod(array, candiePerStudent, start, end);
                    printArray(candiePerStudent);
                    System.out.println(checkForZero(candiePerStudent));
                    System.out.println(count(candiePerStudent));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkForZero(int[] candiePerStudent) {
        for (int aCandiePerStudent : candiePerStudent) {
            if (aCandiePerStudent == 0 || aCandiePerStudent < 0 || aCandiePerStudent > 100000) {
                return true;
            }
        }
        return false;
    }


    private static int count(int[] candiePerStudent) {
        int sum = 0;
        for (int aCandiePerStudent : candiePerStudent) {
            sum += aCandiePerStudent;
        }
        return sum;
    }

    private static void findMinimumNumberOfCandies(int[] array, int[] candiePerStudent, int start, int end, int minNumberIndex) {

        if (start == end) {
            candiePerStudent[start] = 1;
        } else {
            candiePerStudent[minNumberIndex] = 1;

            int goRight = minNumberIndex;
            while (goRight + 1 <= end && array[goRight + 1] > array[goRight]) {
                if (array[goRight + 1] > array[goRight]) {
                    candiePerStudent[goRight + 1] = candiePerStudent[goRight] + 1;
                } else if (array[goRight + 1] == array[goRight]) {
                    candiePerStudent[goRight + 1] = 1;
                }
                ++goRight;
            }

            int goLeft = minNumberIndex;
            while (goLeft - 1 >= start && array[goLeft - 1] > array[goLeft]) {
                if (array[goLeft - 1] > array[goLeft]) {
                    candiePerStudent[goLeft - 1] = candiePerStudent[goLeft] + 1;
                } else if (array[goLeft - 1] == array[goLeft]) {
                    candiePerStudent[goLeft - 1] = 1;
                }
                --goLeft;
            }

            if (goLeft - 1 >= start) {
                int min = findMinimum(array, start, goLeft - 1);
                findMinimumNumberOfCandies(array, candiePerStudent, start, goLeft - 1, min);
            }

            if (goRight + 1 <= end) {
                int min = findMinimum(array, goRight + 1, end);
                findMinimumNumberOfCandies(array, candiePerStudent, goRight + 1, end, min);
            }

        }
    }

    private static int findMinimum(int[] array, int start, int end) {
        int min = array[start];
        int minIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


}

