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
    
    public void ejecutarEscramble(int movimientos[]){
        for (int i = 0; i < movimientos.length; i++) 
          ejecutarMovimiento(movimientos[i]);     
    }
    
    public void ejecutarMovimiento(int mov){
        
        // 1 front
        // 2 front primo
        // 3 back 
        // 4 back primo
        // 5 rigth
        // 6 rigth primo
        // 7 left 
        // 8 left primo
        // 9 up 
        // 10 up primo
        // 11 down 
        // 12 down primo
        
        switch(mov){
            case 1 :
              front(false);  
            break;
            case 2 :
              front(true);  
            break;
            case 3 :
              back(false);  
            break;
            case 4 :
              back(true);  
            break;
             case 5 :
               rigth(false);  
            break;
             case 6 :
               rigth(true);  
            break;
            case 7 :
               left(false);  
            break;
            case 8: 
              left(true);  
            break;
            case 9: 
              up(false);  
            break;
             case 10: 
              up(true);  
            break;
            case 11: 
              down(false); 
                System.out.println("");
            break;   
            case 12: 
              down(true);  
            break;
            default: break;
        }
        
        System.out.println("");
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
    
    
       public void back(boolean primo){
        char aux1[], aux2[], aux3[], aux4[];
        ///Auxiliares patra guardar los valores de las caras a girar
        aux1= new char[]{orange[0], orange[3], orange[6]};
         aux2= new char[]{white[0], white[1], white[2]};
          aux3= new char[]{red[2], red[5], red[8]};
            aux4= new char[]{yellow[6], yellow[7], yellow[8]};
            
            ///Actualizacion de los valores de las caras          
            if(!primo){
             //Cara blanca
             white[0]=aux3[0];
             white[1]=aux3[1];
             white[2]=aux3[2];
             //Cara roja
             red[2]=aux4[2];
             red[5]=aux4[1];
             red[8]=aux4[0];
             //Cara amarilla
             yellow[6]=aux1[0];
             yellow[7]=aux1[1];
             yellow[8]=aux1[2];
             //Orange
             orange[0]=aux2[2];
             orange[3]=aux2[1];
             orange[6]=aux2[0];
             
             //Cara verde
             blue = actualizarCara(blue, primo); 
            }else{
              //Cara blanca
             white[0]=aux1[2];
             white[1]=aux1[1];
             white[2]=aux1[0];
             //Cara roja
             red[2]=aux2[0];
             red[5]=aux2[1];
             red[8]=aux2[2];
             //Cara amarilla
             yellow[6]=aux3[2];
             yellow[7]=aux3[1];
             yellow[8]=aux3[0];
             //Orange
             orange[0]=aux4[0];
             orange[3]=aux4[1];
             orange[6]=aux4[2]; 
             //Cara verde
             blue = actualizarCara(blue, primo); 
            }         
    }
       
    
        public void rigth(boolean primo){
        char aux1[], aux2[], aux3[], aux4[];
        ///Auxiliares patra guardar los valores de las caras a girar
        aux1= new char[]{green[2], green[5], green[8]};
         aux2= new char[]{white[2], white[5], white[8]};
          aux3= new char[]{blue[2], blue[5], blue[8]};
           aux4= new char[]{yellow[2], yellow[5], yellow[8]};
            
            ///Actualizacion de los valores de las caras          
            if(!primo){

             white[2]=aux1[0];
             white[5]=aux1[1];
             white[8]=aux1[2];
  
             blue[2]=aux2[0];
             blue[5]=aux2[1];
             blue[8]=aux2[2];
   
             yellow[2]=aux3[0];
             yellow[5]=aux3[1];
             yellow[8]=aux3[2];
   
             green[2]=aux4[0];
             green[5]=aux4[1];
             green[8]=aux4[2];
             
             red = actualizarCara(red, primo); 
            }else{
             white[2]=aux3[0];
             white[5]=aux3[1];
             white[8]=aux3[2];
  
             blue[2]=aux4[0];
             blue[5]=aux4[1];
             blue[8]=aux4[2];
   
             yellow[2]=aux1[0];
             yellow[5]=aux1[1];
             yellow[8]=aux1[2];
   
             green[2]=aux2[0];
             green[5]=aux2[1];
             green[8]=aux2[2];
             
             red = actualizarCara(red, primo);  
            }         
    }
        
      public void left(boolean primo){
        char aux1[], aux2[], aux3[], aux4[];
        ///Auxiliares patra guardar los valores de las caras a girar
        aux1= new char[]{green[0], green[3], green[6]};
         aux2= new char[]{white[0], white[3], white[6]};
          aux3= new char[]{blue[0], blue[3], blue[6]};
           aux4= new char[]{yellow[0], yellow[3], yellow[6]};
            
            ///Actualizacion de los valores de las caras          
            if(!primo){
             white[0]=aux3[0];
             white[3]=aux3[1];
             white[6]=aux3[2];
  
             blue[0]=aux4[0];
             blue[3]=aux4[1];
             blue[6]=aux4[2];
   
             yellow[0]=aux1[0];
             yellow[3]=aux1[1];
             yellow[6]=aux1[2];
   
             green[0]=aux2[0];
             green[3]=aux2[1];
             green[6]=aux2[2];
             
             orange = actualizarCara(orange, primo); 
            }else{
             white[0]=aux1[0];
             white[3]=aux1[1];
             white[6]=aux1[2];
  
             blue[0]=aux2[0];
             blue[3]=aux2[1];
             blue[6]=aux2[2];
   
             yellow[0]=aux3[0];
             yellow[3]=aux3[1];
             yellow[6]=aux3[2];
   
             green[0]=aux4[0];
             green[3]=aux4[1];
             green[6]=aux4[2];
             
             orange = actualizarCara(orange, primo);
            }         
    } 
      
      
      public void up(boolean primo){
        char aux1[], aux2[], aux3[], aux4[];
        ///Auxiliares patra guardar los valores de las caras a girar
        aux1= new char[]{green[0], green[1], green[2]};
         aux2= new char[]{red[0], red[1], red[2]};
          aux3= new char[]{blue[6], blue[7], blue[8]};
           aux4= new char[]{orange[0], orange[1], orange[2]};
            
            ///Actualizacion de los valores de las caras          
            if(!primo){
                
             green[0]=aux2[0];
             green[1]=aux2[1];
             green[2]=aux2[2];
             
             red[0]=aux3[2];
             red[1]=aux3[1];
             red[2]=aux3[0];
  
             blue[6]=aux4[2];
             blue[7]=aux4[1];
             blue[8]=aux4[0];
   
             orange[0]=aux1[0];
             orange[1]=aux1[1];
             orange[2]=aux1[2];
    
             white = actualizarCara(white, primo); 
            }else{
                ////AQUI
             green[0]=aux4[0];
             green[1]=aux4[1];
             green[2]=aux4[2];
             
             red[0]=aux1[0];
             red[1]=aux1[1];
             red[2]=aux1[2];
  
             blue[6]=aux2[2];
             blue[7]=aux2[1];
             blue[8]=aux2[0];
   
             orange[0]=aux3[2];
             orange[1]=aux3[1];
             orange[2]=aux3[0];
    
             white = actualizarCara(white, primo); 
            }         
    }    
      
    public void down(boolean primo){
        char aux1[], aux2[], aux3[], aux4[];
        ///Auxiliares patra guardar los valores de las caras a girar
        aux1= new char[]{green[6], green[7], green[8]};
         aux2= new char[]{red[6], red[7], red[8]};
          aux3= new char[]{blue[0], blue[1], blue[2]};
           aux4= new char[]{orange[6], orange[7], orange[8]};
            
            ///Actualizacion de los valores de las caras          
            if(!primo){
             green[6]=aux4[0];
             green[7]=aux4[1];
             green[8]=aux4[2];
             
             red[6]=aux1[0];
             red[7]=aux1[1];
             red[8]=aux1[2];
  
             blue[0]=aux2[2];
             blue[1]=aux2[1];
             blue[2]=aux2[0];
   
             orange[6]=aux3[2];
             orange[7]=aux3[1];
             orange[8]=aux3[0];
    
             yellow = actualizarCara(yellow, primo); 
            }else{
             green[6]=aux2[0];
             green[7]=aux2[1];
             green[8]=aux2[2];
             
             red[6]=aux3[2];
             red[7]=aux3[1];
             red[8]=aux3[0];
  
             blue[0]=aux4[2];
             blue[1]=aux4[1];
             blue[2]=aux4[0];
   
             orange[6]=aux1[0];
             orange[7]=aux1[1];
             orange[8]=aux1[2];
    
             yellow = actualizarCara(yellow, primo); 
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
        
        // 1 front
        // 2 front primo
        // 3 back 
        // 4 back primo
        // 5 rigth
        // 6 rigth primo
        // 7 left 
        // 8 left primo
        // 9 up 
        // 10 up primo
        // 11 down 
        // 12 down primo
        
     Cubo c = new Cubo();
//     c.left(true);
//        System.out.println("");
//     c.up(false);
//        System.out.println("");
//     c.down(false);
       //Errror en 11 = down
        c.ejecutarEscramble(new int[]{5,5,1,1,5,5,9,5,5,3,3,11,9,9,7,7,10,5,11,11,9,1,6,3,3,10,1,10,5,5});
        System.out.println("");
    }
    
}
