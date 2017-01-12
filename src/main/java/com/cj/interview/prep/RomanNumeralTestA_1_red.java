package com.cj.interview.prep;

public class RomanNumeralTestA_1_red {
    public static void main(String[] args) {
        new RomanNumeralTestA_1_red().run();
    }

    private void run() {
        int number = 1;
        String actual = romanNumeral(number);
        String expected = "I";
        if (expected.equals(actual)) {
            System.out.println(String.format("SUCCESS: %d -> %s", number, expected));
        } else {
            System.out.println(String.format("FAILURE: %d", number));
            System.out.println(String.format("  actual  : %s", actual));
            System.out.println(String.format("  expected: %s", expected));
        }
    }

    private String romanNumeral(int value) {
        return "?";
    }
}
