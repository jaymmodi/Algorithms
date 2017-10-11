package bits;

import java.util.Arrays;

public class XOR {

    public static void main(String[] args) {
        int[] array = {5, 5, 2, 2, 8};

        System.out.println(singleNumber(array));
    }

    private static int singleNumber(int[] array) {
        return Arrays.stream(array).parallel().reduce(0, (x, y) -> x ^ y);
    }

}
