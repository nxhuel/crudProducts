import src.ProductService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ProductService productService = new ProductService();

        System.out.println("--- Bienvenido administrador ---");

        char salida = 'y';

        while (salida != 'n') {
            System.out.println("> Digitalice la opcion que desee: ");
            System.out.println("1. Visualizar catalogos");
            System.out.println("2. Visualizar productos");
            System.out.println("3. Agregar catalogos");
            System.out.println("4. Agregar productos");
            System.out.println("5. Modificar catalogos");
            System.out.println("6. Modificar productos");
            System.out.println("7. Eliminar catalogos");
            System.out.println("8. Eliminar productos");

            int opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("En proceso...");
                    break;
                case 2:
                    productService.getProduct();
                    break;
                case 3:
                    System.out.println("En proceso...");
                    break;
                case 4:
                    productService.addProduct();
                    break;
                case 5:
                    System.out.println("En proceso...");
                    break;
                case 6:
                    productService.putProduct();
                    break;
                case 7:
                    System.out.println("En proceso...");
                    break;
                case 8:
                    productService.deleteProduct();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

            System.out.println("¿Desea continuar? (y/n): ");
            salida = entrada.next().charAt(0);
        }

        System.out.println("Programa finalizado");
    }
}
