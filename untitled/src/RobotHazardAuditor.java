public class RobotHazardAuditor {

    // Constants for machinery risk factors
    private static final double WORN_RISK_FACTOR = 1.3;
    private static final double FAULTY_RISK_FACTOR = 2.0;
    private static final double CRITICAL_RISK_FACTOR = 3.0;

    /**
     * Get the machine risk factor based on machinery state
     * @param machineryState The state of the machinery (Worn/Faulty/Critical)
     * @return The risk factor for the given state
     * @throws RobotSafetyException if machinery state is unsupported
     */
    private static double getMachineRiskFactor(String machineryState) throws RobotSafetyException {
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

    /**
     * Calculate the hazard risk score for a factory robot
     * @param armPrecision Precision of robot arm (0.0 to 1.0)
     * @param workerDensity Number of workers in proximity (1 to 20)
     * @param machineryState State of machinery (Worn/Faulty/Critical)
     * @return The calculated hazard risk score
     * @throws RobotSafetyException if any input is invalid
     */
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
}
