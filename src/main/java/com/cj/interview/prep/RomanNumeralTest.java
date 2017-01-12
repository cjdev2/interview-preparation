package com.cj.interview.prep;

public class RomanNumeralTest {
    public static void main(String[] args) {
        new RomanNumeralTest().run();
    }

    private void run() {
        test(1, "I");
        test(2, "II");
        test(3, "III");
        test(4, "IV");
        test(5, "V");
        test(6, "VI");
        test(7, "VII");
        test(8, "VIII");
        test(9, "IX");
        test(10, "X");
        test(11, "XI");
        test(12, "XII");
        test(13, "XIII");
        test(14, "XIV");
        test(15, "XV");
        test(16, "XVI");
        test(17, "XVII");
        test(18, "XVIII");
        test(19, "XIX");
        test(20, "XX");
        test(40, "XL");
        test(50, "L");
        test(90, "XC");
        test(100, "C");
        test(400, "CD");
        test(500, "D");
        test(900, "CM");
        test(1000, "M");
        test(3999, "MMMCMXCIX");
    }

    private void test(int number, String expected) {
        String actual = romanNumeral(number);
        if (expected.equals(actual)) {
            System.out.println(String.format("SUCCESS: %d -> %s", number, expected));
        } else {
            System.out.println(String.format("FAILURE: %d", number));
            System.out.println(String.format("  actual  : %s", actual));
            System.out.println(String.format("  expected: %s", expected));
        }
    }

    private String romanNumeral(int value) {
        return romanNumeralRecursive(value, "IVXLCDM??");
    }

    private String romanNumeralRecursive(int value, String numerals) {
        if (value == 0) {
            return "";
        } else {
            String biggerPart = romanNumeralRecursive(value / 10, numerals.substring(2));
            String smallerPart = romanNumeralForDigit(value % 10, numerals);
            return biggerPart + smallerPart;
        }
    }

    private String romanNumeralForDigit(int digit, String numeralOneFiveTen) {
        if (digit < 1) {
            return "";
        } else if (digit < 4) {
            char numeralOne = numeralOneFiveTen.charAt(0);
            return repeatChar(numeralOne, digit);
        } else if (digit < 5) {
            char numeralOne = numeralOneFiveTen.charAt(0);
            char numeralFive = numeralOneFiveTen.charAt(1);
            return "" + numeralOne + numeralFive;
        } else if (digit < 9) {
            char numeralFive = numeralOneFiveTen.charAt(1);
            return "" + numeralFive + romanNumeralForDigit(digit - 5, numeralOneFiveTen);
        } else {
            char numeralOne = numeralOneFiveTen.charAt(0);
            char numeralTen = numeralOneFiveTen.charAt(2);
            return "" + numeralOne + numeralTen;
        }
    }

    private String repeatChar(char ch, int times) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
