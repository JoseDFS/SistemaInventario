/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemainventario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Jose Segura
 */
public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    Scanner L = new Scanner(System.in);

    public void addProducto() {
        Producto producto = new Producto();
        productos.add(producto);

        System.out.println("Escriba el nombre del producto:");
        producto.setNombre(L.nextLine());

        System.out.println("Escriba la cantidad del producto:");
        producto.setCantidad(Integer.parseInt(L.nextLine()));

    }

    public void addProducto(Producto producto) throws Exception {
        if (producto != null) {
            if (!productos.contains(producto)) {
                productos.add(producto);
            }
            Exception e = new Exception("No se permiten dos productos iguales.");
            throw e;
        } else {
            throw new Exception("No se puede agregar un producto sin datos.");
        }
    }

    public void sumar() {
        String n;
        int c;
        

        System.out.println("Escriba el nombre del producto al que se le agregará la cantidad:");
        n = L.nextLine();

        System.out.println("Escriba la cantidad a agregar:");
        c = Integer.parseInt(L.nextLine());

        if (productos.isEmpty()) {
            System.out.println("No hay inventario");
        } 
        else {
            boolean find = false;
            productos.forEach((p) -> {
                if (p.getNombre().equals(n)) {
                    p.setCantidad(p.getCantidad() + c);
                    System.out.println("Se ha agregado la cantidad al producto especificado");
                    
                } 
            });
         
        }
       

    }

    public void restar() {
        String n;
        int c;

        System.out.println("Escriba el nombre del producto al que se le restará la cantidad:");
        n = L.nextLine();

        System.out.println("Escriba la cantidad a restar:");
        c = Integer.parseInt(L.nextLine());

        if (productos.isEmpty()) {
            System.out.println("No hay inventario");
        } else {
            productos.forEach((p) -> {
                if (p.getNombre().equals(n)) {
                    p.setCantidad(p.getCantidad() - c);
                    System.out.println("Se ha quitado la cantidad al producto especificado");
                }
            });
        }
    }

    public void eliminar() {
        String n;

        System.out.println("Escriba el nombre del producto a eliminar:");
        n = L.nextLine();
        for (Iterator<Producto> iter = productos.iterator(); iter.hasNext();) {
            Producto producto = iter.next();
            if (producto.getNombre().equals(n)) {
                iter.remove();
                System.out.println("Se ha eliminado el producto especificado");
            } 
        }

    }

    public void mostrar() {
        if (productos.isEmpty()) {
            System.out.println("No hay inventario");
        } 
        else {
            System.out.println("-----Productos-----");
            productos.forEach((e) -> {
                System.out.println(e.toString());
            });
        }
    }

}
