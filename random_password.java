package lab4;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class random_password {

	static int counter = 0;

	public static void main(String[] args) {

		String name = getName();

		String phoneNumber = getNumber();
		String animalType = animal();
		String pitt = pittId();
		System.out.printf("%s-%s-%s-%s", name, phoneNumber, animalType, pitt);

	}

	public static int counter() {

		counter++;
		if (counter == 3) {
			System.out.println("Too many chances given. Goodbye");
			System.exit(0);
		}
		return counter;
	}

	public static String getName() {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter your first name");
		String output = input.nextLine();

		for (int i = 0; i < output.length(); i++) {
			while (output.charAt(i) == ' ' || !Pattern.matches("[a-zA-Z]+", output)) {
				counter();
				System.out.println("Name not valid.Enter your first name");
				output = input.next();
			}
		}
		return output;
	}

	public static String getNumber() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your phone number in the xxx-xxx-xxxx format");
		String output = input.nextLine();

		boolean goodNumber = true;
		while (true) {
			while (output.length() != 12) {
				counter();
				System.out.println("Enter your phone number in the xxx-xxx-xxxx format");
				output = input.nextLine();

			}
			try {
				String phone[] = output.split("-");
				for (int i = 0; i < phone.length; i++) {
					Integer.parseInt(phone[i]);
				}
				goodNumber = false;

				return output.substring(8);

			} catch (Exception e) {
				System.out.println("woops");
				counter();
			}
			System.out.println("Enter your phone number in the xxx-xxx-xxxx format");
			output = input.nextLine();
		}

	}

	public static String animal() {
		Scanner input = new Scanner(System.in);
		System.out.println(" 1 for wolf\n 2 for panther\n 3 for lion");

		int choice = input.nextInt();

		while (choice != 1 && choice != 2 && choice != 3) {

			counter();
			System.out.println("Invalid input!\n1 for wolf\n 2 for panther\n 3 for lion");
			choice = input.nextInt();
		}
		switch (choice) {

		case 1:
			String wolf = "Wolf";
			return wolf.substring(0, 3);

		case 2:
			String animal = "Panther";
			return animal.substring(0, 3);
		case 3:
			String lion = "lion";
			return lion.substring(0, 3);
		default:
			break;

		}

		return null;

	}

	public static String pittId() {

		int numChars = 0;

		Scanner input = new Scanner(System.in);
		System.out.println("Enter pitt Id");

		String output = input.next();

		while (true) {
			if (output.length() == 6) {
				numChars = 3;
				for (int i = 0; i < numChars; i++) {
					if (!Character.isLetter(output.charAt(i))) {
						counter();
						System.out.println("Invalid Input");
						System.out.println("Invalid Input Enter pitt Id");
						output = input.next();
						break;
					}

				}
				for (int i = 3; i < 6; i++) {
					if (!Character.isDigit(output.charAt(i))) {
						counter();
						System.out.println("Invalid Input Enter pitt Id");
						output = input.next();
						break;
					}
					String id = output.substring(3);
					return id;

				}
			}
			if (output.length() == 7) {
				numChars = 4;
				for (int i = 0; i < numChars; i++) {
					if (!Character.isLetter(output.charAt(i))) {
						counter();
						System.out.println("Invalid Input Enter pitt Id");
						output = input.next();
						break;
					}
				}
				for (int i = 4; i < 7; i++) {

					if (!Character.isDigit(output.charAt(i))) {
						counter();
						System.out.println("Invalid Input Enter pitt Id");
						output = input.next();
						break;
					}
					String id = output.substring(4);
					return id;
				}
			}
			counter();
			System.out.println("Invalid Input Enter pitt Id");
			output = input.next();
		}
	}
}
