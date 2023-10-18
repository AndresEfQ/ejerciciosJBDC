package dominio;

import persistencia.FabricanteDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class FabricanteService {

    private final FabricanteDAO fabricanteDAO;
    private final Scanner sc;

    public FabricanteService() {
        fabricanteDAO = new FabricanteDAO();
        sc = new Scanner(System.in);
    }

    public ArrayList<Fabricante> retornarFabricantes() throws Exception {
        try {
            return fabricanteDAO.retornarFabricantes();
        } catch (Exception e) {
            throw e;
        }
    }

    public void ingresarFabricante() throws Exception {
        try {
            System.out.println("Por favor ingrese el nombre del nuevo fabricante");
            fabricanteDAO.ingresarFabricante(new Fabricante(sc.nextLine()));
        } catch (Exception e) {
            throw e;
        }
    }
}
