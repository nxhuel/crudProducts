package src;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {

    private static CatalogService catalogService;
    private static ProductService productService;

    Scanner scanner = new Scanner(System.in);

    private static ArrayList<Admin> admin = new ArrayList<>();

    private static AdminInterface adminInterface = new AdminInterface();

    public AdminService(CatalogService catalogService, ProductService productService) {
        this.catalogService = catalogService;
        this.productService = productService;
    }

    public void signUp() {

        System.out.println("--- Bienvenido al registro ---");

        System.out.println("Ingrese su nombre: ");
        String nameAdmin = scanner.nextLine();
        System.out.println("Ingrese su email: ");
        String emailAdmin = scanner.nextLine();
        System.out.println("Ingrese una contraseña: ");
        String passwordAdmin = scanner.nextLine();

        Admin newAdmin = new Admin();
        newAdmin.setId(admin.size() + 1);
        newAdmin.setName(nameAdmin);
        newAdmin.setEmail(emailAdmin);
        newAdmin.setPassword(passwordAdmin);

        admin.add(newAdmin);

        System.out.println("Admin registrado correctamente.");
        System.out.println();
        adminInterface.adminInter(catalogService, productService);
    }

    public void login() {

        if (!admin.isEmpty()) {
            for (Admin adminIndex : admin) {
                System.out.println("--- Bienvenido " + adminIndex.getName() + " al login ---");
            }

            for (Admin adminIndex : admin) {
                System.out.println("Ingrese su email: ");
                String emailAdmin = scanner.nextLine();

                if (emailAdmin.equals(adminIndex.getEmail())) {
                    System.out.println("Ingrese su contraseña: ");
                    String passwordAdmin = scanner.nextLine();
                    if (passwordAdmin.equals(adminIndex.getPassword())) {
                        System.out.println("Logeado correctamente.");
                        System.out.println();
                        adminInterface.adminInter(catalogService, productService);
                    } else {
                        System.out.println("Error. Contraseña incorrecta.");
                        System.out.println();
                    }
                } else {
                    System.out.println("No existe ese email, debe registrarse primero.");
                    System.out.println();
                }
            }
        } else {
            System.out.println("No hay admins registrados");
            System.out.println();
        }
    }
}