package com.registro.ventas.service;

import com.registro.ventas.models.Cliente;
import com.registro.ventas.models.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    public List<Producto> listaProductos(){
       List<Producto> listaProductos = new ArrayList<>(
        List.of(
                new Producto("Embrague",120,50),
                new Producto("Piston",45,50),
                new Producto("LLanta",85,50),
                new Producto("Filtro",10,50),
                new Producto("Aceite", 21.99F,50),
                new Producto("Refrigerante",15,50)
                )
        );
        try{
            listaProductos= productoRepository.findAll();
        }catch (Exception ex){
            System.out.println("No se pudo conectar con la base de datos");
        }
        return listaProductos;
    }
    public Producto obtenerPorNombre(String nombre){
        Producto producto = null;
        try {
            producto=productoRepository.findByNombre(nombre);
        }catch (Exception ex){
            System.out.println("No se encontro el producto con ese nombre");
        }
        return producto;
    }

    public void agregarProducto(Producto producto){
        try{
            productoRepository.save(producto);
        }catch (Exception ex){
            System.out.println("No se puede guardar el producto");
        }
    }
    public void borrarProducto(String nombre){
        try{
            Producto producto = productoRepository.findByNombre(nombre);
            productoRepository.delete(producto);
        }catch (Exception ex){
            System.out.println("No se puede encontrar el cliente a borrar");
        }
    }
    public void editarProducto(String nombre,Producto producto){
        try{
            Producto productoEditar = productoRepository.findByNombre(nombre);
            if(productoEditar!=null){
                productoEditar.setNombre(producto.getNombre());
                productoEditar.setCantidad(producto.getCantidad());
                productoEditar.setPrecio(producto.getPrecio());
                productoRepository.save(productoEditar);
            }
        }catch (Exception ex){
            System.out.println("No se puede encontrar el producto");
        }
    }


}
