package logica;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import modelo.Cita;

/**
 *
 * @author IVÁN-PC
 */
public class LogicaCita {

    public static List<String> horariosDisponibles(String fecha) throws Exception {

        String sql = "SELECT TIME_FORMAT((SELECT hora FROM cita where fecha = ?), '%H:%i')";

        List<String> tHorariosDisponibles = new ArrayList<>();

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, fecha);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String hora = rs.getString(1);

                if (hora != null) {
                    tHorariosDisponibles.add(rs.getString(1));
                }
            }

            return tHorariosDisponibles;
        } catch (SQLException ex) {
            throw new Exception("Error horariosDisponibles()", ex);
        }
    }
    
    public static void altaCita(Cita c) throws Exception{
        
        String sql = "INSERT INTO cita VALUES(?,?,?,?)";
        
        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setInt(1, c.getIdServicio());
            pst.setString(2, c.getDniCliente());
            pst.setDate(3, Date.valueOf(c.getFecha()));
            pst.setTime(4, Time.valueOf(c.getHora()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error altaCita()", ex);
        }
    }
}
