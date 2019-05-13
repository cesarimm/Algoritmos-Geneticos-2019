/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Grafica {
    
    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String titulo;
    private String tituloEjeX;
    private String tituloEjeY;

    public Grafica(String titulo,
                   String tituloEjeX,
                   String tituloEjeY) {
        this.titulo = titulo;
        this.tituloEjeX = tituloEjeX;
        this.tituloEjeY = tituloEjeY;
        this.grafica = null;
        this.series = new XYSeriesCollection();
     }
    
    public void crearSerie(String nombre){
        XYSeries serie = new XYSeries(nombre);
        this.series.addSeries(serie);
      
    }
    
       public void crearPuntoASerie(String nombre, double x, double y){
      
        this.series.getSeries(nombre).add(x, y);
      
    }
    public void agregarSerie(String id,int [] frecuencias){
        XYSeries serie = new XYSeries(id);
        for (int x=0; x<frecuencias.length;x++){
             serie.add(x,frecuencias[x]);
        }
       
        this.series.addSeries(serie);
    }
    
     
    public void crearGrafica(){
    this.grafica = ChartFactory.createScatterPlot(titulo,tituloEjeX, tituloEjeY, series);
        ChartFrame panel = new ChartFrame("Tiempos",grafica);
        panel.setVisible(true);
    }
    public void crearGraficaPuntos(){
    this.grafica = ChartFactory.createScatterPlot(titulo, titulo, titulo, series);
            
        ChartFrame panel = new ChartFrame("Tiempos",grafica);
        panel.setVisible(true);
    }
    
    public static void main(String args[]){
        Random r = new Random();
        String aux = "";
        for(int i=0;i<1000/20;i++)
            aux+=(r.nextInt(200))+",";
        
        
          try {
                //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
                File archivo = new File("20inc.txt");

                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(archivo, true);


                //Escribimos en el archivo con el metodo write 
                escribir.write(aux);

                //Cerramos la conexion
                escribir.close();
            } //Si existe un problema al escribir cae aqui
            catch (Exception e) {
                System.out.println("Error al escribir");
            }
        System.out.println(aux);
    }
    
}
