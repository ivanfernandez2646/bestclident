/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Citas;

import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import logica.CallBack;
import logica.LogicaCita;
import logica.LogicaServicio;
import logica.MetodosUtiles;
import modelo.Cita;
import modelo.Cliente;
import modelo.Servicio;
import vista.Clientes.ElegirCliente_GUI;

/**
 *
 * @author IVÁN-PC
 */
public class Citas_GUI extends javax.swing.JPanel implements MetodosUtiles, CallBack {

    private enum MESES {
        Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre
    };

    //fdgn
    private DefaultComboBoxModel<String> comboModel;
    private DefaultTableModel tabModel;

    //Para ayudarme a saber que RadioButton está seleccionado de las horas
    private int horaSeleccionada;
    private int minutosSeleccionados;

    //ATRIBUTOS DE CLASE PARA AYUDARME AL MANEJO DEL CALENDARIO
    private int anoSeleccionado;
    private int mesSeleccionado;
    private String diaSeleccionado;

    //Atributos de otras clases para ayudarme al manejo de los servicios y clientes
    private Cliente cliente;
    private Servicio servicio;

    public Citas_GUI() {
        initComponents();
        establecerHoras();
        comboModel = new DefaultComboBoxModel();
        tabModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        tabModel.setColumnIdentifiers(new Object[]{"L", "M", "X", "J",
            "V", "S", "D"});
        tabSeleccionarFecha.setModel(tabModel);
        labAno.setText(String.valueOf(LocalDate.now().getYear()));
        labMes.setText(MESES.values()[LocalDate.now().getMonthValue() - 1].toString());
        anoSeleccionado = Integer.parseInt(labAno.getText());
        mesSeleccionado = LocalDate.now().getMonthValue() - 1;
        diaSeleccionado = null;
        horaSeleccionada = -1;
        minutosSeleccionados = -1;
        RenderizadorTablaCita cambiarColorCeldas = new RenderizadorTablaCita();
        tabSeleccionarFecha.setDefaultRenderer(Object.class, cambiarColorCeldas);
        rellenarCalendario();

    }

