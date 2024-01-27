package com.registro.ventas.service;

import com.registro.ventas.models.Cliente;
import com.registro.ventas.models.Producto;
import com.registro.ventas.models.Venta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {
    private VentaRepository ventaRepository;
    private ProductoRepository productoRepository;
    public VentaService(VentaRepository ventaRepository, ProductoRepository productoRepository) {
        this.ventaRepository = ventaRepository;
        this.productoRepository=productoRepository;
    }
    public void actualizarCantidad(String nombre){
        try{
            Producto producto = productoRepository.findByNombre(nombre);
            int cantidad2= producto.getCantidad();
            producto.setCantidad(cantidad2-1);
            productoRepository.save(producto);
        }catch (Exception ex){
            System.out.println("No se puede encontrar la venta a borrar");
        }
    }


    public List<Venta> listaVenta(){
        List<Venta> listaVentas =new ArrayList<>();
        try{
            listaVentas= ventaRepository.findAll();
        }catch (Exception ex){
            System.out.println("No se pudo conectar con la base de datos");
        }
        return listaVentas;
    }




    public void borrarVenta(int codigoVenta){
        try{
            Venta venta = ventaRepository.findByCodigoVenta(codigoVenta);
            ventaRepository.delete(venta);
        }catch (Exception ex){
            System.out.println("No se puede encontrar la venta a borrar");
        }
    }
    public void agregarVenta(Venta  venta){
        try{
            ventaRepository.save(venta);
        }catch (Exception ex){
            System.out.println("No se puede guardar el producto");
        }
    }


}
