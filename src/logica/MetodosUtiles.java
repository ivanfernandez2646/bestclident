package logica;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public interface MetodosUtiles {

    //Para salir y a la vez cerrar la conexion con la BBDD
    //Devuelve true or false para controlar si queremos abrir de nuevo el programa o no no.
    default boolean salirYCerrarConexion(JFrame frameLlamada, boolean cerrarSesion) {
        try {

            int op;

            if (cerrarSesion) {
                op = JOptionPane.showConfirmDialog(frameLlamada,
                        "¿Está seguro de que desea cerrar sesión?",
                        frameLlamada.getName(),
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
            } else {
                op = JOptionPane.showConfirmDialog(frameLlamada,
                        "¿Está seguro de que desea salir?",
                        frameLlamada.getName(),
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
            }

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

    //Para salir sin cerrar la conexión cuando estamos ubicados en el LogIn
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
