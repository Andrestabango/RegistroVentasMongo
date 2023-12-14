package com.registro.ventas.utils;

import com.registro.ventas.models.Cliente;
import com.registro.ventas.models.Producto;
import com.registro.ventas.models.Venta;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Cliente> listaClientes = new ArrayList<>(
            List.of(


            )
    );

    public static List<Producto> listaProducto = new ArrayList<>(
            List.of(
                new Producto("Embrague",120,50),
                new Producto("Piston",45,50),
                new Producto("LLanta",85,50),
                new Producto("Filtro",10,50),
                new Producto("Aceite", 21.99F,50),
                new Producto("Refrigerante",15,50)
            )
    );

    public static List<Venta> listaVenta = new ArrayList<>(
            List.of(


            )


    );
}
