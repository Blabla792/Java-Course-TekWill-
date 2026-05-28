package homework9.task1;

public class Main {

    public static void main(String[] args) {

        ParkingCharges car1 = new ParkingCharges("CAT 224", 8.5);
        ParkingCharges car2 = new ParkingCharges("MAV 284", 5.0);
        ParkingCharges car3 = new ParkingCharges("OOD 001", 15.0);
        ParkingCharges car4 = new ParkingCharges("GHT 820", 28);
        ParkingCharges car5 = new ParkingCharges("TTN 428", -5);

        ParkingCharges[] cars = {car1, car2, car3, car4, car5};

        printParkingCarsList(cars, "List Of Charged Cars");

    }

    public static void printParkingCarsList(ParkingCharges[] parkingCharges,
                                            String tableName) {

        System.out.println("=".repeat(62));
        System.out.println(tableName.toUpperCase());
        System.out.println("-".repeat(62));
        System.out.printf("%s | %s | %s | %s%n",
                "Costumer Car Number", "Hours Parked", "Total Parking Fee", "Total");
        System.out.println("-".repeat(62));

        String formattedTotalParkingFee;

        for (ParkingCharges parkingCharge : parkingCharges) {

            formattedTotalParkingFee = String.format("$%,.2f", parkingCharge.getTotalParkingFee());

            System.out.printf("%-19s | %,12.0f | %17s%s%n", parkingCharge.getLicensePlate(),
                    parkingCharge.getHoursParked(), formattedTotalParkingFee, " |");
        }

        System.out.println("-".repeat(62));
        formattedTotalParkingFee = String.format("$%,.2f", ParkingCharges.getTotalCollectedFees());
        System.out.printf("%s%57s%n", "TOTAL", formattedTotalParkingFee);
        System.out.println("=".repeat(62));
    }
}
