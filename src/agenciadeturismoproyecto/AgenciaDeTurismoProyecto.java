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
public class AgenciaDeTurismoProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Alojamiento alojamiento1 = new Alojamiento("LaPampa",5,true,700);
        Traslado traslado1 = new Traslado ("Auto",4,300);
        Paquete paquete1 = new Paquete (alojamiento1,traslado1,"hermoso");
        
        System.out.println("Disponibilidad "+paquete1.cupo());
        System.out.println("camas" +alojamiento1.getCantidadDeCamas());
    }
    
}
