/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import java.util.ArrayList;
import nreinas.Configuracion;
import nreinas.GeneticoNReinas;
import nreinas.Manager;
import nreinas.Seleccion;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class AlgoritmoNreinas {
    
//        public static void main(String[] args) {
//        GeneticoNReinas gen = new GeneticoNReinas(100000, 25, 0.2, 1000);
//        gen.evolucionar();
//        System.out.println();
  public static void main(String[] args) {
        // configuraciones 
        ArrayList<Configuracion> configuraciones = new ArrayList<>();
        Configuracion c1 = new Configuracion(500000, 20, 0.2, 0.1, new Seleccion.TipoSeleccion[]{Seleccion.TipoSeleccion.RANDOM,Seleccion.TipoSeleccion.TORNEO}, 60);
        Configuracion c2 = new Configuracion(500000, 50, 0.2, 0.1, new Seleccion.TipoSeleccion[]{Seleccion.TipoSeleccion.RANDOM,Seleccion.TipoSeleccion.TORNEO}, 60);
        
        configuraciones.add(c1);
        configuraciones.add(c2);
        
        
        // manager
        Manager m = new Manager("Manager1",c1.getTamGenotipo());
        m.generarGeneticos(configuraciones);
        m.ejecutarGeneticos();
        System.out.println("");
          m.setPoblacion(0, 1);
          System.out.println("");
        
    }  
}
