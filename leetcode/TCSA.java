import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TCSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bs = sc.nextLine();
        String[] worth = sc.nextLine().split(" ");
        int[] worths1 = Arrays.stream(worth).mapToInt(Integer::parseInt).toArray();

        System.out.println(calculateRemovedWorth(bs, worths1));
    }

    public static int calculateRemovedWorth(String bs, int[] worths1) {
        int n = bs.length();

        int total = Arrays.stream(worths1).sum();

        Map<Character, Integer> Map = new HashMap<>();
        Map.put('0', 0);
        Map.put('1', 0);

        for (int i = 0; i < n; i++) {
            char current = bs.charAt(i);
            char opposite = current == '0' ? '1' : '0';

            Map.put(current, Math.max(
                    Map.get(current),
                    Map.get(opposite) + worths1[i]));
        }

        int max = Math.max(Map.get('0'), Map.get('1'));

        return total - max;
    }
}
