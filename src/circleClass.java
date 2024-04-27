package src;

import java.util.Scanner;

public class circleClass implements figureInterface {
    private double radius;

    public circleClass() {
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