package DynamicProgramming;

public class CountingBits {

    public static void main(String[] args) {
        int[] ints = countBits(16);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;

        if (num == 0) {
            return result;
        }
        result[1] = 1;
        if (num == 1) {
            return result;
        }

        for (int i = 2; i <= num; i++) {
            int bits;
            if (Math.ceil(Math.log(i) / Math.log(2)) == Math.log(i) / Math.log(2)) {
                bits = 1;
            } else if (i % 2 == 0) {
                int nearestFloor = (int) Math.floor(Math.log(i) / Math.log(2));
                int nearestPower = (int) Math.pow(2, nearestFloor);

                bits = result[nearestPower] + result[i - nearestPower];
            } else {
                bits = result[i - 1] + result[1];
            }

            result[i] = bits;
        }

        return result;
    }
}

