package logica;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import modelo.Cita;
import modelo.Cliente;
import modelo.ListadoCitas;

/**
 *
 * @author IVÁN-PC
 */
public class LogicaCita {

   public static List<String> horariosDisponibles(String fecha) throws Exception {

        String sql = "SELECT time_format(hora,'%H:%i') FROM cita WHERE fecha = ?;";

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

    public static void altaCita(Cita c) throws Exception {

        String sql = "INSERT INTO cita VALUES(?,?,?,?)";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setInt(1, c.getIdServicio());
            pst.setString(2, c.getDniCliente());
            pst.setDate(3, Date.valueOf(c.getFecha()));
            pst.setTime(4, Time.valueOf(c.getHora()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error altaCita()\n" + ex.getMessage(), ex);
        }
    }
    
    public static void listadoCitaFiltrado(List<ListadoCitas> tListadoCitas,String filtroDni, String filtroFecha) throws Exception{
         
        String sql = "SELECT * FROM cliente c JOIN cita ci ON c.dni = ci.dniCliente JOIN servicio s ON s.id = ci.idServicio LEFT JOIN doctor d ON d.dni = s.dniDoctor"
                + " WHERE c.dni LIKE ? AND fecha LIKE ?";
        
        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, filtroDni);
            pst.setString(2, filtroFecha);
            ResultSet rs = pst.executeQuery();
            ListadoCitas lc;
            while(rs.next()){
                lc = new ListadoCitas();
                lc.setDniCliente(rs.getString("c.dni"));
                lc.setNombreCliente(rs.getString("c.nombre"));
                lc.setId_nombreServicio(rs.getInt("s.id")+". "+rs.getString("s.nombre"));
                lc.setDni_nombreDoctor(rs.getString("d.dni")+". "+rs.getString("d.nombre"));
                lc.setFecha(rs.getDate("ci.fecha").toLocalDate());
                lc.setHora(rs.getTime("ci.hora").toLocalTime());
                tListadoCitas.add(lc);
            }
        } catch (SQLException ex) {
            throw new Exception("Error listadoCitaFiltrado()", ex);
        }
    }
}
