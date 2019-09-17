/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import logica.CallBack;
import logica.EnviarGMail;
import modelo.Cliente;
import modelo.Doctor;
import vista.Clientes.ElegirCliente_GUI;
import vista.Doctores.ElegirDoctor_GUI;
import vista.ElegirFechaPanel_Citas;
import vista.ElegirFechaPanel_ConsultarCitas;

/**
 *
 * @author IVÁN-PC
 */
public class ConsultarCitas_GUI extends javax.swing.JPanel implements CallBack {

    private CallBack imc;

    private ElegirFechaPanel_ConsultarCitas calendario;

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

        jSlider1 = new javax.swing.JSlider();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        labCabecera = new javax.swing.JLabel();
        butSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabConsultarCitas = new javax.swing.JTable();
        panelFitlros = new javax.swing.JPanel();
        labDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        butBuscarDni = new javax.swing.JButton();
        labFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        butFecha = new javax.swing.JButton();
        butBuscar = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setBackground(new java.awt.Color(204, 255, 204));
        setMaximumSize(new java.awt.Dimension(785, 530));
        setMinimumSize(new java.awt.Dimension(785, 530));
        setName("Notas Rápidas"); // NOI18N
        setPreferredSize(new java.awt.Dimension(785, 530));

        labCabecera.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        labCabecera.setForeground(new java.awt.Color(0, 0, 0));
        labCabecera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCabecera.setText("CONSULTAR CITAS");
        labCabecera.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        butSalir.setText("SALIR");
        butSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSalirActionPerformed(evt);
            }
        });

        tabConsultarCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabConsultarCitas);

        panelFitlros.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));
        panelFitlros.setOpaque(false);

        labDni.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labDni.setText("DNI:");

        butBuscarDni.setText("jButton1");
        butBuscarDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBuscarDniActionPerformed(evt);
            }
        });

        labFecha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labFecha.setText("Fecha:");

        butFecha.setText("jButton1");
        butFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFechaActionPerformed(evt);
            }
        });

        butBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsButtons/butBuscar.png"))); // NOI18N

        javax.swing.GroupLayout panelFitlrosLayout = new javax.swing.GroupLayout(panelFitlros);
        panelFitlros.setLayout(panelFitlrosLayout);
        panelFitlrosLayout.setHorizontalGroup(
            panelFitlrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFitlrosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelFitlrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(labDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelFitlrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(txtDni))
                .addGap(18, 18, 18)
                .addGroup(panelFitlrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFitlrosLayout.createSequentialGroup()
                        .addComponent(butBuscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelFitlrosLayout.createSequentialGroup()
                        .addComponent(butFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(butBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelFitlrosLayout.setVerticalGroup(
            panelFitlrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFitlrosLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(panelFitlrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butBuscarDni))
                .addGroup(panelFitlrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFitlrosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelFitlrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labFecha)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butFecha)))
                    .addGroup(panelFitlrosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(butBuscar)))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(butSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                    .addComponent(labCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(panelFitlros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelFitlros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butSalir)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSalirActionPerformed

        this.setVisible(false);
        this.getRootPane().getContentPane().remove(this);
        imc.panelDeLlamada();
    }//GEN-LAST:event_butSalirActionPerformed

    private void butBuscarDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBuscarDniActionPerformed

        ElegirCliente_GUI panelElegirCliente = new ElegirCliente_GUI((JFrame) SwingUtilities.getWindowAncestor(this), true, this);
        panelElegirCliente.setVisible(false);
        panelElegirCliente.setSize(600, 410);
        panelElegirCliente.cambiarColorBackground();
        panelElegirCliente.mostrar();
    }//GEN-LAST:event_butBuscarDniActionPerformed

    private void butFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFechaActionPerformed
        
        calendario = new ElegirFechaPanel_ConsultarCitas((JFrame) SwingUtilities.getWindowAncestor(this), true);
        calendario.mostrar(this);
    }//GEN-LAST:event_butFechaActionPerformed

    //Devuelve el dni del cliente o la fecha, dependiendo del objeto que traiga
    @Override
    public void panelDeLlamada(Object o) {

        if (o instanceof Cliente) {
            txtDni.setText(((Cliente) o).getDni());
        }else if(o instanceof String){
            txtFecha.setText((String)o);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butBuscar;
    private javax.swing.JButton butBuscarDni;
    private javax.swing.JButton butFecha;
    private javax.swing.JButton butSalir;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel labCabecera;
    private javax.swing.JLabel labDni;
    private javax.swing.JLabel labFecha;
    private javax.swing.JPanel panelFitlros;
    private javax.swing.JTable tabConsultarCitas;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
