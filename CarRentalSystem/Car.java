public class Car {
    private String registrationNumber;
    private String model;
    private double dailyRate;
    private boolean isAvailable;

    public Car(String registrationNumber, String model, double dailyRate) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "RegNo='" + registrationNumber + '\'' +
                ", Model='" + model + '\'' +
                ", Rate=" + dailyRate +
                ", Available=" + isAvailable +
                '}';
    }
}
