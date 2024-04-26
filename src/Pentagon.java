package src;

import java.util.Scanner;

public class Pentagon implements Figure {
    private double side;

    public Pentagon() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la longitud del lado del pentagono: ");
        this.side = scanner.nextDouble();
    }

    @Override
    public double calculateArea() {
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(side, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 5 * side;
    }
}
