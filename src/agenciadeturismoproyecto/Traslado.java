/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciadeturismoproyecto;

/**
 *
 * @author G5
 */
public class Traslado {
     
    private Tipo_traslado MiTipo_traslado;
    private int cantidadDePasajeros;
    private double costoPorKm;
    private int id_traslado;
   
    public Traslado(Tipo_traslado MiTipo_traslado, int cantidadDePasajeros, double costoPorKm) {
        this.MiTipo_traslado = MiTipo_traslado;
        this.cantidadDePasajeros = cantidadDePasajeros;
        this.costoPorKm = costoPorKm;
    }
     public Traslado(int id_traslado, Tipo_traslado MiTipo_traslado, int cantidadDePasajeros, double costoPorKm) {
        this.MiTipo_traslado = MiTipo_traslado;
        this.cantidadDePasajeros = cantidadDePasajeros;
        this.costoPorKm = costoPorKm;
        this.id_traslado = id_traslado;
    }
      public Traslado(int id_traslado) {
        this.MiTipo_traslado = MiTipo_traslado;  
        this.cantidadDePasajeros = cantidadDePasajeros;
        this.costoPorKm = costoPorKm;
        this.id_traslado = id_traslado;
    }
public Traslado() {
        this.MiTipo_traslado = MiTipo_traslado;
        this.cantidadDePasajeros = cantidadDePasajeros;
        this.costoPorKm = costoPorKm;
    }
    public int getId_traslado() {
        return id_traslado;
    }

    public void setId_traslado(int id_traslado) {
        this.id_traslado = id_traslado;
    }

   

    public int getCantidadDePasajeros() {
        return cantidadDePasajeros;
    }

    public void setCantidadDePasajeros(int cantidadDePasajeros) {
        this.cantidadDePasajeros = cantidadDePasajeros;
    }

    public double getCostoPorKm() {
        return costoPorKm;
    }

    public void setCostoPorKm(double costoPorKm) {
        this.costoPorKm = costoPorKm;
    }

    public Tipo_traslado getMiTipo_traslado() {
        return MiTipo_traslado;
    }

    public void setMiTipo_traslado(Tipo_traslado MiTipo_traslado) {
        this.MiTipo_traslado = MiTipo_traslado;
    }

    
    
}
