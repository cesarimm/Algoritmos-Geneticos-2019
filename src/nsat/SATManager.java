/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class SATManager implements Runnable{
     // parametros
    private Poblacion poblacionActual;
    private Configuracion manager;

    

    public SATManager(Configuracion manager) {
        this.manager = manager;
        this.poblacionActual = new Poblacion(this.manager.getTamPoblacion());   
    }
    
    public void evolucionar2(){
    //int mask[] = Cruza.generarMascaraAleatoria(100);
    Individuo mejor = null;
    // generar las itereaciones para las generaciones
    for(int g=1;g<this.manager.getNumGeneraciones();g++){
        // garantizar construir una nueva población
            ArrayList<Individuo> ind=new ArrayList<>();
             //calcular un N
            int n = (int)(this.manager.getTamPoblacion()*this.manager.getpMuestra());
            if (n>0){
            ind = new ArrayList<>();
            ind.add(this.poblacionActual.getMejor());

            }else {
            ind = new ArrayList<>();
            }
        for(int i=0; i<this.manager.getTamPoblacion();i++){
            // seleccionamos
            Individuo madre = Seleccion.seleccionTorneo(this.poblacionActual);
            Individuo padre = Seleccion.seleccionAleatoria(this.poblacionActual);
            
            // reproducimos
            Individuo hijo = Cruza.cruzaXMascara(this.manager.getMask(), madre, padre);
            // mutamos 
                // evaluar la probabilidad
            Muta.mutaBit(this.manager.getProbMuta(), hijo);
            // agregamos
            ind.add(hijo);
            
        }
        // actualizamos la nueva población
        this.poblacionActual = new Poblacion(ind);
       // pedimos el mejor a la poblacion 
       mejor  = this.poblacionActual.getMejor();
   
        System.out.println(g+": "+mejor.getFitness());
    }
    
    System.out.println(mejor.getFitness());
    System.out.println(Arrays.toString(mejor.getGenotipo()));
    }
    
    public void evolucionar(){
        // generar las itereaciones para las generaciones
        for(int g=1;g<this.manager.getNumGeneraciones();g++){
            // garantizar construir una nueva población
            ArrayList<Individuo> ind=null;
            // calcular un N
            int n = (int)(this.manager.getTamPoblacion()*this.manager.getpMuestra());
            System.out.println("");
            if (n>0){
                System.out.println("");
            ind = new ArrayList<>();
            ind.add(this.poblacionActual.getMejor());

            }else {
            ind = new ArrayList<>();
            }
            for(int i=n; i<this.manager.getTamPoblacion();i++){
                // seleccionamos
                Individuo madre = this.manager.aplicarSeleccion(poblacionActual,0);
                Individuo padre = this.manager.aplicarSeleccion(poblacionActual,1);
                // reproducimos
                Individuo hijo = Cruza.cruzaXMascara(this.manager.getMask(), madre, padre);
                // mutamos 
                // evaluar la probabilidad
                Muta.mutaBit(this.manager.getProbMuta(), hijo);
                // agregamos
                ind.add(hijo);
            }
            // actualizamos la nueva población
            this.poblacionActual = new Poblacion(ind);
        
        Individuo mejor  = this.poblacionActual.getMejor();

        int f = mejor.getFitness();
        System.out.println("g: "+g+" f:"+f+" id:"+this.hashCode());
            
       }
  }

    public Configuracion getManager() {
        return manager;
    }

    
    public Poblacion getPoblacionActual() {
        return poblacionActual;
    }

    public void setPoblacionActual(Poblacion poblacionActual) {
        this.poblacionActual = poblacionActual;
    }
    
    

    @Override
    public void run() {
        evolucionar2();
    }
    
}
