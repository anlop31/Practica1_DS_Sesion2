import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ana
 */
public class ProductoCompuesto extends Producto {
    
    //puede tener productos simples o más productos compuestos
    private ArrayList<Producto> productos;
    private int componentes;

    public ProductoCompuesto(){
        productos = new ArrayList<>();
        componentes = productos.size();
    }

    /*
     * 10 barras 
     * 1 cesta de 10 barras
     * 1 cesta de 2 barras y 1 cesta de 1 barras
     * 
     */

}
