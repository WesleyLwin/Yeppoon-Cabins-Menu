/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package YeppoonCabinsMenu;
import java.util.Scanner;

/**
 *
 * @author 12206477
 */
public class YeppoonCabinsMenu {
    final int ENTER_BOOKING = 1;
    final int DISPLAY_BOOKINGS = 2;
    final int DISPLAY_STATISTICS = 3;
    final int SEARCH_BOOKINGS = 4;
    final int EXIT = 5;
    
    private int maximumNights = 10;
    private Booking[] booking = new Booking[maximumNights];
    private int number = 0;
    
    Scanner inputMenuChoice = new Scanner (System.in);
        private int getMenuItem() {
		System.out.println("\nPlease select from the following");
		System.out.println(ENTER_BOOKING + ". Enter booking name and number of nights");
		System.out.println(DISPLAY_BOOKINGS + ". Display all booking names, number of nights and charges");
		System.out.println(DISPLAY_STATISTICS + ". Display Statistics");
		System.out.println(SEARCH_BOOKINGS + ". Search for booking");
		System.out.println(EXIT + ". Exit the application");
		System.out.print("Enter choice==> ");

		String choice = inputMenuChoice.nextLine();
		while (choice.equals("") || !isStringNumeric(choice)) {
			System.out.println("Error - Menu selection name cannot be blank and must be numeric");

			System.out.print("Enter choice==> ");

			choice = inputMenuChoice.nextLine();
		}

		return Integer.parseInt(choice);
    }
        private boolean isStringNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)))
                            return false;
		}

		return true;
	}
        private void processOrders() {
		int choice = getMenuItem();
		while (choice != EXIT) {
			switch (choice) {
				case ENTER_BOOKING:
					enterBooking();
					break;
				case DISPLAY_BOOKINGS:
					displayAllBookings();
					break;
				case DISPLAY_STATISTICS:
					displayStatistics();
					break;
				case SEARCH_BOOKINGS:
					searchBookings();
					break;
				default:
					System.out.println("ERROR choice not recognised");
			}
			choice = getMenuItem();
		}
	}
        private void enterBooking() {
            if (number == booking.length) {
		System.out.println("Maximum bookings to be entered has been reached!");
		return;
	}
        System.out.print("\nPlease enter the booking name ==> ");
            String bookingName = inputMenuChoice.nextLine();
                while (bookingName.length()==0) {
			System.out.println("Error - Booking name cannot be blank!");
                        System.out.print("Please enter the booking name ==> ");
			bookingName = inputMenuChoice.nextLine();
		}
        System.out.print("Please enter the number of nights ==> ");
		String nightStay = inputMenuChoice.nextLine();
                while (!isStringNumeric(nightStay) || Integer.parseInt(nightStay) < 1) {
			System.out.println("Error - Number of nights must be  numeric and must be greater than 0");
                        System.out.print("Please enter the number of nights ==> ");
			nightStay = inputMenuChoice.nextLine();
		}
                int night = Integer.parseInt(nightStay);
            booking [number] = new Booking(bookingName, night);
            displayHeading();
            System.out.println(booking[number]);
            number++;
    }
        private void displayHeading() {
		System.out.printf("%-30s%-11s%-6s\n", "Booking Name", "Nights", "Charge");
	}
        private void displayAllBookings() {
		if (number == 0) {
			System.out.println("ERROR - You must enter at least one booking!");
			return;
		}
		displayHeading();
                for (int i = 0; i < number; i++) {
			System.out.println(booking[i]);
		}
    }
        private void displayStatistics() {
		// Check if there has been an booking entered
		if (number == 0) {
			System.out.println("ERROR - You must enter at least one booking!");
			return;
		}
                int a = 10;
		int b = 0;
		int max = 0;
		int min = 0;
		double total = 0;
            
                for (int i = 0; i < number; i++) {
			int bookingNights = booking[i].getNights();
			double totalNights = booking[i].getNights();
			total += totalNights;

			if (bookingNights < a) {
				a = bookingNights;
				min  = i;
			}

			if (bookingNights > b) {
				b = bookingNights;
				max = i;
			}
		}
                double averageNights = (double) total / number;

		System.out.println(booking[max].getName() + " has the maximum number of " + b + " nights");
		System.out.println(booking[min].getName() + " has the minimum number of " + a + " nights");
		System.out.printf("Average number of nights per booking is %.2f\n", averageNights);
		System.out.printf("The total charges are: $%.2f\n", total);
        }
        private void searchBookings() {
		if (number == 0) {
			System.out.println("ERROR - You must enter at least one booking!");
			return;
		}
                System.out.print("\nPlease enter the booking name ==> ");
		String findingName = inputMenuChoice.nextLine();
                int i = 0;
		boolean found = false;
                    while (i < number && !found) {
			if (findingName.equalsIgnoreCase(booking[i].getName())) {
				found = true;
			} else {
				i++;
			}
		}

		if (found) {
			displayHeading();
			System.out.println(booking[i]);
		} else {
			System.out.println(findingName + " not found");
		}
	}
        public static void main(String[] args) {
     	System.out.println("\n Welcome to the Yeppoon Cabins Management System");

		YeppoonCabinsMenu menu = new YeppoonCabinsMenu();

		menu.processOrders();

		System.out.println("\nThank you for using the Yeppoon Cabins Management System!");
                System.out.println("Program written by 12206477");
	}
}

