package com.registro.ventas.models;

import java.util.Scanner;

public class Cliente extends Venta {
    String nombre;
    String cedula;
    String correo;

    public Cliente(String nombre, String cedula, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
    }

    @Override
    public void ingresarDatos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del cliente:");
        this.nombre = scanner.nextLine();
        System.out.println("Ingrese cédula del cliente:");
        this.cedula = scanner.nextLine();
        System.out.println("Ingrese correo del cliente:");
        this.correo = scanner.nextLine();
    }

    @Override
    public void imprimirDatos(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Precio: "+this.cedula);
        System.out.println("Código: "+this.correo);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
