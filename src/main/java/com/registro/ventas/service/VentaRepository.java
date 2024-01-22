package com.registro.ventas.service;

import com.registro.ventas.models.Cliente;
import com.registro.ventas.models.Producto;
import com.registro.ventas.models.Venta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends MongoRepository<Venta, String> {

    public Venta findByCodigoVenta(int codigoVenta);
    public Venta findByFechaCompra(String fechaCompra);
}
