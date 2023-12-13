package com.registro.ventas.views.productos;

import com.registro.ventas.models.Cliente;
import com.registro.ventas.models.Producto;
import com.registro.ventas.models.Venta;
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

    public ProductosView() {
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
        grid.addColumn(Producto::getCantidad).setHeader("Nombre").setAutoWidth(true);
        grid.addColumn(
                new ComponentRenderer<>(producto -> {
                    Button botonBorrar = new Button();
                    botonBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonBorrar.addClickListener(e -> {
                        Util.listaProducto.remove(producto);
                        grid.getDataProvider().refreshAll();
                    });
                    botonBorrar.setIcon(new Icon(VaadinIcon.TRASH));

                    Button botonAgregar = new Button();
                    botonAgregar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonAgregar.addClickListener(e -> {
                        producto.aumentarCantidad(); // Método para aumentar la cantidad en tu modelo Producto
                        grid.getDataProvider().refreshItem(producto);
                    });
                    botonAgregar.setIcon(new Icon(VaadinIcon.PLUS));

                    Button botonEliminar = new Button();
                    botonEliminar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
                    botonEliminar.addClickListener(e -> {
                        producto.disminuirCantidad(); // Método para disminuir la cantidad en tu modelo Producto
                        if (producto.getCantidad() <= 0) {
                            producto.getProductos().remove(producto);
                        }
                        grid.getDataProvider().refreshItem(producto);
                    });
                    botonEliminar.setIcon(new Icon(VaadinIcon.MINUS));

                    HorizontalLayout buttons = new HorizontalLayout(botonBorrar, botonAgregar, botonEliminar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);

        List<Producto> producto = Util.listaProducto;
        grid.setItems(producto);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        getContent().add(buttonPrimary,grid);
    }
}
