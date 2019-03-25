/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import java.util.ArrayList;
import nsat.Configuracion;
import nsat.Individuo;
import nsat.Manager;
import nsat.Seleccion;
import nsat.Tokenizador;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class MainSAT {
//    public static void main(String args[]){
//        Tokenizador.leerDatos();
//        
//        System.out.println("");
//        Individuo i = new Individuo();
//        Individuo i2 = new Individuo();
//        Individuo i3 = new Individuo();
//        
//        System.out.println();    
//    }
    
      public static void main(String[] args) {
          Tokenizador.leerDatos();
        // configuraciones 
        ArrayList<Configuracion> configuraciones = new ArrayList<>();
        Configuracion c1 = new Configuracion(500000, 20, 0.2, 0.1, new Seleccion.TipoSeleccion[]{Seleccion.TipoSeleccion.RANDOM,Seleccion.TipoSeleccion.TORNEO});
        Configuracion c2 = new Configuracion(500000, 50, 0.2, 0.1, new Seleccion.TipoSeleccion[]{Seleccion.TipoSeleccion.RANDOM,Seleccion.TipoSeleccion.TORNEO});
        
        configuraciones.add(c1);
        configuraciones.add(c2);
        
        
        // manager
        Manager m = new Manager("Manager1");
        m.generarGeneticos(configuraciones);
        m.ejecutarGeneticos();
        System.out.println("");
          //m.setPoblacion(0, 1);
          System.out.println("");   
    }
}
