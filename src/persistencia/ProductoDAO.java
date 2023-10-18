package persistencia;

import dominio.Producto;

import java.util.ArrayList;

public final class ProductoDAO extends DAO {
    public ArrayList<Producto> retornarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM producto;";
            consultarBase(sql);

            ArrayList<Producto> productos = new ArrayList<>();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> listarProductosPorPrecio(double max) throws Exception {

        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 0.0 AND " + max + ";";
            consultarBase(sql);

            ArrayList<Producto> productos = new ArrayList<>();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> listarProductosPorNombre(String nombre) throws Exception {

        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%" + nombre + "%';";
            consultarBase(sql);

            ArrayList<Producto> productos = new ArrayList<>();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> listarProductosPorPrecio(double min, double max) throws Exception {

        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN " + min + " AND " + max + ";";
            consultarBase(sql);

            ArrayList<Producto> productos = new ArrayList<>();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto listarProductoMenorPrecio() throws Exception {

        try {
            String sql = "SELECT * FROM producto WHERE precio = (SELECT MIN(precio) FROM producto);";
            consultarBase(sql);

            Producto producto = new Producto();

            while (resultado.next()) {
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public void ingresarProducto(Producto producto) throws Exception {
        try {
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) VALUES ('" +
                    producto.getNombre() + "', " +
                    producto.getPrecio() + ", " +
                    producto.getCodigo_fabricante() + ");";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarProducto(int codigoProducto, Producto producto) throws Exception {
        try {
            String sql = "UPDATE producto SET " +
                    "nombre = '" + producto.getNombre() + "', " +
                    "precio = " + producto.getPrecio() + ", " +
                    "codigo_fabricante = " + producto.getCodigo_fabricante() +
                    " WHERE codigo = " + codigoProducto + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
