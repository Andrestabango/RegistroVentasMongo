package com.registro.ventas.models;

import java.util.Scanner;

public class Producto extends Venta {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public void ingresarProducto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del producto:");
        this.nombre = scanner.nextLine();
        System.out.println("Ingrese precio del producto:");
        this.precio = scanner.nextDouble();
        System.out.println("Ingrese cantidad del producto:");
        this.cantidad = scanner.nextInt();
    }


    public void imprimirProducto(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Precio: "+this.precio);
        System.out.println("Código: "+this.cantidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
