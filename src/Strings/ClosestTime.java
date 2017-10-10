package Strings;

import java.util.ArrayList;
import java.util.List;

public class ClosestTime {

    public static void main(String[] args) {
        System.out.println(nextClosestTime("00:00"));
    }

    public static String nextClosestTime(String time) {
        String[] splits = time.split("");
        List<Integer> numbers = new ArrayList<>();


        for (String split : splits) {
            if (!split.equals(":")) {
                numbers.add(Integer.parseInt(split));
            }
        }

        int firstNumber = numbers.get(0);
        int count = 1;
        for (int i = 1; i <= numbers.size() - 1; i++) {
            if (firstNumber == numbers.get(i)) {
                count++;
            }
        }

        if (count == numbers.size()) {
            return time;
        }

        int minutesMinDiff = Integer.MAX_VALUE;
        int minutesMaxDiff = Integer.MIN_VALUE;
        int timeInteger = Integer.parseInt(time.replace(":", ""));
        int fhourOneMax = 0, fhourTwoMax = 0, fminutueOneMax = 0, fminuteTwoMax = 0;
        int fhourOneMin = 0, fhourTwoMin = 0, fminutueOneMin = 0, fminuteTwoMin = 0;

        for (Integer hourOne : numbers) {
            if (hourOne <= 2) {
                for (Integer hourTwo : numbers) {
                    if (hourOne == 2 && hourTwo <= 4 || hourOne <= 1 && hourTwo <= 9) {

                        for (Integer minuteOne : numbers) {
                            if (minuteOne <= 5) {
                                for (Integer minuteTwo : numbers) {
                                    int nextNumber = 1000 * hourOne + 100 * hourTwo + 10 * minuteOne + minuteTwo;

                                    if (nextNumber < timeInteger) {
                                        if (timeInteger - nextNumber > minutesMaxDiff) {
                                            minutesMaxDiff = timeInteger - nextNumber;
                                            fhourOneMax = hourOne;
                                            fhourTwoMax = hourTwo;
                                            fminuteTwoMax = minuteTwo;
                                            fminutueOneMax = minuteOne;
                                        }
                                    } else if (nextNumber > timeInteger) {
                                        if (nextNumber - timeInteger < minutesMinDiff) {
                                            minutesMinDiff = nextNumber - timeInteger;
                                            fhourOneMin = hourOne;
                                            fhourTwoMin = hourTwo;
                                            fminuteTwoMin = minuteTwo;
                                            fminutueOneMin = minuteOne;
                                        }
                                    }


                                }
                            }
                        }
                    }
                }
            }


        }
        if (minutesMinDiff != Integer.MAX_VALUE)
            return String.format("%d%d:%d%d", fhourOneMin, fhourTwoMin, fminutueOneMin, fminuteTwoMin);
        else {
            return String.format("%d%d:%d%d", fhourOneMax, fhourTwoMax, fminutueOneMax, fminuteTwoMax);
        }
    }
}
