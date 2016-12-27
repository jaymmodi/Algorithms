package bits;

public class Addition {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        System.out.println(sum(a, b));
    }

    private static int sum(int a, int b) {
        if (b == 0) {
            return a;
        }

        int sumWithoutCarry = a ^ b;
        int actualCarryGeneratedPosition = a & b;
        int addCarryPosition = actualCarryGeneratedPosition << 1;

        return sum(sumWithoutCarry, addCarryPosition);
    }

}
