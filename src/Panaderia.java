import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import java.util.Timer;
import java.util.TimerTask;

public class Panaderia extends Observable implements Runnable{

    //Se encarga de instanciar los objetos y notificar al observador las cantidades


    //Tiene originalmente el número de productos de cada tipo
    
    //array de producto

    ArrayList<Producto> stockSimples = new ArrayList<>();
    ArrayList<Producto> stockCompuestos = new ArrayList<>();
    
    Random rand = new Random();

    private int nSimples = stockSimples.size();
    private int nCompuestos = stockCompuestos.size();

    private int simplesVendidos = 0;
    private int compuestosVendidos = 0;

    private Timer timer = new Timer();

    //Getters y setters
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

    //Esto no lo necesitamos ???
    public void meterSimple(ProductoSimple producto){
        stockSimples.add(producto);
        nSimples++;
    }
    
    public void meterCompuesto(ProductoCompuesto producto){
        stockCompuestos.add(producto);
        nCompuestos++;
    }
    

    public void venderSimple(int n){
        System.out.println("VENDERSIMPLES");
        
        if (nSimples <= 0){
            nSimples = 0;
            System.out.println("Se han acabado los productos simples");
        }
        else{ // si hay
            simplesVendidos += n;
            for (int i = 0; (i < n) && !stockSimples.isEmpty(); i++){
                stockSimples.remove(stockSimples.size()-1);
            }   
            nSimples -= n;
            System.out.println(n +" simples vendidos y quedan " + nSimples + " == " + stockSimples.size());
        }

    }

    public void venderCompuesto(int n){
        System.out.println("VENDERCOMPUESTOS");
        if(nCompuestos <= 0){
            nCompuestos = 0;
            System.out.println("Se han acabado los productos compuestos");
        }else{ // si hay
            compuestosVendidos += n;
            for (int i = 0; i < n; i++){
                stockCompuestos.remove(stockCompuestos.size()-1);
            }
            nCompuestos -= n;
            System.out.println(n +" compuestos vendidos y quedan " + nCompuestos + " == " + stockCompuestos.size());
        }

    }

    public void venderProducto(int tipo, int cantidad){
        // Print para comprobar que está ejecutándose
        System.out.println("Se venden " + cantidad + " productos de tipo " + tipo);
        if (tipo == 0){
            this.venderSimple(cantidad);
        } else { // si tipo == 1
            this.venderCompuesto(cantidad);
        } 
    }
    
    public void inicializarProductos(){
        int nSimples = rand.nextInt(20)+10;
        int nCompuestos = rand.nextInt(20)+10;

        for (int i = 0; i < nSimples; i++){
            this.stockSimples.add(new ProductoSimple());
        }
        for (int i = 0; i < nCompuestos; i++){
            this.stockCompuestos.add(new ProductoCompuesto());
        }

        System.out.println("Se inicializa con " + nSimples + "productos simples y " + nCompuestos + " compuestos.");
    }

    @Override
    public void run(){

        inicializarProductos();
        for (int i = 0; i < 4; i++){
        //while (!(nSimples == 0 && nCompuestos == 0)){
            int instante = rand.nextInt(5000)+1000;

            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    int tipo = rand.nextInt(2);
                    int cantidad = rand.nextInt(4);
                    venderProducto(tipo, cantidad);
                }
            }, instante);
       }            
       System.out.println("Fin de la ejecución");
        

    }
}
