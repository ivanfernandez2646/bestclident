/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.io.IOException;
import javax.swing.JOptionPane;
import logica.CallBack;

/**
 *
 * @author IVÁN-PC
 */
public class NotasRapidas_GUI extends javax.swing.JPanel {

    private CallBack imc;

    public NotasRapidas_GUI(CallBack imc) {
        initComponents();
        this.imc = imc;
    }

    public void mostrar() {
        setVisible(true);
        try {
            logica.FicheroNotasRapidas.leerFichero(txtNotasRapidas);
        } catch (IOException ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labCabecera = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotasRapidas = new javax.swing.JTextArea();
        butSalir = new javax.swing.JButton();
        butGuardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 102, 102));
        setMaximumSize(new java.awt.Dimension(785, 530));
        setMinimumSize(new java.awt.Dimension(785, 530));
        setName("Notas Rápidas"); // NOI18N
        setPreferredSize(new java.awt.Dimension(785, 530));

        labCabecera.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labCabecera.setForeground(new java.awt.Color(0, 0, 0));
        labCabecera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCabecera.setText("NOTAS RÁPIDAS");

        txtNotasRapidas.setColumns(20);
        txtNotasRapidas.setRows(5);
        jScrollPane1.setViewportView(txtNotasRapidas);

        butSalir.setText("SALIR");
        butSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSalirActionPerformed(evt);
            }
        });

        butGuardar.setText("GUARDAR");
        butGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 515, Short.MAX_VALUE)
                        .addComponent(butSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(butGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butGuardar)
                    .addComponent(butSalir))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSalirActionPerformed

        int op = JOptionPane.showConfirmDialog(this,
                "Si sale perderá la información nueva\n¿Está seguro de que desea salir?",
                getName(),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        switch (op) {
            case JOptionPane.YES_OPTION:
                this.setVisible(false);
                this.getRootPane().getContentPane().remove(this);
                imc.panelDeLlamada();
                break;
        }


    }//GEN-LAST:event_butSalirActionPerformed

    private void butGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butGuardarActionPerformed
        try {
            logica.FicheroNotasRapidas.guardarFichero(txtNotasRapidas);
            JOptionPane.showMessageDialog(this,
                    "Cambios guardados correctamente!!",
                    getName(),
                    JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            this.getRootPane().getContentPane().remove(this);
            imc.panelDeLlamada();
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_butGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butGuardar;
    private javax.swing.JButton butSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labCabecera;
    private javax.swing.JTextArea txtNotasRapidas;
    // End of variables declaration//GEN-END:variables
}
