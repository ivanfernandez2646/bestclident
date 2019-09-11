/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Doctores;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.LogicaComun;
import logica.LogicaDoctor;
import logica.MetodosUtiles;
import modelo.Doctor;

/**
 *
 * @author IVÁN-PC
 */
public class Doctores_GUI extends javax.swing.JPanel implements MetodosUtiles {

    private DefaultTableModel tabModel;
    private List<Doctor> tDoctores;

    //Esta variable sirve para cuando cargamos un usuario de la tabla poder almacenar la ruta de su imagen
    //en caso de que la cambiemos él programa la tendrá almacenada para poder borrarla al Editarlo.
    private String URLImagenAntigua;

    public Doctores_GUI() {
        initComponents();
        tabModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabModel.setColumnIdentifiers(new Object[]{"DNI", "Nombre", "Apellidos", "Edad", "Sueldo"});
        tabDoctores.setModel(tabModel);
        URLImagenAntigua = null;
    }

    public void mostrar() {
        setVisible(true);
        mostrarListadoDoctores();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDoctores = new javax.swing.JTable();
        panelDatosPersonales = new javax.swing.JPanel();
        labDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        labNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        labEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        labSueldo = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        panelImagen = new javax.swing.JPanel();
        labFoto = new javax.swing.JLabel();
        labPath = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        butExaminar = new javax.swing.JButton();
        panelBotonesFuncionales = new javax.swing.JPanel();
        butAgregar = new javax.swing.JButton();
        butEliminar = new javax.swing.JButton();
        butLimpiar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(785, 530));
        setMinimumSize(new java.awt.Dimension(785, 530));
        setName("Doctores"); // NOI18N
        setPreferredSize(new java.awt.Dimension(785, 530));

        labCabecera.setBackground(new java.awt.Color(255, 255, 102));
        labCabecera.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labCabecera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCabecera.setText("DOCTORES");
        labCabecera.setOpaque(true);

