/**
 * Class for a standard Passenger, Children of passenger
 * @author Christian Guerra
 * @since  A17660168
 */
public class StandardPassenger extends Passenger{

    // instance variable
    private int passengerID;

    /**
     *
     * @param username String of the standard Passenger
     * @param bio String of the bio of passenger
     */
    public StandardPassenger(String username, String bio){
        super(username, bio);
        this.passengerID = 0;//Set Passenger ID to 0
    }

    /**
     *
     * @return username of vehicle
     */
    public String displayName() {
        return this.username;
    }
}