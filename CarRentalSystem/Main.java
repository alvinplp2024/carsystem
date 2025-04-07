import java.util.*;

public class Main {
    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Rental> rentals = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addCar();
                case 2 -> addCustomer();
                case 3 -> rentCar();
                case 4 -> displayRentals();
                case 5 -> searchCar();
                case 6 -> removeCar();
                case 7 -> sortCars();
                case 8 -> displayCars();
                case 0 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void showMenu() {
        System.out.println("""
                \n---- Car Rental Menu ----
                1. Add Car
                2. Add Customer
                3. Rent Car
                4. Display All Rentals
                5. Search Car
                6. Remove Car
                7. Sort Cars by Daily Rate
                8. Display All Cars
                0. Exit
                Choose an option:""");
    }

    static void addCar() {
        System.out.print("Enter Car Reg Number: ");
        String reg = scanner.nextLine();
        System.out.print("Enter Car Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Daily Rate: ");
        double rate = scanner.nextDouble();
        scanner.nextLine();

        cars.add(new Car(reg, model, rate));
        System.out.println("Car added successfully!");
    }

    static void addCustomer() {
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter License Number: ");
        String license = scanner.nextLine();

        customers.add(new Customer(name, license));
        System.out.println("Customer added.");
    }

    static void rentCar() {
        System.out.print("Enter Customer License Number: ");
        String license = scanner.nextLine();
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getLicenseNumber().equals(license)) {
                customer = c;
                break;
            }
        }
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.print("Enter Car Registration Number: ");
        String reg = scanner.nextLine();
        Car car = null;
        for (Car c : cars) {
            if (c.getRegistrationNumber().equals(reg) && c.isAvailable()) {
                car = c;
                break;
            }
        }

        if (car == null) {
            System.out.println("Car not available!");
            return;
        }

        System.out.print("Enter Rental Days: ");
        int days = scanner.nextInt();
        scanner.nextLine();

        rentals.add(new Rental(customer, car, days));
        System.out.println("Car rented successfully!");
    }

    static void displayRentals() {
        if (rentals.isEmpty()) {
            System.out.println("No rentals.");
        } else {
            for (Rental r : rentals) {
                System.out.println(r);
            }
        }
    }

    static void searchCar() {
        System.out.print("Enter Car Registration Number: ");
        String reg = scanner.nextLine();
        for (Car c : cars) {
            if (c.getRegistrationNumber().equalsIgnoreCase(reg)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Car not found.");
    }

    static void removeCar() {
        System.out.print("Enter Car Reg Number to Remove: ");
        String reg = scanner.nextLine();
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car c = iterator.next();
            if (c.getRegistrationNumber().equalsIgnoreCase(reg)) {
                iterator.remove();
                System.out.println("Car removed.");
                return;
            }
        }
        System.out.println("Car not found.");
    }

    static void sortCars() {
        cars.sort(Comparator.comparingDouble(Car::getDailyRate));
        System.out.println("Cars sorted by rate.");
    }

    static void displayCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            for (Car c : cars) {
                System.out.println(c);
            }
        }
    }
}
