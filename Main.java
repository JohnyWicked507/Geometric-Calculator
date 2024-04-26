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
        System.out.println("0. Salir");

        boolean continuar = true;
        double[] resultados = new double[2];

        while (continuar) {
            System.out.print("Tu selección: ");
            int opcionFigura = getIntInput(scanner);

            switch (opcionFigura) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    Circle circle = new Circle();
                    handleOperation(circle, resultados);
                    break;
                case 2:
                    Square square = new Square();
                    handleOperation(square, resultados);
                    break;
                case 3:
                    Triangle triangle = new Triangle();
                    handleOperation(triangle, resultados);
                    break;
                case 4:
                    Rectangle rectangle = new Rectangle();
                    handleOperation(rectangle, resultados);
                    break;
                case 5:
                    Pentagon pentagon = new Pentagon();
                    handleOperation(pentagon, resultados);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        }

        System.out.println("¡Gracias por usar la calculadora!");
    }

    public static void handleOperation(Figure figure, double[] resultados) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué operación deseas realizar?");
        System.out.println("1. Calcular área");
        System.out.println("2. Calcular perímetro");
        System.out.println("0. Volver al menú principal");
        System.out.print("Tu selección: ");
        int opcionOperacion = getIntInput(scanner);

        switch (opcionOperacion) {
            case 0:
                break;
            case 1:
                double area = figure.calculateArea();
                resultados[0] = area;
                System.out.println("El área es: " + area);
                break;
            case 2:
                double perimetro = figure.calculatePerimeter();
                resultados[1] = perimetro;
                System.out.println("El perímetro es: " + perimetro);
                break;
            default:
                System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                break;
        }
    }

    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
            scanner.next(); // Limpiar el buffer del scanner
        }
        return scanner.nextInt();
    }
}
