import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Factory Robot Hazard Analyzer");
        System.out.println("Evaluating robot safety parameters...");
        System.out.println();

        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = scanner.nextDouble();

        System.out.print("Enter Worker Density (1 - 20): ");
        int workerDensity = scanner.nextInt();

        scanner.nextLine(); // consume newline
        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = scanner.nextLine();

        System.out.println();
        System.out.println("Inputs Received:");
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        scanner.close();
    }
}
