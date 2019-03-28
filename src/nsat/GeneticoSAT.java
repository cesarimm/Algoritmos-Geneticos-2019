/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsat;

import java.io.File;
import java.io.FileWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//
///**
// *
// * @author CESAR IVAN MTZ
// */
//public class GeneticoSAT implements Runnable{
//    
////    //#Generaciones, Tam Poblacion. #Probabilidad de muta, pendiente considerar una probabilidad de muestreo.
////    private int tamPob, numGen;
////    private double probMuta;
////    private Poblacion poblacionSAT;
////    private int mask[];
////    
////    //Crear una poblacion de individuos
////    //Crear Operadores Muta, Cruza, Seleccion
////    //Dentro de GeneticosSAT evolucionar el algoritmo genetico
////    
////    //Crear un metodo para guardar al mejor individuo o el que satisfaga los 550, dentro de un txt.
////    
////    public GeneticoSAT(int tamPob, int numGen, double probMuta){
////        this.numGen=numGen;
////        this.tamPob=tamPob;
////        this.probMuta=probMuta;
////        this.poblacionSAT = new Poblacion(this.tamPob);
////        this.mask = Cruza.generarMascaraAleatoria(100);
////        System.out.println("");
////    }
//    
//    private Poblacion poblacionActual;
//    private Configuracion manager;
//
//    
//
//    public GeneticoSAT(Configuracion manager) {
//        this.manager = manager;
//        this.poblacionActual = new Poblacion(this.manager.getTamPoblacion());
//        
//    }
//    
//       public void evolucionar(){
//    ///int mask2[] = Cruza.generarMascaraAleatoria(100);
//    Individuo mejor = null;
//    // generar las itereaciones para las generaciones
//    for(int g=1;g<this.manager.getNumGeneraciones();g++){
//        
//        // garantizar construir una nueva población
//        ArrayList<Individuo> ind;
//        // calcular un N
//        int n = (int)(this.manager.getTamPoblacion()*this.manager.getpMuestra());
//        if (n>0){
//        ind = new ArrayList<>();
//        ind.add(this.poblacionActual.getMejor());
//        
//        }else {
//        ind = new ArrayList<>();
//        }  
//       
//    
//         for(int i=n; i<this.manager.getTamPoblacion();i++){
//            // seleccionamos
//            Individuo madre = this.manager.aplicarSeleccion(poblacionActual,0);
//            Individuo padre = this.manager.aplicarSeleccion(poblacionActual,1);
//            // reproducimos
//            Individuo hijo = Cruza.cruzaXMascara(this.manager.getMask(), madre, padre);
//            // mutamos 
//            // evaluar la probabilidad
//            Muta.mutaBit(this.manager.getProbMuta(), hijo);
//            // agregamos
//            ind.add(hijo);
//        }
//        // actualizamos la nueva población
//        this.poblacionActual = new Poblacion(ind);
//       // pedimos el mejor a la poblacion 
//       mejor  = this.poblacionActual.getMejor();
//       System.out.println(g+": "+mejor.getFitness()+" "+this.manager.toString());
//       
//       if(this.poblacionActual.getMejor().getFitness()==550)
//           break;
//    }
//    
//    System.out.println(mejor.getFitness());
//    System.out.println(Arrays.toString(mejor.getGenotipo()));
//        if(this.poblacionActual.getMejor().getFitness()==550)
//            this.escribirIndividuo();
//   }
//    
//    
//    public void escribirIndividuo(){
//        
//       // java.util.Date fecha = new Date();
//       // System.out.println (fecha);   
//        try {
//            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
//            File archivo = new File("Geno550.txt");
//
//            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
//            FileWriter escribir = new FileWriter(archivo, true);
//
//
//            //Escribimos en el archivo con el metodo write 
//            escribir.write(Arrays.toString(this.poblacionActual.getMejor().getGenotipo()));
//         
//            //Cerramos la conexion
//            escribir.close();
//        } //Si existe un problema al escribir cae aqui
//        catch (Exception e) {
//            System.out.println("Error al escribir");
//        }
//    }
//
//        public Configuracion getManager() {
//        return manager;
//    }
//
//    
//    public Poblacion getPoblacionActual() {
//        return poblacionActual;
//    }
//
//    public void setPoblacionActual(Poblacion poblacionActual) {
//        this.poblacionActual = poblacionActual;
//    }
//    
//      @Override
//    public void run() {
//           evolucionar();
//    }
//    
//
//}


import nsat.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Roberto Cruz Leija
 */
public class GeneticoSAT {
    
    // parametros
    private Poblacion poblacionActual;
    private int numG,tamP;
    private double pMuta;
    private Configuracion manager;

    public GeneticoSAT(int numG, int tamP, double pMuta) {
        this.numG = numG;
        this.tamP = tamP;
        this.pMuta = pMuta;
        this.poblacionActual = new Poblacion(tamP);
    }
    
   public void evolucionar(){
       
   int mask[] = Cruza.generarMascaraAleatoria(100);
  
    Individuo mejor = null;

    for(int g=1;g<this.numG;g++){  
        // garantizar construir una nueva población
        ArrayList<Individuo> ind = new ArrayList<>(); 
        
         for(int i=0; i<this.tamP;i++){
            // seleccionamos
           Individuo madre = Seleccion.seleccionTorneo(this.poblacionActual);
           Individuo padre = Seleccion.seleccionAleatoria(this.poblacionActual);
            // reproducimos
             Individuo hijo = Cruza.cruzaXMascara(mask, madre, padre);
            // mutamos 
            // evaluar la probabilidad
            Muta.mutaBit(this.pMuta, hijo);
            // agregamos
            ind.add(hijo);
        }
        // actualizamos la nueva población
        this.poblacionActual = new Poblacion(ind);
       // pedimos el mejor a la poblacion 
       mejor  = this.poblacionActual.getMejor();
       System.out.println(g+": "+mejor.getFitness());
       
       if(this.poblacionActual.getMejor().getFitness()==550)
           break;
    }
    
    System.out.println(mejor.getFitness());
    System.out.println(Arrays.toString(mejor.getGenotipo()));
        if(this.poblacionActual.getMejor().getFitness()==550)
            this.escribirIndividuo();
   }
    
     
     
    public void evolucionar2(){
    int mask[] = Cruza.generarMascaraAleatoria(100);
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
            Individuo hijo = Cruza.cruzaXMascara(mask, madre, padre);
            // mutamos 
                // evaluar la probabilidad
            Muta.mutaBit(pMuta, hijo);
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
   
    
      public void escribirIndividuo(){
            try {
                //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
                File archivo = new File("Geno550.txt");

                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(archivo, true);


                //Escribimos en el archivo con el metodo write 
                escribir.write(Arrays.toString(this.poblacionActual.getMejor().getGenotipo()));

                //Cerramos la conexion
                escribir.close();
            } //Si existe un problema al escribir cae aqui
            catch (Exception e) {
                System.out.println("Error al escribir");
            }
    }

    private void mejor() {
       Individuo i = new Individuo(new int[]{0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0});
       this.poblacionActual.getIndivduos().add(i);
    }
    
}
