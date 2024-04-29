import src.calculators.*;
import src.config.PairType;
import src.functions.fn;

import java.util.Scanner;

public class Main {
	private static boolean runMain = true;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		/* [0] area, [1] perimeter, [2] power */
		double[] resultsArray = new double[3];

		do {
			fn.clearScr();
			fn.selectionMenuFormatter("""
					Please choose a geometric figure:
					1. Circle
					2. Square
					3. Triangle
					4. Rectangle
					5. Pentagon
					6. Power
					""");
			PairType<Integer, Boolean> option = fn.getIntegerInput(scanner);

			if (option.getValue2())
				continue;

			switch (option.getValue1()) {
				case 0 :
					runMain = false;
					break;
				case 1 :
					CircleCalculator circleCalculator = new CircleCalculator();
					fn.handleOperation(circleCalculator, resultsArray, "circle");
					break;
				case 2 :
					SquareCalculator squareCalculator = new SquareCalculator();
					fn.handleOperation(squareCalculator, resultsArray, "square");
					break;
				case 3 :
					TriangleCalculator triangleCalculator = new TriangleCalculator();
					fn.handleOperation(triangleCalculator, resultsArray, "triangle");
					break;
				case 4 :
					RectangleCalculator rectangleCalculator = new RectangleCalculator();
					fn.handleOperation(rectangleCalculator, resultsArray, "rectangle");
					break;
				case 5 :
					PentagonCalculator pentagonCalculator = new PentagonCalculator();
					fn.handleOperation(pentagonCalculator, resultsArray, "pentagon");
					break;
				case 6 :
					fn.handlePowerOperation(resultsArray);
					break;
				default :
					fn.extraMessage = "Invalid option. Please select a valid option.\n"
							+ "If you want to exit, simply type '0'.";
					break;
			}
		} while (runMain);

		fn.println("Bye bye!");
		scanner.close();
	}
}
