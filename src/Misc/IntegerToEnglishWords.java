package Misc;

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(11234567));
        System.out.println(numberToWords(1234567891));
        System.out.println(numberToWords(100));
        System.out.println(numberToWords(10000));
        System.out.println(numberToWords(10500));
    }

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;

        StringBuilder stringBuilder = new StringBuilder();


        if (num / billion > 0) {
            String word = convert(num / billion);
            stringBuilder.append(word).append(" ").append("Billion").append(" ");
            num = num % billion;
        }

        if (num / million > 0) {
            String word = convert(num / million);
            stringBuilder.append(word).append(" ").append("Million").append(" ");
            num = num % million;
        }

        if (num / thousand > 0) {
            String word = convert(num / thousand);
            stringBuilder.append(word).append(" ").append("Thousand").append(" ");
            num = num % thousand;
        }

        stringBuilder.append(convert(num));

        return stringBuilder.toString().trim();
    }

    private static String convert(int num) {
        String result = "";

        int hundred = 100;
        if (num / hundred > 0) {
            result += getOneDigit(num / hundred) + " ";
            result += "Hundred" + " ";
            num = num % hundred;
        }

        if (num >= 10 && num <= 19) {
            result += getNumber(num);
        } else {
            if (num > 9) {
                result += getSecondDigit(num / 10) + " ";
            }
            result += getOneDigit(num % 10);
        }

        return result.trim();
    }

    private static String getNumber(int num) {
        String number = "";

        switch (num) {
            case 10:
                number += "Ten";
                break;
            case 11:
                number += "Eleven";
                break;
            case 12:
                number += "Twelve";
                break;
            case 13:
                number += "Thirteen";
                break;
            case 14:
                number += "Fourteen";
                break;
            case 15:
                number += "Fifteen";
                break;
            case 16:
                number += "Sixteen";
                break;
            case 17:
                number += "Seventeen";
                break;
            case 18:
                number += "Eighteen";
                break;
            case 19:
                number += "Nineteen";
                break;
            default:
                break;

        }

        return number;
    }

    private static String getSecondDigit(int num) {
        String secondDigit = "";

        switch (num) {
            case 2:
                secondDigit += "Twenty";
                break;
            case 3:
                secondDigit += "Thirty";
                break;
            case 4:
                secondDigit += "Forty";
                break;
            case 5:
                secondDigit += "Fifty";
                break;
            case 6:
                secondDigit += "Sixty";
                break;
            case 7:
                secondDigit += "Seventy";
                break;
            case 8:
                secondDigit += "Eighty";
                break;
            case 9:
                secondDigit += "Ninety";
                break;
            default:
                break;

        }

        return secondDigit;
    }

    private static String getOneDigit(int num) {
        String oneDigit = "";
        switch (num) {
            case 1:
                oneDigit += "One";
                break;
            case 2:
                oneDigit += "Two";
                break;
            case 3:
                oneDigit += "Three";
                break;
            case 4:
                oneDigit += "Four";
                break;
            case 5:
                oneDigit += "Five";
                break;
            case 6:
                oneDigit += "Six";
                break;
            case 7:
                oneDigit += "Seven";
                break;
            case 8:
                oneDigit += "Eight";
                break;
            case 9:
                oneDigit += "Nine";
                break;
            default:
                break;

        }

        return oneDigit;
    }

}
