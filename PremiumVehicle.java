/**
 * Premium Vehicles only, very limited vehicles, chidlren of vehicle class.
 * @author Christian Guerra
 * @since  April 28th, 2023
 */
public class PremiumVehicle extends Vehicle{

    // Error message to use in OperationDeniedException
    private static final String INVALID_INPUT =
            "The input vehicle is not a premium vehicle.";
    private static final String [] PREMIUM_VEHICLE_BRAND =
            new String[] {"lamborghini", "ferrari", "bmw", "mercedes","audi"};
    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";

    /**
     *
     * @param VehicleName String of the name of the vehicle, must be premium car
     * @throws OperationDeniedException returns error if not found
     */
    public PremiumVehicle(String VehicleName)
            throws OperationDeniedException {
        super(VehicleName);
        boolean isPremium = false;
        for (String brand : PREMIUM_VEHICLE_BRAND) {
            if (VehicleName.toLowerCase().contains(brand)) {
                isPremium = true;
                break;
            }
        }
        if (!isPremium) {
            throw new OperationDeniedException(INVALID_INPUT);
        }
        vehicleID = 1;
    }

    /**
     *
     * @param p takes in passenger object
     * @return boolean value of if passenger is a valued passenger and not standard, as well as
     * if it is already on the vehicle or not
     * @throws OperationDeniedException error if passenger isnt a valued passenger
     */
    public boolean addPassengerToVehicle(Passenger p) throws OperationDeniedException{
        if (!(p instanceof ValuePassenger)) {
            throw new OperationDeniedException(DENIED_PASSENGER_GROUP);
        }
        ValuePassenger valuePassenger = (ValuePassenger) p;
        if (passengerNames.contains(valuePassenger.displayName())) {
            return false;
        }
        currentPassengers.add(valuePassenger);
        passengerNames.add(valuePassenger.displayName());
        return true;
    }

    // bmw01 (Premium) [2022-10-08]: [<Value Passenger> Yunyi]

    /**
     *
     * @return String of Vehicle Information, returns date vehicle name and passenger name.
     */
    public String getVehicleInfo() {
        return String.format("%s (Premium) [%s]: %s", getVehicleName(), getDate(), passengerNames);
    }


}
