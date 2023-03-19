import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ana
 */
public class main {
    public static void main(String [] args){
        // Observable
        Panaderia panaderia = new Panaderia();
        
        // Observers
        Supervisor supervisor = new Supervisor();
        Analista analista = new Analista();
        
        // Threads
        Thread threadSupervisor = new Thread(panaderia);
        Thread threadAnalista = new Thread(panaderia);
        
        //Número de productos para el cliente (MEJOR UN GET EN PANADERIA)
        ArrayList<Integer> datos = new ArrayList<>();
        
        
        /**** PRUEBA PANELES ****/
        
        //JFrame ventana = new JFrame(); // crea una ventana
        //ventana.add(panel); // agrega la instancia del panel al contenedor principal
        supervisor.setTitle("Panaderia (supervisor)");
        supervisor.setSize(300, 200);
        supervisor.setLocationRelativeTo(null);
        supervisor.setVisible(true); // muestra la ventana
        

        
        analista.setTitle("Panaderia (analista)");
        analista.setSize(300, 200);
        analista.setLocationRelativeTo(null);
        analista.setVisible(true); // muestra la ventana
        
        /*********************/
        
        // Añadimos los observadores a la panaderia
        /* Analista se suscribe a la panaderia */
        panaderia.adscribir(analista);
        
        
        // Iniciamos los threads
        threadSupervisor.start();
        threadAnalista.start();        
        
        while(threadSupervisor.isAlive()){
            // actualizamos los datos
            datos.add(panaderia.getNSimples());
            datos.add(panaderia.getNCompuestos());
            datos.add(panaderia.getSimplesVendidos());
            datos.add(panaderia.getCompuestosVendidos());
            
            supervisor.update(panaderia, datos); // mandamos los datos
            
            //System.out.println("mensajeSimples: " + sup.mensajeSimples);
            System.out.println("--->mensajeSimples(analista): " + analista.mensajeSimples);
            
            datos.clear(); // Lo limpiamos para luego meter nuevos datos actualizados
        }
        
        
    }
}
