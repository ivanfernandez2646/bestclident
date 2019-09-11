package logica;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author IVÁN-PC
 */
public class HiloReloj extends Thread {

    private JLabel labFechaSistema;

    public HiloReloj(JLabel labFechaSistema) {
        this.labFechaSistema = labFechaSistema;
        this.start();
    }

    @Override
    public void run() {

        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

        while (true) {
            d = new Date();
            labFechaSistema.setText(dateFormat.format(d));
        }
    }
}
