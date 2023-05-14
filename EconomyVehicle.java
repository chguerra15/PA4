/**
 * Economy Vehicle, only accepts Standard Passengers
 * @author Christian Guerra
 * @since  April 28th 2023
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
            passengerNames += p.displayName() + ", ";
        }
        // Remove the trailing comma and space
        if (!passengerNames.isEmpty()) {
            passengerNames = passengerNames.substring(0, passengerNames.length() - 2);
        }
        return String.format("%s [%s]: [%s]", this.getVehicleName(), this.getDate(),
                passengerNames);
    }


}