/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Roberto Cruz Leija
 */
public class GeneticoTSP {
    // parametros
    private Poblacion poblacionActual;
    private int numG,tamP;
    private double pMuta;

    public GeneticoTSP(int numG, int tamP, int numCd, int ci, double pMuta) {
        this.numG = numG;
        this.tamP = tamP;
        this.pMuta = pMuta;
        this.poblacionActual = new Poblacion(tamP,numCd,ci);
        //mejor();
    }
    
    public void evolucionar(){
        Grafica grafica = new Grafica("Puntos ", "Distancias","Inclinaciones");
        grafica.crearSerie("0");
        Individuo mejor = null;
    // generar las itereaciones para las generaciones
    for(int g=1;g<this.numG;g++){
        // garantizar construir una nueva población
        ArrayList<Individuo> ind = new ArrayList<>();
        for(int i=0; i<this.tamP;i++){
            // seleccionamos
            Individuo madre = Seleccion.seleccionTorneo(this.poblacionActual);
            Individuo padre = Seleccion.seleccionAleatoria(this.poblacionActual);
            
            // reproducimos
            Individuo hijo = Cruza.cruzaAsexual(madre, padre);
            // mutamos 
                // evaluar la probabilidad
            Muta.mutaGen(pMuta, hijo);
            // agregamos
            ind.add(hijo);
        }
        // actualizamos la nueva población
        this.poblacionActual = new Poblacion(ind);
       // pedimos el mejor a la poblacion 
       mejor  = this.poblacionActual.getMejor();
       grafica.crearPuntoASerie("0",mejor.getFitnessDistancia(),mejor.getFitnessInclinacion());
        System.out.println(g+": "+mejor.getFitnessGeneral());
    }
    
    grafica.crearGrafica();
    
    }

    public static void main(String[] args){
        
        Herramientas.cargarDistancias();
        GeneticoTSP g = new GeneticoTSP(100000,100,Herramientas.distancias.length,0,0.001); 
        g.evolucionar();
        
        
        
    }  
}
