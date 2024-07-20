package src;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    private static CatalogService catalogService;
    private static ProductService productService;

    public UserService(CatalogService catalogService, ProductService productService) {
        this.catalogService = catalogService;
        this.productService = productService;
    }

    Scanner scanner = new Scanner(System.in);

    private static ArrayList<User> user = new ArrayList<>();

    UserInterface userInterface = new UserInterface();

    public void signUp() {

        System.out.println("--- Bienvenido al registro ---");

        System.out.println("Ingrese su nombre: ");
        String nameUser = scanner.nextLine();
        System.out.println("Ingrese su email: ");
        String emailUser = scanner.nextLine();
        System.out.println("Ingrese una contraseña: ");
        String passwordUser = scanner.nextLine();

        User newUser = new User();
        newUser.setId(user.size() + 1);
        newUser.setName(nameUser);
        newUser.setEmail(emailUser);
        newUser.setPassword(passwordUser);

        user.add(newUser);

        System.out.println("Usuario registrado correctamente.");
        System.out.println();
        userInterface.userInter(catalogService, productService);
    }

    public void login() {
        if (!user.isEmpty()) {
            for (User userIndex : user) {
                System.out.println("--- Bienvenido " + userIndex.getName() + " al login ---");
            }

            for (User userIndex : user) {
                System.out.println("Ingrese su email: ");
                String emailUser = scanner.nextLine();

                if (emailUser.equals(userIndex.getEmail())) {
                    System.out.println("Ingrese su contraseña: ");
                    String passwordUser = scanner.nextLine();
                    if (passwordUser.equals(userIndex.getPassword())) {
                        System.out.println("Logeado correctamente.");
                        System.out.println();
                        userInterface.userInter(catalogService, productService);
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
            System.out.println("No hay usuarios registrados");
            System.out.println();
        }
    }
}