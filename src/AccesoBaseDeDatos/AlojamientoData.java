/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBaseDeDatos;

import agenciadeturismoproyecto.Alojamiento;
import agenciadeturismoproyecto.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G5
 */
public class AlojamientoData {
    private Connection con;
    
    public AlojamientoData(Conectar conectar){
        
        con = conectar.getConectar();
        
}

    public void guardarAlojamiento(Alojamiento alojamiento) {
    
        try {
            String sql = "INSERT INTO Alojamiento (Direccion, Cantidad_de_camas,fumadores,Costo_por_noche) VALUES ( ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alojamiento.getDireccion());
            ps.setInt(2, alojamiento.getCantidadDeCamas());
            ps.setBoolean(3, alojamiento.isFumadores());
            ps.setDouble (4, alojamiento.getCostoPorNoche());
            System.out.println("alojamiento" + alojamiento.getCantidadDeCamas());
            int filas = ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
            alojamiento.setId_alojamiento(rs.getInt("id_alojamiento"));
            
            }
            else {
            System.out.println("No se pudo obtener el id de alojamiento");}
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }}

    public void borrarAlojamiento(int id_alojamiento) {    
        try {
            String sql = "DELETE FROM alojamiento WHERE id_alojamiento= ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id_alojamiento);
            ps.executeUpdate();
            ps.close();
            System.out.println("borra" + id_alojamiento);
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
public void actualizarAlojamiento(Alojamiento alojamiento){ 
    
        try {
           
            String sql = "UPDATE alojamiento SET Direccion=?, Cantidad_de_camas=?,Fumadores=?,Costo_por_noche=? WHERE id_alojamiento= ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alojamiento.getDireccion());
            ps.setInt(2, alojamiento.getCantidadDeCamas());
            ps.setBoolean(3, alojamiento.isFumadores());
            ps.setDouble (4, alojamiento.getCostoPorNoche());
            ps.setInt(5, alojamiento.getId_alojamiento());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
             System.out.println("Error al insertar un alumno: " + ex.getMessage());
        
            Logger.getLogger(AlojamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public Alojamiento buscarAlojamiento(int id_alojamiento){
        Alojamiento alojamiento=null;
          try {
            
              
            String sql ="SELECT * FROM alojamiento WHERE id_alojamiento=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id_alojamiento);
            
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                alojamiento=new Alojamiento();
                
                alojamiento.setId_alojamiento(resultSet.getInt("id_alojamiento"));
                alojamiento.setDireccion(resultSet.getString("direccion"));
                alojamiento.setCantidadDeCamas(resultSet.getInt("cantidad_de_camas"));
                alojamiento.setFumadores(resultSet.getBoolean("fumadores"));
                alojamiento.setCostoPorNoche(resultSet.getDouble("costo_por_noche"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
          return alojamiento;
        
        
        
    }


}
