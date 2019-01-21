/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBaseDeDatos;

import agenciadeturismoproyecto.Conectar;
import agenciadeturismoproyecto.Traslado;
import java.sql.Connection;
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
public class TrasladoData {
    private Connection con;
    
    public TrasladoData(Conectar conectar){
        
        con = conectar.getConectar();
        
}

    public void guardarTraslado(Traslado traslado) {
    
        try {
            String sql = "INSERT INTO Traslado (Tipo, Cantidad_max_de_pasajeros,Costo_por_km) VALUES ( ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, traslado.getTipo());
            ps.setInt(2, traslado.getCantidadDePasajeros());
            ps.setDouble (3, traslado.getCostoPorKm());
            
            int filas = ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
            traslado.setId_traslado(rs.getInt("id_traslado"));
            
            }
            else {
            System.out.println("No se pudo obtener el id de traslado");}
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TrasladoData.class.getName()).log(Level.SEVERE, null, ex);
        }}

    public void borrarTraslado(int id_traslado) {    
        try {
            String sql = "DELETE FROM traslado WHERE id_traslado=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id_traslado);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrasladoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void actualizarTraslado(Traslado traslado) { 
        try {
            String sql = "UPDATE traslado SET tipo=?, cantidad_max_de_pasajeros=?,costo_por_km=? WHERE id_traslado=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, traslado.getTipo());
            ps.setInt(2, traslado.getCantidadDePasajeros());
            ps.setDouble(3, traslado.getCostoPorKm());
            ps.setInt(4,traslado.getId_traslado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrasladoData.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public Traslado buscarTraslado(int id_traslado){
        Traslado traslado=null;
          try {
            
              
            String sql ="SELECT * FROM traslado WHERE id_traslado=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id_traslado);
            
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                traslado=new Traslado();
                
                traslado.setId_traslado(resultSet.getInt("id_traslado"));
                traslado.setTipo(resultSet.getString("tipo"));
                traslado.setCantidadDePasajeros(resultSet.getInt("cantidad_max_de_pasajeros"));
                traslado.setCostoPorKm(resultSet.getDouble("costo_por_km"));
                
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
          return traslado;
        
        
        
    }


    
}
