/**
 * TODO
 * @author Christian Guerra
 * @since  TODO
 */
public class PremiumVehicle extends Vehicle{

    // Error message to use in OperationDeniedException
    private static final String INVALID_INPUT =
            "The input vehicle is not a premium vehicle.";
    private static final String [] PREMIUM_VEHICLE_BRAND =
            new String[] {"lamborghini", "ferrari", "bmw", "mercedes","audi"};
    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";

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

    public boolean addPassengerToVehicle(Passenger p) throws OperationDeniedException{
    return false;}

    // bmw01 (Premium) [2022-10-08]: [<Value Passenger> Yunyi]
    public String getVehicleInfo() {
        return String.format("%s (Premium) [%s]: %s", getVehicleName(), getDate(), getCurrentPassengers());
    }
}