package src.functions;

import src.config.CalculatorInterface;
import src.config.PairType;
import src.types.Pair;

import java.util.Scanner;

public class fn {
	public static String extraMessage = "Good looking!";

	/**
	 * The method `resetExtraMessage` resets the value of the static variable
	 * `extraMessage` to the string "Good looking!".
	 */
	public static void resetExtraMessage() {
		extraMessage = "Good looking!";
	}

	/**
	 * The function `println` prints the provided string to the console followed by
	 * a newline character.
	 *
	 * @param s
	 *            The `s` parameter in the `println` function is a string that
	 *            represents the text to be printed to the console.
	 */
	public static void println(String s) {
		System.out.println(s);
	}

	/**
	 * The function `print` prints the provided string to the console without adding
	 * a newline character.
	 * 
	 * @param s
	 *            The `s` parameter in the `print` function is a string that
	 *            represents the text to be printed to the console.
	 */
	public static void print(String s) {
		System.out.print(s);
	}

	/**
	 * The method `inputFormatter` takes a string `s` and formats it with a newline
	 * character and a greater than sign followed by a space.
	 *
	 * @param s
	 *            The `s` parameter in the `inputFormatter` method is a string that
	 *            will be formatted with a newline character and a greater than sign
	 *            followed by a space.
	 */
	public static void inputFormatter(String s) {
		System.out.printf("%s\n> ", s);
	}

	/**
	 * The method `selectionMenuFormatter` takes a string `s` as input, appends the
	 * value of the static variable `extraMessage` to it, and then passes it to the
	 * method `inputFormatter`.
	 *
	 * @param s
	 *            The `s` parameter in the `selectionMenuFormatter` method is a
	 *            string that is appended with the value of the static variable
	 *            `extraMessage`.
	 */
	public static void selectionMenuFormatter(String s) {
		inputFormatter(s + extraMessage + "\n");
	}

	/** The function `clearScr` clears the console screen. */
	public static void clearScr() {
		print("\\033[H\\033[2J");
		System.out.flush();
	}

	/** The function `clearBuffer` clears the input buffer. */
	public static void clearBuffer(Scanner scanner) {
		scanner.next();
	}

	/**
	 * The method 'handleOperation' handles operations related to calculating area
	 * and perimeter based on user input, storing the results and displaying
	 * messages accordingly.
	 *
	 * @param calculatorInterface
	 *            The 'calculatorInterface' parameter represents the calculator
	 *            interface instance that performs area and perimeter calculations.
	 * @param storedResultsValues
	 *            The 'storedResultsValues' parameter is an array used to store the
	 *            calculated area and perimeter.
	 * @param calculatedValue
	 *            The 'calculatedValue' parameter is a string representing the value
	 *            being calculated (e.g., square, triangle).
	 */
	public static void handleOperation(CalculatorInterface calculatorInterface, double[] storedResultsValues,
			String calculatedValue) {
		Scanner get = new Scanner(System.in);
		resetExtraMessage();

		while (true) {
			clearScr();
			selectionMenuFormatter("""
					What operation do you want to perform?
					1. Calculate area.
					2. Calculate perimeter.
					""");
			PairType<Integer, Boolean> option = getIntegerInput(get);

			if (option.getValue2())
				continue;

			switch (option.getValue1()) {
				case 0 :
					return;
				case 1 :
					double calculatedArea = calculatorInterface.calculateArea();
					storedResultsValues[0] = calculatedArea;
					extraMessage = "The area of the " + calculatedValue + " is '" + calculatedArea + "'.";
					return;
				case 2 :
					double calculatedPerimeter = calculatorInterface.calculatePerimeter();
					storedResultsValues[1] = calculatedPerimeter;
					extraMessage = "The perimeter of the " + calculatedValue + " is '" + calculatedPerimeter + "'.";
					return;
				default :
					extraMessage = "Invalid option. Please select a valid option.\n"
							+ "If you wish to return to the main menu, simply type '0'.";
					break;
			}
		}
	}

	/**
	 * The function `handlePowerOperation` handles user input for entering a base
	 * and exponent, then calculates the result of exponentiation.
	 * 
	 * @param results
	 *            The `results` parameter in the `handlePowerOperation` function is
	 *            an array of doubles where the calculated result of the
	 *            exponentiation will be stored.
	 */
	public static void handlePowerOperation(double[] results) {
		Scanner get = new Scanner(System.in);
		resetExtraMessage();

		while (true) {
			inputFormatter("Enter the base.");
			double base = get.nextDouble();
			inputFormatter("Enter the exponent.");
			PairType<Integer, Boolean> exponent = getIntegerInput(get);

			if (exponent.getValue2()) {
				println(extraMessage);
				continue;
			}

			double powerResult = calculateExponentiation(base, exponent.getValue1());
			results[2] = powerResult;
			extraMessage = "The result of the exponentiation is '" + powerResult + "'.";
			break;
		}
	}

