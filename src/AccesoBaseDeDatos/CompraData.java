/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBaseDeDatos;

import agenciadeturismoproyecto.Compra;
import agenciadeturismoproyecto.Conectar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G5
 */
public class CompraData {
    private Connection con;
    
    public CompraData(Conectar conectar){
        
        con = conectar.getConectar();
        
}

    public void guardarCompra(Compra compra) {
    
        try {
            String sql = "INSERT INTO Compra (id_paquete, Fecha_de_ingreso,Fecha_de_egreso,id_cliente,cantidad_de_pasajeros) VALUES ( ? ,?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, compra.getPaquete().getId_paquete());
            ps.setDate(2,Date.valueOf(compra.getFechaIngreso()));
            ps.setDate(3,Date.valueOf(compra.getFechaEgreso()));
            ps.setInt (4, compra.getCliente().getId_cliente());
            ps.setInt(5,compra.getCantidadDePasajeros());
            System.out.println("cantidad de pasajeros" + compra.getCantidadDePasajeros());
            int filas = ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
            compra.setId_compra(rs.getInt("id_compra"));
            
            }
            else {
            System.out.println("No se pudo obtener el id de compra");}
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompraData.class.getName()).log(Level.SEVERE, null, ex);
        }}

    public void borrarCompra(int id_compra) {    
        try {
            String sql = "DELETE FROM compra WHERE id_compra= ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id_compra);
            ps.executeUpdate();
            ps.close();
            System.out.println("borra" + id_compra);
        } catch (SQLException ex) {
            Logger.getLogger(CompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
public void actualizarCompra(Compra compra){ 
    
        try {
           
            String sql = "UPDATE compra SET id_paquete=?, Fecha_de_ingreso=?,Fecha_de_egreso=?,id_cliente=?,cantidad_de_pasajeros=? WHERE id_compra= ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, compra.getPaquete().getId_paquete());
            ps.setDate(2,Date.valueOf(compra.getFechaIngreso()));
            ps.setDate(3,Date.valueOf(compra.getFechaEgreso()));
            ps.setInt (4, compra.getCliente().getId_cliente());
            ps.setInt(5, compra.getCantidadDePasajeros());
            ps.setInt (6,compra.getId_compra());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
             System.out.println("Error al insertar un alumno: " + ex.getMessage());
        
            Logger.getLogger(AlojamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public Compra buscarCompra(int id_compra){
        Compra compra=null;
          try {
            
              
            String sql ="SELECT * FROM compra WHERE id_compra=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id_compra);
            
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                compra=new Compra();
                
                compra.setId_compra(resultSet.getInt("id_compra"));
                compra.getPaquete().setId_paquete(resultSet.getInt("id_paquete"));
                compra.setFechaIngreso(resultSet.getDate("Fecha_de_ingreso").toLocalDate());
                compra.setFechaEgreso(resultSet.getDate("Fecha_de_egreso").toLocalDate());
                compra.getCliente().setId_cliente(resultSet.getInt("id_cliente"));
                compra.setCantidadDePasajeros(resultSet.getInt("cantidad_de_pasajeros"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
          return compra;
        
        
        
    }


}
    

