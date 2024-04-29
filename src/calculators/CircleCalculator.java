package src.calculators;

import src.functions.fn;
import src.config.CalculatorInterface;
import java.util.Scanner;

public class CircleCalculator implements CalculatorInterface {
	/** The radius of the circle. */
	private final double radius;

	/**
	 * The constructor `CircleCalculator` initializes a new instance of the
	 * `CircleCalculator` class by prompting the user to enter the radius of the
	 * circle via standard input.
	 */
	public CircleCalculator() {
		Scanner get = new Scanner(System.in);
		this.radius = fn.assignSingleDouble(get, "Enter the radius of the circle.");
	}

	/**
	 * The method `calculateArea` calculates the area of the circle using the
	 * formula: π * radius^2.
	 *
	 * @return The method `calculateArea` returns the calculated area of the circle.
	 */
	@Override
	public double calculateArea() {
		return Math.PI * radius * radius;
	}

	/**
	 * The method `calculatePerimeter` calculates the perimeter of the circle using
	 * the formula: 2 * π * radius.
	 *
	 * @return The method `calculatePerimeter` returns the calculated perimeter of
	 *         the circle.
	 */
	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}
}
