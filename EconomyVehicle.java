/**
 * Economy Vehicle, only accepts Standard Passengers
 * @author TODO
 * @since  TODO
 */
public class EconomyVehicle extends Vehicle{

    private int vehicleID;

    /**
     *
     * @param VehicleName takes in vehicle name but must contain any actual vehicle name
     */
    public EconomyVehicle(String VehicleName) {
        super(VehicleName);
        this.vehicleID = 0;
    }

    /**
     *
     * @param p Takes in Passenger object
     * @return adds passenger to vehicle, returns false otherwise
     */
    public boolean addPassengerToVehicle(Passenger p) {
        if (this.currentPassengers.contains(p)) {
            return false;
        } else {
            this.currentPassengers.add(p);
            return true;
        }
    }

    /**
     *
     *
     * @return string about the vehicle info, returns type of vehicle, date and passenger
     */
    public String getVehicleInfo() {
        String passengerNames = "";
        for (Passenger p : currentPassengers) {
            passengerNames += p.displayName() + "";
        }
        return String.format("%s [%s]: [%s]", this.getVehicleName(), this.getDate(),
                passengerNames);
    }


}