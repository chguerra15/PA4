import java.util.ArrayList;

public class StandardRide implements RideScheduler{

    private final String MISMATCH_MSG =
            "Each passenger should have one vehicle matched.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    public StandardRide(){
        this.vehicles = new ArrayList<Vehicle>();
        this.passengers = new ArrayList<Passenger>();
        this.assignments = new ArrayList<String>();
    }

    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public boolean addPassenger(Passenger p) {
        return this.passengers.add(p);
    }

    public boolean addVehicle(Vehicle v) {
        return this.vehicles.add(v);
    }

    /**
     *
     * @throws OperationDeniedException if vehicle size is full
     */
    public void assignPassengerToVehicle() throws OperationDeniedException {
        // Check that each passenger has a vehicle assigned
        if (this.passengers.size() >= this.vehicles.size()) {
            throw new OperationDeniedException(this.MISMATCH_MSG);
        }
        // Clear the previous assignments
        this.assignments.clear();
        // Assign each passenger to a vehicle
        for (int i = 0; i < this.passengers.size(); i++) {
            Passenger p = this.passengers.get(i);
            Vehicle v = this.vehicles.get(i);
            if (p == null || v == null) {
                throw new OperationDeniedException(this.INVALID_ACTION);
            }
            String assignment = "Passenger " + p.getPassengerID() +
                    " assigned to vehicle " + v.getVehicleID();
            this.assignments.add(assignment);
        }
    }

    /**
     *
     * @return the assignments of the car
     */
    public ArrayList<String> getRecords() {
        return this.assignments;
    }
}
