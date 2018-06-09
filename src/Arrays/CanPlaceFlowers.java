package Arrays;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int flowerbed[] = {1, 0, 0, 0, 0};
        System.out.println(canPlaceFlowers(flowerbed, 1));

        flowerbed = new int[]{1, 0, 0, 0, 0};
        System.out.println(canPlaceFlowers(flowerbed, 2));

        flowerbed = new int[]{1, 0, 0, 0, 0};
        System.out.println(canPlaceFlowers(flowerbed, 0));

        flowerbed = new int[]{0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed, 1));

        flowerbed = new int[]{1, 0, 1, 0, 0, 1, 0};
        System.out.println(canPlaceFlowers(flowerbed, 1));

        flowerbed = new int[]{1, 0, 0, 1, 0, 1, 0, 0, 0, 0};
        System.out.println(canPlaceFlowers(flowerbed, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int totalOnes = getOnes(flowerbed);
        int maxOnes = (int) Math.ceil(flowerbed.length / 2.0);

        if (totalOnes + n > maxOnes) {
            return false;
        } else if (totalOnes == 0 && n <= maxOnes) {
            return true;
        } else {
            int end = flowerbed.length - 1;
            int firstIndexOfOne = getFirstIndex(flowerbed);

            // go left
            int leftIndex = firstIndexOfOne;
            while (n > 0 && leftIndex > 0 && inRange(leftIndex - 1, end) && inRange(leftIndex - 2, end)) {
                if (flowerbed[leftIndex] == 1 && flowerbed[leftIndex - 1] == 0 && flowerbed[leftIndex - 2] == 0) {
                    if (inRange(leftIndex - 3, end) && flowerbed[leftIndex - 3] != 1) {
                        flowerbed[leftIndex - 2] = 1;
                        n--;
                    } else if (leftIndex - 2 == 0) {
                        flowerbed[leftIndex - 2] = 1;
                        n--;
                    }
                    leftIndex = leftIndex - 2;
                } else if (flowerbed[leftIndex] == 0 && flowerbed[leftIndex - 1] == 0 && flowerbed[leftIndex - 2] == 1) {
                    if (inRange(leftIndex + 1, end) && flowerbed[leftIndex + 1] != 1) {
                        flowerbed[leftIndex] = 1;
                        n--;
                    } else if (leftIndex > end) {
                        flowerbed[leftIndex] = 1;
                        n--;
                    }
                    leftIndex = leftIndex - 2;
                } else {
                    leftIndex = leftIndex - 1;
                }


            }

            //go right
            int rightIndex = firstIndexOfOne;
            while (n > 0 && rightIndex < end && inRange(rightIndex + 1, end) && inRange(rightIndex + 2, end)) {
                if (flowerbed[rightIndex] == 1 && flowerbed[rightIndex + 1] == 0 && flowerbed[rightIndex + 2] == 0) {
                    if (inRange(rightIndex + 3, end) && flowerbed[rightIndex + 3] != 1) {
                        flowerbed[rightIndex + 2] = 1;
                        n--;
                    } else if (rightIndex + 2 == end) {
                        flowerbed[rightIndex + 2] = 1;
                        n--;
                    }
                    rightIndex = rightIndex + 2;
                } else if (flowerbed[rightIndex] == 0 && flowerbed[rightIndex + 1] == 0 && flowerbed[rightIndex + 2] == 1) {
                    if (inRange(rightIndex - 1, end) && flowerbed[rightIndex - 1] != 1) {
                        flowerbed[rightIndex] = 1;
                        n--;
                    } else if (rightIndex - 1 < 0) {
                        flowerbed[rightIndex] = 1;
                        n--;
                    }
                    rightIndex = rightIndex + 2;
                } else {
                    rightIndex = rightIndex + 1;
                }
            }

            return n <= 0;
        }
    }


    private static int getFirstIndex(int[] flowebed) {
        for (int i = 0; i < flowebed.length; i++) {
            if (flowebed[i] == 1) {
                return i;
            }
        }

        return -1;
    }

    private static int getOnes(int[] flowerbed) {
        long count = 0L;
        for (int i : flowerbed) {
            if (i == 1) {
                count++;
            }
        }
        return (int) count;
    }

    private static boolean inRange(int index, int end) {
        return index >= 0 && index <= end;
    }
}
