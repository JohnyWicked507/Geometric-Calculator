package src;

import java.util.Scanner;

public class Circle implements Figure {
    private double radius;

    public Circle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el radio del circulo: ");
        this.radius = scanner.nextDouble();
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}