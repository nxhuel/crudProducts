package src;

import crudProductos.Main;

import java.util.Scanner;

public class UserMain {
    private static CatalogService catalogService;
    private static ProductService productService;

    public UserMain(CatalogService catalogService, ProductService productService) {
        this.catalogService = catalogService;
        this.productService = productService;
    }

    public static void main(String[] args) {
        runApplication();
    }

    public static void runApplication() {
        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService(catalogService, productService);

        Main main = new Main();

        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("--- Bienvenido ---");

            System.out.println("SignUp (1) / Login (2) / Start (3) /Exit (4): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    userService.signUp();
                    break;
                case 2:
                    userService.login();
                    break;
                case 3:
                    main.start();
                    break;
                case 4:
                    continueRunning = false;
                    System.out.println("Programa finalizado.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
}