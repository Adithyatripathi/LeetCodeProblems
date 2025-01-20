import java.util.*;
import java.util.Scanner;

public class TCSC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        double[] xCoords = new double[N];
        double[] yCoords = new double[N];

        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            xCoords[i] = Double.parseDouble(parts[0]);
            yCoords[i] = Double.parseDouble(parts[1]);
        }

        double minX = Arrays.stream(xCoords).min().getAsDouble();
        double maxX = Arrays.stream(xCoords).max().getAsDouble();
        double minY = Arrays.stream(yCoords).min().getAsDouble();
        double maxY = Arrays.stream(yCoords).max().getAsDouble();

        int width = (int) Math.ceil(maxX - minX);
        int height = (int) Math.ceil(maxY - minY);

        int smaller = Math.min(width, height);
        int larger = Math.max(width, height);

        System.out.println(smaller + " " + larger);
    }
}
