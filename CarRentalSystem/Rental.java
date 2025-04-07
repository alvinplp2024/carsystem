public class Rental {
    private Customer customer;
    private Car car;
    private int rentalDays;

    public Rental(Customer customer, Car car, int rentalDays) {
        this.customer = customer;
        this.car = car;
        this.rentalDays = rentalDays;
        this.car.setAvailability(false); // Mark car as rented
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double calculateTotalCost() {
        return car.getDailyRate() * rentalDays;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "Customer=" + customer +
                ", Car=" + car +
                ", Days=" + rentalDays +
                ", Total=" + calculateTotalCost() +
                '}';
    }
}
