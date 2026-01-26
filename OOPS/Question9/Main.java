public class Main{
    public static void main(String[] args) {

        Rentable v1 = new Bike(6, true);
        Rentable v2 = new Car(6, false);
        Rentable v3 = new Truck(6, true);

        System.out.println(v1.calculateTotalRent());
        System.out.println(v2.calculateTotalRent());
        System.out.println(v3.calculateTotalRent());
    }
}

// Interface
interface Rentable {
    double calculateBaseRent();
    double calculateTotalRent();
}

// Abstract class
abstract class Vehicle {
    private int days;
    private double baseRate;
    private boolean loyalCustomer;

    Vehicle(int days, double baseRate, boolean loyalCustomer) {
        this.days = days;
        this.baseRate = baseRate;
        this.loyalCustomer = loyalCustomer;
    }

    int getDays() {
        return days;
    }

    double getBaseRate() {
        return baseRate;
    }

    boolean isLoyalCustomer() {
        return loyalCustomer;
    }

    double applySurge(double amount) {
        return amount;
    }

    double applyDiscount(double amount) {
        if (loyalCustomer) {
            return amount * 0.90; // 10% discount
        }
        return amount;
    }
}

// Bike
class Bike extends Vehicle implements Rentable {

    Bike(int days, boolean loyalCustomer) {
        super(days, 300, loyalCustomer);
    }

    public double calculateBaseRent() {
        return getDays() * getBaseRate();
    }

    public double calculateTotalRent() {
        double rent = calculateBaseRent();
        if (getDays() > 5) {
            rent += 500;
        }
        rent = applyDiscount(rent);
        return rent;
    }
}

// Car
class Car extends Vehicle implements Rentable {

    Car(int days, boolean loyalCustomer) {
        super(days, 1000, loyalCustomer);
    }

    public double calculateBaseRent() {
        return getDays() * getBaseRate();
    }

    public double calculateTotalRent() {
        double rent = calculateBaseRent();
        if (getDays() > 5) {
            rent += 1500;
        }
        rent = applyDiscount(rent);
        return rent;
    }
}

// Truck
class Truck extends Vehicle implements Rentable {

    Truck(int days, boolean loyalCustomer) {
        super(days, 2500, loyalCustomer);
    }

    public double calculateBaseRent() {
        return getDays() * getBaseRate();
    }

    public double calculateTotalRent() {
        double rent = calculateBaseRent();
        if (getDays() > 5) {
            rent += 3000;
        }
        rent = applyDiscount(rent);
        return rent;
    }
}