	/**
	 * The function `calculateExponentiation` calculates the exponentiation of a
	 * given base raised to a given exponent.
	 * 
	 * @param base
	 *            The `base` parameter in the `calculateExponentiation` function is
	 *            a double representing the base value of the exponentiation.
	 * @param exponent
	 *            The `exponent` parameter in the `calculateExponentiation` function
	 *            is an integer representing the exponent value of the
	 *            exponentiation.
	 */
	public static double calculateExponentiation(double base, int exponent) {
		if (exponent == 0)
			return 1;
		else if (exponent > 0)
			return base * calculateExponentiation(base, exponent - 1);
		return 1 / (base * calculateExponentiation(base, -exponent - 1));
	}

	/**
	 * The function `getIntegerInput` retrieves an integer input from the user using
	 * a provided scanner object.
	 * 
	 * @param userInput
	 *            The `userInput` parameter in the `getIntegerInput` function is a
	 *            `Scanner` object used to capture user input.
	 */
	public static PairType<Integer, Boolean> getIntegerInput(Scanner userInput) {
		if (!userInput.hasNextInt()) {
			extraMessage = "Invalid input. Please enter a valid integer value.";
			fn.clearBuffer(userInput);
			return Pair.resolve(0, true);
		}
		return Pair.resolve(userInput.nextInt(), false);
	}

	/**
	 * The method `isDouble` checks if the next input from the provided `userInput`
	 * Scanner object is a double value. If not, it clears the buffer, resolves the
	 * PairType to contain 0.0 and true, indicating an error state, else resolves it
	 * to contain the double value and false.
	 *
	 * @param userInput
	 *            The `userInput` parameter is a Scanner object from which the next
	 *            input is checked for being a double value.
	 * @param prompt
	 *            The `prompt` parameter is a string displayed to prompt the user
	 *            for input.
	 *
	 * @return A PairType containing a double value from the user input and a
	 *         boolean flag indicating whether the input was valid or not.
	 */
	public static PairType<Double, Boolean> isDouble(Scanner userInput, String prompt) {
		inputFormatter(prompt);
		if (!userInput.hasNextDouble()) {
			fn.clearBuffer(userInput);
			return Pair.resolve(0.0, true);
		}
		return Pair.resolve(userInput.nextDouble(), false);
	}

	/**
	 * The method `assignMultipleDoubles` iterates over an array of prompts,
	 * prompting the user to enter double values for each prompt using the
	 * `isDouble` method. It then assigns these values to the corresponding indices
	 * in the `values` array.
	 *
	 * @param userInput
	 *            The `userInput` parameter is a Scanner object used to accept user
	 *            input.
	 * @param prompts
	 *            The `prompts` parameter is an array of strings containing prompts
	 *            for the user to enter double values.
	 * @param values
	 *            The `values` parameter is an array of Double objects where the
	 *            entered double values will be assigned.
	 */
	public static void assignMultipleDoubles(Scanner userInput, String[] prompts, double[] values) {
		for (int i = 0; i < prompts.length; i++) {
			PairType<Double, Boolean> input = isDouble(userInput, prompts[i]);
			while (input.getValue2()) {
				println("Invalid input. Please enter a valid double.");
				input = isDouble(userInput, prompts[i]);
			}
			values[i] = input.getValue1();
		}
	}

	/**
	 * The function `assignSingleDouble` receives a Scanner object and a prompt
	 * message. It continuously prompts the user until a valid double value is
	 * entered, handling invalid input by printing an error message and asking for
	 * input again.
	 * 
	 * @param userInput
	 *            The `userInput` parameter is a Scanner object used to receive
	 *            input from the user.
	 * @param prompt
	 *            The `prompt` parameter is a string that represents the message to
	 *            be displayed to the user, prompting them to enter a double value.
	 * 
	 * @return The function returns a double value entered by the user once it
	 *         passes validation. There is no return value in case of invalid input.
	 */
	public static double assignSingleDouble(Scanner userInput, String prompt) {
		while (true) {
			PairType<Double, Boolean> input = isDouble(userInput, prompt);
			if (input.getValue2()) {
				fn.println("Invalid input. Please enter a valid double.");
				continue;
			}
			return input.getValue1();
		}
	}
}
