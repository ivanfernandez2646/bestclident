/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import logica.CallBack;
import vista.Citas.RenderizadorTablaCita;

/**
 *
 * @author IVÁN-PC
 */
public class ElegirFechaPanel_Citas extends javax.swing.JPanel {

    public enum MESES {
        Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre
    }

    private CallBack imc;

    private DefaultTableModel tabModel;

    private int anoSeleccionado;
    private int mesSeleccionado;
    private String diaSeleccionado;

    public ElegirFechaPanel_Citas() {
        initComponents();
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
        RenderizadorTablaCita cambiarColorCeldas = new RenderizadorTablaCita();
        tabSeleccionarFecha.setDefaultRenderer(Object.class, cambiarColorCeldas);
        tabSeleccionarFecha.setModel(tabModel);
    }

    public int getAnoSeleccionado() {
        return anoSeleccionado;
    }

    public void setAnoSeleccionado(int anoSeleccionado) {
        this.anoSeleccionado = anoSeleccionado;
    }

    public int getMesSeleccionado() {
        return mesSeleccionado;
    }

    public void setMesSeleccionado(int mesSeleccionado) {
        this.mesSeleccionado = mesSeleccionado;
    }

    public String getDiaSeleccionado() {
        return diaSeleccionado;
    }

    public void setDiaSeleccionado(String diaSeleccionado) {
        this.diaSeleccionado = diaSeleccionado;
    }

    public void mostrar(CallBack imc) {

        this.setBounds(20, 262, 408, 240);
        this.imc = imc;
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    //Limpiamos los campos del panel
    public void limpiarCampos() {
        tabSeleccionarFecha.clearSelection();
        labDiaDisponible.setText("");
        diaSeleccionado = null;
    }


    private void tabSeleccionarFechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabSeleccionarFechaMousePressed

        //Sacamaos el día que hay seleccionado
        diaSeleccionado = tabSeleccionarFecha.getValueAt(tabSeleccionarFecha.getSelectedRow(), tabSeleccionarFecha.getSelectedColumn()) == null ? null
                : String.valueOf(tabSeleccionarFecha.getValueAt(tabSeleccionarFecha.getSelectedRow(), tabSeleccionarFecha.getSelectedColumn()));

        //Comprobamos si es válido, es decir si está en la columna de los fines de Semana o si es un día nulo perteneciente a otro mes
        //De esta manera conseguimos saber si el día es válido o no.
        if (tabSeleccionarFecha.getSelectedColumn() != 5 && tabSeleccionarFecha.getSelectedColumn() != 6 && diaSeleccionado != null) {
            labDiaDisponible.setText("Día Seleccionado: " + String.valueOf(diaSeleccionado));
        } else {
            labDiaDisponible.setText("Día No Disponible!!");
            diaSeleccionado = null;
        }

        imc.panelDeLlamada();
    }//GEN-LAST:event_tabSeleccionarFechaMousePressed

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

    public void rellenarCalendario() {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnoAnterior;
    private javax.swing.JButton butAnoPosterior;
    private javax.swing.JButton butMesAnterior;
    private javax.swing.JButton butMesPosterior;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labAno;
    private javax.swing.JLabel labDiaDisponible;
    private javax.swing.JLabel labMes;
    private javax.swing.JPanel panelFecha;
    private javax.swing.JTable tabSeleccionarFecha;
    // End of variables declaration//GEN-END:variables
}