import java.util.*;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int lens = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                lens += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() > 0 ? lens + 1 : lens;
    }
}
