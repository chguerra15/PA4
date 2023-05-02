import java.util.ArrayList;

public class ShareableRide implements RideScheduler{

    // A message to display when a passenger tries to join the ride but does
    // not belong to the right passenger group.
    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";

    // A message to display when an invalid action is performed.
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";

    // The maximum number of passengers allowed per vehicle.
    private final int CARPOOL_LIMIT = 5;

    // The list of vehicles in the ride.
    private ArrayList<Vehicle> vehicles;

    // The list of passengers in the ride.
    private ArrayList<Passenger> passengers;

    // The list of assignments of passengers to vehicles.
    private ArrayList<String> assignments;

    /**
     * Initializes the ride with empty lists of vehicles, passengers, and assignments.
     */
    public ShareableRide(){
        vehicles = new ArrayList<Vehicle>();
        passengers = new ArrayList<Passenger>();
        assignments = new ArrayList<String>();
    }

    /**
     * Returns the list of vehicles in the ride.
     *
     * @return the list of vehicles in the ride.
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Returns the list of passengers in the ride.
     *
     * @return the list of passengers in the ride.
     */
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Adds a passenger to the ride if they are a `ValuePassenger` and have not already been added.
     *
     * @param p the passenger to add to the ride.
     * @return true if the passenger was added successfully, false otherwise.
     * @throws OperationDeniedException if the passenger is not a `ValuePassenger`.
     */
    public boolean addPassenger(Passenger p) throws OperationDeniedException {
        if (!(p instanceof ValuePassenger)) {
            throw new OperationDeniedException(DENIED_PASSENGER_GROUP);
        }
        if (passengers.contains(p)) {
            return false;
        }
        passengers.add(p);
        return true;
    }

    /**
     * Adds a vehicle to the ride if it has not already been added.
     *
     * @param v the vehicle to add to the ride.
     * @return true if the vehicle was added successfully, false otherwise.
     */
    public boolean addVehicle(Vehicle v) {
        if (vehicles.contains(v)) {
            return false;
        }
        vehicles.add(v);
        return true;
    }

    /**
     * Assigns passengers to vehicles in the ride.
     *
     * @throws OperationDeniedException if the number of passengers exceeds the
     * total number of seats in the ride.
     */
    public void assignPassengerToVehicle() throws OperationDeniedException {
        int totalSeats = vehicles.size() * CARPOOL_LIMIT;
        if (passengers.size() > totalSeats) {
            throw new OperationDeniedException(INVALID_ACTION);
        }
        for (Vehicle vehicle : vehicles) {//lopp through all vehicle and verifies carpool capacity
            ArrayList<Passenger> assignedPassengers = new ArrayList<Passenger>();
            for (int i = 0; i < CARPOOL_LIMIT && !passengers.isEmpty(); i++) {
                assignedPassengers.add(passengers.remove(0));
            }
            if (!assignedPassengers.isEmpty()) {
                assignments.add(vehicle.getVehicleInfo() + ": " + assignedPassengers.toString());
            }
        }
    }


    /**
     *
     * @return list of assignments
     */
    public ArrayList<String> getRecords() {
        return assignments;
    }
}
