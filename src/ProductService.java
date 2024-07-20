package src;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    Scanner scanner = new Scanner(System.in);

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Catalog> catalogs;

//    CatalogService catalogService = new CatalogService();

    public ProductService(ArrayList<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    //    Agregar productos
    public void addProduct() {
        System.out.println("--- Agregue producto al stock ---");

        if (catalogs.size() > 0) {
            System.out.println("Digitalice el nombre: ");
            String nameProduct = scanner.nextLine();
            System.out.println("Digitalice el numero de catalogo: ");
            for (Catalog catalogIndex : catalogs) {
                System.out.println("ID: " + catalogIndex.getId() + ", nombre: " + catalogIndex.getName());
            }
            int catalogProduct = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digitalice la descripcion: ");
            String descriptionProduct = scanner.nextLine();
            System.out.println("Digitalice la cantidad: ");
            int totalProduct = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digitalice el precio: ");
            float priceProduct = scanner.nextFloat();
            scanner.nextLine();

            Catalog catalog = findCatalogById(catalogProduct);
            if (catalog != null) {
                Product newProduct = new Product();
                newProduct.setId(products.size() + 1);
                newProduct.setName(nameProduct);
                newProduct.setCatalogId(catalogProduct);
                newProduct.setDescription(descriptionProduct);
                newProduct.setTotal(totalProduct);
                newProduct.setPrice(priceProduct);

                products.add(newProduct);

                System.out.println("Producto agregado correctamente.");
            } else {
                System.out.println("No existe el catalogo con ese ID");
            }
        } else {
            System.out.println("No hay catálogos disponibles. Agregue un catálogo primero.");
        }
    }


    public boolean hasProducts() {
        return !products.isEmpty();
    }

    private Catalog findCatalogById(int id) {
        for (Catalog catalog : catalogs) {
            if (catalog.getId() == id) {
                return catalog;
            }
        }
        return null;
    }

    //    Visualizar productos
    public ArrayList<Product> getProduct() {
        if (products.size() == 0 || products == null) {
            System.out.println("No hay productos que mostrar");
        } else {
            for (Product product : products) {
                System.out.println("ID: " + product.getId() +
                        ", Nombre: " + product.getName() +
                        ", Catálogo: " + product.getCatalogId() +
                        ", Descripción: " + product.getDescription() +
                        ", Cantidad: " + product.getTotal() +
                        ", Precio: " + product.getPrice());
            }
        }
        return products;
    }

    //    Eliminar productos
    public void deleteProduct() {
        if (products.size() == 0 || products == null) {
            System.out.println("No hay productos que eliminar");
        } else {
            System.out.println("Desea eliminar todos los productos o alguno en especifico? (1/2): ");
            int deleteOption = scanner.nextInt();

            if (deleteOption == 1) {
                products.clear();
                System.out.println("Se elimino correctamente");
            } else if (deleteOption == 2) {
                System.out.println("Digitalice el ID del producto que desee eliminar: ");
                int deleteId = scanner.nextInt();
                boolean found = false;

                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getId() == deleteId) {
                        products.remove(i);
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("Producto con ID " + deleteId + " ha sido eliminado.");
                } else {
                    System.out.println("Producto con ID " + deleteId + " no se ha encontrado.");
                }
            } else {
                System.out.println("Opcion no valida");
            }
        }
    }

    //    Modificar producto
    public void putProduct() {
        if (products.size() == 0 || products == null) {
            System.out.println("No hay productos que modificar");
        } else {
            System.out.println("Digitalice el ID del producto que desee modificar: ");
            int putId = scanner.nextInt();
            scanner.nextLine();

            boolean found = false;

            for (Product product : products) {
                if (product.getId() == putId) {
                    System.out.println("Digite el nuevo producto: ");
                    String newName = scanner.nextLine();
                    System.out.println("Digitalice el nuevo numero de catalogo: ");
                    int newCatalogProduct = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digitalice la nueva descripcion: ");
                    String newDescriptionProduct = scanner.nextLine();
                    System.out.println("Digite la nueva cantidad: ");
                    int newTotal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite el nuevo precio: ");
                    float newPrice = scanner.nextFloat();
                    scanner.nextLine();

                    product.setName(newName);
                    product.setCatalogId(newCatalogProduct);
                    product.setDescription(newDescriptionProduct);
                    product.setTotal(newTotal);
                    product.setPrice(newPrice);

                    found = true;
                    System.out.println("Producto con ID " + putId + " ha sido modificado.");
                    break;
                }
            }

            if (!found) {
                System.out.println("Producto con ID " + putId + " no encontrado.");
            }
        }
    }
}