/*
  Name: Christian Guerra
  PID:  A17660168
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

/**
 * Class that tests Children classes and their methods
 * @author Christian Guerra
 * @since  April 28th 2023
 */
public class RideSchedulerApplicationTest {
    ValuePassenger yunyi;
    EconomyVehicle car1;
    StandardPassenger person1;
    StandardPassenger person2;
    StandardPassenger person3;
    StandardPassenger person4;
    LocalDate date = LocalDate.now();@BeforeEach
    public void setup(){
        yunyi = new ValuePassenger("Yunyi", "Tutor");
        car1 = new EconomyVehicle("Audi");
        person1 = new StandardPassenger("Javier", "President");
        person2 = new StandardPassenger("Chris", "Software Engineer");
        person3 = new StandardPassenger("Julia", "Economist");

    }@Test
    public void testValuePassengerThrowsIAE() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValuePassenger yunyi = new ValuePassenger("Yunyi", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ValuePassenger yunyi = new ValuePassenger(
                    null, "I am a value passenger.");
        });
    }@Test
    public void testName(){
        String name = car1.getVehicleName();
        assertEquals("Audi", name);

        EconomyVehicle car2 = new EconomyVehicle("BMW");
        String name2 = car2.getVehicleName();
        assertEquals("BMW", name2);
    }@Test
    public void testaddPassengers(){
        car1.addPassengerToVehicle(person1);
        assertTrue(car1.getCurrentPassengers().contains(person1));
        car1.addPassengerToVehicle(person2);
        assertTrue(car1.getCurrentPassengers().contains(person2));
        car1.addPassengerToVehicle(person3);
        assertTrue(car1.getCurrentPassengers().contains(person3));
        car1.addPassengerToVehicle(person4);
        assertTrue(car1.getCurrentPassengers().contains(person4));
        StandardPassenger person5 = new StandardPassenger("Sarah", "Doctor");
        car1.addPassengerToVehicle(person5);
        assertTrue(car1.getCurrentPassengers().contains(person5));
    }@Test
    void testConstructorWithNullUsername() {
        assertThrows(IllegalArgumentException.class, () -> new ValuePassenger(null
                , "I am a value passenger."));

        assertThrows(IllegalArgumentException.class, () -> new StandardPassenger(null
                , "I am a standard passenger."));
    }@Test
    void testDisplayName() {
        ValuePassenger passenger = new ValuePassenger(
                "johndoe", "I am a value passenger.");
        assertEquals("<Value Passenger> johndoe", passenger.displayName());

        StandardPassenger passenger1 = new StandardPassenger
                ("janedoe", "I am a standard passenger.");
        assertEquals("janedoe", passenger1.displayName());

        ValuePassenger passenger2 = new ValuePassenger(
                "robertdoe", "I am a value passenger.");
        passenger2.setCustomTitle("VIP");
        assertEquals("<VIP> robertdoe", passenger2.displayName());
    }@Test
    void testSetCustomTitle() {
        ValuePassenger passenger = new ValuePassenger(
                "johndoe", "I am a value passenger.");
        passenger.setCustomTitle("Super Value Passenger");
        assertEquals("<Super Value Passenger> johndoe", passenger.displayName());
    }@Test
    void testSetCustomTitleWithNullTitle() {
        ValuePassenger passenger = new ValuePassenger(
                "johndoe", "I am a value passenger.");
        assertThrows(IllegalArgumentException.class, () -> passenger.setCustomTitle(null));
    }@Test
    void testConstructorWithValidUsernameAndBio() {
        StandardPassenger passenger = new StandardPassenger(
                "johndoe", "I am a standard passenger.");
        assertEquals("johndoe", passenger.displayName());
        StandardPassenger passenger1 = new StandardPassenger(
                "Chris", "Software Engineer");
        assertEquals("Chris", passenger1.displayName());
        StandardPassenger passenger2 = new StandardPassenger(
                "julia", "Cashier");
        assertEquals("julia", passenger2.displayName());
    }@Test
    void testConstructorWithPremiumVehicleName() throws OperationDeniedException {
        PremiumVehicle vehicle1 = new PremiumVehicle("Lamborghini");
        assertEquals("Lamborghini", vehicle1.getVehicleName());
        PremiumVehicle vehicle2 = new PremiumVehicle("Ferrari");
        assertEquals("Ferrari", vehicle2.getVehicleName());
        PremiumVehicle vehicle3 = new PremiumVehicle("bmw");
        assertEquals("bmw", vehicle3.getVehicleName());
    }@Test
    void testConstructorWithNonPremiumVehicleName() {
        try {
            new PremiumVehicle("Toyota Corolla");
            fail("Expected an OperationDeniedException to be thrown");
        } catch (OperationDeniedException e) {
            assertEquals(
                    "The input vehicle is not a premium vehicle.", e.getMessage());
        }
    }@Test
    public void testPremiumVehicleConstructorValid() throws OperationDeniedException {
        PremiumVehicle premiumVehicle = new PremiumVehicle("Lamborghini");
        assertEquals(1, premiumVehicle.getVehicleID());
    }@Test
    public void testPremiumVehicleConstructorInvalid() {
        assertThrows(OperationDeniedException.class, () -> {
            new PremiumVehicle("Toyota");
        });
    }@Test
    public void testGetPassengerID() {
        assertEquals(1, yunyi.getPassengerID());
        yunyi.passengerID = 123456;
        assertEquals(Integer.valueOf(123456), yunyi.getPassengerID());
    }

    @Test
    public void testAddPassenger() throws OperationDeniedException {
        ShareableRide ride = new ShareableRide();
        Passenger p1 = new ValuePassenger("John", "Doe");
        assertTrue(ride.addPassenger(p1));
        assertFalse(ride.addPassenger(p1));
        Passenger p2 = new StandardPassenger("Jane", "Doe");
        try {
            ride.addPassenger(p2);
            fail("Expected OperationDeniedException");
        } catch (OperationDeniedException e) {
            assertEquals("This operation is disabled in your passenger group.", e.getMessage());
        }
    }

    @Test
    public void testAddVehicle(){
        ShareableRide ride2 = new ShareableRide();
        Vehicle v1 = new EconomyVehicle("Audi");
        assertTrue(ride2.addVehicle(v1));
        assertFalse(ride2.addVehicle(v1));
    }



}
