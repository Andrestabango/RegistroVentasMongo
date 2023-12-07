package com.registro.ventas.utils;

import com.registro.ventas.models.Cliente;
import com.registro.ventas.models.Producto;
import com.registro.ventas.models.Venta;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Cliente> listaClientes = new ArrayList<>(
            List.of(
               new Cliente ("Andres","1753468311","andrestab@gmail.com"),
                    new Cliente ("Luis","1753468381","luis@gmail.com")

            )
    );

    public static List<Producto> listaProducto = new ArrayList<>(
            List.of(
                    new Producto ("Embrague",120,4),
                    new Producto ("Piston",140,2)

            )
    );

    public static List<Venta> listaVenta = new ArrayList<>();
}
