/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemainventario;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jose Segura
 */
public class Menu {

    private static Menu menu;

    private Menu() {
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public void opciones() {
        System.out.println("----- Menu -----");
        System.out.println("1. Mostrar Productos");
        System.out.println("2. Agregar Producto");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Agregar cantidad a un producto");
        System.out.println("5. Quitar cantidad a un producto");
        System.out.println("6. Salir \n");
    }

    public void mostrar() {
        int opcion = 7;
        Scanner leer = new Scanner(System.in);
        Inventario productos = new Inventario();

        while (opcion != 6) {
            opciones();
            try {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        productos.mostrar();
                        break;
                    case 2:
                        productos.addProducto();
                        break;
                    case 3:
                        productos.eliminar();
                        break;
                    case 4:
                        productos.sumar();
                        break;
                    case 5:
                        productos.restar();
                        break;
                    case 6:
                        System.out.println("Se ha salido del sistema.");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese un número");
                leer.nextLine();
            }
        }
    }

}
