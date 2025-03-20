package computernetworking;

import java.util.Scanner;


public class CRC {
    // Example CRC divisor (CRC-8, CRC-16, CRC-32, etc.)
    // private static final String divisor = "1101"; // Example: x^3 + x^2 + 1 (CRC-4)

    public static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < a.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }

    public static String divide(String dividend, String divisor) {
        int pick = divisor.length();
        String tmp = dividend.substring(0, pick);

        while (pick < dividend.length()) {
            if (tmp.charAt(0) == '1') {
                tmp = xor(tmp, divisor) + dividend.charAt(pick);
            } else {
                tmp = xor(tmp, "0".repeat(divisor.length())) + dividend.charAt(pick);
            }
            pick++;
        }

        if (tmp.charAt(0) == '1') {
            tmp = xor(tmp, divisor);
        } else {
            tmp = xor(tmp, "0".repeat(divisor.length()));
        }

        return tmp;
    }

    public static String encode(String data,String divisor) {
        String appendedData = data + "0".repeat(divisor.length() - 1);
        String remainder = divide(appendedData, divisor);
        return data + remainder;
    }

    public static boolean check(String receivedData,String divisor) {
        String remainder = divide(receivedData, divisor);
        return remainder.replace("0", "").isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter binary data: ");
        String data = scanner.next();
        System.out.print("Enter  divisor in binary data: ");
        String divisor = scanner.next();
        String transmittedData = encode(data,divisor);
        System.out.println("Transmitted Data (with CRC): " + transmittedData);

        System.out.print("Enter received data: ");
        String receivedData = scanner.next();
        boolean isValid = check(receivedData,divisor);

        if (isValid) {
            System.out.println("No error detected.");
        } else {
            System.out.println("Error detected!");
        }
    }
}

