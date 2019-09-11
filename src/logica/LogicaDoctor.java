package logica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Doctor;

/**
 *
 * @author IVÁN-PC
 */
public class LogicaDoctor {
    
    public static Doctor getDoctor(Doctor d) throws Exception{
        String sql = "SELECT * FROM doctor WHERE dni = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, d.getDni());
            ResultSet rs = pst.executeQuery();
            
            Doctor newDoctor = null;
            
            if(rs.next()){
                newDoctor = new Doctor();
                newDoctor.setDni(rs.getString("dni"));
                newDoctor.setNombre(rs.getString("nombre"));
                newDoctor.setApellidos(rs.getString("apellidos"));
                newDoctor.setEdad(rs.getInt("edad"));
                newDoctor.setSueldo(rs.getDouble("sueldo"));
                newDoctor.setRutaFoto(rs.getString("rutaFoto"));
            }
            
            return newDoctor;
        } catch (SQLException ex) {
            throw new Exception("Error getDoctor()", ex);
        }
    }

    public static boolean existeDoctor(Doctor d) throws Exception {

        String sql = "SELECT * FROM doctor WHERE dni = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, d.getDni());
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            throw new Exception("Error existeDoctor()", ex);
        }
    }

    public static void altaDoctor(Doctor d) throws Exception {

        String sql = "INSERT INTO doctor VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, d.getDni());
            pst.setString(2, d.getNombre());
            pst.setString(3, d.getApellidos());
            pst.setInt(4, d.getEdad());
            pst.setDouble(5, d.getSueldo());
            pst.setString(6, d.getRutaFoto());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error altaDoctor()\n"+ex.getMessage(), ex);
        }
    }

    public static void bajaDoctor(Doctor d) throws Exception {

        String sql = "DELETE FROM doctor WHERE dni = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, d.getDni());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error bajaDoctor()", ex);
        }
    }

    public static void editarDoctor(Doctor d) throws Exception {

        String sql = "UPDATE doctor SET dni = ?, nombre = ?, apellidos = ?, edad = ?, sueldo = ? ,rutaFoto = ? WHERE dni = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, d.getDni());
            pst.setString(2, d.getNombre());
            pst.setString(3, d.getApellidos());
            pst.setInt(4, d.getEdad());
            pst.setDouble(5, d.getSueldo());
            pst.setString(6, d.getRutaFoto());
            pst.setString(7, d.getDni());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error editarDoctor()", ex);
        }
    }
    
    public static void listadoDoctor(List<Doctor> tDoctores) throws Exception{
        
        String sql = "SELECT * FROM doctor";
        
        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            ResultSet rs = pst.executeQuery();
            Doctor d;
            while(rs.next()){
                d = new Doctor();
                d.setDni(rs.getString("dni"));
                d.setNombre(rs.getString("nombre"));
                d.setApellidos(rs.getString("apellidos"));
                d.setEdad(rs.getInt("edad"));
                d.setSueldo(rs.getDouble("sueldo"));
                d.setRutaFoto(rs.getString("rutaFoto"));
                tDoctores.add(d);
            }
        } catch (SQLException ex) {
            throw new Exception("Error listadoDoctor()", ex);
        }
    }
    
    public static void listadoDoctorFiltrado(List<Doctor> tDoctores,String filtroDni) throws Exception{
         
        String sql = "SELECT * FROM doctor WHERE dni LIKE ?";
        
        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, filtroDni);
            ResultSet rs = pst.executeQuery();
            Doctor d;
            while(rs.next()){
                d = new Doctor();
                d.setDni(rs.getString("dni"));
                d.setNombre(rs.getString("nombre"));
                d.setApellidos(rs.getString("apellidos"));
                d.setEdad(rs.getInt("edad"));
                d.setSueldo(rs.getDouble("sueldo"));
                d.setRutaFoto(rs.getString("rutaFoto"));
                tDoctores.add(d);
            }
        } catch (SQLException ex) {
            throw new Exception("Error listadoDoctorFiltrado()", ex);
        }
    }
}
