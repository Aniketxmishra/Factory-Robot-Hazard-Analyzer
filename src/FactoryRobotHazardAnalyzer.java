import java.util.Scanner;

/**
 * Factory Robot Hazard Analyzer - Main Application
 * Evaluates hazard risk score based on robot parameters
 * @author Aniket Mishra
 * @version 1.0
 */
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

        try {
            double hazardRisk = RobotHazardAuditor.calculateHazardRisk(armPrecision, workerDensity, machineryState);
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
