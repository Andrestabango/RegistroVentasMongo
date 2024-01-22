package com.registro.ventas.views.productos;

import com.registro.ventas.models.Cliente;
import com.registro.ventas.models.Producto;
import com.registro.ventas.models.Venta;
import com.registro.ventas.service.ProductoService;
import com.registro.ventas.utils.Util;
import com.registro.ventas.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@PageTitle("Productos")
@Route(value = "productos", layout = MainLayout.class)
@Uses(Icon.class)
public class ProductosView extends Composite<VerticalLayout> {
    List<Producto> productos;
    private ProductoService productoService;



    public ProductosView(ProductoService productoService) {
        this.productoService = productoService;

        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Nuevo Producto");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener(e -> {
            buttonPrimary.getUI().ifPresent(ui ->
                    ui.navigate("nuevo-producto"));
        });

        Grid<Producto> grid = new Grid<>(Producto.class, false);
        grid.addColumn(Producto::getNombre).setHeader("Nombre").setAutoWidth(true);
        grid.addColumn(Producto::getPrecio).setHeader("Precio").setAutoWidth(true);
        grid.addColumn(Producto::getCantidad).setHeader("Cantidad").setAutoWidth(true);
        grid.addColumn(
                new ComponentRenderer<>(producto -> {
                    Button botonBorrar = new Button();
                    botonBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonBorrar.addClickListener(e -> {
                      productoService.borrarProducto(producto.getNombre());
                      productos.clear();
                      productos.addAll(productoService.listaProductos());
                        grid.getDataProvider().refreshAll();
                    });
                    botonBorrar.setIcon(new Icon(VaadinIcon.TRASH));

                    Button botonAgregar = new Button();
                    botonAgregar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonAgregar.addClickListener(e -> {
                        producto.aumentarCantidad();
                        grid.getDataProvider().refreshItem(producto);
                    });
                    botonAgregar.setIcon(new Icon(VaadinIcon.PLUS));

                    Button botonEliminar = new Button();
                    botonEliminar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
                    botonEliminar.addClickListener(e -> {
                        producto.disminuirCantidad();
                        if (producto.getCantidad() <= 0) {
                            producto.getProductos().remove();
                        }
                        grid.getDataProvider().refreshItem(producto);
                    });
                    botonEliminar.setIcon(new Icon(VaadinIcon.MINUS));

                    HorizontalLayout buttons = new HorizontalLayout(botonBorrar, botonAgregar, botonEliminar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);

        productos = productoService.listaProductos();
        grid.setItems(productos);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        getContent().add(buttonPrimary,grid);
    }
}
