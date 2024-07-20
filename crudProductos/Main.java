package crudProductos;

import src.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Catalog> catalogs  = new ArrayList<>();
    private static CatalogService catalogService = new CatalogService(catalogs);
    private static ProductService productService = new ProductService(catalogs);

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        AdminMain adminMain = new AdminMain(catalogService, productService);
        UserMain userMain = new UserMain(catalogService, productService);


        System.out.println("--- Bienvenido al sistema de productos ---");

        System.out.println("Si usted es Admin ingrese 1.");
        System.out.println("Si usted es Visitante ingrese 2.");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                adminMain.runApplication();
                break;
            case 2:
                userMain.runApplication();
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }
}
