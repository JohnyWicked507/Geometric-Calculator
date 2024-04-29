package src.calculators;

import src.functions.fn;
import src.config.CalculatorInterface;
import java.util.Scanner;

public class PentagonCalculator implements CalculatorInterface {
	/** The length of one side of the pentagon. */
	private final double side;

	/**
	 * The constructor `PentagonCalculator` initializes a new instance of the class
	 * by prompting the user to enter the length of the side of the pentagon, which
	 * is stored in the private field `side`.
	 */
	public PentagonCalculator() {
		Scanner get = new Scanner(System.in);
		this.side = fn.assignSingleDouble(get, "Enter the length of the side of the pentagon.");
	}

	/**
	 * The method `calculateArea` calculates the area of the pentagon using the
	 * formula: area = 0.25 * sqrt(5 * (5 + 2 * sqrt(5))) * side^2.
	 *
	 * @return The method `calculateArea` returns a double value representing the
	 *         calculated area of the pentagon.
	 */
	@Override
	public double calculateArea() {
		return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(side, 2);
	}

	/**
	 * The method `calculatePerimeter` calculates the perimeter of the pentagon
	 * using the formula: perimeter = 5 * side.
	 *
	 * @return The method `calculatePerimeter` returns a double value representing
	 *         the calculated perimeter of the pentagon.
	 */
	@Override
	public double calculatePerimeter() {
		return 5 * side;
	}
}
