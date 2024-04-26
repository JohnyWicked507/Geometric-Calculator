import src.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la calculadora de áreas y perímetros.");
        System.out.println("Por favor, elige una figura geométrica:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        System.out.print("Tu selección: ");
        int opcionFigura = scanner.nextInt();

        switch (opcionFigura) {
            case 1:
                Circle circle = new Circle();
                handleOperation(circle);
                break;
            case 2:
                Square square = new Square();
                handleOperation(square);
                break;
            case 3:
                Triangle triangle = new Triangle();
                handleOperation(triangle);
                break;
            case 4:
                Rectangle rectangle = new Rectangle();
                handleOperation(rectangle);
                break;
            case 5:
                Pentagon pentagon = new Pentagon();
                handleOperation(pentagon);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void handleOperation(Figure figure) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué operación deseas realizar?");
        System.out.println("1. Calcular área");
        System.out.println("2. Calcular perímetro");
        System.out.print("Tu selección: ");
        int opcionOperacion = scanner.nextInt();

        switch (opcionOperacion) {
            case 1:
                System.out.println("El área es: " + figure.calculateArea());
                break;
            case 2:
                System.out.println("El perímetro es: " + figure.calculatePerimeter());
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
