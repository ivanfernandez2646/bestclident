package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

/**
 *
 * @author IVÁN-PC
 */
public class ConexionBD {

    private static Connection conn;
    private static final String DB = "bestclident";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB
            + "?serverTimezone=Europe/Madrid & useSSL=false & useServerPrepStmts=true & allowPublicKeyRetrieval=true";
    private static String USER;
    private static String PASS;

    public static Connection getConn() {
        return conn;
    }

    public static void setUSER(String USER) {
        ConexionBD.USER = USER;
    }

    public static void setPASS(String PASS) {
        ConexionBD.PASS = PASS;
    }

    public static void abrirConexion() throws Exception {

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            crearTablas();
            crearSPandTriggersDoctor();
            crearSPandTriggersServicio();
            crearSPandTriggersCita();
        } catch (SQLNonTransientConnectionException ex) {
            throw new Exception("Error usuario o contraseña incorrectos", ex);
        } catch (SQLException ex) {
            throw new Exception("Error abrirConexion()", ex);
        }
    }

    private static void crearTablas() throws Exception {

        String sqlDoctor = "create table if not exists doctor(\n"
                + "	dni char(9) primary key,\n"
                + "	nombre varchar(15) not null,\n"
                + "	apellidos varchar(30) not null,\n"
                + "	edad tinyint not null,\n"
                + "	sueldo decimal(6,2) not null,\n"
                + "	rutaFoto varchar(50) null\n"
                + ")";

        String sqlServicio = "create table if not exists servicio(\n"
                + "	id int auto_increment primary key,\n"
                + "	nombre varchar(15) not null,\n"
                + "     precio decimal(6,2) not null,\n"
                + "	dniDoctor char(9),\n"
                + "	constraint fk_dniDoctor foreign key(dniDoctor) references doctor(dni) on delete set null\n"
                + ");";

        String sqlCliente = "create table if not exists cliente(\n"
                + "	dni char(9) primary key,\n"
                + "	nombre varchar(15) not null,\n"
                + "	direccion varchar(10) not null,\n"
                + "	telefono char(9) not null,\n"
                + "	email varchar(50) null,\n"
                + "	rutaFoto varchar(50) null\n"
                + ")";

        String sqlCita = "create table if not exists cita(\n"
                + "	idServicio int,\n"
                + "	dniCliente char(9),\n"
                + "	fecha date,\n"
                + "	hora time,\n"
                + "	constraint fk_idServicio foreign key(idServicio) references servicio(id),\n"
                + "	constraint fk_dniCliente foreign key(dniCliente) references cliente(dni),\n"
                + "	constraint pk_cita primary key(idServicio,dniCliente,fecha,hora)\n"
                + ");";

        try (PreparedStatement pstDoctor = conn.prepareStatement(sqlDoctor);
                PreparedStatement pstServicio = conn.prepareStatement(sqlServicio);
                PreparedStatement pstCliente = conn.prepareStatement(sqlCliente);
                PreparedStatement pstCita = conn.prepareStatement(sqlCita);) {

            pstDoctor.executeUpdate();
            pstServicio.executeUpdate();
            pstCliente.executeUpdate();
            pstCita.executeUpdate();

        } catch (SQLException ex) {
            throw new Exception("Error crearTablas()", ex);
        }
    }

    private static void crearSPandTriggersDoctor() throws Exception {

        String sqlDoctorProcBorrar = "select count(*) from information_schema.ROUTINES where ROUTINE_SCHEMA=\"bestclident\" and ROUTINE_TYPE=\"PROCEDURE\" and SPECIFIC_NAME = 'procComprobarDatosDoctor';";
        String sqlDoctorProc = "create procedure procComprobarDatosDoctor(IN edad tinyint, IN sueldo decimal(6,2))\n"
                + "begin\n"
                + "	if edad < 1 or edad > 120 then \n"
                + "		signal sqlstate '45000' set message_text = 'ERROR. Edad debe estar comprendida entre 0 y 120';\n"
                + "	end if;\n"
                + "    \n"
                + "    if sueldo < 900 then\n"
                + "		signal sqlstate '45001' set message_text = 'ERROR. Salario no debe estar por debajo de SMI(900€)';\n"
                + "    end if;\n"
                + "end;";

        String sqlDoctorTrigg1Borrar = "select count(*) from information_schema.TRIGGERS where TRIGGER_SCHEMA = 'bestclident' and TRIGGER_NAME = 'comprobarDoctorInsert';";
        String sqlDoctorTrigg1 = "create trigger comprobarDoctorInsert\n"
                + "before insert on\n"
                + "doctor\n"
                + "for each row\n"
                + "begin\n"
                + "	call procComprobarDatosDoctor(NEW.edad,NEW.sueldo);\n"
                + "end;";

        String sqlDoctorTrigg2Borrar = "select count(*) from information_schema.TRIGGERS where TRIGGER_SCHEMA = 'bestclident' and TRIGGER_NAME = 'comprobarDoctorUpdate';";
        String sqlDoctorTrigg2 = "create trigger comprobarDoctorUpdate\n"
                + "before update on\n"
                + "doctor\n"
                + "for each row\n"
                + "begin\n"
                + "	call procComprobarDatosDoctor(NEW.edad,NEW.sueldo);\n"
                + "end;";

        try (PreparedStatement pstDoctorProcBorrar = conn.prepareStatement(sqlDoctorProcBorrar);
                PreparedStatement pstDoctorProc = conn.prepareStatement(sqlDoctorProc);
                PreparedStatement pstDoctorTrigg1Borrar = conn.prepareStatement(sqlDoctorTrigg1Borrar);
                PreparedStatement pstDoctorTrigg1 = conn.prepareStatement(sqlDoctorTrigg1);
                PreparedStatement pstDoctorTrigg2Borrar = conn.prepareStatement(sqlDoctorTrigg2Borrar);
                PreparedStatement pstDoctorTrigg2 = conn.prepareStatement(sqlDoctorTrigg2);) {

            ResultSet rs;

            rs = pstDoctorProcBorrar.executeQuery();
            rs.next();

            if (rs.getInt(1) == 0) {
                pstDoctorProc.executeUpdate();
            }

            rs = pstDoctorTrigg1Borrar.executeQuery();
            rs.next();

            if (rs.getInt(1) == 0) {
                pstDoctorTrigg1.executeUpdate();
            }

            rs = pstDoctorTrigg2Borrar.executeQuery();
            rs.next();

            if (rs.getInt(1) == 0) {
                pstDoctorTrigg2.executeUpdate();
            }

        } catch (SQLException ex) {
            throw new Exception("Error crearSPandTriggersDoctor()", ex);
        }
    }

    private static void crearSPandTriggersServicio() throws Exception {

        String sqlServicioProcBorrar = "select count(*) from information_schema.ROUTINES where ROUTINE_SCHEMA=\"bestclident\" and ROUTINE_TYPE=\"PROCEDURE\" and SPECIFIC_NAME = 'procComprobarDatosServicio';";
        String sqlServicioProc = "create procedure procComprobarDatosServicio(IN precio decimal(6,2))\n"
                + "begin\n"
                + "	if precio < 0 then \n"
                + "		signal sqlstate '45000' set message_text = 'ERROR. Precio no debe ser inferior a 0';\n"
                + "	end if;\n"
                + "end;";

        String sqlServicioTrigg1Borrar = "select count(*) from information_schema.TRIGGERS where TRIGGER_SCHEMA = 'bestclident' and TRIGGER_NAME = 'comprobarServicioInsert';";
        String sqlServicioTrigg1 = "create trigger comprobarServicioInsert\n"
                + "before insert on\n"
                + "servicio\n"
                + "for each row\n"
                + "begin\n"
                + "	call procComprobarDatosServicio(NEW.precio);\n"
                + "end;";

        String sqlServicioTrigg2Borrar = "select count(*) from information_schema.TRIGGERS where TRIGGER_SCHEMA = 'bestclident' and TRIGGER_NAME = 'comprobarServicioUpdate';";
        String sqlServicioTrigg2 = "create trigger comprobarServicioUpdate\n"
                + "before update on\n"
                + "servicio\n"
                + "for each row\n"
                + "begin\n"
                + "	call procComprobarDatosServicio(NEW.precio);\n"
                + "end;";

        try (PreparedStatement pstServicioProcBorrar = conn.prepareStatement(sqlServicioProcBorrar);
                PreparedStatement pstServicioProc = conn.prepareStatement(sqlServicioProc);
                PreparedStatement pstServicioTrigg1Borrar = conn.prepareStatement(sqlServicioTrigg1Borrar);
                PreparedStatement pstServicioTrigg1 = conn.prepareStatement(sqlServicioTrigg1);
                PreparedStatement pstServicioTrigg2Borrar = conn.prepareStatement(sqlServicioTrigg2Borrar);
                PreparedStatement pstServicioTrigg2 = conn.prepareStatement(sqlServicioTrigg2);) {

            ResultSet rs;

            rs = pstServicioProcBorrar.executeQuery();
            rs.next();

            if (rs.getInt(1) == 0) {
                pstServicioProc.executeUpdate();
            }

            rs = pstServicioTrigg1Borrar.executeQuery();
            rs.next();

            if (rs.getInt(1) == 0) {
                pstServicioTrigg1.executeUpdate();
            }

            rs = pstServicioTrigg2Borrar.executeQuery();
            rs.next();

            if (rs.getInt(1) == 0) {
                pstServicioTrigg2.executeUpdate();
            }

        } catch (SQLException ex) {
            throw new Exception("Error crearSPandTriggersServicio()", ex);
        }
    }

    private static void crearSPandTriggersCita() throws Exception {

        String sqlCitaProcBorrar = "select count(*) from information_schema.ROUTINES where ROUTINE_SCHEMA=\"bestclident\" and ROUTINE_TYPE=\"PROCEDURE\" and SPECIFIC_NAME = 'procComprobarDatosCita';";
        String sqlCitaProc = "create procedure procComprobarDatosCita(IN fecha date, IN hora time)\n"
                + "begin\n"
                + "	if fecha <= curdate() then \n"
                + "		signal sqlstate '45000' set message_text = 'ERROR. Fecha tiene que ser posterior a la fecha actual';\n"
                + "	end if;\n"
                + "end;";

        String sqlCitaTrigg1Borrar = "select count(*) from information_schema.TRIGGERS where TRIGGER_SCHEMA = 'bestclident' and TRIGGER_NAME = 'comprobarCitaInsert';";
        String sqlCitaTrigg1 = "create trigger comprobarCitaInsert\n"
                + "before insert on\n"
                + "cita\n"
                + "for each row\n"
                + "begin\n"
                + "	call procComprobarDatosCita(NEW.fecha,NEW.hora);\n"
                + "end;";

        String sqlCitaTrigg2Borrar = "select count(*) from information_schema.TRIGGERS where TRIGGER_SCHEMA = 'bestclident' and TRIGGER_NAME = 'comprobarCitaUpdate';";
        String sqlCitaTrigg2 = "create trigger comprobarCitaUpdate\n"
                + "before update on\n"
                + "cita\n"
                + "for each row\n"
                + "begin\n"
                + "	call procComprobarDatosCita(NEW.fecha,NEW.hora);\n"
                + "end;";

        try (PreparedStatement pstCitaProcBorrar = conn.prepareStatement(sqlCitaProcBorrar);
                PreparedStatement pstCitaProc = conn.prepareStatement(sqlCitaProc);
                PreparedStatement pstCitaTrigg1Borrar = conn.prepareStatement(sqlCitaTrigg1Borrar);
                PreparedStatement pstCitaTrigg1 = conn.prepareStatement(sqlCitaTrigg1);
                PreparedStatement pstCitaTrigg2Borrar = conn.prepareStatement(sqlCitaTrigg2Borrar);
                PreparedStatement pstCitaTrigg2 = conn.prepareStatement(sqlCitaTrigg2);) {

            ResultSet rs;

            rs = pstCitaProcBorrar.executeQuery();
            rs.next();

            if (rs.getInt(1) == 0) {
                pstCitaProc.executeUpdate();
            }

            rs = pstCitaTrigg1Borrar.executeQuery();
            rs.next();

            if (rs.getInt(1) == 0) {
                pstCitaTrigg1.executeUpdate();
            }

            rs = pstCitaTrigg2Borrar.executeQuery();
            rs.next();

            if (rs.getInt(1) == 0) {
                pstCitaTrigg2.executeUpdate();
            }

        } catch (SQLException ex) {
            throw new Exception("Error crearSPandTriggersCita()", ex);
        }
    }

    public static void cerrarConexion() throws Exception {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            throw new Exception("Error cerrarConexion()", ex);
        }
    }
}
