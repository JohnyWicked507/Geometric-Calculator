package src.calculators;

import src.functions.fn;
import src.config.CalculatorInterface;
import java.util.Scanner;

public class RectangleCalculator implements CalculatorInterface {
	/** [0] length, [1] width */
	final private static double[] allValues = new double[2];

	/**
	 * The constructor `RectangleCalculator` initializes a new instance of the
	 * `RectangleCalculator` class. It prompts the user to enter the length and
	 * width of the rectangle via the console, reads the input values using a
	 * Scanner object, and assigns them to the corresponding instance variables
	 * `length` and `width`.
	 */
	public RectangleCalculator() {
		Scanner get = new Scanner(System.in);
		String[] prompts = {"Enter the length of the rectangle.", "Enter the width of the rectangle."};
		fn.assignMultipleDoubles(get, prompts, allValues);
	}

	/**
	 * The method `calculateArea` calculates the area of the rectangle. It
	 * multiplies the instance variables `length` and `width` to determine the area.
	 *
	 * @return The method `calculateArea` returns a double value representing the
	 *         area of the rectangle.
	 */
	@Override
	public double calculateArea() {
		return allValues[0] * allValues[1];
	}

	/**
	 * The method `calculatePerimeter` calculates the perimeter of the rectangle. It
	 * adds the instance variables `length` and `width`, multiplies the sum by 2,
	 * and returns the result, which represents the perimeter.
	 *
	 * @return The method `calculatePerimeter` returns a double value representing
	 *         the perimeter of the rectangle.
	 */
	@Override
	public double calculatePerimeter() {
		return 2 * (allValues[0] + allValues[1]);
	}
}
