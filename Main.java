import src.Catalog;
import src.CatalogService;
import src.Product;
import src.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<Catalog> catalogs = new ArrayList<>();

        CatalogService catalogService = new CatalogService(catalogs);

        ProductService productService = new ProductService(catalogs);


        System.out.println("--- Bienvenido administrador ---");

        char salida = 'y';

        while (salida != 'n') {
            System.out.println("> Digitalice la opcion que desee: ");
            System.out.println("1. Visualizar catalogo");
            System.out.println("2. Agregar catalogo");
            System.out.println("3. Modificar catalogo");
            System.out.println("4. Eliminar catalogo");
            System.out.println("---------------------------------");
            if (catalogService.hasCatalogs()) {
                System.out.println("5. Visualizar producto");
                System.out.println("6. Agregar producto");
                System.out.println("7. Modificar producto");
                System.out.println("8. Eliminar producto");
                System.out.println("---------------------------------");
                System.out.println("9. Visualizar todo");
            }

            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    catalogService.getCatalog();
                    break;
                case 2:
                    catalogService.addCatalog();
                    break;
                case 3:
                    catalogService.putCatalog();
                    break;
                case 4:
                    catalogService.deleteCatalog();
                    break;
                case 5:
                    productService.getProduct();
                    break;
                case 6:
                    productService.addProduct();
                    break;
                case 7:
                    productService.putProduct();
                    break;
                case 8:
                    productService.deleteProduct();
                    break;
                case 9:
                    getAll(catalogService, productService);
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

    public static void getAll(CatalogService catalogService, ProductService productService) {

        System.out.println("--- Catalogos ---");
        ArrayList<Catalog> catalogs = catalogService.getCatalog();

        System.out.println("--- Catalogos ---");
        ArrayList<Product> products = productService.getProduct();

        if (products.size() == 0 || catalogs.size() == 0) {
            System.out.println("No hay nada que mostrar");
        }
    }
}
