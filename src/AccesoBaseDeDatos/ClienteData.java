/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBaseDeDatos;

import agenciadeturismoproyecto.Cliente;
import agenciadeturismoproyecto.Conectar;
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
public class ClienteData {
    private Connection con;
    
    public ClienteData(Conectar conectar){
        
        con = conectar.getConectar();
        
}

    public void guardarCliente(Cliente cliente) {
    
        try {
            String sql = "INSERT INTO Cliente (Nombre_comleto,DNI,Telfono) VALUES ( ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombreCompleto());
            ps.setInt(2, cliente.getDni());
            ps.setDouble (4, cliente.getTelefono());
            
            int filas = ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
            cliente.setId_cliente(rs.getInt("id_cliente"));
            
            }
            else {
            System.out.println("No se pudo obtener el id de traslado");}
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TrasladoData.class.getName()).log(Level.SEVERE, null, ex);
        }}

    public void borrarCliente(int id_cliente) {    
        try {
            String sql = "DELETE FROM cliente WHERE id_cliente= ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id_cliente);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void actualizarTraslado(Cliente cliente) { 
        try {
            String sql = "UPDATE cliente SET Nombre_completo=?, DNI=?,Telefono=? WHERE id_cliente=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombreCompleto());
            ps.setInt(2, cliente.getDni());
            ps.setInt(3, cliente.getTelefono());
            ps.setInt(4,cliente.getId_cliente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public Cliente buscarCliente(int id_cliente){
        Cliente cliente=null;
          try {
            
              
            String sql ="SELECT * FROM cliente WHERE id_cliente=?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id_cliente);
            
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                cliente=new Cliente();
                
                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNombreCompleto(resultSet.getString("nombre_completo"));
                cliente.setDni(resultSet.getInt("DNI"));
                cliente.setTelefono(resultSet.getInt("telefono"));
                
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
          return cliente;
        
        
        
    }
}
