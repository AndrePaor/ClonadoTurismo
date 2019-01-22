/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBaseDeDatos;

import agenciadeturismoproyecto.Conectar;
import agenciadeturismoproyecto.Tipo_traslado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author 
 */
public class Tipo_trasladoData {
   private Connection con;
    
    public Tipo_trasladoData(Conectar conectar){
        
        con = conectar.getConectar();
        
}
    
     public Tipo_traslado buscarTipo_traslado(int tipo_trasladoId){
        Tipo_traslado MiTipo_traslado=null;
          try {
            
              
            String sql ="SELECT * FROM tipo_traslado WHERE tipo_trasladoId=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,tipo_trasladoId);
            
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                MiTipo_traslado=new Tipo_traslado();
                
                MiTipo_traslado.setTipo_trasladoId(resultSet.getInt("tipo_trasladoId"));
                MiTipo_traslado.setNombre(resultSet.getString("nombre"));
                           }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
          return MiTipo_traslado;
        
        
        
    }
}
