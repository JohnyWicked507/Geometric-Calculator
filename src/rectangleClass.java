package src;

import java.util.Scanner;

public class rectangleClass implements figureInterface {
    private double length;
    private double width;

    public rectangleClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la longitud del rectangulo: ");
        this.length = scanner.nextDouble();
        System.out.print("Ingresa la anchura del rectangulo: ");
        this.width = scanner.nextDouble();
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
