package src;

import java.util.Scanner;

public class Rectangle implements Figure {
    private double length;
    private double width;

    public Rectangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la longitud del rectángulo: ");
        this.length = scanner.nextDouble();
        System.out.print("Ingresa la anchura del rectángulo: ");
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
