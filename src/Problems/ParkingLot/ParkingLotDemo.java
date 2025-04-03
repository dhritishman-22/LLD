package Problems.ParkingLot;

import Problems.ParkingLot.vehicleType.Car;
import Problems.ParkingLot.vehicleType.Motorcycle;
import Problems.ParkingLot.vehicleType.Truck;
import Problems.ParkingLot.vehicleType.Vehicle;

public class ParkingLotDemo {
    public static void run() {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 10));
        parkingLot.addLevel(new Level(2, 8));

        Vehicle car = new Car("Car123");
        Vehicle truck = new Truck("Tata321");
        Vehicle motorcycle = new Motorcycle("H2Rxyz");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        parkingLot.showAvailability();

        parkingLot.unparkVehicle(motorcycle);
        System.out.println();

        parkingLot.showAvailability();
    }
}
