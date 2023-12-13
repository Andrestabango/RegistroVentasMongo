package com.registro.ventas.views.clientes;

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

import java.util.List;

@PageTitle("Clientes")
@Route(value = "clientes", layout = MainLayout.class)
@Uses(Icon.class)
public class ClientesView extends Composite<VerticalLayout> {

    public ClientesView() {

        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Nuevo Cliente");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener(e -> {
            buttonPrimary.getUI().ifPresent(ui ->
                    ui.navigate("nuevo-cliente"));
        });

        Grid<Cliente> grid = new Grid<>(Cliente.class, false);
        grid.addColumn(Cliente::getNombre).setHeader("Nombre").setAutoWidth(true);
        grid.addColumn(Cliente::getCedula).setHeader("Cedula").setAutoWidth(true);
        grid.addColumn(Cliente::getCorreo).setHeader("Correo").setAutoWidth(true);
        grid.addColumn(
                new ComponentRenderer<>(cliente -> {
                    Button botonBorrar = new Button();
                    botonBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonBorrar.addClickListener(e -> {
                        Util.listaClientes.remove(cliente);
                        grid.getDataProvider().refreshAll();
                    });
                    botonBorrar.setIcon(new Icon(VaadinIcon.TRASH));

                    HorizontalLayout buttons = new HorizontalLayout(botonBorrar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);

        List<Cliente> clientes = Util.listaClientes;
        grid.setItems(clientes);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        getContent().add(buttonPrimary,grid);





    }
}
