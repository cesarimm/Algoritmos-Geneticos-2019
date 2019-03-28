/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsat;



public class Configuracion {
   private int numGeneraciones;
   private int tamPoblacion;
   private double probMuta;
   private double pMuestra;
   private int mask[];
   private Seleccion.TipoSeleccion tipoSeleccion[];
   private String id;
   
   
    public Configuracion(String id, int numGeneraciones, int tamPoblacion, double probMuta, double pMuestra, Seleccion.TipoSeleccion[] tipoSeleccion) {
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.probMuta = probMuta;
        this.pMuestra = pMuestra;
        this.mask = Cruza.generarMascaraAleatoria(100);
        this.tipoSeleccion = tipoSeleccion;
        this.id=id;
    }
   
    public Configuracion(int numGeneraciones, int tamPoblacion, double probMuta, double pMuestra, Seleccion.TipoSeleccion[] tipoSeleccion) {
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.probMuta = probMuta;
        this.pMuestra = pMuestra;
        this.mask = Cruza.generarMascaraAleatoria(100);
        this.tipoSeleccion = tipoSeleccion;
        id="";
    }
    
   public Configuracion() {
        this.numGeneraciones = 10000;
        this.tamPoblacion = 50;
        this.probMuta = 0.2;
        this.pMuestra = 0.2;
        this.mask = Cruza.generarMascaraAleatoria(100);
        this.tipoSeleccion = new Seleccion.TipoSeleccion[]{Seleccion.TipoSeleccion.TORNEO,Seleccion.TipoSeleccion.RANDOM};
        id="";
    }
   
   
   public Individuo aplicarSeleccion(Poblacion pobActual, int i){
       Individuo aux = null; 
       switch(getTipoSeleccion()[i]){
           case RANDOM:{
             aux = Seleccion.seleccionAleatoria(pobActual);
           break;}
           case TORNEO:{
             aux = Seleccion.seleccionTorneo(pobActual);
           break;}   
           default: aux = null;
           
       }
   return aux;
   }

   
    public int getNumGeneraciones() {
        return numGeneraciones;
    }

    
    public void setNumGeneraciones(int numGeneraciones) {
        this.numGeneraciones = numGeneraciones;
    }

   
    public int getTamPoblacion() {
        return tamPoblacion;
    }

  
    public void setTamPoblacion(int tamPoblacion) {
        this.tamPoblacion = tamPoblacion;
    }

   
    public double getProbMuta() {
        return probMuta;
    }

    public void setProbMuta(double probMuta) {
        this.probMuta = probMuta;
    }

   
    public double getpMuestra() {
        return pMuestra;
    }

   
    public void setpMuestra(double pMuestra) {
        this.pMuestra = pMuestra;
    }

   
    public int[] getMask() {
        return mask;
    }

   
    public void setMask(int[] mask) {
        this.mask = mask;
    }

  
    public Seleccion.TipoSeleccion[] getTipoSeleccion() {
        return tipoSeleccion;
    }

    
    public void setTipoSeleccion(Seleccion.TipoSeleccion[] tipoSeleccion) {
        this.tipoSeleccion = tipoSeleccion;
    }

  
    public String getId() {
        return id;
    }
      
}
