import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MotorcycleFunctions functions = new MotorcycleFunctions();

        boolean running = true;

        while (running) {

            System.out.println("\n===== MOTORCYCLE TERMINAL =====");
            if (functions.getBikeState() == false) {
                System.out.println("Status: OFF");
                System.out.println("1. Turn Motorcycle On");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");

                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        functions.startBike();
                        System.out.println("Motorcycle is now ON.");
                        break;

                    case 2:
                        running = false;
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }

                continue;
            }
            System.out.println("Status: ON");
            System.out.println("Current Speed: " + functions.getSpeed());
            System.out.println("Current Gear: " + functions.getGear());
            System.out.println("1. Turn Motorcycle Off");
            System.out.println("2. Accelerate");
            System.out.println("3. Decelerate");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    functions.turnOffBike();
                    System.out.println("Parking your bike...");
                    break;

                case 2:
                    functions.accelerate();
                    break;

                case 3:
                    functions.brake();
                    break;
                case 4:
                    running = false;
                    System.out.println("...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

    }
}
