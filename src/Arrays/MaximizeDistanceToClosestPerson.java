package Arrays;

public class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        int array1[] = {1, 0, 0, 0, 1, 0, 1};
        int array2[] = {1, 0, 0, 0};
        int array3[] = {0, 0, 0, 1};
        int array4[] = {0, 0, 0, 1, 0, 0, 1};
        int array5[] = {1, 0, 1, 0, 0, 1};
        int array8[] = {1, 0};
        int array9[] = {0, 1, 0, 0, 0};

        System.out.println(maxDistToClosest(array1));
        System.out.println(maxDistToClosest(array2));
        System.out.println(maxDistToClosest(array3));
        System.out.println(maxDistToClosest(array4));
        System.out.println(maxDistToClosest(array5));
        System.out.println(maxDistToClosest(array8));
        System.out.println(maxDistToClosest(array9));
    }

    public static int maxDistToClosest(int[] seats) {
        int lastOne = -1;
        int maxResult = -1;
        int currentSeat;
        int zeroCount = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (lastOne != -1) {
                    currentSeat = (i - lastOne) / 2;
                    maxResult = Math.max(currentSeat, maxResult);
                } else {
                    maxResult = Math.max(maxResult, zeroCount);
                }
                zeroCount = 0;
                lastOne = i;
            } else {
                zeroCount++;
            }
        }

        return zeroCount > 0 ? Math.max(maxResult, zeroCount) : maxResult;
    }
}
