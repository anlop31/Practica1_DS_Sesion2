import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

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
        }
        else{ // si hay
            simplesVendidos += n;
            for (int i = 0; (i < n) && !stockSimples.isEmpty(); i++){
                stockSimples.remove(stockSimples.size()-1);
            }   
            nSimples -= n;
            System.out.println(n +" simples vendidos");
        }

    }

    public void venderCompuesto(int n){
        System.out.println("VENDERCOMPUESTOS");
        if(nCompuestos <= 0)
            nCompuestos = 0;
        else{ // si hay
            compuestosVendidos += n;
            for (int i = 0; i < n; i++){
                stockCompuestos.remove(stockCompuestos.size()-1);
            }
            nCompuestos -= n;
            System.out.println(n+" compuestos vendidos");
        }

    }
    
    @Override
    public void run(){
        long inicio = System.currentTimeMillis();
        this.setChanged();
        try{
            // while true da error?? cómo era xddd
            //while(true){
                int instante = rand.nextInt(10);
                int cantidad = rand.nextInt(4);
                int tipo = rand.nextInt(2);

                // ¿Cómo metemos la espera?
                Thread.sleep(instante); 
                while(System.currentTimeMillis() - inicio < 2000) { 
                    //System.out.println(System.currentTimeMillis() - inicio);
                }
                
                // Print para comprobar que está ejecutándose
                System.out.println("tipo: "+ tipo + "(0=simple, 1=compuesto)");
                if (tipo == 0){
                    this.venderSimple(cantidad);
                } else { // si tipo == 1
                    this.venderCompuesto(cantidad);
                }  
            //}
        } catch (InterruptedException ex) {
                System.out.println("Hilo interrumpido");
        } 
        
        while(System.currentTimeMillis() - inicio < 30000) { 
            //System.out.println(System.currentTimeMillis() - inicio);
        }

    }
}
