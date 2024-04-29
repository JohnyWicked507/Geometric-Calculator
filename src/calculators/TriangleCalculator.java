package src.calculators;

import src.functions.fn;
import src.config.CalculatorInterface;
import java.util.Scanner;

public class TriangleCalculator implements CalculatorInterface {
	/** [0] base, [1] height, [2] side1, [3] side2, [4] side3 */
	final private static double[] allValues = new double[5];

	/**
	 * The constructor initializes a TriangleCalculator object by prompting the user
	 * to enter the base, height, and lengths of the three sides of a triangle using
	 * the Scanner class.
	 */
	public TriangleCalculator() {
		Scanner get = new Scanner(System.in);
		String[] prompts = {"Enter the base of the triangle.", "Enter the height of the triangle.",
				"Enter the length of side 1 of the triangle.", "Enter the length of side 2 of the triangle.",
				"Enter the length of side 3 of the triangle."};
		fn.assignMultipleDoubles(get, prompts, allValues);
	}

	/**
	 * The method `calculateArea` calculates the area of the triangle using the
	 * formula: (base * height) / 2.
	 *
	 * @return The method returns the area of the triangle as a double value.
	 */
	@Override
	public double calculateArea() {
		return (allValues[0] * allValues[1]) / 2;
	}

	/**
	 * The method `calculatePerimeter` calculates the perimeter of the triangle by
	 * adding the lengths of its three sides.
	 *
	 * @return The method returns the perimeter of the triangle as a double value.
	 */
	@Override
	public double calculatePerimeter() {
		return allValues[2] + allValues[3] + allValues[4];
	}
}
