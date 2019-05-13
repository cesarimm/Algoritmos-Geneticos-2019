/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Herramientas {
    
    public static double distancias [][];
    public static double inclinaciones [];
    
    public static void generarDistanciasAletorias(int numCiudades,int limDistancia){
        distancias = new double[numCiudades][numCiudades];
        Random ran = new Random();
        
        for (int x=0; x< numCiudades;x++)
            for(int y=x; y < numCiudades;y++){
              
                double dist = ran.nextInt(limDistancia)+0.1;
                if (x==y) {distancias[x][y]=0;}else{
                distancias[x][y] = dist;
                distancias[y][x] = dist;
                }
               
            }
           
    }
    
    public static void generarInclinacionesAletorias(int numCiudades,int limInclinacion){
        inclinaciones = new double[numCiudades];
        Random ran = new Random();
            for(int y=0; y < numCiudades;y++){
              
                double incli = ran.nextInt(limInclinacion)+0.1;
                
                inclinaciones[y] = incli;
               
            }
    }
    
    
    public static void cargarDistancias()  {
        FileReader archivos = null;
        try {
            String cadena;
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            archivos = new FileReader(abre);
            BufferedReader lee = new BufferedReader(archivos);
            ArrayList<ArrayList<Double>> Matriz = new ArrayList();
            if (abre != null) {
                int i=0;
              
                while ((cadena = lee.readLine()) != null) {
                    String[] datos = cadena.split(",");
                    
                    ArrayList<Double> c = new ArrayList();
                    for (int j = 0; j < datos.length; j++) {
                        c.add(Double.parseDouble(datos[j])); 
                        
                        
                    }
                    Matriz.add(c); 
                    
                    i++;
                }
                lee.close();
                
            }   distancias = new double[Matriz.size()][Matriz.size()];
            for (int i = 0; i < Matriz.size(); i++) {
                for (int j = 0; j < Matriz.get(0).size(); j++) {
                    distancias[i][j] = Matriz.get(i).get(j);
                }
                 
            }
        } catch (FileNotFoundException ex) {            
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivos.close();
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
    }
    
    
     public static void cargarInclinaciones()  {
        FileReader archivos = null;
        try {
            String cadena;
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            archivos = new FileReader(abre);
            BufferedReader lee = new BufferedReader(archivos);
            String[] datos = null;
            //ArrayList<ArrayList<Double>> Matriz = new ArrayList();
            if (abre != null) {
                int i=0;
              
                while ((cadena = lee.readLine()) != null) {
                     datos = cadena.split(",");
                }
                
                lee.close();
                
                 inclinaciones = new double[datos.length];
                    for (int j = 0; j < datos.length; j++)
                        inclinaciones[j]=Double.parseDouble(datos[j]);
            }  
            System.out.println("");
        } catch (FileNotFoundException ex) {            
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivos.close();
            } catch (IOException ex) {
                Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
    }
    
    public static void guardarDistancias(){
    
    }
    
    public static double generarCoseno(double co, double ca){     
        return Math.cos(Math.atan(co/ca));
    }
    
    public static double gastoGasolina(double cos, double dis){
        double e = (1/(0.95*0.03584)*(1304*9.8*cos+(0.3/2)*0.3*1.8*1))*dis;
        return e/59400000;
    }

}
