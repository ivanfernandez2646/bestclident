package logica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author IVÁN-PC
 */
public class LogicaCliente {
    
    public static Cliente getCliente(Cliente c) throws Exception{
        String sql = "SELECT * FROM cliente WHERE dni = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, c.getDni());
            ResultSet rs = pst.executeQuery();
            
            Cliente newCliente = null;
            
            if(rs.next()){
                newCliente = new Cliente();
                newCliente.setDni(rs.getString("dni"));
                newCliente.setNombre(rs.getString("nombre"));
                newCliente.setDireccion(rs.getString("direccion"));
                newCliente.setTelefono(rs.getString("telefono"));
                newCliente.setEmail(rs.getString("email"));
                newCliente.setRutaFoto(rs.getString("rutaFoto"));
            }
            
            return newCliente;
        } catch (SQLException ex) {
            throw new Exception("Error getCliente()", ex);
        }
    }

    public static boolean existeCliente(Cliente c) throws Exception {

        String sql = "SELECT * FROM cliente WHERE dni = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, c.getDni());
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            throw new Exception("Error existeCliente()", ex);
        }
    }

    public static void altaCliente(Cliente c) throws Exception {

        String sql = "INSERT INTO cliente VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, c.getDni());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getDireccion());
            pst.setString(4, c.getTelefono());
            pst.setString(5, c.getEmail());
            pst.setString(6, c.getRutaFoto());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error altaCliente()\n"+ex.getMessage(), ex);
        }
    }

    public static void bajaCliente(Cliente c) throws Exception {

        String sql = "DELETE FROM cliente WHERE dni = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, c.getDni());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error bajaCliente()", ex);
        }
    }

    public static void editarCliente(Cliente c) throws Exception {

        String sql = "UPDATE cliente SET dni = ?, nombre = ?, direccion = ?, telefono = ?, email = ? ,rutaFoto = ? WHERE dni = ?";

        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, c.getDni());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getDireccion());
            pst.setString(4, c.getTelefono());
            pst.setString(5, c.getEmail());
            pst.setString(6, c.getRutaFoto());
            pst.setString(7, c.getDni());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error editarCliente()", ex);
        }
    }
    
    public static void listadoCliente(List<Cliente> tClientes) throws Exception{
        
        String sql = "SELECT * FROM cliente";
        
        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            ResultSet rs = pst.executeQuery();
            Cliente c;
            while(rs.next()){
                c = new Cliente();
                c.setDni(rs.getString("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setRutaFoto(rs.getString("rutaFoto"));
                tClientes.add(c);
            }
        } catch (SQLException ex) {
            throw new Exception("Error listadoCliente()", ex);
        }
    }
    
    public static void listadoClienteFiltrado(List<Cliente> tClientes,String filtroDni) throws Exception{
         
        String sql = "SELECT * FROM cliente WHERE dni LIKE ?";
        
        try (PreparedStatement pst = ConexionBD.getConn().prepareCall(sql)) {
            pst.setString(1, filtroDni);
            ResultSet rs = pst.executeQuery();
            Cliente c;
            while(rs.next()){
                c = new Cliente();
                c.setDni(rs.getString("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setRutaFoto(rs.getString("rutaFoto"));
                tClientes.add(c);
            }
        } catch (SQLException ex) {
            throw new Exception("Error listadoClienteFiltrado()", ex);
        }
    }
}
