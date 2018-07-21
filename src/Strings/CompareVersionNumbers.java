package Strings;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "11.1"));
        System.out.println(compareVersion("0.1", "11.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("01", "1"));
        System.out.println(compareVersion("01", "2"));
        System.out.println(compareVersion("05", "2"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] data1 = version1.split("\\.");
        String[] data2 = version2.split("\\.");

        int sum1 = 0;
        int sum2 = 0;
        int index = 0;

        while (sum1 == sum2) {
            if (index < data1.length) {
                sum1 += Integer.parseInt(data1[index]);
            }
            if (index < data2.length) {
                sum2 += Integer.parseInt(data2[index]);
            }

            if (index >= data1.length && index >= data2.length) {
                break;
            }
            index++;
        }

        return Integer.compare(sum1, sum2);
    }
}
