import java.util.ArrayList;
import java.util.Observable;

public class Panaderia extends Observable{

    //Se encarga de instanciar los objetos y notificar al observador las cantidades


    //Tiene originalmente el número de productos de cada tipo
    
    //array de producto

    ArrayList<Producto> stockSimples = new ArrayList<>();
    ArrayList<Producto> stockCompuestos = new ArrayList<>();

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

    public void venderSimple(int n){
        nSimples -= n;
        if (nSimples < 0){
            nSimples = 0;
        }
        simplesVendidos += n;
        for (int i = 0; (i < n) && !stockSimples.isEmpty(); i++){
            stockSimples.remove(stockSimples.size()-1);
        }
    }

    public void venderCompuesto(int n){
        nCompuestos -= n;
        if(nCompuestos < 0)
            nCompuestos = 0;
        compuestosVendidos += n;
        for (int i = 0; i < n; i++){
            stockCompuestos.remove(stockCompuestos.size()-1);
        }
    }
}
