package com.registro.ventas.models;

public class Producto extends Venta {
    private String nombre;
    private float precio;
    private int cantidad;

    public Producto(String nombre, float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto() {
        // Constructor por defecto
    }

    public void aumentarCantidad() {
        cantidad++;
    }



    public void disminuirCantidad() {
        if (cantidad > 0) {
            cantidad--;
        }
    }

    /*
    public void ingresarProducto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del producto:");
        this.nombre = scanner.nextLine();
        System.out.println("Ingrese precio del producto:");
        this.precio = scanner.nextFloat();
        System.out.println("Ingrese cantidad del producto:");
        this.cantidad = scanner.nextInt();
    }

    public void imprimirProducto(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Precio: "+this.precio);
        System.out.println("Código: "+this.cantidad);
    }
    */

    // Métodos getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
