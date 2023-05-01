/**
 * TODO
 * @author TODO
 * @since  TODO
 */
public class EconomyVehicle extends Vehicle{

    private int vehicleID;

    public EconomyVehicle(String VehicleName) {
        super(VehicleName);
        this.vehicleID = 0;
    }

    public boolean addPassengerToVehicle(Passenger p) {
        if (this.currentPassengers.contains(p)) {
            return false;
        } else {
            this.currentPassengers.add(p);
            return true;
        }
    }

    public String getVehicleInfo() {
        String passengerNames = "";
        for (Passenger p : currentPassengers) {
            passengerNames += p.displayName() + " ";
        }
        return String.format("%s [%s]: [%s]", this.getVehicleName(), this.getDate(), passengerNames);
    }


}