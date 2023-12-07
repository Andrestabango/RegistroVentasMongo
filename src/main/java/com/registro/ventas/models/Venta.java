package com.registro.ventas.models;

import java.util.ArrayList;

public abstract class Venta {
    int codigoVenta;
    String fechaCompra;
    ArrayList<Producto>  productos = new ArrayList<>();
    Cliente cliente;

    public Venta(int codigoVenta, String fechaCompra, ArrayList<Producto> productos, Cliente cliente) {
        this.codigoVenta = codigoVenta;
        this.fechaCompra = fechaCompra;
        this.productos = productos;
        this.cliente = cliente;
    }


    public abstract void ingresarDatos();


    public abstract void imprimirDatos();

    public Venta() {
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
