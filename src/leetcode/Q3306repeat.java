package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3306repeat {

    public static void main(String[] args) {
        String input = "iqeaouqiaeouqo";
        int k = 2;
        int ans = countValidSubstrings(input, k);
        System.out.println("Valid substrings count: " + ans);
    }

    public static int countValidSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i <= n - (5 + k); i++) {
            for (int j = i + 5 + k - 1; j < n; j++) {
                String subStr = s.substring(i, j + 1);
                if (isValidSubstring(subStr, k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isValidSubstring(String str, int k) {
        Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        int[] vowelCount = new int[5];
        int consonantCount = 0;

        for (char ch : str.toCharArray()) {
            if (vowels.contains(ch)) {
                switch (ch) {
                    case 'a': vowelCount[0]++; break;
                    case 'e': vowelCount[1]++; break;
                    case 'i': vowelCount[2]++; break;
                    case 'o': vowelCount[3]++; break;
                    case 'u': vowelCount[4]++; break;
                }
            } else {
                consonantCount++;
            }
        }
        return hasAllVowels(vowelCount) && consonantCount == k;
    }

    public static boolean hasAllVowels(int[] vowelCount) {
        for (int count : vowelCount) {
            if (count < 1) return false;
        }
        return true;
    }
}
