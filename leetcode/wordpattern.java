import java.util.HashMap;

class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // Split the string 's' into words
        String[] words = s.split(" ");

        // Check if pattern length matches number of words
        if (pattern.length() != words.length) {
            return false;
        }

        // Maps for storing pattern-to-word and word-to-pattern relationships
        HashMap<Character, String> patternToWord = new HashMap<>();
        HashMap<String, Character> wordToPattern = new HashMap<>();

        // Loop through each character in the pattern and corresponding word in words
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check pattern-to-word mapping
            if (patternToWord.containsKey(c)) {
                if (!patternToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                patternToWord.put(c, word);
            }

            // Check word-to-pattern mapping
            if (wordToPattern.containsKey(word)) {
                if (!wordToPattern.get(word).equals(c)) {
                    return false;
                }
            } else {
                wordToPattern.put(word, c);
            }
        }
        return true;
    }

}