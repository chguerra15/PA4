/*
  Name: Your Name
  PID:  A12345678
 */
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * TODO
 * @author TODO
 * @since  TODO
 */

public abstract class Vehicle {

    private LocalDate date;
    private final String vehicle;
    protected final ArrayList<Passenger> currentPassengers;
    protected final ArrayList<String> passengerNames;
    protected int vehicleID;

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

    public LocalDate getDate() {
        return this.date;
    }

    public String getVehicleName() {
        return this.vehicle;
    }

    public ArrayList<Passenger> getCurrentPassengers() {
        return this.currentPassengers;
    }

    public Integer getVehicleID() {
        return this.vehicleID;
    }

    public abstract boolean addPassengerToVehicle(Passenger p)
            throws OperationDeniedException;

    public abstract String getVehicleInfo();
}
