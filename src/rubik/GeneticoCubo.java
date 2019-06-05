/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class GeneticoCubo {
    // parametros
    private Poblacion poblacionActual;
    private int numG,tamP, tamGen;
    private double pMuta;

    public GeneticoCubo(int numG, int tamP, double pMuta, int tamGen, int[] scramble) {
        this.numG = numG;
        this.tamP = tamP;
        this.pMuta = pMuta;
        this.tamGen = tamGen;
        this.poblacionActual = new Poblacion(tamP, tamGen, scramble);
    }
    
    public void evolucionar(){
      int mascara[] =  Cruza.generarMascaraAleatoria(this.tamGen);
    // generar las itereaciones para las generaciones
    for(int g=1;g<this.numG;g++){
        // garantizar construir una nueva población
        ArrayList<Cubo> ind = new ArrayList<>();
        for(int i=0; i<this.tamP;i++){
            // seleccionamos
            Cubo madre = Seleccion.seleccionAleatoria(this.poblacionActual);
            Cubo padre = Seleccion.seleccionAleatoria(this.poblacionActual);
            // reproducimos
            Cubo hijo = Cruza.cruzaXMascara(mascara, madre, padre);
            // mutamos 
                // evaluar la probabilidad
            Muta.mutaGen(pMuta, hijo);
            // agregamos
            ind.add(hijo);
        }
        // actualizamos la nueva población
        this.poblacionActual = new Poblacion(ind);
        System.out.println(g+" f:"+this.poblacionActual.getMejor().getFitness());
    }
    // pedimos el mejor a la poblacion 
    Cubo mejor  = this.poblacionActual.getMejor();
    //System.out.println(mejor.getFenotipo());
    System.out.println(mejor.getFitness());
    System.out.println(Arrays.toString(mejor.getGenotipo()));
    }
    
    public static void main(String args[]){
     GeneticoCubo gc = new GeneticoCubo(10000, 50, .35, 42,new int[]{3,3,9,9,2,7,7,4,11,11,8,8,5,5,2,11,6,6,1,7,12,10,2,2,7,3,11,11,2,2});
     gc.evolucionar();
    }
}
