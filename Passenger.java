/**
 * The Passenger class is the abstract class that defines the functionality of a vehicle user.
 */
public abstract class Passenger {

    // instance variables
    protected String username;
    protected String bio;
    protected int passengerID;

    /**
     * Constructor for creating a Passenger object.
     * @param username the username of the passenger like you might see in a ride-share app
     * @param bio the bio of the passenger like you might see in a ride-share app
     * @throws IllegalArgumentException if username or bio are null
     */
    public Passenger(String username, String bio) {
        if (username == null || bio == null) {
            throw new IllegalArgumentException("Username and bio cannot be null.");
        }
        this.username = username;
        this.bio = bio;
    }

    /**
     * Updates the bio of the passenger.
     * @param newBio the new bio of the passenger
     * @throws IllegalArgumentException if newBio is null
     */
    public void setBio(String newBio) {
        if (newBio == null) {
            throw new IllegalArgumentException("Bio cannot be null.");
        }
        this.bio = newBio;
    }

    /**
     * Returns the bio of the passenger.
     * @return the bio of the passenger
     */
    public String displayBio() {
        return this.bio;
    }

    /**
     * Returns the passenger ID.
     * @return the passenger ID
     */
    public Integer getPassengerID() {
        return this.passengerID;
    }

    /**
     * Abstract method for returning the display name of the passenger.
     * All subclasses of Passenger must implement this method.
     * @return the display name of the passenger
     */
    public abstract String displayName();
}
