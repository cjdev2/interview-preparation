package com.cj.interview.prep;

public class RomanNumeralTestH_3_refactor {
    public static void main(String[] args) {
        new RomanNumeralTestH_3_refactor().run();
    }

    private void run() {
        test(1, "I");
        test(2, "II");
        test(3, "III");
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
        return repeatI(value);
    }

    private String repeatI(int times) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append("I");
        }
        return stringBuilder.toString();
    }
}
