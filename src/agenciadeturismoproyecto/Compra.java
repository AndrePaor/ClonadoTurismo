/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciadeturismoproyecto;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author G5
 */
public class Compra {
    private Paquete paquete;
    private Cliente cliente;
    private LocalDate fechaIngreso;
   private LocalDate fechaEgreso;
   private int cantidadDePasajeros;
   private int Id_compra;

    public Compra(Paquete paquete, Cliente cliente, LocalDate fechaIngreso, LocalDate fechaEgreso, int cantidadDePasajeros) {
        this.paquete = paquete;
        this.cliente = cliente;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.cantidadDePasajeros = cantidadDePasajeros;
    }
    public Compra() {
        this.paquete = paquete;
        this.cliente = cliente;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.cantidadDePasajeros = cantidadDePasajeros;
    }

    public int getId_compra() {
        return Id_compra;
    }

    public void setId_compra(int Id_compra) {
        this.Id_compra = Id_compra;
    }
    

    public int getCantidadDePasajeros() {
        return cantidadDePasajeros;
    }

    public void setCantidadDePasajeros(int cantidadDePasajeros) {
        this.cantidadDePasajeros = cantidadDePasajeros;
    }

    

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
    
    public boolean verificacion() {return (paquete.cupo() >= this.cantidadDePasajeros);}
}
