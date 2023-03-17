import java.util.ArrayList;
import java.util.Random;

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

        Panaderia panaderia = new Panaderia();
        Supervisor supervisor = new Supervisor();
        Analista analista = new Analista();
        
        Thread threadSupervisor = new Thread(panaderia);
        Thread threadAnalista = new Thread(panaderia);
        
        
        //Número de productos para el cliente (MEJOR UN GET EN PANADERIA)
        ArrayList<Integer> datos = new ArrayList<>();

        // PROBANDO
        for (int i = 0; i < 10; i++){ // 10 barras de pan
            ProductoSimple pan = new ProductoSimple();
            panaderia.meterSimple(pan);
        }
        for(int i = 0; i<15; i++){ // 15 cestas
            ProductoCompuesto cesta = new ProductoCompuesto();
            panaderia.meterCompuesto(cesta);
        }

        // Añadimos los observadores a la panaderia
        // UNO DE ESTOS TIENE QUE SER SUSCRITO Y OTRO NO SUSCRITO
        // Supervisor no suscrito al tener el while true?
        /* Supervisor */
        panaderia.addObserver(supervisor);
        /* Analista */
        panaderia.addObserver(analista);
        
        
        // Iniciamos los threads
        threadSupervisor.start();
        threadAnalista.start();
        
        if(threadSupervisor.isAlive())
            System.out.println("thread supervisor vivo");
        
        while(threadSupervisor.isAlive()){
            // actualizamos los datos
            datos.add(panaderia.getNSimples());
            datos.add(panaderia.getNCompuestos());
            datos.add(panaderia.getSimplesVendidos());
            datos.add(panaderia.getCompuestosVendidos());
            
            supervisor.update(panaderia, datos); // mandamos los datos
            supervisor.getStock();
            datos.clear(); // Lo limpiamos para luego meter nuevos datos actualizados
        }
    }
}
