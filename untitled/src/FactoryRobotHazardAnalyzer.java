import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    // Constants for machinery risk factors
    private static final double WORN_RISK_FACTOR = 1.3;
    private static final double FAULTY_RISK_FACTOR = 2.0;
    private static final double CRITICAL_RISK_FACTOR = 3.0;

    public static double getMachineRiskFactor(String machineryState) throws RobotSafetyException {
        if (machineryState.equals("Worn")) {
            return WORN_RISK_FACTOR;
        } else if (machineryState.equals("Faulty")) {
            return FAULTY_RISK_FACTOR;
        } else if (machineryState.equals("Critical")) {
            return CRITICAL_RISK_FACTOR;
        } else {
            throw new RobotSafetyException("Error: Unsupported machinery state");
        }
    }

    public static double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState) throws RobotSafetyException {
        // Validate arm precision
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }

        // Validate worker density
        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        // Get machine risk factor (validates machinery state)
        double machineRiskFactor = getMachineRiskFactor(machineryState);

        // Calculate and return hazard risk
        return (1.0 - armPrecision) * 15.0 + workerDensity * machineRiskFactor;
    }

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
            double hazardRisk = calculateHazardRisk(armPrecision, workerDensity, machineryState);
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
