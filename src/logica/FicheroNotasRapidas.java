package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;

public class FicheroNotasRapidas {

    public static void leerFichero(JTextArea txtNotasRapidas) throws IOException {

        File f = new File("notasRapidas.txt");
        String tmp;
        String res = "";

        //Contador para no concatenar un salto de línea en la primera línea leída.
        int cont = 0;

        if (f.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(f));) {
                while ((tmp = br.readLine()) != null) {
                    if (cont == 0) {
                        res += tmp;
                        cont++;
                    } else {
                        res += "\n" + tmp;
                    }
                }
            } catch (IOException ex) {
                System.out.println("Error leerFichero()");
            }
        }
        txtNotasRapidas.setText(res);
    }

    public static void guardarFichero(JTextArea txtNotasRapidas) throws IOException {

        String texto = txtNotasRapidas.getText();
        File f = new File("notasRapidas.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f));) {
            bw.write(texto);
        } catch (IOException ex) {
            System.out.println("Error escribir fichero");
        }
    }
}
