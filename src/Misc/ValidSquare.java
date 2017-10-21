package Misc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class ValidSquare {
    public static void main(String[] args) {
        int[] p1 = {0, 1};
        int[] p2 = {1, 2};
        int[] p3 = {0, 2};
        int[] p4 = {0, 0};

        System.out.println(validSquare(p1, p2, p3, p4));

    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Double> distances = new HashSet<>();

        BigDecimal root2 = BigDecimal.valueOf(Math.sqrt(2));
        BigDecimal side;
        BigDecimal diagonal = BigDecimal.valueOf(0.0);

        BigDecimal distanceOne = getDistance(p1, p2);
        if (distanceOne.doubleValue() == 0.0) {
            return false;
        }
        distances.add(distanceOne.doubleValue());

        BigDecimal distanceTwo = getDistance(p1, p3);
        if (!distances.contains(distanceTwo.doubleValue())) {
            if (distanceTwo.setScale(2, RoundingMode.HALF_UP).doubleValue() == distanceOne.multiply(root2).setScale(2, RoundingMode.HALF_UP).doubleValue()) {
                diagonal = distanceTwo;
                side = distanceOne;
                distances.add(distanceTwo.doubleValue());
            } else if (distanceOne.setScale(2, RoundingMode.HALF_UP).doubleValue() == distanceTwo.multiply(root2).setScale(2, RoundingMode.HALF_UP).doubleValue()) {
                diagonal = distanceOne;
                side = distanceTwo;
                distances.add(distanceTwo.doubleValue());
            } else {
                return false;
            }
        } else {
            side = distanceOne;
        }

        BigDecimal distanceThree = getDistance(p1, p4);
        if (diagonal.doubleValue() == 0.0 && distanceThree.setScale(2, RoundingMode.HALF_UP).doubleValue() == side.multiply(root2).setScale(2, RoundingMode.HALF_UP).doubleValue()) {
            return true;
        } else if (diagonal.doubleValue() > 0.0 && distanceThree.setScale(2, RoundingMode.HALF_UP).doubleValue() == side.setScale(2, RoundingMode.HALF_UP).doubleValue()) {
            return true;
        }

        return false;
    }

    public static BigDecimal getDistance(int[] p1, int[] p2) {
        return BigDecimal.valueOf(Math.sqrt((p1[1] - p2[1]) * (p1[1] - p2[1]) + (p1[0] - p2[0]) * (p1[0] - p2[0])));
    }
}
