import java.io.*;

public class Ladderproblem {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i < 26; i++) {
            c = a + b;

            a = b;
            b = c;

        }
        System.out.println( + c);
    }
}