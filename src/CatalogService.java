package src;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogService {
    Scanner scanner = new Scanner(System.in);

    private ArrayList<Catalog> catalogs;

    public CatalogService(ArrayList<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public void addCatalog() {
        System.out.println("--- Agregue catalogo al stock ---");

        System.out.println("Digitalice el nombre del catalogo: ");
        String nameCatalog = scanner.nextLine();

        Catalog newCatalog = new Catalog();
        newCatalog.setId(catalogs.size() + 1);
        newCatalog.setName(nameCatalog);

        catalogs.add(newCatalog);
        System.out.println("Catalogo agregado correctamente.");
    }

    public ArrayList<Catalog> getCatalog() {
        if (catalogs.size() == 0 || catalogs == null) {
            System.out.println("No hay catalogos para mostrar.");
        } else {
            for (Catalog catalog : catalogs) {
                System.out.println("ID: " + catalog.getId() +
                        ", Nombre: " + catalog.getName());
            }
        }
        return catalogs;
    }

    public boolean hasCatalogs() {
        return !catalogs.isEmpty();
    }

    public void deleteCatalog() {
        if (catalogs.size() == 0) {
            System.out.println("No hay catalogos para eliminar.");
        } else {
            System.out.println("Desea eliminar todos los catalogos o alguno en especifico? (1/2): ");
            int deleteOption = scanner.nextInt();

            if (deleteOption == 1) {
                catalogs.clear();
                System.out.println("Se elimino correctamente");
            } else if (deleteOption == 2) {
                System.out.println("Ingrese el ID del catalogo que desee eliminar");
                int deleteId = scanner.nextInt();
                scanner.nextLine();

                boolean found = false;

                for (int i = 0; i < catalogs.size(); i++) {
                    if (catalogs.get(i).getId() == deleteId) {
                        catalogs.remove(i);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    System.out.println("Catalogo con ID " + deleteId + " ha sido eliminado.");
                } else {
                    System.out.println("Catalogo con ID " + deleteId + " no se ha encontrado.");
                }
            } else {
                System.out.println("Opcion no valida.");
            }
        }
    }

    public void putCatalog() {
        if (catalogs.size() == 0) {
            System.out.println("No hay catalogos que modificar.");
        } else {
            System.out.println("Digitalice el ID del catalogo que desee modificar: ");
            int putId = scanner.nextInt();
            scanner.nextLine();

            boolean found = false;

            for (Catalog catalog : catalogs) {
                if (catalog.getId() == putId) {
                    System.out.println("Digite el nuevo catalogo: ");
                    String newName = scanner.nextLine();

                    catalog.setName(newName);

                    found = true;
                    System.out.println("Catalogo con ID " + putId + " ha sido modificado.");
                    break;
                }
            }

            if (!found) {
                System.out.println("Catalogo con ID " + putId + " no encontrado.");
            }
        }
    }
}