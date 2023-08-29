package javaexercices;

import java.util.regex.Pattern;

public class CNPValidator {
    private static final Pattern CNP_PATTERN = Pattern.compile("^\\d{13}$");
    private static final int[] CONSTANT = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};

    public static void main(String[] args) {
        String cnp = "2990219469000";
        if (isValidCNP(cnp)) {
            System.out.println("CNP-ul este valid.");
        } else {
            System.out.println("CNP-ul este invalid.");
        }
    }

    public static boolean isValidCNP(String cnp) {
        if (cnp == null || !CNP_PATTERN.matcher(cnp).matches()) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += Character.getNumericValue(cnp.charAt(i)) * CONSTANT[i];
        }

        int remainder = sum % 11;
        int controlDigit = (remainder == 10) ? 1 : remainder;

        return controlDigit == Character.getNumericValue(cnp.charAt(12));
    }
}

