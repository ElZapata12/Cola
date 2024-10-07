package colaCircular;

import javax.swing.*;

public class CircularEjemplo {
    private ColaCircular cola;

    public CircularEjemplo(int capacidad) {
        cola = new ColaCircular(capacidad);
    }

    public void agregarProducto(String producto) {
        if (cola.estaLlena()) {
            JOptionPane.showMessageDialog(null, "La cola está llena. No se puede agregar más productos.");
        } else {
            cola.encolar(producto);
            JOptionPane.showMessageDialog(null, "Producto agregado: " + producto);
        }
    }

    public String eliminarProducto() {
        if (cola.estaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía. No hay productos para eliminar.");
        } else {
            String productoEliminado = cola.desencolar();
            JOptionPane.showMessageDialog(null, "Producto eliminado: " + productoEliminado);
        }
        return null;
    }

    public void mostrarProductos() {
        if (cola.estaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
        } else {
            String mensaje = "Contenido de la cola:\n";
            for (int i = 0; i < cola.tamanio; i++) {
                mensaje += cola.cola[(cola.frente + i) % cola.tamanio] + "\n";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    public class ColaCircular {
        private String[] cola;
        private int frente;
        private int finalCola;
        private int tamanio;

        public ColaCircular(int tamanio) {
            this.tamanio = tamanio;
            cola = new String[tamanio];
            frente = -1;
            finalCola = -1;
        }

        public boolean estaVacia() {
            return (frente == -1);
        }

        public boolean estaLlena() {
            return ((finalCola + 1) % tamanio == frente);
        }

        public void encolar(String valor) {
            if (estaLlena()) {
                System.out.println("Cola llena. No se puede insertar.");
                return;
            }
            if (estaVacia()) {
                frente = 0;
            }
            finalCola = (finalCola + 1) % tamanio;
            cola[finalCola] = valor;
        }

        public String desencolar() {
            if (estaVacia()) {
                System.out.println("Cola vacía. No se puede eliminar.");
                return null;
            }
            String valor = cola[frente];
            if (frente == finalCola) {
                frente = -1;
                finalCola = -1;
            } else {
                frente = (frente + 1) % tamanio;
            }
            return valor;
        }
    }
}