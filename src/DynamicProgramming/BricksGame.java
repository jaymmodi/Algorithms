package DynamicProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BricksGame {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numberOfTestCases = Integer.parseInt(br.readLine());
            for (int i = 1; i <= numberOfTestCases; i++) {
                int numberOfBricks = Integer.parseInt(br.readLine());
                int scoreArray[] = new int[numberOfBricks];
                String array[] = br.readLine().split(" ");
                for (int j = 0; j < scoreArray.length; j++) {
                    scoreArray[j] = Integer.parseInt(array[j]);
                }
//                System.out.println(findMaxScoreRecursive(scoreArray, 0, scoreArray.length - 1));
                int[] storedArray = new int[numberOfBricks + 1];
                for (int j = 0; j < storedArray.length; j++) {
                    storedArray[j] = -1;
                }

                System.out.println(findMaxScoreDynamic(scoreArray, storedArray, 0, scoreArray.length - 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findMaxScoreDynamic(int[] scoreArray, int[] storedArray, int startIndex, int endIndex) {
        if (endIndex - startIndex == 0) {
            storedArray[1] = scoreArray[endIndex];
            return scoreArray[endIndex];
        } else if (endIndex - startIndex == 1) {
            storedArray[2] = scoreArray[startIndex] + scoreArray[endIndex];
            return scoreArray[startIndex] + scoreArray[endIndex];
        } else if (endIndex - startIndex == 2) {
            storedArray[3] = scoreArray[startIndex] + scoreArray[startIndex + 1] + scoreArray[startIndex + 2];
            return scoreArray[startIndex] + scoreArray[startIndex + 1] + scoreArray[startIndex + 2];
        } else if (storedArray[endIndex - startIndex + 1] != -1) {
            return storedArray[endIndex - startIndex + 1];
        } else {
            int max = Integer.MIN_VALUE;
            for (int i = startIndex; i <= startIndex + 2; i++) {
                max = Math.max(max, scoreTilli(startIndex, i, scoreArray) + totalRemainingScore(i + 1, scoreArray) - findMaxScoreDynamic(scoreArray, storedArray, i + 1, endIndex));
            }
            storedArray[endIndex - startIndex + 1] = max;
            return max;
        }
    }

    private static int findMaxScoreRecursive(int[] scoreArray, int startIndex, int endIndex) {
        if (endIndex - startIndex == 0) {
            return scoreArray[endIndex];
        } else if (endIndex - startIndex == 1) {
            return scoreArray[startIndex] + scoreArray[endIndex];
        } else if (endIndex - startIndex == 2) {
            return scoreArray[startIndex] + scoreArray[startIndex + 1] + scoreArray[startIndex + 2];
        } else {
            int max = Integer.MIN_VALUE;
            for (int i = startIndex; i <= startIndex + 2; i++) {
                max = Math.max(max, scoreTilli(startIndex, i, scoreArray) + totalRemainingScore(i + 1, scoreArray) - findMaxScoreRecursive(scoreArray, i + 1, endIndex));
            }
            return max;
        }
    }

    private static int totalRemainingScore(int startIndex, int[] scoreArray) {
        int sum = 0;
        for (int i = startIndex; i < scoreArray.length; i++) {
            sum += scoreArray[i];
        }
        return sum;
    }

    private static void printArray(int[] scoreArray) {
        for (int aScoreArray : scoreArray) {
            System.out.println(aScoreArray);
        }
    }

    public static int scoreTilli(int startIndex, int jIndex, int[] scoreArray) {
        int sum = 0;
        for (int i = startIndex; i <= jIndex; i++) {
            sum += scoreArray[i];
        }
        return sum;
    }


}
