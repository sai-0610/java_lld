import Product.Vehicle;
import Product.VehicleType;
import Product.Car;
import Product.Bike;
import Product.Status;
public class Location {

    String address;
    int pincode;
    String city;
    String state;
    String country;

    Location(int pincode, String city, String state, String country) {
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;

    }
}
