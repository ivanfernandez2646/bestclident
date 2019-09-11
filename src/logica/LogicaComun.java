package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author IVÁN-PC
 */
public class LogicaComun {

    public static enum DUEÑOFOTO {
        DOCTOR, CLIENTE
    }

    public static String conseguirRutaRelativa(String URL, DUEÑOFOTO dueñoFoto) {

        String newURL = "";

        if (!URL.equals("")) {
            for (int i = URL.length() - 1; URL.charAt(i) != '\\' && URL.charAt(i) != '/'; i--) {
                newURL = URL.charAt(i) + newURL;
            }
        }

        if (dueñoFoto.equals(DUEÑOFOTO.DOCTOR)) {
            newURL = "dat/imgDoctores/" + newURL;
        } else if (dueñoFoto.equals(DUEÑOFOTO.CLIENTE)) {
            newURL = "dat/imgClientes/" + newURL;
        }

        return newURL;
    }

    public static void copiarFoto(String URL, String newURL, String URLAntigua) throws Exception {

        try {
            Path origenFoto = FileSystems.getDefault().getPath(URL);
            Path destinoFoto = FileSystems.getDefault().getPath(newURL);
            Files.copy(origenFoto, destinoFoto, StandardCopyOption.REPLACE_EXISTING);

            //Para borrar la foto antigua en caso de que tenga una ya asignada
            if (URLAntigua != null && !URLAntigua.equals(newURL)) {
                Path fotoABorrar = FileSystems.getDefault().getPath(URLAntigua);
                Files.delete(fotoABorrar);
            }
        } catch (FileNotFoundException ex) {
            throw new Exception("Error. Imagen no encontrada!!", ex);
        } catch (IOException ex) {
            throw new Exception("Error copiarFoto()", ex);
        }
    }
    
    public static void eliminarFoto(String URL) throws Exception{
        
        try{
            Path urlFoto = FileSystems.getDefault().getPath(URL);
            Files.delete(urlFoto);
        }catch(IOException ex){
            throw new Exception("Error eliminarFoto()", ex);
        }
    }
}
