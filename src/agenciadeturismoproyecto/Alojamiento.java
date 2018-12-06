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
public class Alojamiento {
    private String direccion;
    private int cantidadDeCamas;
    private boolean fumadores;
    private double costoPorNoche;
    private int id_alojamiento; 
    

    public Alojamiento(String direccion, int cantidadDeCamas, boolean fumadores, double costoPorNoche) {
        this.direccion = direccion;
        this.cantidadDeCamas = cantidadDeCamas;
        this.fumadores = fumadores;
        this.costoPorNoche = costoPorNoche;
    }
     public Alojamiento( int id_alojamiento, String direccion, int cantidadDeCamas, boolean fumadores, double costoPorNoche) {
        this.direccion = direccion;
        this.cantidadDeCamas = cantidadDeCamas;
        this.fumadores = fumadores;
        this.costoPorNoche = costoPorNoche;
        this.id_alojamiento = id_alojamiento;
    }
public Alojamiento() {
        this.direccion = direccion;
        this.cantidadDeCamas = cantidadDeCamas;
        this.fumadores = fumadores;
        this.costoPorNoche = costoPorNoche;
    }

    public void setId_alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }

    public int getId_alojamiento() {
        return id_alojamiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direcccion) {
        this.direccion = direcccion;
    }

    public int getCantidadDeCamas() {
        return cantidadDeCamas;
    }

    public void setCantidadDeCamas(int cantidadDeCamas) {
        this.cantidadDeCamas = cantidadDeCamas;
    }

    public boolean isFumadores() {
        return fumadores;
    }

    public void setFumadores(boolean fumadores) {
        this.fumadores = fumadores;
    }

    public double getCostoPorNoche() {
        return costoPorNoche;
    }

    public void setCostoPorNoche(double costoPorNoche) {
        this.costoPorNoche = costoPorNoche;
    }

   
    
}
