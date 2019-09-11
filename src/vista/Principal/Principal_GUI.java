/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Principal;

import javax.swing.ImageIcon;
import logica.CallBack;
import logica.MetodosUtiles;
import vista.ClinicaDental_GUI;
import vista.ClinicaDental_LogIn;

/**
 *
 * @author IVÁN-PC
 */
public class Principal_GUI extends javax.swing.JPanel implements CallBack, MetodosUtiles{

    /**
     * Creates new form Principal_GUI
     */
    private ClinicaDental_GUI jFramePrincipal;
    
    
    public Principal_GUI() {
        initComponents();
        rellenarMenuPrinicipal();
    }
    
    public void mostrar(ClinicaDental_GUI jFramePrincipal){
        setVisible(true);
        this.jFramePrincipal = jFramePrincipal;
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
        labNotasRapidas = new javax.swing.JLabel();
        butNotasRapidas = new javax.swing.JButton();
        labConsultarCitas = new javax.swing.JLabel();
        butConsultarCitas = new javax.swing.JButton();
        labb = new javax.swing.JLabel();
        butt = new javax.swing.JButton();
        labCerrarSesion = new javax.swing.JLabel();
        butCerrarSesion = new javax.swing.JButton();
        labSalir = new javax.swing.JLabel();
        butSalir = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(785, 530));
        setMinimumSize(new java.awt.Dimension(785, 530));

        labCabecera.setBackground(new java.awt.Color(255, 153, 51));
        labCabecera.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labCabecera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCabecera.setText("PRINCIPAL");
        labCabecera.setOpaque(true);

        labNotasRapidas.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        labNotasRapidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNotasRapidas.setText("fg");

        butNotasRapidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFuncionalesActionPerformed(evt);
            }
        });

        labConsultarCitas.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        labConsultarCitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labConsultarCitas.setText("fg");

        butConsultarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFuncionalesActionPerformed(evt);
            }
        });

        labb.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        labb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labb.setText("gf");

        butt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFuncionalesActionPerformed(evt);
            }
        });

        labCerrarSesion.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        labCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCerrarSesion.setText("fg");

        butCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFuncionalesActionPerformed(evt);
            }
        });

        labSalir.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        labSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labSalir.setText("fg");

        butSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFuncionalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(butNotasRapidas, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(butConsultarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labNotasRapidas, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labConsultarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labb, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butNotasRapidas, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butConsultarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labb)
                    .addComponent(labConsultarCitas)
                    .addComponent(labNotasRapidas))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labCerrarSesion)
                    .addComponent(labSalir))
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rellenarMenuPrinicipal() {
        labNotasRapidas.setText("NOTAS RÁPIDAS");
        butNotasRapidas.setIcon(new ImageIcon(getClass().getResource("/img/iconsButtons/notasRapidas.png")));
        labConsultarCitas.setText("CONSULTAR CITAS");
        butConsultarCitas.setIcon(new ImageIcon(getClass().getResource("/img/iconsButtons/consultarCitas.png")));
        //labb.setText("SALIR");
        //butt.setIcon(new ImageIcon(getClass().getResource("/img/iconsButtons/salir.png")));
        labCerrarSesion.setText("CERRAR SESIÓN");
        butCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/img/iconsButtons/cerrarSesion.png")));
        labSalir.setText("SALIR");
        butSalir.setIcon(new ImageIcon(getClass().getResource("/img/iconsButtons/salir.png")));
    }
    
    private void ocultarFuncionalidades(){
        labCabecera.setVisible(false);
        labNotasRapidas.setVisible(false);
        butNotasRapidas.setVisible(false);
        labConsultarCitas.setVisible(false);
        butConsultarCitas.setVisible(false);
        labb.setVisible(false);
        butt.setVisible(false);
        labCerrarSesion.setVisible(false);
        butCerrarSesion.setVisible(false);
        labSalir.setVisible(false);
        butSalir.setVisible(false);
    }
    
    private void mostrarFuncionalidades(){
        labCabecera.setVisible(true);
        labNotasRapidas.setVisible(true);
        butNotasRapidas.setVisible(true);
        labConsultarCitas.setVisible(true);
        butConsultarCitas.setVisible(true);
        labb.setVisible(true);
        butt.setVisible(true);
        labCerrarSesion.setVisible(true);
        butCerrarSesion.setVisible(true);
        labSalir.setVisible(true);
        butSalir.setVisible(true);
    }
    
    
    private void butFuncionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFuncionalesActionPerformed

        if (evt.getSource() == butNotasRapidas) {
            ocultarFuncionalidades();
            jFramePrincipal.getMenuBarClinica().setVisible(false);
            NotasRapidas_GUI panelNotasRapidas = new NotasRapidas_GUI(this);
            panelNotasRapidas.setSize(785, 530);
            panelNotasRapidas.setVisible(false);
            this.add(panelNotasRapidas);
            panelNotasRapidas.mostrar();
        } else if(evt.getSource() == butConsultarCitas){
            
        } else if(evt.getSource() == butt){
            
        }else if (evt.getSource() == butCerrarSesion) {
            try {
                if (salirYCerrarConexion(jFramePrincipal)) {
                    ClinicaDental_GUI.getHiloReloj().stop();
                    ClinicaDental_LogIn cliLogin = new ClinicaDental_LogIn();
                    cliLogin.setVisible(false);
                    cliLogin.setSize(500, 500);
                    cliLogin.setVisible(true);
                }
            } catch (Exception ex) {
            }
        } else if (evt.getSource() == butSalir) {
            try {
                if(salirYCerrarConexion(jFramePrincipal)){
                    ClinicaDental_GUI.getHiloReloj().stop();
                }
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_butFuncionalesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCerrarSesion;
    private javax.swing.JButton butConsultarCitas;
    private javax.swing.JButton butNotasRapidas;
    private javax.swing.JButton butSalir;
    private javax.swing.JButton butt;
    private javax.swing.JLabel labCabecera;
    private javax.swing.JLabel labCerrarSesion;
    private javax.swing.JLabel labConsultarCitas;
    private javax.swing.JLabel labNotasRapidas;
    private javax.swing.JLabel labSalir;
    private javax.swing.JLabel labb;
    // End of variables declaration//GEN-END:variables

    @Override
    public void panelDeLlamada() {
        setVisible(true);
        jFramePrincipal.getMenuBarClinica().setVisible(true);
        mostrarFuncionalidades();
    }
}
