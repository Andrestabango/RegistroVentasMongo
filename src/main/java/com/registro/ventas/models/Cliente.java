package com.registro.ventas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Scanner;
@Document
public class Cliente {
    @Id
    String id;
    String nombre;
    String correo;
    @Indexed(name ="cedula",unique = true)
    String cedula;
    public Cliente(String nombre, String cedula, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
    }

    public Cliente() {

    }


    public void ingresarClientes(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del cliente:");
        this.nombre = scanner.nextLine();
        System.out.println("Ingrese cédula del cliente:");
        this.cedula = scanner.nextLine();
        System.out.println("Ingrese correo del cliente:");
        this.correo = scanner.nextLine();
    }


    public void imprimirClientes(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Precio: "+this.cedula);
        System.out.println("Código: "+this.correo);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
