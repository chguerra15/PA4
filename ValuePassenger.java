/*
  Name: Your Name
  PID:  A12345678
 */

/**
 * TODO
 * @author TODO
 * @since  TODO
 */
public class ValuePassenger extends Passenger{

    // instance variable
    private String customTitle;

    /**
     *
     * @param username Username of the passenger
     * @param bio Details of passenger
     */
    public ValuePassenger(String username, String bio){
        super(username, bio);
        customTitle = "Value Passenger";
        passengerID = 1;
    }

    /**
     *
     * @return Display name of title and the username of the passenger
     */
    public String displayName() {
        return String.format("<%s> %s", customTitle, username);
    }

    /**
     *
     * @param newTitle Custom title for vehicle
     * @return the new customized title
     */
    public void setCustomTitle(String newTitle) {
        if(newTitle == null){
            throw new IllegalArgumentException("Title cannot be null.");
        }
        customTitle = newTitle;
    }
}
