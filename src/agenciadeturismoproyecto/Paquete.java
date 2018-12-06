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
public class Paquete {
    private Alojamiento alojamiento;
    private Traslado traslado;
    private String descripcion;
    private int id_paquete;
    int cupo;

    
    public Paquete() {
        this.alojamiento = alojamiento;
        this.traslado = traslado;
        this.descripcion = descripcion;
    }
    public Paquete(Alojamiento alojamiento, Traslado traslado, String descripcion) {
        this.alojamiento = alojamiento;
        this.traslado = traslado;
        this.descripcion = descripcion;
    }

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
    

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
      public int cupo() { 
        if (alojamiento.getCantidadDeCamas()< traslado.getCantidadDePasajeros()) {
        return alojamiento.getCantidadDeCamas();}
        else { return traslado.getCantidadDePasajeros();}
     
     }

    
    }
      
   
   
