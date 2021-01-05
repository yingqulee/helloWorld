package A_Others;

import java.util.Arrays;

public class KMPmatcher {

    // find the starting index in string haystack[] that matches the search word P[]
    public static void kmpMatcher(final String haystack, final String needle) {
        final int m = haystack.length();
        final int n = needle.length();

        final int[] prefix = computePrefixFunction(needle);
        System.out.println("Prefix Before: " + Arrays.toString(prefix));
        movePrefixFunction(prefix);
        System.out.println("Prefix After: " + Arrays.toString(prefix));

        int index = 0;
        for (int i = 0; i < m; i++) {
            while (index > 0 && haystack.charAt(i) != needle.charAt(index)) {
                index = prefix[index];
            }

            if (haystack.charAt(i) == needle.charAt(index)) {
                index++;
            }

            if (index == n) {
                System.out.println("Pattern starts: " + (i + 1 - n));
                index = prefix[index - 1];
            }
        }
    }

    // return the prefix function
    private static int[] computePrefixFunction(final String pattern) {
        final int n = pattern.length();
        final int[] prefix = new int[n];
        prefix[0] = 0;
        int index = 0;
        for (int i = 1; i < n; i++) {
            while (index > 0 && pattern.charAt(index) != pattern.charAt(i)) {
                index = prefix[index - 1];
            }

            if (pattern.charAt(index) == pattern.charAt(i)) {
                index++;
            }

            prefix[i] = index;

        }
        return prefix;
    }

    //move, add -1 in the front of prefix
    public static void movePrefixFunction(final int[] prefix){
        for (int i = prefix.length - 1; i > 0; i--) {
            prefix[i] = prefix[i - 1];
        }
        prefix[0] = -1;
    }

    public static void main(String[] args) {
        final String haystack = "ABABABABCABAABABABCABAA";        //This is the full string
        final String needle = "ABABCABAA";                //This is the substring that we want to find
        //Prefix: [0, 0, 1, 2, 0, 1, 2, 3, 1]
        kmpMatcher(haystack, needle);
    }
}
