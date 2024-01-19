package com.registro.ventas.service;


import com.registro.ventas.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listaClientes(){
        List<Cliente> listaClientes =new ArrayList<>();
        try{
            listaClientes= clienteRepository.findAll();
        }catch (Exception ex){
            System.out.println("No se pudo conectar con la base de datos");
        }
        return listaClientes;
    }

    public Cliente obtenerPorCedula(String cedula){
       Cliente cliente = null;
        try {
            cliente=clienteRepository.findByCedula(cedula);
        }catch (Exception ex){
            System.out.println("No se encontro un cliente con esa cedula");
        }
        return cliente;
    }
    public void agregarCliente(Cliente cliente){
        try{
           clienteRepository.save(cliente);
        }catch (Exception ex){
            System.out.println("No se puede guardar el cliente");
        }
    }
    public void borrarCLiente(String cedula){
        try{
            Cliente cliente = clienteRepository.findByCedula(cedula);
            clienteRepository.delete(cliente);
        }catch (Exception ex){
            System.out.println("No se puede encontrar el cliente a borrar");
        }
    }

    public void editarCliente(String cedula,Cliente cliente){
        try{
            Cliente clienteEditar = clienteRepository.findByCedula(cedula);
            if(clienteEditar!=null){
                clienteEditar.setNombre(cliente.getNombre());
                clienteEditar.setCorreo(cliente.getCorreo());
                clienteRepository.save(clienteEditar);
            }
        }catch (Exception ex){
            System.out.println("No se puede encontrar el cliente a ser editado");
        }
    }

}
