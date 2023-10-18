package dominio;

import persistencia.ProductoDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductoService {

    private final ProductoDAO productoDAO;
    private final FabricanteService fabricanteService;
    private final Scanner sc;

    public ProductoService() {
        productoDAO = new ProductoDAO();
        fabricanteService = new FabricanteService();
        sc = new Scanner(System.in);
    }

    public void listarProductos() throws Exception {
        try {
            ArrayList<Producto> productos = productoDAO.retornarProductos();
            productos.forEach(producto -> System.out.println(producto));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarNombreProductos() throws Exception {
        try {
            ArrayList<Producto> productos = productoDAO.retornarProductos();
            productos.forEach(producto -> System.out.println(producto.getNombre()));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarNombrePrecioProductos() throws Exception {
        try {
            ArrayList<Producto> productos = productoDAO.retornarProductos();
            productos.forEach(producto -> System.out.println(producto.getNombre() + " $" + producto.getPrecio()));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarProductos102A202() throws Exception {
        try {
            ArrayList<Producto> productos = productoDAO.listarProductosPorPrecio(102.0, 202.0);
            productos.forEach(producto -> System.out.println(producto.getNombre() + " $" + producto.getPrecio()));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarPortatiles() throws Exception {
        try {
            ArrayList<Producto> productos = productoDAO.listarProductosPorNombre("Portátil");
            productos.forEach(producto -> System.out.println(producto.getNombre() + " $" + producto.getPrecio()));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarProductoMenorPrecio() throws Exception {
        try {
            Producto producto = productoDAO.listarProductoMenorPrecio();
            System.out.println(producto.getNombre() + " $" + producto.getPrecio());
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto crearProducto() throws Exception {
        System.out.println("Por favor ingrese los datos del producto");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.println("Elija un fabricante");
        ArrayList<Fabricante> fabricantes = fabricanteService.retornarFabricantes();
        int i = 1;
        for (Fabricante fabricante : fabricantes) {
            System.out.println(i + ". " + fabricante.getNombre());
            i++;
        }
        int op;
        do {
            op = Integer.parseInt(sc.nextLine());
            if (op < 1 || op > fabricantes.size()) {
                System.out.println("Opción incorrecta, por favor intente de nuevo");
            }
        } while (op < 1 || op > fabricantes.size());
        int codigo_fabricante = fabricantes.get(op - 1).getCodigo();

        return new Producto(nombre, precio, codigo_fabricante);
    }

    public void ingresarProducto() throws Exception {
        Producto producto = crearProducto();
        productoDAO.ingresarProducto(producto);
    }

    public int seleccionarCodigoProducto() throws Exception {
        try {
            ArrayList<Producto> productos = productoDAO.retornarProductos();
            System.out.println("Por favor elija el producto que desea editar");
            int i = 1;
            for (Producto producto : productos) {
                System.out.println(i + ". " + producto.getNombre());
                i++;
            }
            int op;
            do {
                op = Integer.parseInt(sc.nextLine());
                if (op < 1 || op > productos.size()) {
                    System.out.println("Opción incorrecta, por favor elija de nuevo");
                }
            } while (op < 1 || op > productos.size());
            return productos.get(op - 1).getCodigo();
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarProducto() throws Exception {
        try {
            int codigoProducto = seleccionarCodigoProducto();
            Producto producto = crearProducto();
            productoDAO.editarProducto(codigoProducto, producto);
        } catch (Exception e) {
            throw e;
        }
    }
}

