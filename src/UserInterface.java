package src;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private static Scanner entrada = new Scanner(System.in);

    private static ArrayList<Product> inventories = new ArrayList<>();

    public static void userInter(CatalogService catalogService, ProductService productService) {

        UserMain userMain = new UserMain(catalogService, productService);

        System.out.println("--- Bienvenido ---");

        char salida = 'y';

        while (salida != 'n') {
            System.out.println("> Digitalice la opcion que desee: ");
            System.out.println("---------------------------------");
            System.out.println("1. Visualizar catalogo: ");
            System.out.println("---------------------------------");
            System.out.println("2. Visualizar producto: ");
            System.out.println("---------------------------------");
            System.out.println("3. Visualizar todo: ");
            System.out.println("---------------------------------");
            System.out.println("4. Visualizar su inventario: ");
            System.out.println("---------------------------------");
            System.out.println("5. Agregar producto a su inventario: ");
            System.out.println("---------------------------------");
            System.out.println();

            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    catalogService.getCatalog();
                    break;
                case 2:
                    productService.getProduct();
                    break;
                case 3:
                    getAll(catalogService, productService);
                    break;
                case 4:
                    getInventory();
                    break;
                case 5:
                    addInventory(catalogService, productService);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

            System.out.println();
            System.out.println("--- ¿Desea continuar? (y/n) ---");
            salida = entrada.next().charAt(0);
        }

        System.out.println("Desea ir al inicio? (y/n):  ");
        char option = entrada.next().charAt(0);

        if (option == 'y') {
            userMain.runApplication();
        } else if (option == 'n') {
            System.out.println("Programa finalizado");
            System.exit(0);
        } else {
            System.out.println("Opcion no valida.");
            System.out.println("Programa finalizado");
            System.exit(0);
        }
    }

    public static void getAll(CatalogService catalogService, ProductService productService) {
        System.out.println("--- Catalogos ---");
        ArrayList<Catalog> catalogs = catalogService.getCatalog();

        System.out.println("--- Productos ---");
        ArrayList<Product> products = productService.getProduct();

        if (products.size() == 0 && catalogs.size() == 0) {
            System.out.println();
            System.out.println("No hay nada que mostrar");
        }
    }

    public static void getInventory() {
        if (inventories.isEmpty()) {
            System.out.println("Aun no hay productos en tu inventario");
        } else {
            System.out.println("--- Inventario ---");
            for (Product product : inventories) {
                System.out.println("Nombre: " + product.getName() +
                        ", Catálogo: " + product.getCatalogId() +
                        ", Descripción: " + product.getDescription() +
                        ", Cantidad: " + product.getTotal() +
                        ", Precio: " + product.getPrice());
            }
        }
    }

    public static void addInventory(CatalogService catalogService, ProductService productService) {
        System.out.println();
        System.out.println("Lista de catalogos/productos disponibles: ");
        ArrayList<Catalog> catalogs = catalogService.getCatalog();
        System.out.println("-----------------------------------------");
        ArrayList<Product> products = productService.getProduct();

        if (products.size() == 0) {
            System.out.println();
            System.out.println("No hay productos para agregar");
        } else {
            System.out.println();
            System.out.println("Ingrese con el respectivo ID que producto desea agregar: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            boolean found = false;

            for (int i = 0; i < products.size(); i++) {
                if (opcion == products.get(i).getId()) {
                    inventories.add(productService.getProduct().get(i));
                    System.out.println("Se agrego correctamente el producto con el ID: " + opcion);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No existe ese ID");
            }
        }
    }

}
