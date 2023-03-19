/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ana
 */
public abstract class Producto {
    private String nombre;
    private float precio;
    private int stock; // ??
    private int stock_inicial; // añadido
    
    public int informarStock(){
        return stock;
    }
    
    public int informarVendidos(){
        return stock_inicial - stock; // ??
    }
    
    public void setPrecio(float precio){
        this.precio = precio;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
}
