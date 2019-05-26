/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Cubo {
    
    private char white[], green[], yellow[], blue[], red[], orange[];
    
    public Cubo(){
        white = new char[]{'w','w','w','w','w','w','w','w','w'};
        green = new char[]{'g','g','g','g','g','g','g','g','g'};
        yellow = new char[]{'y','y','y','y','y','y','y','y','y'};
        blue = new char[]{'b','b','b','b','b','b','b','b','b'};
        red = new char[]{'r','r','r','r','r','r','r','r','r'};
        orange = new char[]{'o','o','o','o','o','o','o','o','o'};
    }
    
    public void front(boolean primo){
        char aux1[], aux2[], aux3[], aux4[];
        ///Auxiliares patra guardar los valores de las caras a girar
        aux1= new char[]{orange[2], orange[5], orange[8]};
         aux2= new char[]{white[6], white[7], white[8]};
          aux3= new char[]{red[0], red[3], red[6]};
            aux4= new char[]{yellow[0], yellow[1], yellow[2]};
            
            ///Actualizacion de los valores de las caras
            
            if(!primo){
             //Cara blanca
             white[6]=aux1[2];
             white[7]=aux1[1];
             white[8]=aux1[0];
             //Cara roja
             red[0]=aux2[0];
             red[3]=aux2[1];
             red[6]=aux2[2];
             //Cara amarilla
             yellow[0]=aux3[2];
             yellow[1]=aux3[1];
             yellow[2]=aux3[0];
             //Orange
             orange[2]=aux4[0];
             orange[5]=aux4[1];
             orange[8]=aux4[2];
             
             //Cara verde
             green = actualizarCara(green, primo); 
            }else{
             //Cara blanca
             white[6]=aux3[0];
             white[7]=aux3[1];
             white[8]=aux3[2];
             //Cara roja
             red[0]=aux4[2];
             red[3]=aux4[1];
             red[6]=aux4[0];
             //Cara amarilla
             yellow[0]=aux1[0];
             yellow[1]=aux1[1];
             yellow[2]=aux1[2];
             //Orange
             orange[2]=aux2[2];
             orange[5]=aux2[1];
             orange[8]=aux2[0];
             
             //Cara verde
             green = actualizarCara(green, primo); 
            }         
    }

    
    private char[] actualizarCara(char[] green, boolean primo) {
        char arreglo[] = new char[9];
        if(!primo){
        arreglo[0] = green[6];
        arreglo[1] = green[3];
        arreglo[2] = green[0];
        arreglo[3] = green[7];
        arreglo[4] = green[4];
        arreglo[5] = green[1];
        arreglo[6] = green[8];
        arreglo[7] = green[5];
        arreglo[8] = green[2];
        }else{
        arreglo[0] = green[2];
        arreglo[1] = green[5];
        arreglo[2] = green[8];
        arreglo[3] = green[1];
        arreglo[4] = green[4];
        arreglo[5] = green[7];
        arreglo[6] = green[0];
        arreglo[7] = green[3];
        arreglo[8] = green[6];    
        }     
        return arreglo;
    }
    
    public static void main(String args[]){
     Cubo c = new Cubo();
     c.front(false);
     c.front(true);
       System.out.println("");
    }
    
}
