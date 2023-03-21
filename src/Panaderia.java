import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;

public class Panaderia extends Observable implements Runnable{

    /*
    Panaderia : se encarga de instanciar los objetos y notificar
    al observador las cantidades
    */
    
    Random rand = new Random();

    private int nSimples;
    private int nCompuestos;
    private int nProd;
    private int simplesVendidos;
    private int compuestosVendidos;
    
    //arrays de productos
    ArrayList<Producto> stockSimples;
    ArrayList<Producto> stockCompuestos;
    
    //array de suscriptores
    ArrayList<Observer> observadores;

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public Panaderia(){
        stockSimples = new ArrayList<>();
        stockCompuestos = new ArrayList<>();
        observadores = new ArrayList<>();
        simplesVendidos = 0;
        compuestosVendidos = 0;
        
        inicializarProductos();

    }
    
    public void inicializarProductos(){

        //Genera las cantidades de productos de cada tipo
        //y añade dicha cantidad de productos al arraylist correspondiente

        nSimples = rand.nextInt(20)+10;
        nCompuestos = rand.nextInt(20)+10;
        nProd = nSimples + nCompuestos;
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               setChanged();
               notifyObservers();
            }
        });
        
        for (int i = 0; i < nSimples; i++){
            this.stockSimples.add(new ProductoSimple());
        }
        for (int i = 0; i < nCompuestos; i++){
            this.stockCompuestos.add(new ProductoCompuesto());
        }

        System.out.println("Se inicializa con " + nSimples + " productos simples y " + nCompuestos + " compuestos.");
    }
    
    public void adscribir(Observer observador){
        addObserver(observador);
        observadores.add(observador);
    }
    
    public void quitar(Observer observador){
        observadores.remove(observador); 
    }
    
    //Getters  
    public int getNSimples(){
        return nSimples;
    }

    public int getNCompuestos(){
        return nCompuestos;
    }

    public int getSimplesVendidos(){
        return simplesVendidos;
    }

    public int getCompuestosVendidos(){
        return compuestosVendidos;
    }
       

    public void venderSimple(int n){
        if (nSimples <= 0){ // si no quedan simples
            nSimples = 0;
            System.out.println("Se han acabado los panes");
        }
        else{ // si quedan simples
            if(n <= nSimples){
                simplesVendidos += n;
                for (int i = 0; (i < n) && !stockSimples.isEmpty(); i++){
                    stockSimples.remove(stockSimples.size()-1);
                }   
                nSimples -= n;
                System.out.println(n +" panes vendidos y quedan " + nSimples + " == " + stockSimples.size());
            }
            else{
                System.out.println("No hay suficientes panes");
            }
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               setChanged();
               notifyObservers();
            }
        });

    }

    public void venderCompuesto(int n){
        if(nCompuestos <= 0){ // si no quedan compuestos
            nCompuestos = 0;
            System.out.println("Se han acabado las cestas");
        }
        else{ // si quedan compuestos
            if(n <= nCompuestos){
                compuestosVendidos += n;
                for (int i = 0; i < n; i++){
                    stockCompuestos.remove(stockCompuestos.size()-1);
                }
                nCompuestos -= n;
                System.out.println(n +" cestas vendidas y quedan " + nCompuestos + " == " + stockCompuestos.size());
            }
            else{
                System.out.println("No hay suficientes cestas");
            }
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               setChanged();
               notifyObservers();
            }
        });
    }

    //Vende n productos del tipo correspondiente

    public void venderProducto(int tipo, int cantidad){
        // Print para comprobar que está ejecutándose
        System.out.println("Se van a vender " + cantidad + " productos de tipo " + tipo);
        if (tipo == 0){
            this.venderSimple(cantidad);
        } else { // si tipo == 1
            this.venderCompuesto(cantidad);
        } 
    }
   

    @Override
    public void run(){

        //Cada cierto tiempo (instante) se vende una serie de productos 
        //(cantidad) de un tipo u otro (tipo)
        while (nProd > 0){
            //this.setChanged();
            int instante = rand.nextInt(5000)+1000;
            int tipo = rand.nextInt(2);
            int cantidad = rand.nextInt(4)+1;

            executor.schedule(() -> venderProducto(tipo, cantidad), instante, TimeUnit.MILLISECONDS);
            try {
                Thread.sleep(instante);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nProd = nSimples + nCompuestos;
        }

        executor.shutdown();

    } 
}
