import dominio.TiendaService;

public class Main {
    public static void main(String[] args) {
        TiendaService ts = new TiendaService();
        try {
            ts.mostrarMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
