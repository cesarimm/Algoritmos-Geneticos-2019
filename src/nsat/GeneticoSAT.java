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
public class GeneticoSAT {
    
    //#Generaciones, Tam Poblacion. #Probabilidad de muta, pendiente considerar una probabilidad de muestreo.
    private int tamPob, numGen;
    private double probMuta;
    private Poblacion poblacionSAT;
    
    //Crear una poblacion de individuos
    //Crear Operadores Muta, Cruza, Seleccion
    //Dentro de GeneticosSAT evolucionar el algoritmo genetico
    
    //Crear un metodo para guardar al mejor individuo o el que satisfaga los 550, dentro de un txt.
    
    public GeneticoSAT(int tamPob, int numGen, double probMuta){
        this.numGen=numGen;
        this.tamPob=tamPob;
        this.probMuta=probMuta;
        this.poblacionSAT = new Poblacion(this.tamPob);
        System.out.println("");
    }
    
    public void evolucionar(){
 
    for(int g=1;g<this.numGen;g++){
        ArrayList<Individuo> ind = new ArrayList<>();
        for(int i=0; i<this.tamPob;i++){

            Individuo madre = Seleccion.seleccionAleatoria(this.poblacionSAT);
            Individuo padre = Seleccion.seleccionAleatoria(this.poblacionSAT);
            
            int mCruza[] = new int[100];
            
            for(int j=0;j<mCruza.length;j++){
                 if(j>50)
                     mCruza[j]=1;
                 else
                     mCruza[j]=0;
            }
          
            // reproducimos
            //Individuo hijo = Cruza.cruzaXMascara(mCruza, madre, padre);
                Individuo hijo = Cruza.cruzaXMascara(new int[]{1,1,1,1,1,1,1,1,1,1,
                                                               1,1,1,1,1,1,1,1,1,1,
                                                               1,1,1,1,1,1,1,1,1,1,
                                                               1,1,1,1,1,1,1,1,1,1,
                                                               1,1,1,1,1,1,1,1,1,1,
                                                               0,0,0,0,0,0,0,0,0,0,
                                                               0,0,0,0,0,0,0,0,0,0,
                                                               0,0,0,0,0,0,0,0,0,0,
                                                               0,0,0,0,0,0,0,0,0,0,
                                                               0,0,0,0,0,0,0,0,0,0}, madre, padre);
                
            Muta.mutaBit(probMuta, hijo);
            // agregamos
            ind.add(hijo);
        }
        // actualizamos la nueva población
        //this.poblacionSAT = new Poblacion(ind);
      System.out.println(g);
    }
    // pedimos el mejor a la poblacion 
        System.out.println("El mejor");
    Individuo mejor  = this.poblacionSAT.getMejor();
    System.out.println(mejor.getFitness());
    System.out.println(Arrays.toString(mejor.getGenotipo())); 
    }

  public static void main(String args[]){
      
      Tokenizador.leerDatos();
      
      GeneticoSAT gSAT = new GeneticoSAT(50, 10000, .15);
      gSAT.evolucionar();
  }
    
}
