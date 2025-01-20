import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TCSB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        Map<String, Gate> gates = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String[] parts = sc.nextLine().split("=");
            String output = parts[0].trim();
            String[] operat = parts[1].split("\\(");
            String operation = operat[0].trim();
            String[] inputs = operat[1].replace(")", "").split(", ");
            gates.put(output, new Gate(output, operation, inputs));
        }

        int numCycles = Integer.parseInt(sc.nextLine());
        Map<String, int[]> signals = new HashMap<>();
        for (int i = 0; i < numCycles; i++) {
            String[] li = sc.nextLine().split(" ");
            signals.put(li[0], Arrays.stream(li, 1, li.length).mapToInt(Integer::parseInt).toArray());
        }

        String targt = sc.nextLine().trim();
        System.out.println(Arrays.toString(simulate(gates, signals, targt, numCycles)).replaceAll("[\\[\\],]", ""));
    }

    private static int[] simulate(Map<String, Gate> gates, Map<String, int[]> signals, String targetGate, int cycles) {
        Map<String, int[]> outputs = new HashMap<>();
        for (int cycle = 0; cycle < cycles; cycle++) {
            for (String gateName : gates.keySet()) {
                outputs.computeIfAbsent(gateName, k -> new int[cycles]);
                Gate gate = gates.get(gateName);
                int input1 = getValue(signals, outputs, gate.inputs[0], cycle);
                int input2 = getValue(signals, outputs, gate.inputs[1], cycle);
                outputs.get(gateName)[cycle] = compute(gate.operation, input1, input2);
            }
        }
        return outputs.get(targetGate);
    }

    private static int getValue(Map<String, int[]> signals, Map<String, int[]> outputs, String input, int cycle) {
        if (signals.containsKey(input))
            return signals.get(input)[cycle];
        return cycle == 0 ? 0 : outputs.get(input)[cycle - 1];
    }

    private static int compute(String op, int a, int b) {
        return switch (op) {
            case "AND" -> a & b;
            case "OR" -> a | b;
            case "NAND" -> ~(a & b) & 1;
            case "NOR" -> ~(a | b) & 1;
            case "XOR" -> a ^ b;
            default -> 0;
        };
    }

    static class Gate {
        String output, operation;
        String[] inputs;

        Gate(String output, String operation, String[] inputs) {
            this.output = output;
            this.operation = operation;
            this.inputs = inputs;
        }
    }
}
