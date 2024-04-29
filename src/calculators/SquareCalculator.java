package src.calculators;

import src.functions.fn;
import src.config.CalculatorInterface;
import java.util.Scanner;

public class SquareCalculator implements CalculatorInterface {
	/** The length of the side of the square entered by the user. */
	private final double side;

	/**
	 * The constructor `SquareCalculator` initializes a new instance of the
	 * `SquareCalculator` class, prompting the user to enter the length of the side
	 * of the square and storing it internally.
	 */
	public SquareCalculator() {
		Scanner get = new Scanner(System.in);
		this.side = fn.assignSingleDouble(get, "Enter the length of the side of the square.");
	}

	/**
	 * The method `calculateArea` calculates the area of the square using the
	 * formula: side * side.
	 *
	 * @return The method `calculateArea` returns a double value representing the
	 *         area of the square.
	 */
	@Override
	public double calculateArea() {
		return side * side;
	}

	/**
	 * The method `calculatePerimeter` calculates the perimeter of the square using
	 * the formula: 4 * side.
	 *
	 * @return The method `calculatePerimeter` returns a double value representing
	 *         the perimeter of the square.
	 */
	@Override
	public double calculatePerimeter() {
		return 4 * side;
	}
}
