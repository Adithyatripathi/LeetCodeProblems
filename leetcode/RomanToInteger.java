import java.util.HashMap;

class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);// IV
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        char chars[] = s.toCharArray();
        int result = 0;
        int i, j;
        for (i = 0, j = 1; j < chars.length; i++, j++) {
            if (map.get(chars[i]) >= map.get(chars[j])) {
                result += map.get(chars[i]);
            } else {
                result -= map.get(chars[i]);
            }
        }
        result += map.get(chars[i]);
        return result;
    }
}
// I 1
// V 5
// X 10
// L 50
// C 100
// D 500
// M 1000
