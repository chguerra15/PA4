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

    public ValuePassenger(String username, String bio){
        super(username, bio);
        customTitle = "Value Passenger";
        passengerID = 1;
    }

    public String displayName() {
        return String.format("<%s> %s", customTitle, username);
    }

    public void setCustomTitle(String newTitle) {
        if(newTitle == null){
            throw new IllegalArgumentException("Title cannot be null.");
        }
        customTitle = newTitle;
    }
}
