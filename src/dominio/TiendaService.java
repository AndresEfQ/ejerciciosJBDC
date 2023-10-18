package dominio;

import java.util.Scanner;

public class TiendaService {
    private FabricanteService fabricanteService;
    private ProductoService productoService;
    private Scanner sc;

    public TiendaService() {
        fabricanteService = new FabricanteService();
        productoService = new ProductoService();
        sc = new Scanner(System.in);
    }

    public void mostrarMenu() throws Exception {

        int op;
        do {
            System.out.println("Bienvenido a la tienda");
            System.out.println("Elija la opción que desea realizar");
            System.out.println();
            System.out.println("1. Listar el nombre de todos los productos de la tienda");
            System.out.println("2. Listar el nombre y el precio de todos los productos de la tienda");
            System.out.println("3. Listar el nombre de los productos que su precio esté entre 102 y 202");
            System.out.println("4. Buscar y listar todos los portatiles de la tienda");
            System.out.println("5. Listar el nombre y el precio del producto más barato");
            System.out.println("6. Ingresar un producto a la base de datos");
            System.out.println("7. Ingresar un fabricante a la base de datos");
            System.out.println("8. Editar un producto");
            System.out.println("0. Salir");

            do {
                op = Integer.parseInt(sc.nextLine());
                if (op < 0 || op > 9) {
                    System.out.println("Opción incorrecta, por favor elija una opción entre 0 y 8");
                }
            } while (op < 0 || op > 9);

            switch (op) {
                case 1 -> productoService.listarNombreProductos();
                case 2 -> productoService.listarNombrePrecioProductos();
                case 3 -> productoService.listarProductos102A202();
                case 4 -> productoService.listarPortatiles();
                case 5 -> productoService.listarProductoMenorPrecio();
                case 6 -> productoService.ingresarProducto();
                case 7 -> fabricanteService.ingresarFabricante();
                case 8 -> productoService.editarProducto();
                case 9 -> productoService.listarProductos();
                case 0 -> System.out.println("Graciar por utilizar nuestra tienda");
            }
            System.out.println();
        } while (op != 0);
    }
}
