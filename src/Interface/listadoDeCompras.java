/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import AccesoBaseDeDatos.ClienteData;
import AccesoBaseDeDatos.CompraData;
import AccesoBaseDeDatos.PaqueteData;
import agenciadeturismoproyecto.Cliente;
import agenciadeturismoproyecto.Compra;
import agenciadeturismoproyecto.Conectar;
import agenciadeturismoproyecto.Paquete;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aulasitc
 */
public class listadoDeCompras extends javax.swing.JInternalFrame {
private DefaultTableModel modelo;
private ArrayList<Compra> listaCompra;
private ArrayList<Paquete> listaPaquete;
private CompraData compraData;
private PaqueteData paqueteData;
private ArrayList<Cliente> listaCliente;
private Conectar con;
private ClienteData clienteData;


    /**
     * Creates new form listadoDeCompras
     */
    public listadoDeCompras() {
        initComponents();
        con = new Conectar();
        modelo = new DefaultTableModel();
        
        compraData = new CompraData(con);
        listaCompra = (ArrayList)compraData.obtenerCompras();
        
        paqueteData = new PaqueteData(con);
        listaPaquete = (ArrayList)paqueteData.obtenerPaquetes();
        
        clienteData = new ClienteData(con);
        listaCliente = (ArrayList)clienteData.obtenerClientes();
        
        cargarPaquete();
        armaCabeceraTabla();
        cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbPaquete = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCliente = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Listado de Compras");

        jLabel2.setText("Paquetes");

        cbPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPaqueteActionPerformed(evt);
            }
        });

        tCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarPaquete(){
    for(Paquete item:listaPaquete){
        cbPaquete.addItem(item);
    }
}
    public void armaCabeceraTabla(){
    ArrayList<Object> columns =new ArrayList<Object>();
    columns.add("Id_Cliente");
    columns.add("Nombre_Completo");
    columns.add("Dni");
    columns.add("Telefono");
    for(Object it:columns){
    modelo.addColumn(it);
    }
    tCliente.setModel(modelo);
    }
    public void borrarFilasTabla(){
    int a= modelo.getRowCount()-1;
    for(int i=a;i>=0;i--){
        modelo.removeRow(i);
    }
    
    }
    public void cargarDatos(){
        borrarFilasTabla();
        
        
        Paquete paq=(Paquete)cbPaquete.getSelectedItem();
        for(Compra p:listaCompra){
            if(p.getPaquete().getId_paquete()==paq.getId_paquete()){
                modelo.addRow(new Object[]{p.getCliente().getId_cliente(),p.getCliente().getNombreCompleto(),p.getCliente().getDni(),p.getCliente().getTelefono()});
            }
        }
    }
    private void cbPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPaqueteActionPerformed
        cargarDatos();
    }//GEN-LAST:event_cbPaqueteActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Paquete> cbPaquete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tCliente;
    // End of variables declaration//GEN-END:variables
}
