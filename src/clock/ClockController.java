package clock;

import java.util.Scanner;

import date.DateDisplay;
import display.Displayable;
import time.TimeDisplay;

public class ClockController {
    private ClockStateEnum currentState;
    private Displayable timeDisplay;
    private Displayable dateDisplay;
    private Scanner scanner;

    public ClockController(Displayable timeDisplay, Displayable dateDisplay) {
        currentState = ClockStateEnum.DISPLAY_TIME;
        this.timeDisplay = timeDisplay;
        this.dateDisplay = dateDisplay;
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Välj en åtgärd:");
            System.out.println("1. Visa tid");
            System.out.println("2. Visa datum");
            System.out.println("3. Ändra tid");
            System.out.println("4. Ändra datum");
            System.out.println("5. Avsluta");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (currentState) {
                case DISPLAY_TIME:
                    if (choice == 1) {
                        String currentTime = timeDisplay.getCurrentValue();
                        System.out.println("Aktuell tid: " + currentTime);
                    } else if (choice == 2) {
                        currentState = ClockStateEnum.DISPLAY_DATE;
                    } else if (choice == 3) {
                        System.out.print("Ange ny tid (HH:mm:ss): ");
                        String newTime = scanner.nextLine();
                        changeValue(timeDisplay, newTime);
                    }
                    break;
                case DISPLAY_DATE:
                    if (choice == 2) {
                        String currentDate = dateDisplay.getCurrentValue();
                        System.out.println("Aktuellt datum: " + currentDate);
                    } else if (choice == 3) {
                        currentState = ClockStateEnum.DISPLAY_TIME;
                    } else if (choice == 4) {
                        System.out.print("Ange nytt datum (yyyy-MM-dd): ");
                        String newDate = scanner.nextLine();
                        changeValue(dateDisplay, newDate);
                    }
                    break;
                case CHANGE_TIME:
                    System.out.print("Ange ny tid (HH:mm:ss): ");
                    String newTime = scanner.nextLine();
                    changeValue(timeDisplay, newTime);
                    currentState = ClockStateEnum.DISPLAY_TIME;
                    break;
                case CHANGE_DATE:
                    System.out.print("Ange nytt datum (yyyy-MM-dd): ");
                    String newDate = scanner.nextLine();
                    changeValue(dateDisplay, newDate);
                    currentState = ClockStateEnum.DISPLAY_DATE;
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
                    break;
            }

            if (choice == 5) {
                System.out.println("Avslutar programmet.");
                scanner.close();
                System.exit(0);
            }
        }
    }

    public void changeValue(Displayable display, String newValue) {
        boolean valueUpdated = display.updateValue(newValue);
        if (valueUpdated) {
            currentState = (display == timeDisplay) ? ClockStateEnum.DISPLAY_TIME : ClockStateEnum.DISPLAY_DATE;
        }
    }

    public static void main(String[] args) {
        Displayable timeDisplay = new TimeDisplay();
        Displayable dateDisplay = new DateDisplay();
        ClockController clockController = new ClockController(timeDisplay, dateDisplay);
        clockController.run();
    }
}


