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
    
    
    public void evolucionar(){  
        for(int g=1;g<this.manager.getNumGeneraciones();g++){
            ArrayList<Individuo> ind=null;
            int n = (int)(this.manager.getTamPoblacion()*this.manager.getpMuestra());
            if (n>0){
            ind = new ArrayList<>();
            ind.add(this.poblacionActual.getMejor());

            }else {
            ind = new ArrayList<>();
            }
            for(int i=n; i<this.manager.getTamPoblacion();i++){
                // Seleccion
                Individuo madre = this.manager.aplicarSeleccion(poblacionActual,0);
                Individuo padre = this.manager.aplicarSeleccion(poblacionActual,1);
                // Cruza
                Individuo hijo = Cruza.cruzaXMascara(this.manager.getMask(), madre, padre);
                // Mutar de acuerdo a la probabilidad
                Muta.mutaBit(this.manager.getProbMuta(), hijo);
                //Agregar a la lista
                ind.add(hijo);
            }
           this.poblacionActual = new Poblacion(ind);
           
        Individuo mejor  = this.poblacionActual.getMejor();
        int f = mejor.getFitness();
        System.out.println("g: "+g+" f:"+f+" id:"+this.hashCode());
        
        if(this.poblacionActual.getMejor().getFitness()==550)
           break;
       }
        
        //Escribir el archivo si solo si el mejor es igual a 550, dando solucion a lo coloquialemente conocido como la aguja en e
        if(this.poblacionActual.getMejor().getFitness()==550)
            this.escribirIndividuo();
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
    
      private void escribirIndividuo(){
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

    @Override
    public void run() {
        evolucionar();
    }
    
    
}
