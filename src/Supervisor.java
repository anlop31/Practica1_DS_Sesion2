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
public class Supervisor implements Observer {

    //Mostrará la disponibilidad de productos (y ventas ??)

    public String mensajeSimples;
    public String mensajeCompuestos;

    @Override
    public void update(Observable o, Object arg){
        //Se le avisa de los productos disponibles en la tienda y los que ya se han vendido
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex){
            //Logger.getLogger()
        }

        Panaderia panaderia = (Panaderia) o;
        ArrayList<Integer> datos = (ArrayList<Integer>) arg;

        int nSimples = datos.get(0);
        int nCompuestos = datos.get(1);
        int simplesVendidos = datos.get(2);
        int compuestosVendidos = datos.get(3);

        mensajeSimples = "El número de productos simples en stock es " + nSimples + " y el número de productos simples que ya se han vendido es " + simplesVendidos;
        mensajeCompuestos = "El número de productos compuestos en stock es " + nCompuestos + " y el número de productos compuestos que ya se han vendido es " + compuestosVendidos;

    }


    public String getStock(){
        return (mensajeSimples + mensajeCompuestos);
    }

}
