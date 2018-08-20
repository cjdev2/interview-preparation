package com.cj.interview.preparation;

public class RomanNumeralTestD_2_red {
    public static void main(String[] args) {
        new RomanNumeralTestD_2_red().run();
    }

    private void run() {
        test(1, "I");
        test(2, "II");
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
        return "I";
    }
}
