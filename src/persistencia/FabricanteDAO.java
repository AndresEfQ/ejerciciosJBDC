package persistencia;

import dominio.Fabricante;
import dominio.Producto;

import java.util.ArrayList;

public final class FabricanteDAO extends DAO {
    public ArrayList<Fabricante> retornarFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante;";
            consultarBase(sql);

            ArrayList<Fabricante> fabricantes = new ArrayList<>();
            Fabricante fabricante = null;

            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void ingresarFabricante(Fabricante fabricante) throws Exception {
        try {
            String sql = "INSERT INTO fabricante (nombre) VALUES ('" +
                    fabricante.getNombre() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
