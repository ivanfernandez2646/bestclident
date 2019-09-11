/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author IVÁN-PC
 */
public class EnviarGMail {

    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        try {
            String host = "smtp.gmail.com";
            String from = "bestclident@gmail.com";
            String pass = "bestclident1234";
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");

            Session session = Session.getDefaultInstance(props, new GMailAuthenticator(from, pass));
            MimeMessage message = new MimeMessage(session);
            Address fromAddress = new InternetAddress(from);
            Address toAddress = new InternetAddress(destinatario);

            message.setFrom(fromAddress);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            message.saveChanges();
            Transport.send(message);
            transport.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String asuntoBienvenida() {
        return "BestClident Bienvenida";
    }

    public static String mensajeBienvenida(String dni, String nombre) {
        return "Bienvenid@ " + nombre + " (" + dni + ") te damos la bienvenida a BestCliDent.\n"
                + "Esperamos brindarle el mejor servicio posible.\n\n"
                + "Este mensaje ha sido generado aleatoriarmente. No responder a él."
                + "Cualquier duda puede contactarnos en bestclident@gmail.com";
    }
    
    static class GMailAuthenticator extends Authenticator {

        String user;
        String pw;

        public GMailAuthenticator(String username, String password) {
            super();
            this.user = username;
            this.pw = password;
        }

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, pw);
        }
    }
}
