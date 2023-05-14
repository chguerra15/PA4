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
    ValuePassenger chris;

    PremiumVehicle vehicle2;
    LocalDate date = LocalDate.now();@BeforeEach
    public void setup()throws OperationDeniedException {
        yunyi = new ValuePassenger("Yunyi", "Tutor");
        chris = new ValuePassenger("Christian", "Data Scientist");
        vehicle2 = new PremiumVehicle("Ferrari");
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
    public void testPremiumVehicleIDandPassanger() throws OperationDeniedException {
        PremiumVehicle premiumVehicle = new PremiumVehicle("Lamborghini");
        assertEquals(1, premiumVehicle.getVehicleID());
        PremiumVehicle premiumVehicle1 = new PremiumVehicle("Ferrari");
        premiumVehicle1.vehicleID = 12345;
        assertEquals(12345, premiumVehicle1.getVehicleID());
        PremiumVehicle ChrisCar = new PremiumVehicle("mercedes8");
        ChrisCar.vehicleID = 17660168;
        assertEquals(17660168, ChrisCar.getVehicleID());
        assertEquals("mercedes8", ChrisCar.getVehicleName());
        ValuePassenger chris = new ValuePassenger("Chris", "Data Scientist");
        ChrisCar.addPassengerToVehicle(chris);
        assertEquals("mercedes8 (Premium) [" + ChrisCar.getDate() +"]: [" +
                        "<Value Passenger>" +
                        " Chris]",
                ChrisCar.getVehicleInfo());


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
        chris.passengerID = 17660194;
        assertEquals(17660194, chris.getPassengerID());
        chris.passengerID = 1234;
        assertEquals(1234, chris.getPassengerID());
    }@Test
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
            assertEquals("Passenger is not a ValuePassenger and" +
                            " cannot book a ShareableRide.",
                    e.getMessage());
        }
    }@Test
    public void testAddVehicle(){
        ShareableRide ride2 = new ShareableRide();
        Vehicle v1 = new EconomyVehicle("Audi");
        assertTrue(ride2.addVehicle(v1));
        assertFalse(ride2.addVehicle(v1));
        ShareableRide ride3 = new ShareableRide();
        Vehicle c3 = new EconomyVehicle("Toyota3");
        assertTrue(ride3.addVehicle(c3));
        assertFalse(ride3.addVehicle(c3));
        ShareableRide ride4 = new ShareableRide();
        Vehicle v4 = new EconomyVehicle("Audi");
        assertTrue(ride4.addVehicle(v4));
        assertFalse(ride4.addVehicle(v4));
    }@Test
    public void testAddPassengerToVehicle() throws OperationDeniedException {
        Vehicle vehicle = new PremiumVehicle("Ferrari");
        Passenger passenger = new ValuePassenger("John", "Pork");
        boolean result = vehicle.addPassengerToVehicle(passenger);
        assertTrue(result);
        result = vehicle.addPassengerToVehicle(passenger);
        assertFalse(result);
        Passenger passenger2 = new StandardPassenger("Bob", "I don't like cars");
        assertThrows(OperationDeniedException.class, () -> vehicle.addPassengerToVehicle
                (passenger2));
    }@Test
    void testAddPassengerToVehicle3() {
        EconomyVehicle vehicle = new EconomyVehicle("Honda Civic");
        Passenger passenger1 = new StandardPassenger("Alice", "Wonderland");
        assertTrue(vehicle.addPassengerToVehicle(passenger1));
        assertFalse(vehicle.addPassengerToVehicle(passenger1));
        Passenger passenger2 = new StandardPassenger("Bob", "Constructor");
        assertTrue(vehicle.addPassengerToVehicle(passenger2));
    }@Test
    void testGetVehicleInfo() throws OperationDeniedException {
        vehicle2.addPassengerToVehicle(chris);
        assertEquals("Ferrari (Premium) [" + vehicle2.getDate() + "]:" +
                        " [<Value Passenger> Christian]"
                , vehicle2.getVehicleInfo());
    }

    @Test
    public void testAddPassengerAndVehicle() {
        StandardRide ride = new StandardRide();
        Passenger passenger = new StandardPassenger("John", "prok");
        Vehicle vehicle = new EconomyVehicle("Sedan");

        assertTrue(ride.addPassenger(passenger));
        assertTrue(ride.addVehicle(vehicle));
        assertEquals(1, ride.getPassengers().size());
        assertEquals(1, ride.getVehicles().size());
        assertEquals(passenger, ride.getPassengers().get(0));
        assertEquals(vehicle, ride.getVehicles().get(0));
    }

    @Test
    public void testDisplayandsetBIO(){
        Passenger jose = new StandardPassenger("jose", "Rendon");
        jose.setBio("Hola como estas");
        assertEquals("Hola como estas", jose.displayBio());
        Passenger chrisre = new ValuePassenger("Chris", "Ronaldo");
        chrisre.setBio("Cristiano");
        assertEquals("Cristiano", chrisre.displayBio());
        Passenger tito = new StandardPassenger("tito45", "Texis");
        tito.setBio("Fillmore");
        assertEquals("Fillmore", tito.displayBio());

    }

    @Test
    void testConstructorWithEconomyVehicleName() throws OperationDeniedException {
        // Test constructor and getVehicleName method
        EconomyVehicle vehicle1 = new EconomyVehicle("Toyota");
        assertEquals("Toyota", vehicle1.getVehicleName());
        EconomyVehicle vehicle2 = new EconomyVehicle("Honda");
        assertEquals("Honda", vehicle2.getVehicleName());
        EconomyVehicle vehicle3 = new EconomyVehicle("Ford");
        assertEquals("Ford", vehicle3.getVehicleName());

        // Test addPassengerToVehicle method
        Passenger passenger1 = new StandardPassenger("John", "Doe");
        assertTrue(vehicle1.addPassengerToVehicle(passenger1));
        assertFalse(vehicle1.addPassengerToVehicle(passenger1));

        // Test getVehicleInfo method
        Passenger passenger2 = new StandardPassenger("Jane", "Doe");
        vehicle1.addPassengerToVehicle(passenger2);
    }

    @Test
    void testAssignPassengerToVehicle() throws OperationDeniedException {
        // Create some vehicles and passengers
        EconomyVehicle vehicle1 = new EconomyVehicle("Toyota");
        EconomyVehicle vehicle2 = new EconomyVehicle("Honda");
        ValuePassenger passenger1 = new ValuePassenger("John", "Doe");
        ValuePassenger passenger2 = new ValuePassenger("Jane", "Doe");
        ValuePassenger passenger3 = new ValuePassenger("Tom", "Hanks");
        ValuePassenger passenger4 = new ValuePassenger("Emma", "Watson");
        ValuePassenger passenger5 = new ValuePassenger("Johnny", "Depp");
        ValuePassenger passenger6 = new ValuePassenger("Angelina", "Jolie");
        vehicle1.addPassengerToVehicle(passenger1);
        vehicle1.addPassengerToVehicle(passenger2);
        vehicle1.addPassengerToVehicle(passenger3);
        vehicle1.addPassengerToVehicle(passenger4);
        vehicle1.addPassengerToVehicle(passenger5);
        vehicle2.addPassengerToVehicle(passenger6);

        // Create a shareable ride and add passengers and vehicles
        ShareableRide shareableRide = new ShareableRide();
        shareableRide.addVehicle(vehicle1);
        shareableRide.addVehicle(vehicle2);
        for (Passenger passenger : vehicle1.currentPassengers) {
            shareableRide.addPassenger(passenger);
        }

        // Assign passengers to vehicles
        shareableRide.assignPassengerToVehicle();

        // Check that the correct assignments were made
        assertEquals("Toyota [2023-05-14]: [<Value Passenger>" +
                " John, <Value Passenger> Jane, <Value Passenger> Tom, <Value Passenger> Emma," +
                " <Value Passenger> Johnny]", vehicle1.getVehicleInfo());
        assertEquals("Honda [2023-05-14]: [<Value Passenger> Angelina]"
                , vehicle2.getVehicleInfo());
        assertTrue(shareableRide.getRecords().size()>0);
    }

    @Test
    void testgetInfo() throws OperationDeniedException{
        EconomyVehicle vehicle1 = new EconomyVehicle("Toyota");
        EconomyVehicle vehicle2 = new EconomyVehicle("Nissan");
        ValuePassenger passenger1 = new ValuePassenger("John", "Doe");
        vehicle1.addPassengerToVehicle(passenger1);
        ValuePassenger passenger2 = new ValuePassenger("Jane", "Doe");
        ValuePassenger passenger3 = new ValuePassenger("Tom", "Hanks");
        ValuePassenger passenger4 = new ValuePassenger("Emma", "Watson");
        ValuePassenger passenger5 = new ValuePassenger("Johnny", "Depp");
        ValuePassenger passenger6 = new ValuePassenger("Angelina", "Jolie");
        passenger1.setCustomTitle("Data Scientist");
        ShareableRide ride1 = new ShareableRide();
        ride1.addVehicle(vehicle1);
        ride1.addVehicle(vehicle2);
        ride1.addPassenger(passenger1);
        ride1.addPassenger(passenger2);
        ride1.addPassenger(passenger3);
        ride1.addPassenger(passenger4);
        ride1.addPassenger(passenger5);
        ride1.addPassenger(passenger6);
        ride1.assignPassengerToVehicle();
        System.out.println(vehicle1.getCurrentPassengers());
        
        assertEquals("Toyota ["+ vehicle1.getDate().toString() +"]: [<Data Scientist> " +
                "John, <Value Passenger> Jane, <Value Passenger> Tom, <Value Passenger> Emma, " +
                "<Value Passenger> Johnny]", vehicle1.getVehicleInfo()
        );
        System.out.println(vehicle1.getCurrentPassengers().size());//here it does output the number
        //of passengers in a vehicle.
        System.out.print(vehicle2.getCurrentPassengers().size());

    }

        @Test
        public void testConstructor() {
            // Test valid premium vehicle name
            try {
                PremiumVehicle premiumVehicle = new PremiumVehicle("Lamborghini Aventador");
                assertEquals("Lamborghini Aventador", premiumVehicle.getVehicleName());
            } catch (OperationDeniedException e) {
                fail("Exception thrown unexpectedly: " + e.getMessage());
            }

            // Test invalid non-premium vehicle name
            try {
                PremiumVehicle premiumVehicle = new PremiumVehicle("Toyota Corolla");
                fail("Expected OperationDeniedException not thrown.");
            } catch (OperationDeniedException e) {
                assertEquals("The input vehicle is not a premium vehicle.", e.getMessage());
            }
        }

        @Test
        public void testAddPassengerToVehicle2() {
            // Test adding valid ValuePassenger to premium vehicle
            try {
                PremiumVehicle premiumVehicle = new PremiumVehicle("Lamborghini Aventador");
                ValuePassenger valuePassenger = new ValuePassenger("Yunyi", "h");
                assertTrue(premiumVehicle.addPassengerToVehicle(valuePassenger));
                assertTrue(premiumVehicle.getCurrentPassengers().contains(valuePassenger));
            } catch (OperationDeniedException e) {
                fail("Exception thrown unexpectedly: " + e.getMessage());
            }

            // Test adding invalid StandardPassenger to premium vehicle
            try {
                PremiumVehicle premiumVehicle = new PremiumVehicle("Lamborghini" +
                        " Aventador");
                StandardPassenger standardPassenger = new StandardPassenger("Bob", "j");
                premiumVehicle.addPassengerToVehicle(standardPassenger);
                fail("Expected OperationDeniedException not thrown.");
            } catch (OperationDeniedException e) {
                assertEquals("This operation is disabled in your passenger group.",
                        e.getMessage());
            }

            // Test adding duplicate passenger to premium vehicle
            try {
                PremiumVehicle premiumVehicle = new PremiumVehicle("Lamborghini" +
                        " Aventador");
                ValuePassenger valuePassenger = new ValuePassenger("Yunyi", "oh");
                premiumVehicle.addPassengerToVehicle(valuePassenger);
                assertFalse(premiumVehicle.addPassengerToVehicle(valuePassenger));
            } catch (OperationDeniedException e) {
                fail("Exception thrown unexpectedly: " + e.getMessage());
            }
        }

        @Test
        public void testGetVehicleInfo2() {
            // Test getting vehicle info for premium vehicle with passengers
            try {
                PremiumVehicle premiumVehicle = new PremiumVehicle("Lamborghini " +
                        "Aventador");
                ValuePassenger valuePassenger = new ValuePassenger("Yunyi", "oh");
                premiumVehicle.addPassengerToVehicle(valuePassenger);
                assertEquals("Lamborghini Aventador (Premium) [" + premiumVehicle.
                        getDate() +
                        "]: [<Value Passenger> Yunyi]", premiumVehicle.getVehicleInfo());
            } catch (OperationDeniedException e) {
                fail("Exception thrown unexpectedly: " + e.getMessage());
            }

            // Test getting vehicle info for premium vehicle with no passengers
            try {
                PremiumVehicle premiumVehicle = new PremiumVehicle("Lamborghini " +
                        "Aventador");
                assertEquals("Lamborghini Aventador (Premium) [" + premiumVehicle.
                        getDate() +
                        "]: []", premiumVehicle.getVehicleInfo());
            } catch (OperationDeniedException e) {
                fail("Exception thrown unexpectedly: " + e.getMessage());
            }
        }





}
