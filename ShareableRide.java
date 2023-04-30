import java.util.ArrayList;

public class ShareableRide implements RideScheduler{

    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    private final int CARPOOL_LIMIT = 5;

    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    public ShareableRide(){
        vehicles = new ArrayList<Vehicle>();
        passengers = new ArrayList<Passenger>();
        assignments = new ArrayList<String>();
    }


    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

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

    public boolean addVehicle(Vehicle v) {
        if (vehicles.contains(v)) {
            return false;
        }
        vehicles.add(v);
        return true;
    }
    public void assignPassengerToVehicle() throws OperationDeniedException {
        int totalSeats = vehicles.size() * CARPOOL_LIMIT;
        if (passengers.size() > totalSeats) {
            throw new OperationDeniedException("There are not enough seats available for all passengers.");
        }
        for (Vehicle vehicle : vehicles) {
            ArrayList<Passenger> assignedPassengers = new ArrayList<Passenger>();
            for (int i = 0; i < CARPOOL_LIMIT && !passengers.isEmpty(); i++) {
                assignedPassengers.add(passengers.remove(0));
            }
            if (!assignedPassengers.isEmpty()) {
                assignments.add(vehicle.getVehicleInfo() + ": " + assignedPassengers.toString());
            }
        }
    }


    public ArrayList<String> getRecords() {
        return assignments;
    }
}
