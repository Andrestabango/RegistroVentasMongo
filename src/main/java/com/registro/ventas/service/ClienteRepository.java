package com.registro.ventas.service;

import com.registro.ventas.models.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
public Cliente findByNombre(String nombre);
public Cliente findByCedula(String cedula);

}
