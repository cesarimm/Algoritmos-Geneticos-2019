/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsat;


import java.util.ArrayList;
import java.util.Arrays;


public class Manager {
    
    private String id;
    private int nG;
    private boolean ejecucion;
    private ArrayList<SATManager> geneticos;
    private ArrayList<Configuracion> configuraciones;
 
    
    public Manager (String id){
        this.nG = 0;
        this.ejecucion = false;
        this.geneticos = new ArrayList<>();
        this.configuraciones = new ArrayList<>();
        this.id = id;
    }
    
    public void generarGeneticos(ArrayList<Configuracion> configuraciones){
    // crear los geneticos en base a las configuraciones
    this.nG = configuraciones.size();
    for (int x=0; x<nG;x++){
        this.configuraciones.add(configuraciones.get(x));
        //GeneticoSAT gen = new GeneticoSAT(configuraciones.get(x));
        SATManager gen = new SATManager(configuraciones.get(x));
        this.geneticos.add(gen);
    }      
    }
    
    public void generarGeneticos(int nG){
    // crear los geneticos en base a las configuraciones
    for (int x=0; x<nG;x++){
       this.configuraciones.add(new Configuracion());
        //GeneticoSAT gen = new GeneticoSAT(configuraciones.get(x));
        SATManager gen = new SATManager(configuraciones.get(x));
        this.geneticos.add(gen);
    }
    }
    
    public void ejecutarGeneticos(){
    // ejecutar los geneticos en un hilo diferente
    for (SATManager aux: this.geneticos){
    Thread hilo = new Thread(aux);
    hilo.start();
    }
    this.ejecucion = true;
    }
    
    //Vamos a cmabia la familia de un  gentico a otro genetico
    public void setPoblacion(int conf1, int conf2){
        Poblacion pob2=this.geneticos.get(conf2).getPoblacionActual();
        ///Setear el tamaño del conf1 al conf2
        this.configuraciones.get(conf1).setTamPoblacion(this.configuraciones.get(conf2).getTamPoblacion());
        this.geneticos.get(conf1).setPoblacionActual(pob2);
          for(int i=0;i<100;i++)
            System.out.println("Cambio");
    }
    
    
    
    public void setMejor(int conf1, int conf2){
      
        Individuo ind=this.geneticos.get(conf2).getPoblacionActual().getMejor();
        this.geneticos.get(conf1).getPoblacionActual().setMejor(ind);
    }
    
    
    public void setMejores(int conf1, int conf2, int n){
      
        ArrayList<Individuo> individuos=this.geneticos.get(conf2).getPoblacionActual().getNMejores(n);
        this.configuraciones.get(conf1).setTamPoblacion(n);
        this.geneticos.get(conf1).getPoblacionActual().setMejores(individuos);
        
    }
    
    
    
    public String getInfoGenetico(int i){
        String aux="";  
        aux=this.configuraciones.get(i).getId()+" Fitness: "+
        this.geneticos.get(i).getPoblacionActual().getMejor().getFitness()+" "+Arrays.toString(this.geneticos.get(i).getPoblacionActual().getMejor().getGenotipo())+"\n";
       
        return aux;
    }
    
}
