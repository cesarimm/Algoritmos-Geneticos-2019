/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsat;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class GeneticoSAT {
    
    //#Generaciones, Tam Poblacion. #Probabilidad de muta, pendiente considerar una probabilidad de muestreo.
    private int tamPob, numGen;
    private double probMuta;
    private Poblacion poblacionSAT;
    private int mask[];
    
    //Crear una poblacion de individuos
    //Crear Operadores Muta, Cruza, Seleccion
    //Dentro de GeneticosSAT evolucionar el algoritmo genetico
    
    //Crear un metodo para guardar al mejor individuo o el que satisfaga los 550, dentro de un txt.
    
    public GeneticoSAT(int tamPob, int numGen, double probMuta){
        this.numGen=numGen;
        this.tamPob=tamPob;
        this.probMuta=probMuta;
        this.poblacionSAT = new Poblacion(this.tamPob);
        this.mask = Cruza.generarMascaraAleatoria(100);
        System.out.println("");
    }
    
       public void evolucionar(){
    int mask2[] = Cruza.generarMascaraAleatoria(100);
    Individuo mejor = null;
    // generar las itereaciones para las generaciones
    for(int g=1;g<this.numGen;g++){
        // garantizar construir una nueva población
        ArrayList<Individuo> ind = new ArrayList<>();
        for(int i=0; i<this.tamPob;i++){
            // seleccionamos
            Individuo madre = Seleccion.seleccionTorneo(this.poblacionSAT);
            Individuo padre = Seleccion.seleccionAleatoria(this.poblacionSAT);
            
            // reproducimos
            Individuo hijo = Cruza.cruzaXMascara(mask2, madre, padre);
            // mutamos 
                // evaluar la probabilidad
            Muta.mutaBit(probMuta, hijo);
            // agregamos
            ind.add(hijo);
        }
        // actualizamos la nueva población
        this.poblacionSAT = new Poblacion(ind);
       // pedimos el mejor a la poblacion 
       mejor  = this.poblacionSAT.getMejor();
       System.out.println(g+": "+mejor.getFitness());
       if(this.poblacionSAT.getMejor().getFitness()==550)
           break;
    }
    
    System.out.println(mejor.getFitness());
    System.out.println(Arrays.toString(mejor.getGenotipo()));
        if(this.poblacionSAT.getMejor().getFitness()==550)
            this.escribirIndividuo();
       }
    
    
    public void escribirIndividuo(){
        
       // java.util.Date fecha = new Date();
       // System.out.println (fecha);   
        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("Geno550.txt");

            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);


            //Escribimos en el archivo con el metodo write 
            escribir.write(Arrays.toString(this.poblacionSAT.getMejor().getGenotipo()));
         
            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

  public static void main(String args[]){
      Tokenizador.leerDatos();
      
      GeneticoSAT gSAT = new GeneticoSAT(100, 100000, .25);
      gSAT.evolucionar();
      
  }
    
}

