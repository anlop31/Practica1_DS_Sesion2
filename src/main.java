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

        //Número de productos para el cliente
        public ArrayList<Integer> datos = new ArrayList<>();
        datos.add(panaderia.getNSimples());
        datos.add(panaderia.getNCompuestos());
        datos.add(panaderia.getSimplesVendidos());
        datos.add(panaderia.getCompuestosVendidos());



        Random rand = new Random();
        int instante = rand.nextInt(10);
        int cantidad = rand.nextInt(4);
        int tipo = rand.nextInt(2);

        if (tipo == 0){
            panaderia.venderSimple(cantidad);
        } else {
            panaderia.venderCompuesto(cantidad);
        }



        Supervisor supervisor = new Supervisor();
        while(true){
            supervisor.update(panaderia, datos);
        }
    }
}
