/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 import java.util.Observer;
 import java.util.logging.Logger;
 import java.util.ArrayList;
 import java.util.Observable;
/**
 *
 * @author ana
 */
public class Analista implements Observer {

    //Mostrará una gráfica con las ventas de los últimos 7 días
    private int nSimples = 0;
    private int nCompuestos = 0;
    private int simplesVendidos = 0;
    private int compuestosVendidos = 0;
    public String mensajeSimples = "";
    public String mensajeCompuestos = "";

    @Override
    public void update(Observable o, Object arg){
        //Se le avisa de los productos disponibles en la tienda y los que ya se han vendido
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex){
            //Logger.getLogger()
        }

        System.out.println("update de analista");
        
        Panaderia panaderia = (Panaderia) o;

        nSimples = panaderia.getNSimples();
        nCompuestos = panaderia.getNCompuestos();
        simplesVendidos = panaderia.getSimplesVendidos();
        compuestosVendidos = panaderia.getCompuestosVendidos();

        
        mensajeSimples = "El número de productos simples en stock es " + nSimples + " y el número de productos simples que ya se han vendido es " + simplesVendidos;
        mensajeCompuestos = "El número de productos compuestos en stock es " + nCompuestos + " y el número de productos compuestos que ya se han vendido es " + compuestosVendidos;

    }
    
    public String getStock(){
        return ("analista: " + mensajeSimples + mensajeCompuestos);
    }
}
