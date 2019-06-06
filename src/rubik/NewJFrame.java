/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class NewJFrame extends javax.swing.JFrame {
    GeneticoCubo gc;
    
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
//        p = new Poblacion(int numInd, int tam, int[] escramble);
      //  gc = new GeneticoCubo(10000, 50, .35, 42,new int[]{3,3,9,9,2,7,7,4,11,11,8,8,5,5,2,11,6,6,1,7,12,10,2,2,7,3,11,11,2,2});
        iniciarCliente();
//        gc.run();
    }
    
    Socket socketCliente = null;
    BufferedReader entrada = null;
    PrintWriter salidaCl = null;
    int jugador;
    
    public void iniciarCliente(){
        System.out.println("cliente iniciado");
        try {
            String host = JOptionPane.showInputDialog("Ingrese una ip");
            socketCliente = new Socket(host, 5000);
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            salidaCl = new PrintWriter(new BufferedWriter(new 
            OutputStreamWriter(socketCliente.getOutputStream())),true);
            jugador=Integer.parseInt(entrada.readLine());
            System.out.println("Jugador: "+jugador);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void enviar(){
        System.out.println("Envio");
        int i=0;
        String linea = gc.getPoblacionActual().getMejor().toString();
        salidaCl.println(linea);
        try {
            refresh();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            espera();
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    boolean esNumero(char c){
        return c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9';
    }
    
    boolean esColor(char c){
        return c=='b' || c=='g' || c=='o' || c=='r' || c=='w' || c=='y';
    }
    
    public char[][] stringMask(String linea){
        char[][] aux = new char[6][9];
        int k=0;
        for(int i=0; i<6; i++){
            int j=0;
            while(j<9){
                if(esColor(linea.charAt(k))){
                    aux[i][j]=linea.charAt(k);
                    j++;
                }
                k++;
            }
        }
        return aux;
    }
    
    public int[] stringGen(String linea){
        int l=0;
        for(int j=0; j<linea.length(); j++){
            if(linea.charAt(j)=='='){
                l=j+1;
                break;
            }
        }
        int[] aux = new int[linea.length()+1];
        int k=0;
        for(int i=l; i<linea.length()-1; i++){
            if(linea.charAt(i)=='[' || linea.charAt(i)==' ' || linea.charAt(i)==','){
                
            }else{
                String tmp="";
                while(esNumero(linea.charAt(i))){
                    tmp+=linea.charAt(i);
                    i++;
                }
                aux[k]=Integer.parseInt(tmp);
                k++;
            }
        }
        int n=0;
        for(int m=0; m<aux.length; m++){
            if(aux[m]==0){
                n=m;
                break;
            }
        }
        int[] aux2 = new int[n];
        for(int o=0; o<n; o++){
            aux2[o]=aux[o];
        }
        return aux2;
    } 
    
    public void refresh() throws IOException{
        System.out.println("Refresco");
        int r=0;
        String linea = entrada.readLine();
        int[] genotipoExterno = stringGen(linea);
        char[][] mask = stringMask(linea);
        // Cubo(int [] genotipo, char[][] mascaras)
        Cubo c = new Cubo(genotipoExterno, mask);
        gc.getPoblacionActual().setIndividuo(c);
    }
    
    public void espera() throws IOException{
        System.out.println("Refresco");
        String linea = "";
        while("".equals(linea)){
            linea=entrada.readLine();
        }
        int[] genotipoExterno = stringGen(linea);
        char[][] mask = stringMask(linea);
        // Cubo(int [] genotipo, char[][] mascaras)
        Cubo c = new Cubo(genotipoExterno, mask);
        gc.getPoblacionActual().setIndividuo(c);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 125, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.jTextArea1.setText(gc.getPoblacionActual().getMejor().toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        enviar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        gc.run();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
