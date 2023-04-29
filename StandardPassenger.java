/**
 * TODO
 * @author TODO
 * @since  TODO
 */
public class StandardPassenger extends Passenger{

    // instance variable
    private int passengerID;

    public StandardPassenger(String username, String bio){
        super(username, bio);
        this.passengerID = 0;
    }

    public String displayName() {
        return this.username;
    }
}