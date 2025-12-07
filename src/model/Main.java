package model;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of stack: ");
        int n = scanner.nextInt();
        System.out.println("Enter capacity of each stack: ");
        int m = scanner.nextInt();
        Parking parking = new Parking(n, m);
        QueueCar queue = new QueueCar();
        boolean running = true;
        while (running) {
            System.out.println("\n *** Parking Menu ***");
            System.out.println("1. Add car to queue");
            System.out.println("2. Park car in first available stack");
            System.out.println("3. Park car in specified stack");
            System.out.println("4. Remove car from stack");
            System.out.println("5. Sort a stack");
            System.out.println("6. Move cars between stacks");
            System.out.println("7. Find car");
            System.out.println("8. Exit");
            System.out.println("Choose option (Enter the number of option): ");
            int choice = scanner.nextInt();
            scanner.nextInt();
            switch (choice) {
                case 1:
                    String plate = scanner.nextLine();
                    LocalDateTime now = LocalDateTime.now();
                    CarInformation car = new CarInformation(plate, now);
                    queue.enqueue(car);
                    System.out.println("Car added to queue at " + now);
                    break;
                case 2:
                    parking.parkFirstAvailableStack(queue);
                    break;
                case 3:
                    System.out.println("Enter your stack number: ");
                    int stackNumber1 = scanner.nextInt();
                    parking.parkInSpecifiedStack(queue, stackNumber1);
                    break;
                case 4:
                    System.out.println("Enter your stack number: ");
                    int stackNumber2 = scanner.nextInt();
                    System.out.println("Enter car plate number: ");
                    String plateNumber = scanner.nextLine();
                    try {
                        CarInformation removed = parking.removeCar(stackNumber2, plateNumber);
                        System.out.println("Removed car: " + removed.getPlateNumber());
                    } catch (Exception e) {
                        System.out.println("Can't delete the car!");
                    }
                    break;
                case 5:
                    System.out.println("Enter stack number to sort: ");
                    int sortNumber = scanner.nextInt();
                    parking.sortStack(sortNumber);
                    System.out.println("Stack" + sortNumber + "sorted.");
                case 6:
                    System.out.println("Enter source stack: ");
                    int i = scanner.nextInt();
                    System.out.println("Enter destination stack: ");
                    int j = scanner.nextInt();
                    parking.moveCar(i, j);
                    break;
                case 7:
                    System.out.println("Enter plate number to search: ");
                    String searchPlate = scanner.nextLine();
                    String result = parking.find(searchPlate);
                    System.out.println(result);
                    break;
                case 8:
                    running = false;
                    System.out.print("Exiting program...");
                    break;
                default:
                    System.out.print("Invalid choice!");
            }
        }
        scanner.close();;
    }
}