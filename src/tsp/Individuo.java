/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;


import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Individuo {
    
    private int genotipo[];
    private double fitnessDistancia;
    private double fitnessInclinacion;
    private double fitnessGeneral;
    private double fitnessGasolina;
    private int n;
    private int ci;
    

    public Individuo(int n, int ci) {
        this.n = n;
        this.ci = ci;
        generarGenotipoAleatorio();
        calcularFitnessDistancia();
        calcularFitnessGeneral();
        calcularGastoCombustible();
    }
    
    public Individuo(int genotipo[]){
         this.n = genotipo.length;
         this.ci = genotipo[0];
         this.genotipo = genotipo.clone();
         calcularFitnessDistancia();
         calcularFitnessInclinacion();
         calcularFitnessGeneral();
         calcularGastoCombustible();
    }
    
    private void generarGenotipoAleatorio() {
       this.genotipo = new int[this.n];
        ArrayList<Integer> lista = new ArrayList<>();
        Random ran = new Random();
        // inicializar 
       
        for(int x=0; x<this.genotipo.length;x++){
            if(x!=this.ci)
            lista.add(x);
        }
         this.genotipo[0]=this.ci;
        for(int x=1; x<this.genotipo.length;x++){
             int i = ran.nextInt(lista.size());
             this.genotipo[x]=lista.remove(i);
        }     
    }
    
    
    public void actualizarIndividuo(){ 
       calcularFitnessDistancia();
       calcularFitnessInclinacion();
       calcularFitnessGeneral();
       calcularGastoCombustible();
    }
   

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }


    /**
     * @return the fitnessDistancia
     */
    public double getFitnessDistancia() {
        return fitnessDistancia;
    }
    private void calcularFitnessInclinacion(){
        
        // recorrer el individudo y consultamos las inclinaciones
        for (int x=0 ; x<this.genotipo.length-1;x++){
            this.fitnessInclinacion+=Herramientas.inclinaciones[this.genotipo[x+1]]-Herramientas.inclinaciones[this.genotipo[x]];
        }
     // agregamos la inclinacion de la ultima a la inicial
         this.fitnessInclinacion+=Herramientas.inclinaciones[this.genotipo[this.genotipo.length-1]]-Herramientas.inclinaciones[this.genotipo[0]];
    
    }
    
    private void calcularFitnessDistancia() {
       int ultima = this.genotipo[this.n-1];
       int primera = this.genotipo[0];
       this.fitnessDistancia = Herramientas.distancias[primera][ultima];
      // recorremos el genotipo
      for(int x=0;x<this.n-1;x++){
         this.fitnessDistancia += Herramientas.distancias[this.genotipo[x]][this.genotipo[x+1]];
      
      }
     }
    
    private void calcularGastoCombustible(){  
        //Inclinacion CATETO OPUESTO
        //Distancia CATETO ADYACENTE
        int ultima = this.genotipo[this.n-1];
        int primera = this.genotipo[0];
        double inclinacion, distancia;
        
         inclinacion=Herramientas.inclinaciones[primera]-Herramientas.inclinaciones[ultima];
         distancia=Herramientas.distancias[primera][ultima];
       
         this.fitnessGasolina = Herramientas.gastoGasolina(Herramientas.generarCoseno(inclinacion, distancia), Math.sqrt(Math.pow(distancia, 2)+Math.pow(inclinacion, 2)));
         
          for(int x=0;x<this.n-1;x++){
           distancia= Herramientas.distancias[this.genotipo[x]][this.genotipo[x+1]];
           inclinacion= Herramientas.inclinaciones[this.genotipo[x]]-Herramientas.inclinaciones[this.genotipo[x+1]];
           this.fitnessGasolina+=Herramientas.gastoGasolina(Herramientas.generarCoseno(inclinacion, distancia), Math.sqrt(Math.pow(distancia, 2)+Math.pow(inclinacion, 2)));
         } 
         
    }

    /**
     * @return the fitnessInclinacion
     */
    public double getFitnessInclinacion() {
        return fitnessInclinacion;
    }
     
    private void calcularFitnessGeneral(){
        // 1er Forma 
        //this.fitnessGeneral = (0.5)*Math.abs(fitnessDistancia)+(0.2)*Math.abs(fitnessInclinacion);
        this.fitnessGeneral = ((0.5)*this.fitnessDistancia)+((0.2)*fitnessInclinacion); 
    }

    /**
     * @return the fitnessGeneral
     */
    public double getFitnessGeneral() {
        return fitnessGeneral;
    }
    
    
}
