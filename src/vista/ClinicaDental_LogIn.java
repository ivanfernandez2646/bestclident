/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import logica.ConexionBD;
import logica.MetodosUtiles;

/**
 *
 * @author IVÁN-PC
 */
public class ClinicaDental_LogIn extends javax.swing.JFrame implements MetodosUtiles {

    public ClinicaDental_LogIn() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labCabecera = new javax.swing.JLabel();
        labNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        labContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        butIniciarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BestCliDent");
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setName("BestCliDent - LogIn"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labCabecera.setBackground(new java.awt.Color(102, 255, 204));
        labCabecera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDental.png"))); // NOI18N
        labCabecera.setOpaque(true);

        labNombreUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labNombreUsuario.setText("Nombre:");

        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clickEnterActionPerformed(evt);
            }
        });

        labContrasena.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labContrasena.setText("Contraseña:");

        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clickEnterActionPerformed(evt);
            }
        });

        butIniciarSesion.setBackground(new java.awt.Color(102, 255, 204));
        butIniciarSesion.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        butIniciarSesion.setText("Log In");
        butIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butIniciarSesionActionPerformed(evt);
            }
        });
        butIniciarSesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clickEnterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labCabecera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(butIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreUsuario)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labCabecera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(labNombreUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(butIniciarSesion)
                .addGap(124, 124, 124))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String comprobarCamposObligatorios() {

        String datosObligatorios = "";

        if (txtNombreUsuario.getText().equals("")) {
            datosObligatorios = "Nombre Usuario\n";
            txtNombreUsuario.setBackground(Color.red);
        } else {
            txtNombreUsuario.setBackground(Color.white);
        }

        if (new String(txtContrasena.getPassword()).equals("")) {
            datosObligatorios += "Contraseña\n";
            txtContrasena.setBackground(Color.red);
        } else {
            txtContrasena.setBackground(Color.white);
        }

        return datosObligatorios;
    }

    private void butIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butIniciarSesionActionPerformed

        String datosObligatorios = comprobarCamposObligatorios();

        if (datosObligatorios.equals("")) {
            ConexionBD.setUSER(txtNombreUsuario.getText());
            ConexionBD.setPASS(new String(txtContrasena.getPassword()));            
            abrirConexion();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Error. Faltan campos obligatorios!!\n" + datosObligatorios,
                    getName(),
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_butIniciarSesionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salirSinCerrarConexion(this);
    }//GEN-LAST:event_formWindowClosing

    private void clickEnterActionPerformed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clickEnterActionPerformed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            butIniciarSesion.doClick();
        }
    }//GEN-LAST:event_clickEnterActionPerformed

    private void abrirConexion() {
        try {
            System.out.println("Abriendo conexión...");
            ConexionBD.abrirConexion();
            System.out.println("Conexión abierta correctamente");

            setVisible(false);
            dispose();

            ClinicaDental_GUI cliDental_GUI = new ClinicaDental_GUI();
            cliDental_GUI.setVisible(false);
            cliDental_GUI.setSize(800, 600);
            cliDental_GUI.mostrar();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    getName(),
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClinicaDental_LogIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClinicaDental_LogIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClinicaDental_LogIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClinicaDental_LogIn.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClinicaDental_LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butIniciarSesion;
    private javax.swing.JLabel labCabecera;
    private javax.swing.JLabel labContrasena;
    private javax.swing.JLabel labNombreUsuario;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
