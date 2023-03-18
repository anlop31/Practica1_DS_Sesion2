
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ana
 */
public class Supervisor_panel extends javax.swing.JFrame implements Observer {

    private int nSimples = 0;
    private int nCompuestos = 0;
    private int simplesVendidos = 0;
    private int compuestosVendidos = 0;
    public String mensajeSimples = "NADA";
    public String mensajeCompuestos = "NADA";
    public String mensaje = mensajeSimples + mensajeCompuestos;
    
    /**
     * Creates new form Supervisor_panel
     */
    public Supervisor_panel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        simples = new java.awt.Label();
        compuestos = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        simples.setText(mensaje);

        compuestos.setText(mensajeCompuestos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(compuestos, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addComponent(simples, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(simples, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(compuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Supervisor_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supervisor_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supervisor_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supervisor_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supervisor_panel().setVisible(true);
            }
        });
    }
        @Override
    public void update(Observable o, Object arg){
        //Se le avisa de los productos disponibles en la tienda y los que ya se han vendido
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex){
            //Logger.getLogger()
        }

        // Panaderia panaderia = (Panaderia) o;
        ArrayList<Integer> datos = (ArrayList<Integer>) arg;

        nSimples = datos.get(0);
        nCompuestos = datos.get(1);
        simplesVendidos = datos.get(2);
        compuestosVendidos = datos.get(3);

        this.mensajeSimples = "El número de productos simples en stock es " + nSimples + " y el número de productos simples que ya se han vendido es " + simplesVendidos;
        this.mensajeCompuestos = "El número de productos compuestos en stock es " + nCompuestos + " y el número de productos compuestos que ya se han vendido es " + compuestosVendidos;

        mensaje = mensajeSimples + mensajeCompuestos;
        
        simples.setText(mensajeSimples);
        compuestos.setText(mensajeCompuestos);
        simples.repaint();
        // titulo_simples.revalidate();
    }


    public String getStock(){
        return ("hola" + mensajeSimples + mensajeCompuestos);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label compuestos;
    private java.awt.Label simples;
    // End of variables declaration//GEN-END:variables
}
