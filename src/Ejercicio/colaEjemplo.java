package Ejercicio;

import javax.swing.*;

public class colaEjemplo {
    private String[]productos;
    private int frente;
    private int fin;
    private int tamanio;
    public colaEjemplo(int capacidad) {
        productos = new String[capacidad];
        frente = 0;
        fin = -1;
        tamanio = 0;
    }
    public boolean llena(){
        return tamanio== productos.length;
    }
    public void addProducto(String elemeto){
        if (!llena()){
            fin = (fin + 1) % productos.length;
            productos[fin] = elemeto;
            tamanio++;
            JOptionPane.showMessageDialog(null, "El elemento "+ frente+ "se agregó");
        } else {
            JOptionPane.showMessageDialog(null, "El elemento no puede ser agregado, tu carrito esta lleno, ¿deseas eliminar "+ frente+ "De la lista para poder agregar algun otro producto?");
        }

    }
    public boolean vacia(){
        return tamanio==0;
    }
    public String eliminar() {
        if ((vacia())) {
            JOptionPane.showMessageDialog(null, "Tu carro se encuentra vacio");
        }
        String elemento = productos[frente];
        frente = (frente + 1) % productos.length;
        tamanio--;
        return elemento;
    }
    public void mostrar(){
        if (vacia()){
            JOptionPane.showMessageDialog(null, "Tu carrito esta vacio");
        }
        JOptionPane.showMessageDialog(null, "el contenido de la cola es: ");
        for (int i=0; i<tamanio; i++){
            JOptionPane.showMessageDialog(null, productos[(frente+i)%productos.length]+ "");
        }
        JOptionPane.showMessageDialog(null, "");
    }
    public void cambio(){
        String producto = productos[frente];
        frente = (frente + 1) % productos.length;
        tamanio--;

    }

}
