package com.cj.interview.preparation;

public class RomanNumeralTestJ_4_green {
    public static void main(String[] args) {
        new RomanNumeralTestJ_4_green().run();
    }

    private void run() {
        test(1, "I");
        test(2, "II");
        test(3, "III");
        test(4, "IV");
    }

    private String romanNumeral(int value) {
        if(value < 4){
            return repeatI(value);
        } else {
            return "IV";
        }
    }

    private String repeatI(int times) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append("I");
        }
        return stringBuilder.toString();
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
}
