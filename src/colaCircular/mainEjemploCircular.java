package colaCircular;

import javax.swing.*;
import java.util.Scanner;

public class mainEjemploCircular {
    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        int capacidad;
        capacidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de articulos a comprar"));
        CircularEjemplo cola = new CircularEjemplo(capacidad);
        while (true) {
            int opc ;
            opc=Integer.parseInt(JOptionPane.showInputDialog(null, "Sele ccione una opcion:"+ "\n1...Agregar producto\n 2...Eliminar primer producto agregado\n 3...Mostrar Productos\n 4...Salir"));
            switch (opc){
                case 1:
                    String pro;
                    pro=JOptionPane.showInputDialog(null, "¿que producto quieres agregar?");
                    try {
                        cola.agregarProducto(pro);
                        JOptionPane.showMessageDialog(null, "El producto "+pro+ " a sido agregado a tu carrito");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        String Eliminado = cola.eliminarProducto();
                        JOptionPane.showMessageDialog(null, Eliminado+ " Se ha eliminado de tu carrito");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    cola.mostrarProductos();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliste de tu compra, ¡buena suerte!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
