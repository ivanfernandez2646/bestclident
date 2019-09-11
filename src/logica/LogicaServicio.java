package logica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Servicio;

/**
 *
 * @author IVÁN-PC
 */
public class LogicaServicio {

    public static int conseguirID() throws Exception {

        String sql = "SELECT MAX(id)+1 as idActual FROM servicio";

        try (PreparedStatement pst = ConexionBD.getConn().prepareStatement(sql);) {
            ResultSet rs = pst.executeQuery();
            rs.next();

            int id = rs.getInt("idActual");

            if (id == 0) {
                return 1;
            } else {
                return id;
            }
        } catch (SQLException ex) {
            throw new Exception("Error conseguirID()", ex);
        }
    }

    public static Servicio getServicio(Servicio s) throws Exception {
        String sql = "SELECT * FROM servicio WHERE id = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setInt(1, s.getId());
            ResultSet rs = pst.executeQuery();

            Servicio newServicio = null;

            if (rs.next()) {
                newServicio = new Servicio();
                newServicio.setId(rs.getInt("id"));
                newServicio.setNombre(rs.getString("nombre"));
                newServicio.setPrecio(rs.getDouble("precio"));
                newServicio.setDniDoctor(rs.getString("dniDoctor"));
            }

            return newServicio;
        } catch (SQLException ex) {
            throw new Exception("Error getServicio()", ex);
        }
    }

    public static boolean existeServicio(Servicio s) throws Exception {

        String sql = "SELECT * FROM servicio WHERE id = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setInt(1, s.getId());
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            throw new Exception("Error existeServicio()", ex);
        }
    }

    public static void altaServicio(Servicio s) throws Exception {

        String sql = "INSERT INTO servicio VALUES(?,?,?,?)";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setInt(1, s.getId());
            pst.setString(2, s.getNombre());
            pst.setDouble(3, s.getPrecio());
            pst.setString(4, s.getDniDoctor().equals("") ? null : s.getDniDoctor());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error altaServicio()\n" + ex.getMessage(), ex);
        }
    }

    public static void bajaServicio(Servicio s) throws Exception {

        String sql = "DELETE FROM servicio WHERE id = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setInt(1, s.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error bajaServicio()", ex);
        }
    }

    public static void editarServicio(Servicio s) throws Exception {

        String sql = "UPDATE servicio SET id = ?, nombre = ?, precio = ?, dniDoctor = ? WHERE id = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setInt(1, s.getId());
            pst.setString(2, s.getNombre());
            pst.setDouble(3, s.getPrecio());
            pst.setString(4, s.getDniDoctor().equals("") ? null : s.getDniDoctor());
            pst.setInt(5, s.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error editarServicio()", ex);
        }
    }

    public static void listadoServicio(List<Servicio> tDoctores) throws Exception {

        String sql = "SELECT * FROM servicio";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            ResultSet rs = pst.executeQuery();
            Servicio s;
            while (rs.next()) {
                s = new Servicio();
                s.setId(rs.getInt("id"));
                s.setNombre(rs.getString("nombre"));
                s.setPrecio(rs.getDouble("precio"));
                s.setDniDoctor(rs.getString("dniDoctor"));
                tDoctores.add(s);
            }
        } catch (SQLException ex) {
            throw new Exception("Error listadoServicio()", ex);
        }
    }
}
