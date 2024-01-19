package com.registro.ventas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document
public class Directorio {

    @Id
    String id;
    @Indexed(name ="nombre",unique = true)
    String nombre;

    //@DBRef
    /*public static List<Cliente> listaClientes = new ArrayList<>{

    }*/

    public Directorio() {
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

}
