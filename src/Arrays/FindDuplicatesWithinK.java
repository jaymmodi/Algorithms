package Arrays;


import java.util.HashMap;

public class FindDuplicatesWithinK {

    public static void main(String[] args) {
        int array[] = {1, 2, 4, 4, 5};
        System.out.println(findDuplicates(array, 3));
    }

    private static boolean findDuplicates(int[] array, int distance) {
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                if (i - map.get(array[i]) <= 3) {
                    return true;
                } else {
                    return false;
                }
            } else {
                map.put(array[i], i);
                index++;
            }
        }
        return false;
    }
}
