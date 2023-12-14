package com.registro.ventas.views.ventas;

import com.registro.ventas.models.Cliente;
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
import com.vaadin.flow.router.RouteAlias;

import java.util.List;

@PageTitle("Ventas")
@Route(value = "ventas", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class VentasView extends Composite<VerticalLayout> {

    public VentasView() {
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Nueva Venta");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener(e -> {
            buttonPrimary.getUI().ifPresent(ui ->
                    ui.navigate("nueva-venta"));
        });
        Grid<Venta> grid = new Grid<>(Venta.class, false);
        grid.addColumn(Venta::getCodigoVenta).setHeader("Código de Venta").setAutoWidth(true);
        grid.addColumn(Venta::getNombreCliente).setHeader("Cliente").setAutoWidth(true);
        grid.addColumn(venta -> String.join(", ", venta.getNombresProductos())).setHeader("Productos").setAutoWidth(true);
        grid.addColumn(Venta::getPrecioTotal).setHeader("Precio").setAutoWidth(true);
        grid.addColumn(Venta::getFechaCompra).setHeader("Fecha de Venta").setAutoWidth(true);

        grid.addColumn(
                new ComponentRenderer<>(venta -> {
                    Button botonBorrar = new Button();
                    botonBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonBorrar.addClickListener(e -> {
                        Util.listaVenta.remove(venta);
                        grid.getDataProvider().refreshAll();
                    });
                    botonBorrar.setIcon(new Icon(VaadinIcon.TRASH));

                    HorizontalLayout buttons = new HorizontalLayout(botonBorrar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);

        List<Venta> ventas = Util.listaVenta;
        grid.setItems(ventas);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        getContent().add(buttonPrimary,grid);
    }
}
