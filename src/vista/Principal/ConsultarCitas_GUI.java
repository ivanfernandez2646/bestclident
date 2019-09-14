/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.io.IOException;
import javax.swing.JOptionPane;
import logica.CallBack;
import logica.EnviarGMail;

/**
 *
 * @author IVÁN-PC
 */
public class ConsultarCitas_GUI extends javax.swing.JPanel {

    private CallBack imc;

    public ConsultarCitas_GUI(CallBack imc) {
        initComponents();
        this.imc = imc;
    }

    public void mostrar() {
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labCabecera = new javax.swing.JLabel();
        labDestinatario = new javax.swing.JLabel();
        txtDestinatario = new javax.swing.JTextField();
        labAsunto = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        labMensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        butSalir = new javax.swing.JButton();
        butEnviar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setMaximumSize(new java.awt.Dimension(785, 530));
        setMinimumSize(new java.awt.Dimension(785, 530));
        setName("Notas Rápidas"); // NOI18N
        setPreferredSize(new java.awt.Dimension(785, 530));

        labCabecera.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labCabecera.setForeground(new java.awt.Color(0, 0, 0));
        labCabecera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCabecera.setText("CONSULTAR CITAS");
        labCabecera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labDestinatario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labDestinatario.setText("Destinatario:");

        labAsunto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labAsunto.setText("Asunto:");

        labMensaje.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labMensaje.setText("Mensaje:");

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        jScrollPane1.setViewportView(txtMensaje);

        butSalir.setText("SALIR");
        butSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSalirActionPerformed(evt);
            }
        });

        butEnviar.setText("ENVIAR");
        butEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 131, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(butSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(butEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(labDestinatario)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labMensaje)
                                            .addComponent(labAsunto))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(264, 264, 264)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labDestinatario)
                    .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labAsunto)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labMensaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butEnviar)
                    .addComponent(butSalir))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSalirActionPerformed

        this.setVisible(false);
        this.getRootPane().getContentPane().remove(this);
        imc.panelDeLlamada();
    }//GEN-LAST:event_butSalirActionPerformed

    private void butEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEnviarActionPerformed
        
        try{
        
        EnviarGMail.enviarConGMail(txtDestinatario.getText(), txtAsunto.getText(), txtMensaje.getText());
        
        JOptionPane.showMessageDialog(this, 
                    "Mensaje enviado correctamente",
                    getName(),
                    JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, 
                    "Error al enviar el mensaje!!",
                    getName(),
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_butEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butEnviar;
    private javax.swing.JButton butSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labAsunto;
    private javax.swing.JLabel labCabecera;
    private javax.swing.JLabel labDestinatario;
    private javax.swing.JLabel labMensaje;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtDestinatario;
    private javax.swing.JTextArea txtMensaje;
    // End of variables declaration//GEN-END:variables
}
