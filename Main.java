import src.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        println("Bienvenido a la calculadora de areas y perimetros.");

        boolean continuar = true;
        // Array para almacenar resultados [0] área, [1] perímetro, [2] potencia
        double[] resultados = new double[3];

        while (continuar) {
            println("""
                    Por favor, elige una figura geometrica:
                    1. Circulo
                    2. Cuadrado
                    3. Triangulo
                    4. Rectangulo
                    5. Pentagono
                    6. Potencia
                    0. Salir
                    """);
            print("Tu seleccion: ");
            int opcion = getIntInput(scanner);

            switch (opcion) {
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
                case 6:
                    handlePowerOperation(resultados);
                    break;
                default:
                    println("Opcion no valida. Por favor, selecciona una opcion valida.");
                    break;
            }
        }

        println("¡Gracias por usar la calculadora!");
    }

    public static void handleOperation(Figure figure, double[] resultados) {
        Scanner scanner = new Scanner(System.in);

        println("""
                ¿Que operacion deseas realizar?
                1. Calcular area
                2. Calcular perimetro
                0. Volver al menu principal
                """);
        print("Tu seleccion: ");
        int opcion = getIntInput(scanner);

        switch (opcion) {
            case 0:
                break;
            case 1:
                double area = figure.calculateArea();
                resultados[0] = area;
                println("El area es: " + area);
                break;
            case 2:
                double perimetro = figure.calculatePerimeter();
                resultados[1] = perimetro;
                println("El perimetro es: " + perimetro);
                break;
            default:
                println("Opcion no valida. Por favor, selecciona una opcion valida.");
                break;
        }
    }

    public static void handlePowerOperation(double[] resultados) {
        Scanner scanner = new Scanner(System.in);

        print("Ingresa la base: ");
        double base = scanner.nextDouble();
        print("Ingresa el exponente: ");
        int exponente = getIntInput(scanner);

        double resultadoPotencia = calcularPotencia(base, exponente);
        resultados[2] = resultadoPotencia;
        println("El resultado de la potencia es: " + resultadoPotencia);
    }

    public static double calcularPotencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente > 0) {
            return base * calcularPotencia(base, exponente - 1);
        } else {
            return 1 / (base * calcularPotencia(base, -exponente - 1));
        }
    }

    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            println("Entrada invalida. Por favor, ingresa un numero entero.");
            scanner.next(); // Limpiar el buffer del scanner
        }
        return scanner.nextInt();
    }

    private static void println(String s) {
        System.out.println(s);
    }

    private static void print(String s) {
        System.out.print(s);
    }
}
