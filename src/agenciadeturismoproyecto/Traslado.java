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
   private String tipo;
    private int cantidadDePasajeros;
    private double costoPorKm;
    private int id_traslado;

    public Traslado(String tipo, int cantidadDePasajeros, double costoPorKm) {
        this.tipo = tipo;
        this.cantidadDePasajeros = cantidadDePasajeros;
        this.costoPorKm = costoPorKm;
    }
     public Traslado(int id_traslado, String tipo, int cantidadDePasajeros, double costoPorKm) {
        this.tipo = tipo;
        this.cantidadDePasajeros = cantidadDePasajeros;
        this.costoPorKm = costoPorKm;
        this.id_traslado = id_traslado;
    }
      public Traslado(int id_traslado) {
        this.tipo = tipo;
        this.cantidadDePasajeros = cantidadDePasajeros;
        this.costoPorKm = costoPorKm;
        this.id_traslado = id_traslado;
    }
public Traslado() {
        this.tipo = tipo;
        this.cantidadDePasajeros = cantidadDePasajeros;
        this.costoPorKm = costoPorKm;
    }
    public int getId_traslado() {
        return id_traslado;
    }

    public void setId_traslado(int id_traslado) {
        this.id_traslado = id_traslado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    
    
}
