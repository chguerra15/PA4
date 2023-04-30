/*
  Name: Christian Guerra
  PID:  A17660168
 */
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Class that setps up vehicle instances
 * @author Christian Guerra
 * @since  April 28th 2023
 */

public abstract class Vehicle {

    private LocalDate date;
    private final String vehicle;
    protected final ArrayList<Passenger> currentPassengers;
    protected final ArrayList<String> passengerNames;
    protected int vehicleID;

    /**
     *
     * @param vehicleName takes in String name of car
     *
     */
    public Vehicle(String vehicleName) {
        if (vehicleName == null) {
            throw new IllegalArgumentException("Vehicle name cannot be null.");
        }
        this.date = LocalDate.now();
        this.vehicle = vehicleName;
        this.currentPassengers = new ArrayList<>();
        this.passengerNames = new ArrayList<>();
        this.vehicleID = 0;
    }

    /**
     *
     * @return returns date
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * returns vehicle name
     * @return
     */
    public String getVehicleName() {
        return this.vehicle;
    }

    /**
     *
     * @return passangers added to vehicle
     */
    public ArrayList<Passenger> getCurrentPassengers() {
        return this.currentPassengers;
    }

    /**
     *
     * @return returns the ID of vehicle
     */
    public Integer getVehicleID() {
        return this.vehicleID;
    }
    public abstract boolean addPassengerToVehicle(Passenger p)
            throws OperationDeniedException;

    public abstract String getVehicleInfo();
}
