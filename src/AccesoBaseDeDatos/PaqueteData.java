/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBaseDeDatos;

import agenciadeturismoproyecto.Alojamiento;
import agenciadeturismoproyecto.Conectar;
import agenciadeturismoproyecto.Paquete;
import agenciadeturismoproyecto.Traslado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G5
 */
public class PaqueteData {
    private Connection con;
    
    public PaqueteData(Conectar conectar){
        
        con = conectar.getConectar();
        
}

    public void guardarPaquete(Paquete paquete) {
    
        try {
            String sql = "INSERT INTO Paquete (id_traslado,id_alojamiento,Descripcion,Cupo) VALUES ( ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, paquete.getTraslado().getId_traslado());
            ps.setInt(2, paquete.getAlojamiento().getId_alojamiento());
            ps.setString(3, paquete.getDescripcion());
            ps.setInt(4, paquete.getCupo());
            
            
            int filas = ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
            paquete.setId_paquete(rs.getInt("id_paquete"));
            
            }
            else {
            System.out.println("No se pudo obtener el id de paquete");}
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteData.class.getName()).log(Level.SEVERE, null, ex);
        }}

    public void borrarPaquete(int id_paquete) {    
        try {
            String sql = "DELETE FROM paquete WHERE id_paquete= ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id_paquete);
            ps.executeUpdate();
            ps.close();
            System.out.println("borra " +id_paquete);
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
public void actualizarpaquete(Paquete paquete){ 
    
        try {
           
            String sql = "UPDATE paquete SET id_traslado=?, id_alojamiento=?,Descripcion=? WHERE id_paquete= ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, paquete.getTraslado().getId_traslado());
            ps.setInt(2, paquete.getAlojamiento().getId_alojamiento());
            ps.setString(3, paquete.getDescripcion());
            ps.setInt(4,paquete.getId_paquete());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
             System.out.println("Error al insertar un alumno: " + ex.getMessage());
        
            Logger.getLogger(PaqueteData.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public Paquete buscarPaquete(int id_paquete){
        Paquete paquete=null;
          try {
            
              
            String sql ="SELECT * FROM paquete WHERE id_paquete=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id_paquete);
            
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                paquete=new Paquete();
                
                paquete.setId_paquete(resultSet.getInt("id_paquete"));
                paquete.getTraslado().setId_traslado(resultSet.getInt("id_traslado"));
                paquete.getAlojamiento().setId_alojamiento(resultSet.getInt("id_alojamiento"));
                paquete.setDescripcion(resultSet.getString("Descripcion"));
                
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
          return paquete;
        
        
        
    }
       public List<Paquete> obtenerPaquetes(){
        List<Paquete> paquetes = new ArrayList<Paquete>();
            

        try {
            String sql = "SELECT * FROM paquete;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            Paquete paquete;
            while(resultSet.next()){
                paquete= new Paquete();
                paquete.setId_paquete(resultSet.getInt("id_paquete"));
                paquete.getTraslado().setId_traslado(resultSet.getInt("id_traslado"));
                paquete.getAlojamiento().setId_alojamiento(resultSet.getInt("id_alojamiento"));
                paquete.setDescripcion(resultSet.getString("Descripcion"));
                paquetes.add(paquete);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los paquetes: " + ex.getMessage());
        }
        
        
        return paquetes;
    }
       
        public List<Paquete> obtenerPaquetesXtipoXfumadores(boolean aceptaFumadores, Integer CodigoTipoVehiculo){
        List<Paquete> paquetes = new ArrayList<Paquete>();
            

        try {
            String sql = ("SELECT * from paquete pa INNER JOIN traslado tr on pa.id_traslado = tr.id_traslado INNER JOIN alojamiento al on al.id_alojamiento = pa.id_alojamiento WHERE al.Fumadores  = " + aceptaFumadores +" and tr.tipo_trasladoId = '"+CodigoTipoVehiculo+"';");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            Paquete paquete;
            Traslado traslado;
            Alojamiento alojamiento;
            
            while(resultSet.next()){
                paquete= new Paquete();
                traslado= new Traslado();
                alojamiento= new Alojamiento();
                
                traslado.setId_traslado(resultSet.getInt("id_traslado"));
                alojamiento.setId_alojamiento(resultSet.getInt("id_alojamiento"));
                paquete.setId_paquete(resultSet.getInt("id_paquete"));
                paquete.setTraslado(traslado);
                paquete.setAlojamiento(alojamiento);
                paquete.setDescripcion(resultSet.getString("Descripcion"));
                paquete.setKM_Viaje(resultSet.getInt("KM_Viaje"));
                paquetes.add(paquete);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los paquetes: " + ex.getMessage());
        }
        
        
        return paquetes;
    }
        
       public List<Paquete> filtroVehiculos(String tipo){
        List<Paquete> paquetes = new ArrayList<Paquete>();
            

        try {
            String sql = "SELECT * FROM paquete, traslado WHERE paquete.id_traslado = traslado.id_traslado AND traslado.Tipo=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,tipo);
            ResultSet resultSet=ps.executeQuery();
            Paquete paquete;
            while(resultSet.next()){
                paquete= new Paquete();
                paquete.setId_paquete(resultSet.getInt("id_paquete"));
                paquete.getTraslado().setId_traslado(resultSet.getInt("id_traslado"));
                paquete.getAlojamiento().setId_alojamiento(resultSet.getInt("id_alojamiento"));
                paquete.setDescripcion(resultSet.getString("Descripcion"));
                paquetes.add(paquete);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los paquetes: " + ex.getMessage());
        }
        
        
        return paquetes;
    }
       
    
}
