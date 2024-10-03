package lab4;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class word_counter {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a sentence");
		String output = input.nextLine();
		String word[] = output.split(" ");
		int length = word.length;
		System.out.printf("This word has %s words ", length);
	}
}