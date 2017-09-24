package bits;

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int ans = 0;

        for (int i = 0; i < 31; i++) {
            if ((xor & (1 << i)) >= 1) {
                ++ans;
            }
        }

        return ans;
    }

}
