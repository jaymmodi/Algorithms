package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This code will return the count of all sequences for a given pair of n and k.
 */
public class TimeSeriesSequences {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = 0;
        int totalEvents = 0;

        try {
            // The size of sequence
            System.out.println("Please specify a value for  'k' =");
            k = Integer.parseInt(br.readLine());

            // This represents total number of events.
            System.out.println("Please specify a value for  'n' =");
            totalEvents = Integer.parseInt(br.readLine());

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // This will print out the count for total number of sequences.
        System.out.println("Total number of sequences would be = " + getNumberOfSequences(k, totalEvents));
    }

    /**
     * This method will take in two parameters k and total events and will return the count for sequences.
     * @param k - This represents the size of sequence.
     * @param totalEvents - This represents total number of events
     * @return integer - count of sequences.
     */
    private static long getNumberOfSequences(int k, int totalEvents) {
        if (k == 1) {
            return totalEvents;
        }

        List<List<Integer>> allList = new ArrayList<>();
        List<Integer> availableNumbers = IntStream.rangeClosed(1, k - 1).boxed()
                .collect(Collectors.toList());

        List<Integer> currentList = new ArrayList<>();
        getTotalSequences(allList, currentList, availableNumbers, k, 0);


        return (getCount(allList, totalEvents) + nChooseK(totalEvents, k));
    }

    /**
     * This function will return the count for all possible combinations of size k
     * @param allList - All combinations
     * @param totalEvents - Total number of events
     * @return integer - count of combinations.
     */
    private static long getCount(List<List<Integer>> allList, int totalEvents) {
        long count = 0;
        for (List<Integer> integers : allList) {
            long levelCount = 1;
            for (Integer number : integers) {
                levelCount = levelCount * nChooseK(totalEvents, number);
            }

            count = count + levelCount;
        }

        return count;
    }

    /**
     *  Recursive code to generate all possible combinations
     * @param allList - This will store all list of combinations
     * @param currentList - This the currentList in recursion stack
     * @param availableNumbers - list of numbers to use to generate combinations
     * @param k - size of sequence
     * @param currentSum - current sum of numbers present in current list
     */
    private static void getTotalSequences(List<List<Integer>> allList, List<Integer> currentList, List<Integer> availableNumbers, int k, int currentSum) {

        if (currentSum == k) {
            allList.add(currentList);
            currentList.clear();
            return;
        }

        for (int i = 0; i < availableNumbers.size(); i++) {

            int number = availableNumbers.get(i);
            currentList.add(number);

            currentSum = getSum(currentList);

            if (currentSum < k) {
                getTotalSequences(allList, currentList, availableNumbers, k, currentSum);
            } else if (currentSum == k) {
                List<Integer> tempList = new ArrayList<>(currentList);
                allList.add(tempList);
                currentList.remove(currentList.size() - 1);
                return;
            } else if (currentSum > k) {
                currentList.remove(currentList.size() - 1);
                return;
            }

            if (currentList.size() > 0) {
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    /**
     * This funciton will return the sum of all numbers in a list
     * @param currentList - Current list of numbers
     * @return integer - Sum of all numbers.
     */
    private static int getSum(List<Integer> currentList) {

        return currentList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * This function calculates the factorial of a given number. Dynamic Programming.
     * @param number - number for which the factorial is to be calculated.
     * @return integer - factorial of a number.
     */
    private static long factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }

        long dynamicArray[] = new long[number + 1];

        dynamicArray[0] = 1;
        dynamicArray[1] = 1;
        long factorial = 0;

        if (dynamicArray[number] != 0) {
            return dynamicArray[number];
        }

        for (int i = 2; i < dynamicArray.length; i++) {
            factorial = i * dynamicArray[i - 1];
            dynamicArray[i] = factorial;
        }

        return factorial;
    }

    /**
     * This function calculates the nChooseK.
     * @param n - n
     * @param k - k
     * @return integer - nChooseK.
     */
    private static long nChooseK(int n, int k) {
        if (k == 1) {
            return n;
        } else if (k == 0) {
            return 1;
        }
        if (n >= k) {
            long numerator = 1;
            if (n - k > k) {
                for (int i = n - k + 1; i <= n; i++) {
                    numerator = numerator * i;
                }
                return numerator / factorial(k);
            } else {
                for (int i = k + 1; i <= n; i++) {
                    numerator = numerator * i;
                }
                return numerator / factorial(n - k);
            }
        } else
            return 0;
    }
}
