package Strings;

import java.util.HashMap;
import java.util.Map;

public class ClosestTimeNoRepeat {

    public static void main(String[] args) {
        System.out.println(closestTime("00:11"));
    }

    private static String closestTime(String time) {
        String timeArray[] = time.split(":");
        int givenTimeInMinutes = Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);

        time = time.replaceFirst(":", "");
        char[] chars = time.toCharArray();
        int[] timeNumbers = new int[4];
        for (int i = 0; i < chars.length; i++) {
            timeNumbers[i] = chars[i] - '0';
        }

        boolean[] visited = new boolean[4];
        Map<String, Integer> allTimesDifference = new HashMap<>();
        for (int i = 0; i < timeNumbers.length; i++) {
            visited[i] = true;
            printAllPossibleTimes(allTimesDifference, timeNumbers, visited, "" + timeNumbers[i], givenTimeInMinutes, time);
            visited[i] = false;
        }

        int min = Integer.MAX_VALUE;
        String correctTime = "";
        for (Map.Entry<String, Integer> stringIntegerEntry : allTimesDifference.entrySet()) {
            if (stringIntegerEntry.getValue() <= min) {
                min = stringIntegerEntry.getValue();
                correctTime = stringIntegerEntry.getKey();
            }
        }

        return String.format("%02d:%02d", Integer.parseInt(correctTime.substring(0, 2)), Integer.parseInt(correctTime.substring(2)));
    }

    private static void printAllPossibleTimes(Map<String, Integer> allTimesDifference, int[] timeNumbers, boolean[] visited, String timeShuffle, int givenTimeInMinutes, String time) {
        if (timeShuffle.length() == 4 && !timeShuffle.equals(time)) {
            int nextTimeInMinutes = Integer.parseInt(timeShuffle.substring(0, 2)) * 60 + Integer.parseInt(timeShuffle.substring(2));
            allTimesDifference.put(timeShuffle, (nextTimeInMinutes - givenTimeInMinutes) % (24 * 60));
        } else {

            for (int i = 0; i < timeNumbers.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    printAllPossibleTimes(allTimesDifference, timeNumbers, visited, timeShuffle + "" + timeNumbers[i], givenTimeInMinutes, time);
                    visited[i] = false;
                }
            }
        }
    }
}
