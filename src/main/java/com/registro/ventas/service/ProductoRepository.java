package com.registro.ventas.service;

import com.registro.ventas.models.Cliente;
import com.registro.ventas.models.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {
    public Producto findByNombre(String nombre);
    public Producto findByPrecio(Float precio);
    public Producto findByCantidad(int precio);

}