        tabDoctores.setModel(new javax.swing.table.DefaultTableModel(
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
        tabDoctores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabDoctores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabDoctores.getTableHeader().setResizingAllowed(false);
        tabDoctores.getTableHeader().setReorderingAllowed(false);
        tabDoctores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabDoctoresMousePressed(evt);
            }
        });
        tabDoctores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabDoctoresKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabDoctores);

        panelDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));
        panelDatosPersonales.setToolTipText("");
        panelDatosPersonales.setName("Pepe"); // NOI18N

        labDni.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labDni.setText("DNI:");

        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniFocusLost(evt);
            }
        });

        labNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labNombre.setText("Nombre:");

        labApellidos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labApellidos.setText("Apellidos:");

        labEdad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labEdad.setText("Edad:");

        labSueldo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labSueldo.setText("Sueldo:");

        javax.swing.GroupLayout panelDatosPersonalesLayout = new javax.swing.GroupLayout(panelDatosPersonales);
        panelDatosPersonales.setLayout(panelDatosPersonalesLayout);
        panelDatosPersonalesLayout.setHorizontalGroup(
            panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                        .addComponent(labDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                        .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                                .addComponent(labNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                                .addComponent(labApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                                .addComponent(labEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                                .addComponent(labSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDatosPersonalesLayout.setVerticalGroup(
            panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labApellidos)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labEdad)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSueldo)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Imagen"));
        panelImagen.setMaximumSize(new java.awt.Dimension(363, 168));
        panelImagen.setMinimumSize(new java.awt.Dimension(363, 168));

        labFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labFoto.setMaximumSize(new java.awt.Dimension(100, 100));
        labFoto.setMinimumSize(new java.awt.Dimension(100, 100));
        labFoto.setPreferredSize(new java.awt.Dimension(100, 100));

        labPath.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labPath.setText("Path:");

        txtPath.setEditable(false);
        txtPath.setBackground(new java.awt.Color(153, 153, 153));

        butExaminar.setText("jButton5");
        butExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butExaminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImagenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labPath)
                        .addGap(18, 18, 18)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelImagenLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(labFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(labFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labPath)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(butExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelBotonesFuncionales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 204, 204))); // NOI18N

        butAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsButtons/butAgregar.png"))); // NOI18N
        butAgregar.setText("Agregar");
        butAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFuncionalesActionPerformed(evt);
            }
        });

        butEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsButtons/butEliminar.png"))); // NOI18N
        butEliminar.setText("Eliminar");
        butEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFuncionalesActionPerformed(evt);
            }
        });

        butLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconsButtons/butLimpiar.png"))); // NOI18N
        butLimpiar.setText("Limpiar");
        butLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFuncionalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesFuncionalesLayout = new javax.swing.GroupLayout(panelBotonesFuncionales);
        panelBotonesFuncionales.setLayout(panelBotonesFuncionalesLayout);
        panelBotonesFuncionalesLayout.setHorizontalGroup(
            panelBotonesFuncionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesFuncionalesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(butAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesFuncionalesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        panelBotonesFuncionalesLayout.setVerticalGroup(
            panelBotonesFuncionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesFuncionalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesFuncionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butLimpiar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(panelDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBotonesFuncionales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBotonesFuncionales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDatosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Carga todos los Doctores en la JTable
    private void mostrarListadoDoctores() {
        try {
            limpiarTabla();
            tabDoctores.setModel(tabModel);
            tDoctores = new ArrayList<>();
            LogicaDoctor.listadoDoctor(tDoctores);

            for (Doctor d : tDoctores) {
                tabModel.addRow(new Object[]{
                    d.getDni(),
                    d.getNombre(),
                    d.getApellidos(),
                    d.getEdad(),
                    d.getSueldo()});
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Limpia la tabla
    private void limpiarTabla() {
        int cantidadFilas = tabModel.getRowCount();

        if (cantidadFilas != 0) {
            for (int i = cantidadFilas - 1; i >= 0; i--) {
                tabModel.removeRow(i);
            }
        }
    }

    //Limpia todos los campos
    private void limpiarCampos() {
        txtDni.setText("");
        txtDni.setBackground(Color.white);
        txtNombre.setText("");
        txtNombre.setBackground(Color.white);
        txtApellidos.setText("");
        txtApellidos.setBackground(Color.white);
        txtEdad.setText("");
        txtEdad.setBackground(Color.white);
        txtSueldo.setText("");
        txtSueldo.setBackground(Color.white);
        txtPath.setText("");
        labFoto.setIcon(null);
        labFoto.setText("");
    }

    //¿Faltan datos obligatorios?
    private String faltanDatosObligatorios() {

        String datosObligatorios = "";

        if (txtDni.getText().equals("")) {
            datosObligatorios += "\nDNI";
            txtDni.setBackground(new Color(255, 0, 0, 65));
        } else {
            txtDni.setBackground(Color.white);
        }

        if (txtNombre.getText().equals("")) {
            datosObligatorios += "\nNombre";
            txtNombre.setBackground(new Color(255, 0, 0, 65));
        } else {
            txtNombre.setBackground(Color.white);
        }

        if (txtApellidos.getText().equals("")) {
            datosObligatorios += "\nApellidos";
            txtApellidos.setBackground(new Color(255, 0, 0, 65));
        } else {
            txtApellidos.setBackground(Color.white);
        }

        if (txtEdad.getText().equals("")) {
            datosObligatorios += "\nEdad";
            txtEdad.setBackground(new Color(255, 0, 0, 65));
        } else {
            txtEdad.setBackground(Color.white);
        }

        if (txtSueldo.getText().equals("")) {
            datosObligatorios += "\nSueldo";
            txtSueldo.setBackground(new Color(255, 0, 0, 65));
        } else {
            txtSueldo.setBackground(Color.white);
        }

        return datosObligatorios;
    }

    //Métodos de los botones funcionales Agregar, Eliminar y Limpiar
    private void butFuncionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFuncionalesActionPerformed

        if (evt.getSource() == butAgregar) {
            try {

                String datosObligatorios = faltanDatosObligatorios();

                if (!datosObligatorios.equals("")) {
                    JOptionPane.showMessageDialog(this,
                            "Error. Faltan datos obligatorios!!" + datosObligatorios,
                            getName(),
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    Doctor d = new Doctor();
                    d.setDni(txtDni.getText());
                    d.setNombre(txtNombre.getText());
                    d.setApellidos(txtApellidos.getText());
                    d.setEdad(Integer.parseInt(txtEdad.getText()));
                    d.setSueldo(Double.parseDouble(txtSueldo.getText()));

                    String rutaRelativa = null;

                    if (!txtPath.getText().equals("")) {
                        rutaRelativa = LogicaComun.conseguirRutaRelativa(txtPath.getText(), LogicaComun.DUEÑOFOTO.DOCTOR);
                    }

                    d.setRutaFoto(rutaRelativa);

                    boolean existeDoctor = LogicaDoctor.existeDoctor(d);

                    if (existeDoctor) {

                        int op = JOptionPane.showConfirmDialog(this,
                                "¿¿ATENCIÓN. DNI ya registrado. Quiere sobreescribir los datos??",
                                getName(),
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE);

                        switch (op) {
                            case JOptionPane.YES_OPTION:
                                LogicaDoctor.editarDoctor(d);

                                if (rutaRelativa != null) {
                                    LogicaComun.copiarFoto(txtPath.getText(), rutaRelativa, URLImagenAntigua);

                                    JOptionPane.showMessageDialog(this,
                                            "Edición de doctor correcta!!",
                                            getName(),
                                            JOptionPane.INFORMATION_MESSAGE);

                                }
                                limpiarCampos();
                                break;
                        }
                    } else {
                        URLImagenAntigua = null;
                        LogicaDoctor.altaDoctor(d);

                        if (rutaRelativa != null) {
                            LogicaComun.copiarFoto(txtPath.getText(), rutaRelativa, URLImagenAntigua);
                        }
                        limpiarCampos();

                        JOptionPane.showMessageDialog(this,
                                "Alta de doctor correcta!!",
                                getName(),
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                System.out.println(
                        ex.getMessage());
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        getName(),
                        JOptionPane.WARNING_MESSAGE);
            }
            mostrarListadoDoctores();
        } else if (evt.getSource() == butEliminar) {
            Doctor d = new Doctor();
            d.setDni(txtDni.getText());

            if (tabDoctores.getSelectedRowCount() != 0) {
                try {
                    Doctor newDoctor = LogicaDoctor.getDoctor(d);

                    if (newDoctor != null) {
                        LogicaDoctor.bajaDoctor(d);

                        if (newDoctor.getRutaFoto() != null) {
                            LogicaComun.eliminarFoto(newDoctor.getRutaFoto());
                        }

                        JOptionPane.showMessageDialog(this,
                                "Baja de doctor correcta. DNI: " + d.getDni(),
                                getName(),
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "ERROR. No existe ningún doctor con este DNI: " + d.getDni(),
                                getName(),
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this,
                            ex.getMessage(),
                            getName(),
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "ERROR. No hay ningún doctor seleccionado!!",
                        getName(),
                        JOptionPane.WARNING_MESSAGE);
            }
            limpiarCampos();
            mostrarListadoDoctores();
        } else if (evt.getSource() == butLimpiar) {
            limpiarCampos();
            mostrarListadoDoctores();
        }
    }//GEN-LAST:event_butFuncionalesActionPerformed

    //Carga los datos desde la fila del JTable seleccionada a los JTextField
    private void cargarDoctor(Doctor d) {
        limpiarCampos();
        txtDni.setText(d.getDni());
        txtNombre.setText(d.getNombre());
        txtApellidos.setText(d.getApellidos());
        txtEdad.setText(String.valueOf(d.getEdad()));
        txtSueldo.setText(String.valueOf(d.getSueldo()));

        String rutaFoto = d.getRutaFoto();

        if (rutaFoto != null) {
            URLImagenAntigua = d.getRutaFoto();
            txtPath.setText(rutaFoto);
            txtPath.setCaretPosition(0);
            Image img = new ImageIcon(rutaFoto).getImage();
            ImageIcon img2 = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            labFoto.setIcon(img2);
        } else {
            labFoto.setIcon(null);
            labFoto.setText("No Imagen!!");
        }
    }

    //Diferentes eventos para cargar los doctores dentro del JTable
    private void tabDoctoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDoctoresMousePressed
        int i = tabDoctores.getSelectedRow();
        Doctor d = tDoctores.get(i);
        cargarDoctor(d);
    }//GEN-LAST:event_tabDoctoresMousePressed

    private void tabDoctoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabDoctoresKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            int i = tabDoctores.getSelectedRow();
            Doctor d = tDoctores.get(i);
            cargarDoctor(d);
        }
    }//GEN-LAST:event_tabDoctoresKeyReleased

    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
        Doctor d = new Doctor();
        d.setDni(txtDni.getText());

        try {
            if (LogicaDoctor.existeDoctor(d)) {
                d = LogicaDoctor.getDoctor(d);
                cargarDoctor(d);
            } else {
                String dniTMP = txtDni.getText();
                limpiarCampos();
                txtDni.setText(dniTMP);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_txtDniFocusLost

    //Botón Examinar con su JFileChooser
    private void butExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butExaminarActionPerformed

        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(this);
        File archivo = jf.getSelectedFile();
        if (archivo != null) {
            txtPath.setText(archivo.getPath());
            txtPath.setCaretPosition(0);
            Image img = new ImageIcon(txtPath.getText()).getImage();
            ImageIcon img2 = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            labFoto.setIcon(img2);
        }
    }//GEN-LAST:event_butExaminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAgregar;
    private javax.swing.JButton butEliminar;
    private javax.swing.JButton butExaminar;
    private javax.swing.JButton butLimpiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labApellidos;
    private javax.swing.JLabel labCabecera;
    private javax.swing.JLabel labDni;
    private javax.swing.JLabel labEdad;
    private javax.swing.JLabel labFoto;
    private javax.swing.JLabel labNombre;
    private javax.swing.JLabel labPath;
    private javax.swing.JLabel labSueldo;
    private javax.swing.JPanel panelBotonesFuncionales;
    private javax.swing.JPanel panelDatosPersonales;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JTable tabDoctores;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
