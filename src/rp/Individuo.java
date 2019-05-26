/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;


import clasificadoresSupervisados.Knn;
import equis.*;
import herramientas.GeneradorInstancias;
import java.util.ArrayList;
import java.util.Random;
import objetos.Patron;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Individuo {
    
    private int genotipo[];
    private double fitness;
    private int longitud;
    private Knn knn = new Knn(3);

    public Individuo(int longitud) {
        this.longitud=longitud;
        this.genotipo = generarGenotipoAleatorio();
        // calculamos el fenotipo 
        this.fitness = calcularFitness();
    }
    
    public Individuo(int genotipo[]){
        this.longitud = genotipo.length;
        this.genotipo = genotipo.clone();
        this.fitness =  calcularFitness() ;
    }
    
    private int[] generarGenotipoAleatorio() {
        int aux [] = new int[this.longitud];
        Random ran = new Random();
        for(int x=0; x<aux.length;x++)
            aux[x]= ran.nextInt(2);
        return aux;
    }
    
    public void actualizarIndividuo(){
    this.fitness =  calcularFitness() ;
    }

    private double calcularFitness() {
      // convertir el arreglo de bits a base 10         
          knn.entrena(GeneradorInstancias.generarInstancias(this.genotipo));
          knn.clasificaConjunto(GeneradorInstancias.generarInstancias(this.genotipo));  
      return knn.getEficacia();
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }
    /**
     * @return the fitness
     */
    public double getFitness() {
        return fitness;
    }
    
    
    
}
