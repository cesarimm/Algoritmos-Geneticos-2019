/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsat;

import java.util.ArrayList;
import nsat.Individuo;
import java.util.Random;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Poblacion {
    private ArrayList<Individuo> individuos;
    
     public Poblacion(int numInd) {
        this.individuos = new ArrayList<>();
        for(int x=0; x<numInd;x++)
            this.individuos.add(new Individuo());  
    }
     
     
      public Poblacion(ArrayList<Individuo> aux){
        this.individuos = (ArrayList<Individuo>)aux.clone();
    }
      
      
     public ArrayList<nsat.Individuo> getNMejores(int n){
        // validar que n <= tamaño de la población
      if(n<this.individuos.size()){
      // ordenar a la población
      ordenarPoblacionActual();
      // creamos un coleccion nueva de individuos
      ArrayList<nsat.Individuo> muestra = new ArrayList<>();
        
       for(int x=this.individuos.size()-1;x>=this.individuos.size()-n;x--){
       
       nsat.Individuo e = new nsat.Individuo(this.individuos.get(x).getGenotipo());
       muestra.add(e);
       }   
      return muestra;
      }
      
        return (ArrayList<nsat.Individuo>) this.individuos.clone();
    }
     
    public nsat.Individuo getMejor(){
        int idMejor = 0;
        for(int x=1;x<this.individuos.size();x++){
            if(this.individuos.get(x).getFitness()>this.individuos.get(idMejor).getFitness()){
            idMejor = x;
            }
        }
     return new nsat.Individuo(this.individuos.get(idMejor).getGenotipo());    
    }
    
    public ArrayList<nsat.Individuo> getMuestraAleatoria(int n){
      // validar que n <= tamaño de la población
      if(n<this.individuos.size()){
      // creamos un coleccion nueva de individuos
      ArrayList<nsat.Individuo> muestra = new ArrayList<>();
          Random ran = new Random();
       for(int x=0;x<n;x++){
       int pos = ran.nextInt(this.individuos.size());
      nsat.Individuo e = new nsat.Individuo(this.individuos.get(pos).getGenotipo());
       muestra.add(e);
       }   
      return muestra;
      }
      
        return (ArrayList<nsat.Individuo>) this.individuos.clone();
    }
 

    /**
     * @return the indivduos
     */
    public ArrayList<nsat.Individuo> getIndivduos() {
        return individuos;
    }

    private void ordenarPoblacionActual() {
     for(int z = 1; z < this.individuos.size(); ++z) {
      for(int v = 0; v < (this.individuos.size() - z); ++v) {
         
         if(this.individuos.get(v).getFitness()
                 > this.individuos.get(v+1).getFitness()){
            nsat.Individuo aux = new nsat.Individuo(this.individuos.get(v).getGenotipo());
            this.individuos.set(v,new nsat.Individuo(this.individuos.get(v+1).getGenotipo()));
            this.individuos.set(v+1,aux);
           
         }
      }
    }
            
    }
    
     public void setMejor(Individuo ind){
        this.individuos.set(0, ind);
    }
    
    
    public void setMejores(ArrayList<Individuo> individuos){
        this.individuos = individuos;
    }
    
      
      
}
