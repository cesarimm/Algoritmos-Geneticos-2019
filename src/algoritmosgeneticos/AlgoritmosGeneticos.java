/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import equiscuadrada.GeneticoX2;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class AlgoritmosGeneticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneticoX2 x2 = new GeneticoX2(100,50,0.3);
        x2.evolucionar();
    }
    
}
