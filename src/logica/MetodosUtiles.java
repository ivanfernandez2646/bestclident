package logica;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public interface MetodosUtiles {

    //Para salir y a la vez cerrar la conexion con la BBDD
    //Devuelve true or false para controlar si queremos abrir una nueva ventana o no.
    default boolean salirYCerrarConexion(JFrame frameLlamada) {
        try {
            int op = JOptionPane.showConfirmDialog(frameLlamada,
                    "¿Está seguro de que desea salir?",
                    frameLlamada.getName(),
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            switch (op) {
                case JOptionPane.YES_OPTION:
                    System.out.println("Cerrando Conexión con BDDD...");
                    logica.ConexionBD.cerrarConexion();
                    System.out.println("Conexión Cerrada Correctamente");
                    frameLlamada.setVisible(false);
                    frameLlamada.dispose();
                    return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    //Para salir sin cerrar la conexión
    default void salirSinCerrarConexion(JFrame frameLlamada) {

        int op = JOptionPane.showConfirmDialog(frameLlamada,
                "¿Está seguro de que desea salir?",
                frameLlamada.getName(),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        switch (op) {
            case JOptionPane.YES_OPTION:
                frameLlamada.setVisible(false);
                frameLlamada.removeAll();
                frameLlamada.dispose();
                break;
        }
    }
}
