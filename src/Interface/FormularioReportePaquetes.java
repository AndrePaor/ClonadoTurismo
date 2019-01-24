/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import AccesoBaseDeDatos.PaqueteData;
import agenciadeturismoproyecto.Paquete;
import javax.swing.JOptionPane;
import agenciadeturismoproyecto.Conectar;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FormularioReportePaquetes extends javax.swing.JInternalFrame {
private PaqueteData paqueteData;
private Paquete paquete; 
private Conectar con;
private DefaultTableModel modelo;

private ArrayList<Paquete> listaPaquete;

    /**
     * Creates new form FormularioReportePaquetes
     */
    public FormularioReportePaquetes() {
        initComponents();
         con=new Conectar();
        paqueteData = new PaqueteData(con);
         
modelo = new DefaultTableModel();  
armaCabeceraTabla();
    }

 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JtPaquetes = new javax.swing.JTable();
        jRvan = new javax.swing.JRadioButton();
        jRauto = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRminibus = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jBbuscar = new javax.swing.JButton();
        checkBoxpermiteFumadores = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();

        JtPaquetes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JtPaquetes);

        jRvan.setText("Van");

        jRauto.setText("Auto");
        jRauto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRautoActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo de vehiculo:");

        jLabel4.setText("Permite fumador");

        jRminibus.setText("Minibus");
        jRminibus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRminibusActionPerformed(evt);
            }
        });

        jLabel5.setText("Reporte de paquetes, con filtros tipo de vehiculo y permitir fumadores :");

        jBbuscar.setText("Buscar");
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("Resultados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRvan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBbuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkBoxpermiteFumadores)
                                            .addComponent(jRauto)
                                            .addComponent(jRminibus))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jRauto)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRvan)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRminibus)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxpermiteFumadores))
                .addGap(27, 27, 27)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRautoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRautoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRautoActionPerformed

    private void jRminibusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRminibusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRminibusActionPerformed

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
     
        int DatoTransporte = 0;
        DatoTransporte = VistatipoTrasporte();
         paqueteData = new PaqueteData(con);
       

         if ( DatoTransporte > 0 )  {
              listaPaquete = (ArrayList)paqueteData.obtenerPaquetesXtipoXfumadores(checkBoxpermiteFumadores.isSelected(),DatoTransporte);
        
                
                cargarDatos();
        
             }
            else{
             JOptionPane.showMessageDialog(null,"Tipo de trasporte no puede ser vacio","Advertencia",JOptionPane.WARNING_MESSAGE);                       
             }
     
//int id_traslado= Integer.parseInt(tfId.getText());

       /* Traslado traslado =trasladoData.buscarTraslado(id_traslado);
        tfId.setText(traslado.getId_traslado()+"");
        tftipo.setText(traslado.getMiTipo_traslado().getNombre());
        tfcantidad.setText(Integer.toString(traslado.getCantidadDePasajeros()));
        tfcosto.setText(Double.toString(traslado.getCostoPorKm()) );        // TODO add your handling code here: */
    }//GEN-LAST:event_jBbuscarActionPerformed

  public void cargarDatos(){
        borrarFilasTabla();

        for(Paquete p:listaPaquete){
            
                modelo.addRow(new Object[]{p.getId_paquete(),p.getDescripcion(),p.getKM_Viaje()});
 
        } 
    }
  
   public void borrarFilasTabla(){
    int a= modelo.getRowCount()-1;
    for(int i=a;i>=0;i--){
        modelo.removeRow(i);
    }
    
    }
   
 public void armaCabeceraTabla(){
    ArrayList<Object> columns =new ArrayList<Object>();
    columns.add("Codigo");
    columns.add("Descripcion");
    columns.add("KM_Viaje");
   
    for(Object it:columns){
    modelo.addColumn(it);
    }
    JtPaquetes.setModel(modelo);
    }
 
 
     private int VistatipoTrasporte(){
        
        int Tipo=0;
        if (jRauto.isSelected()){
        Tipo = 1;
        
        }
        else{
           if (jRvan.isSelected()){
           Tipo = 3;
             }
        else{
                if (jRminibus.isSelected()){
                    Tipo = 2;
                    
                   
                } else{
                         Tipo = 0;    }
            
            }
            }
        
        return Tipo;
        
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtPaquetes;
    private javax.swing.JCheckBox checkBoxpermiteFumadores;
    private javax.swing.JButton jBbuscar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRauto;
    private javax.swing.JRadioButton jRminibus;
    private javax.swing.JRadioButton jRvan;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}