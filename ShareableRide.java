import java.util.ArrayList;

public class ShareableRide {
    private static final String DENIED_PASSENGER_GROUP = "Passenger is not a " +
            "ValuePassenger and cannot book a ShareableRide.";
    private static final String INVALID_ACTION = "Unable to create passenger-" +
            "to-vehicle assignments.";
    private static final int CARPOOL_LIMIT = 5;

    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    public ShareableRide() {
        vehicles = new ArrayList<>();
        passengers = new ArrayList<>();
        assignments = new ArrayList<>();
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
            throw new OperationDeniedException(INVALID_ACTION);
        }
        for (Vehicle vehicle : vehicles) {
            ArrayList<Passenger> assignedPassengers = new ArrayList<>();
            for (int i = 0; i < CARPOOL_LIMIT && !passengers.isEmpty(); i++) {
                Passenger p = passengers.remove(0);
                try {
                    vehicle.addPassengerToVehicle(p);
                    assignedPassengers.add(p);
                } catch (OperationDeniedException e) {
                    passengers.add(0, p);
                    continue;
                }
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