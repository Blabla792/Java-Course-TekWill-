package homework9.task1;

public class ParkingCharges {

    private final String licensePlate;
    private final double hoursParked;
    private double totalParkingFee;

    private static double totalCollectedFees = 0.0;

    private static final double MINIMUM_FEE = 2.00;
    private static final double ADDITIONAL_FEE_PER_HOUR = 0.5;
    private static final double MAXIMUM_CHARGE = 10;

    public ParkingCharges(String costumerCarNumber, double hoursParked) {
        this.licensePlate = costumerCarNumber;
        this.hoursParked = hoursParked;

        calculateCharges();
    }

    public void calculateCharges() {

        if (hoursParked <= 0 || hoursParked > 24) {
            System.out.println(licensePlate + " - Error: You cannot park for more than 24 hours (or less than 0)!");
            return;
        }

        if (hoursParked <= 3) {
            totalParkingFee = MINIMUM_FEE;
        } else {
            double additionalChargeableHours = Math.ceil(hoursParked - 3);
            totalParkingFee = MINIMUM_FEE + (ADDITIONAL_FEE_PER_HOUR * additionalChargeableHours);
        }

        if (totalParkingFee > MAXIMUM_CHARGE) {
            totalParkingFee = MAXIMUM_CHARGE;
        }

        totalCollectedFees += totalParkingFee;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getHoursParked() {
        return hoursParked;
    }

    public double getTotalParkingFee() {
        return totalParkingFee;
    }

    public static double getTotalCollectedFees() {
        return totalCollectedFees;
    }
}