    public void mostrar() {
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupHoras = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labCabecera = new javax.swing.JLabel();
        panelSeleccionarClienteYServicio = new javax.swing.JPanel();
        labSeleccionarCliente = new javax.swing.JLabel();
        txtSeleccionarCliente = new javax.swing.JTextField();
        butSeleccionarCliente = new javax.swing.JButton();
        labSeleccionarServicio = new javax.swing.JLabel();
        cmbBoxSeleccionarServicio = new javax.swing.JComboBox<>();
        panelFecha = new javax.swing.JPanel();
        butMesAnterior = new javax.swing.JButton();
        labMes = new javax.swing.JLabel();
        butMesPosterior = new javax.swing.JButton();
        butAnoAnterior = new javax.swing.JButton();
        labAno = new javax.swing.JLabel();
        butAnoPosterior = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabSeleccionarFecha = new javax.swing.JTable();
        labDiaDisponible = new javax.swing.JLabel();
        panelHora = new javax.swing.JPanel();
        checkBoxMañanaTarde = new javax.swing.JCheckBox();
        rBut1 = new javax.swing.JRadioButton();
        rBut2 = new javax.swing.JRadioButton();
        rBut3 = new javax.swing.JRadioButton();
        rBut4 = new javax.swing.JRadioButton();
        butConfirmar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setMaximumSize(new java.awt.Dimension(785, 530));
        setMinimumSize(new java.awt.Dimension(785, 530));
        setName("Citas"); // NOI18N
        setPreferredSize(new java.awt.Dimension(785, 530));

        labCabecera.setBackground(new java.awt.Color(0, 153, 153));
        labCabecera.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labCabecera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCabecera.setText("CITAS");
        labCabecera.setOpaque(true);

        panelSeleccionarClienteYServicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione Cliente y Servicio"));

        labSeleccionarCliente.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labSeleccionarCliente.setText("DNI Cliente:");

        txtSeleccionarCliente.setEditable(false);
        txtSeleccionarCliente.setBackground(new java.awt.Color(255, 255, 153));

        butSeleccionarCliente.setText("jButton1");
        butSeleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSeleccionarClienteActionPerformed(evt);
            }
        });

        labSeleccionarServicio.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labSeleccionarServicio.setText("Servicio:");

        cmbBoxSeleccionarServicio.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cmbBoxSeleccionarServicioPopupMenuWillBecomeVisible(evt);
            }
        });

        javax.swing.GroupLayout panelSeleccionarClienteYServicioLayout = new javax.swing.GroupLayout(panelSeleccionarClienteYServicio);
        panelSeleccionarClienteYServicio.setLayout(panelSeleccionarClienteYServicioLayout);
        panelSeleccionarClienteYServicioLayout.setHorizontalGroup(
            panelSeleccionarClienteYServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeleccionarClienteYServicioLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelSeleccionarClienteYServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labSeleccionarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSeleccionarClienteYServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeleccionarClienteYServicioLayout.createSequentialGroup()
                        .addComponent(txtSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(butSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbBoxSeleccionarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        panelSeleccionarClienteYServicioLayout.setVerticalGroup(
            panelSeleccionarClienteYServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeleccionarClienteYServicioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelSeleccionarClienteYServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSeleccionarCliente)
                    .addComponent(txtSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butSeleccionarCliente))
                .addGap(18, 18, 18)
                .addGroup(panelSeleccionarClienteYServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSeleccionarServicio)
                    .addComponent(cmbBoxSeleccionarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        panelFecha.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));

        butMesAnterior.setText("<");
        butMesAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCambiarMesActionPerformed(evt);
            }
        });

        labMes.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labMes.setText("Mes");

        butMesPosterior.setText(">");
        butMesPosterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCambiarMesActionPerformed(evt);
            }
        });

        butAnoAnterior.setText("<");
        butAnoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCambiarAnoActionPerformed(evt);
            }
        });

        labAno.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labAno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labAno.setText("Año");

        butAnoPosterior.setText(">");
        butAnoPosterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCambiarAnoActionPerformed(evt);
            }
        });

        tabSeleccionarFecha.setModel(new javax.swing.table.DefaultTableModel(
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
        tabSeleccionarFecha.setCellSelectionEnabled(true);
        tabSeleccionarFecha.setSelectionForeground(new java.awt.Color(75, 110, 175));
        tabSeleccionarFecha.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabSeleccionarFecha.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabSeleccionarFecha.getTableHeader().setResizingAllowed(false);
        tabSeleccionarFecha.getTableHeader().setReorderingAllowed(false);
        tabSeleccionarFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabSeleccionarFechaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabSeleccionarFecha);

        labDiaDisponible.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelFechaLayout = new javax.swing.GroupLayout(panelFecha);
        panelFecha.setLayout(panelFechaLayout);
        panelFechaLayout.setHorizontalGroup(
            panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(panelFechaLayout.createSequentialGroup()
                            .addComponent(butMesAnterior)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labMes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(butMesPosterior)
                            .addGap(33, 33, 33)
                            .addComponent(butAnoAnterior)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labAno, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(butAnoPosterior)))
                    .addComponent(labDiaDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFechaLayout.setVerticalGroup(
            panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labAno)
                    .addComponent(butMesPosterior)
                    .addComponent(butMesAnterior)
                    .addComponent(labMes)
                    .addComponent(butAnoPosterior)
                    .addComponent(butAnoAnterior))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labDiaDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelHora.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora"));

        checkBoxMañanaTarde.setSelected(true);
        checkBoxMañanaTarde.setText("¿Horario Mañana?");
        checkBoxMañanaTarde.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkBoxMañanaTardeItemStateChanged(evt);
            }
        });

        buttonGroupHoras.add(rBut1);
        rBut1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        rBut1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        rBut1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                buttGroupHorasStateChanged(evt);
            }
        });

        buttonGroupHoras.add(rBut2);
        rBut2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        rBut2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                buttGroupHorasStateChanged(evt);
            }
        });

        buttonGroupHoras.add(rBut3);
        rBut3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        rBut3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                buttGroupHorasStateChanged(evt);
            }
        });

        buttonGroupHoras.add(rBut4);
        rBut4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        rBut4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                buttGroupHorasStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelHoraLayout = new javax.swing.GroupLayout(panelHora);
        panelHora.setLayout(panelHoraLayout);
        panelHoraLayout.setHorizontalGroup(
            panelHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBut1)
                    .addComponent(rBut2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rBut4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rBut3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelHoraLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(checkBoxMañanaTarde)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelHoraLayout.setVerticalGroup(
            panelHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoraLayout.createSequentialGroup()
                .addComponent(checkBoxMañanaTarde)
                .addGap(18, 18, 18)
                .addGroup(panelHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBut3)
                    .addComponent(rBut1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBut2)
                    .addComponent(rBut4))
                .addGap(26, 26, 26))
        );

        butConfirmar.setBackground(new java.awt.Color(0, 102, 102));
        butConfirmar.setText("CONFIRMAR");
        butConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelSeleccionarClienteYServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butConfirmar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(107, 107, 107))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSeleccionarClienteYServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(butConfirmar))
                    .addComponent(panelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Limpia la tabla
    private void limpiarTabla() {
        int cantidadFilas = tabModel.getRowCount();

        if (cantidadFilas != 0) {
            for (int i = cantidadFilas - 1; i >= 0; i--) {
                tabModel.removeRow(i);
            }
        }
    }

    private void limpiarCampos() {
        txtSeleccionarCliente.setText("");
        cmbBoxSeleccionarServicio.setSelectedIndex(-1);
        tabSeleccionarFecha.clearSelection();
        labDiaDisponible.setText("");
        diaSeleccionado = null;
        cambiarColorHoras();
    }

    //Permite recuperar todos los Servicios de la BBDD para mostrarlos en el
    //Combo-Box y seleccionar uno.
    private void cmbBoxSeleccionarServicioPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbBoxSeleccionarServicioPopupMenuWillBecomeVisible

        try {
            comboModel.removeAllElements();
            List<Servicio> tServicios = new ArrayList<>();
            LogicaServicio.listadoServicio(tServicios);

            for (int i = 0; i < tServicios.size(); i++) {
                servicio = tServicios.get(i);
                String txt = servicio.getId() + ". " + servicio.getNombre();
                comboModel.addElement(txt);
            }

            cmbBoxSeleccionarServicio.setModel(comboModel);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_cmbBoxSeleccionarServicioPopupMenuWillBecomeVisible

    //Permite recuperar un Cliente y recuperar su DNI
    private void butSeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSeleccionarClienteActionPerformed

        ElegirCliente_GUI panelElegirCliente = new ElegirCliente_GUI((JFrame) SwingUtilities.getWindowAncestor(this), true, this);
        panelElegirCliente.setVisible(false);
        panelElegirCliente.setSize(600, 410);
        panelElegirCliente.mostrar();
    }//GEN-LAST:event_butSeleccionarClienteActionPerformed

    //Para cambiar entre horario de mañana y tarde con las horas
    private void checkBoxMañanaTardeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxMañanaTardeItemStateChanged
        establecerHoras();

        if (diaSeleccionado != null) {
            cambiarColorHoras();
        }
    }//GEN-LAST:event_checkBoxMañanaTardeItemStateChanged

    //Concatena la fecha para enviar al siguiente panel para imprimir
    private String concatenarFecha() {
        return String.format("%s/%d/%d -- %d:%02d", diaSeleccionado, mesSeleccionado, anoSeleccionado, horaSeleccionada, minutosSeleccionados);
    }

    //Cambiamos el año desplazando con los botones
    private void butCambiarAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCambiarAnoActionPerformed

        anoSeleccionado = Integer.parseInt(labAno.getText());

        if (evt.getSource() == butAnoAnterior) {
            anoSeleccionado = anoSeleccionado - 1;
        } else if (evt.getSource() == butAnoPosterior) {
            anoSeleccionado = anoSeleccionado + 1;
        }
        labAno.setText(String.valueOf(anoSeleccionado));
        rellenarCalendario();
    }//GEN-LAST:event_butCambiarAnoActionPerformed

    //Cambiamos el mes desplazando con los botones
    private void butCambiarMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCambiarMesActionPerformed

        mesSeleccionado = MESES.valueOf(labMes.getText()).ordinal();

        if (evt.getSource() == butMesAnterior && mesSeleccionado > 0) {
            mesSeleccionado = mesSeleccionado - 1;
        } else if (evt.getSource() == butMesPosterior && mesSeleccionado < MESES.values().length - 1) {
            mesSeleccionado = mesSeleccionado + 1;
        } else {

            if (evt.getSource() == butMesAnterior && mesSeleccionado == 0) {
                mesSeleccionado = MESES.values()[MESES.values().length - 1].ordinal();
            } else if (evt.getSource() == butMesPosterior && mesSeleccionado == MESES.values().length - 1) {
                mesSeleccionado = 0;
            }
        }
        labMes.setText(MESES.values()[mesSeleccionado].toString());
        rellenarCalendario();
    }//GEN-LAST:event_butCambiarMesActionPerformed

    //Nos dice si el día está disponible o no
    private void tabSeleccionarFechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabSeleccionarFechaMousePressed

        //Sacamaos el día que hay seleccionado
        diaSeleccionado = tabSeleccionarFecha.getValueAt(tabSeleccionarFecha.getSelectedRow(), tabSeleccionarFecha.getSelectedColumn()) == null ? null
                : String.valueOf(tabSeleccionarFecha.getValueAt(tabSeleccionarFecha.getSelectedRow(), tabSeleccionarFecha.getSelectedColumn()));

        //Comprobamos si es válido, es decir si está en la columna de los fines de Semana o si es un día nulo perteneciente a otro mes
        //De esta manera conseguimos saber si el día es válido o no.
        if (tabSeleccionarFecha.getSelectedColumn() != 5 && tabSeleccionarFecha.getSelectedColumn() != 6 && diaSeleccionado != null) {
            labDiaDisponible.setText("Día Seleccionado: " + String.valueOf(diaSeleccionado));
            cambiarColorHoras();
        } else {
            labDiaDisponible.setText("Día No Disponible!!");
            diaSeleccionado = null;
            cambiarColorHoras();
        }

    }//GEN-LAST:event_tabSeleccionarFechaMousePressed

    private String comprobarCamposObligatorios() {

        String datosObligatorios = "";

        if (txtSeleccionarCliente.getText().equals("")) {
            datosObligatorios += "\nDNI Cliente";
        }

        if (cmbBoxSeleccionarServicio.getSelectedIndex() == -1) {
            datosObligatorios += "\nServicio";
        }

        if (diaSeleccionado == null) {
            datosObligatorios += "\nDía No Seleccionado o no disponible";
        }

        if (rBut1.isSelected() && rBut1.getBackground() == Color.red) {
            datosObligatorios += "\nHora no disponible";
        }

        if (rBut2.isSelected() && rBut2.getBackground() == Color.red) {
            datosObligatorios += "\nHora no disponible";
        }

        if (rBut3.isSelected() && rBut3.getBackground() == Color.red) {
            datosObligatorios += "\nHora no disponible";
        }

        if (rBut4.isSelected() && rBut4.getBackground() == Color.red) {
            datosObligatorios += "\nHora no disponible";
        }

        if (!rBut1.isSelected() && !rBut2.isSelected() && !rBut3.isSelected() && !rBut4.isSelected()) {
            datosObligatorios += "\nNinguna hora seleccionada";
        }

        return datosObligatorios;
    }

    //Agregar la cita
    private void butConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butConfirmarActionPerformed

        try {

            String datosObligatorios = comprobarCamposObligatorios();

            if (datosObligatorios.equals("")) {
                Cita c = new Cita();

                c.setIdServicio(servicio.getId());
                c.setDniCliente(cliente.getDni());
                c.setFecha(LocalDate.of(anoSeleccionado, mesSeleccionado + 1, Integer.parseInt(diaSeleccionado)));
                c.setHora(LocalTime.of(horaSeleccionada, minutosSeleccionados));

                LogicaCita.altaCita(c);

                int op = JOptionPane.showConfirmDialog(this,
                        "Alta de cita correcta!!\n"
                                + "¿Desea imprimir recordatorio?",
                        getName(),
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);

                if (op == JOptionPane.YES_OPTION) {
                    ResumenCita rc = new ResumenCita((JFrame) SwingUtilities.getWindowAncestor(this), true, cliente.getDni(), (String) cmbBoxSeleccionarServicio.getSelectedItem(), concatenarFecha());
                    rc.setVisible(false);
                    rc.setSize(400, 320);
                    rc.mostrar();
                }

                limpiarCampos();
            } else {
                System.out.println();
                JOptionPane.showMessageDialog(this,
                        "ERROR. Faltan datos obligatorios!!" + datosObligatorios,
                        getName(),
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this,
                        ex.getMessage(),
                        getName(),
                        JOptionPane.WARNING_MESSAGE);
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_butConfirmarActionPerformed

    //Para obtener la hora seleccionada
    private void buttGroupHorasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_buttGroupHorasStateChanged

        if (rBut1.isSelected()) {
            horaSeleccionada = Integer.parseInt(rBut1.getText().substring(0, 2));
            minutosSeleccionados = Integer.parseInt(rBut1.getText().substring(3, 5));
        } else if (rBut2.isSelected()) {
            horaSeleccionada = Integer.parseInt(rBut2.getText().substring(0, 2));
            minutosSeleccionados = Integer.parseInt(rBut2.getText().substring(3, 5));
        } else if (rBut3.isSelected()) {
            horaSeleccionada = Integer.parseInt(rBut3.getText().substring(0, 2));
            minutosSeleccionados = Integer.parseInt(rBut3.getText().substring(3, 5));
        } else if (rBut4.isSelected()) {
            horaSeleccionada = Integer.parseInt(rBut4.getText().substring(0, 2));
            minutosSeleccionados = Integer.parseInt(rBut4.getText().substring(3, 5));
        }
    }//GEN-LAST:event_buttGroupHorasStateChanged

    //Establece las horas disponibles en función de si se ha seleccionado
    //el horario de mañanas o de tardes.
    private void establecerHoras() {

        if (checkBoxMañanaTarde.isSelected()) {
            rBut1.setText("09:00");
            rBut2.setText("10:00");
            rBut3.setText("11:00");
            rBut4.setText("12:00");
        } else {
            rBut1.setText("16:00");
            rBut2.setText("17:00");
            rBut3.setText("18:00");
            rBut4.setText("19:00");
        }
    }

    //Cambiar color horas
    private void cambiarColorHoras() {

        try {

            if (diaSeleccionado != null) {
                String anoSelec = String.valueOf(this.anoSeleccionado);
                String mesSelec = String.valueOf(this.mesSeleccionado + 1);

                String fecha = anoSelec + "-" + mesSelec + "-" + diaSeleccionado;

                List<String> tDiasDisponibles = LogicaCita.horariosDisponibles(fecha);

                rBut1.setOpaque(true);
                rBut2.setOpaque(true);
                rBut3.setOpaque(true);
                rBut4.setOpaque(true);

                boolean rBut1Ocupado = false;
                boolean rBut2Ocupado = false;
                boolean rBut3Ocupado = false;
                boolean rBut4Ocupado = false;

                for (String d : tDiasDisponibles) {
                    if (d.equals(rBut1.getText())) {
                        rBut1Ocupado = true;
                    }

                    if (d.equals(rBut2.getText())) {
                        rBut2Ocupado = true;
                    }

                    if (d.equals(rBut3.getText())) {
                        rBut3Ocupado = true;
                    }

                    if (d.equals(rBut4.getText())) {
                        rBut4Ocupado = true;
                    }
                }

                if (rBut1Ocupado) {
                    rBut1.setBackground(Color.red);
                } else {
                    rBut1.setBackground(Color.green);
                }

                if (rBut2Ocupado) {
                    rBut2.setBackground(Color.red);
                } else {
                    rBut2.setBackground(Color.green);
                }

                if (rBut3Ocupado) {
                    rBut3.setBackground(Color.red);
                } else {
                    rBut3.setBackground(Color.green);
                }

                if (rBut4Ocupado) {
                    rBut4.setBackground(Color.red);
                } else {
                    rBut4.setBackground(Color.green);
                }
            } else {
                rBut1.setOpaque(false);
                rBut2.setOpaque(false);
                rBut3.setOpaque(false);
                rBut4.setOpaque(false);
            }
            rBut1.repaint();
            rBut2.repaint();
            rBut3.repaint();
            rBut4.repaint();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    //Rellenar calendario con días
    private void rellenarCalendario() {

        limpiarTabla();

        //Sumamos uno ya que por el enumerado el mes va disminuido en 1
        LocalDate fechaInicial = LocalDate.of(anoSeleccionado, mesSeleccionado + 1, 1);

        //Restamos uno para condicionarlo al JTable
        int diaInicialFechaSeleccionada = fechaInicial.getDayOfWeek().getValue() - 1;

        int fila = 0;
        int dia = 1;
        while (fechaInicial.getMonth().getValue() == mesSeleccionado + 1) {
            tabModel.addRow(new Object[7]);

            int columna = diaInicialFechaSeleccionada;
            while (columna != 7) {

                if (fechaInicial.getMonth().getValue() == mesSeleccionado + 1) {
                    tabModel.setValueAt(dia, fila, columna);

                } else {
                    break;
                }
                fechaInicial = fechaInicial.plusDays(1);
                dia++;
                columna++;
            }
            diaInicialFechaSeleccionada = 0;
            fila++;
        }
        tabSeleccionarFecha.setModel(tabModel);
    }

    //Para recuperar el Cliente al buscarlo en el JDialog
    @Override
    public void panelDeLlamada(Object o) {

        if (o instanceof Cliente) {
            cliente = (Cliente) o;
            txtSeleccionarCliente.setText(cliente.getDni() + ". " + cliente.getNombre());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnoAnterior;
    private javax.swing.JButton butAnoPosterior;
    private javax.swing.JButton butConfirmar;
    private javax.swing.JButton butMesAnterior;
    private javax.swing.JButton butMesPosterior;
    private javax.swing.JButton butSeleccionarCliente;
    private javax.swing.ButtonGroup buttonGroupHoras;
    private javax.swing.JCheckBox checkBoxMañanaTarde;
    private javax.swing.JComboBox<String> cmbBoxSeleccionarServicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labAno;
    private javax.swing.JLabel labCabecera;
    private javax.swing.JLabel labDiaDisponible;
    private javax.swing.JLabel labMes;
    private javax.swing.JLabel labSeleccionarCliente;
    private javax.swing.JLabel labSeleccionarServicio;
    private javax.swing.JPanel panelFecha;
    private javax.swing.JPanel panelHora;
    private javax.swing.JPanel panelSeleccionarClienteYServicio;
    private javax.swing.JRadioButton rBut1;
    private javax.swing.JRadioButton rBut2;
    private javax.swing.JRadioButton rBut3;
    private javax.swing.JRadioButton rBut4;
    private javax.swing.JTable tabSeleccionarFecha;
    private javax.swing.JTextField txtSeleccionarCliente;
    // End of variables declaration//GEN-END:variables
}
