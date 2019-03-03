/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import equis.GeneticoX;



/**
 *
 * @author CESAR IVAN MTZ
 */
public class AlgoritmoX { 
    public static void main(String args[]){
        GeneticoX x = new GeneticoX(650,3,0.9);
        x.evolucionar();
    }
}
