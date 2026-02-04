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

        // Determine machine risk factor based on machinery state
        double machineRiskFactor = 0.0;
        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        }

        // Calculate hazard risk
        double hazardRisk = (1.0 - armPrecision) * 15.0 + workerDensity * machineRiskFactor;

        System.out.println();
        System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        scanner.close();
    }
}
