package com.registro.ventas.views.nuevaventa;

import com.registro.ventas.models.Cliente;
import com.registro.ventas.models.Producto;
import com.registro.ventas.models.Venta;
import com.registro.ventas.utils.Util;
import com.registro.ventas.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Nueva Venta")
@Route(value = "nueva-venta", layout = MainLayout.class)
@Uses(Icon.class)
public class NuevaVentaView extends Composite<VerticalLayout> {

    public NuevaVentaView() {
        Venta venta1= new Venta();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H3 h3 = new H3();
        FormLayout formLayout2Col = new FormLayout();
        TextField tfcodigo = new TextField();
        DatePicker dpFechaVentas = new DatePicker();
        ComboBox cBClientes = new ComboBox();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        H6 h6 = new H6();
        Venta venta2 = new Venta();
        H3 h32 = new H3("Precio Total:");
        H3 h33 = new H3("Precio");
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button guardar = new Button();
        Button buttonSecondary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        layoutColumn2.setWidth("100%");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("min-content");
        h3.setText("Información de Ventas");
        h3.setWidth("100%");
        formLayout2Col.setWidth("100%");
        tfcodigo.setLabel("Código de Venta:");
        dpFechaVentas.setLabel("Fecha de la Venta:");
        cBClientes.setLabel("Cliente:");
        cBClientes.setWidth("min-content");
        setComboBoxSampleData(cBClientes);
        layoutColumn3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        layoutColumn3.setHeight("min-content");
        h6.setText("Agregue los productos a vender");
        h6.setWidth("max-content");
        h32.setText("Precio Total:");
        h32.setWidth("max-content");
        h33.setText("Precio");
        h33.setWidth("max-content");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        guardar.setText("Save");
        guardar.setWidth("min-content");
        guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);


        guardar.addClickListener(e -> {
            int selTipo = Integer.parseInt(((SampleItem) cBClientes.getValue()).value());
            String tipo = ((SampleItem) cBClientes.getValue()).label();
            System.out.println(selTipo);
            venta2.setCodigoVenta(Integer.parseInt(tfcodigo.getValue()));
            venta2.setFechaCompra(dpFechaVentas.getValue().toString());
            venta2.setCliente(Util.listaClientes.get(selTipo));
            Util.listaVenta.add(venta2);

          //  precioTotalSpan.setText("Precio Total: " + venta2.getPrecioTotal()); // Actualizar el valor después de guardar

            guardar.getUI().ifPresent(ui ->
                    ui.navigate("ventas"));
        });



        buttonSecondary.setText("Cancel");
        buttonSecondary.setWidth("min-content");
        getContent().add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(h32);
        layoutColumn2.add(h33);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(tfcodigo);
        formLayout2Col.add(dpFechaVentas);
        formLayout2Col.add(cBClientes);
        layoutColumn2.add(layoutColumn3);
        layoutColumn2.add(layoutRow);
        layoutRow.add(guardar);
        layoutRow.add(buttonSecondary);


        Grid<Producto> grid2 = new Grid<>(Producto.class, false);
        grid2.setItems(venta2.getProductos());
        grid2.addColumn(Producto::getNombre).setHeader("Nombre").setAutoWidth(true);
        grid2.addColumn(Producto::getPrecio).setHeader("Precio").setAutoWidth(true);
        grid2.addColumn(
                new ComponentRenderer<>(producto -> {
                    Button botonEliminar = new Button();
                    botonEliminar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
                    botonEliminar.addClickListener(e -> {
                        producto.disminuirCantidad();
                        venta2.getProductos().remove(producto);
                        grid2.getDataProvider().refreshAll();
                        h32.setText("Precio Total:");
                        h33.setText(String.valueOf(venta2.getPrecioTotal()));
                    });
                    botonEliminar.setIcon(new Icon(VaadinIcon.MINUS));

                    HorizontalLayout buttons = new HorizontalLayout(botonEliminar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);

        grid2.addThemeVariants(GridVariant.LUMO_NO_BORDER);



        layoutColumn3.add(h6, grid2,h32, h33);


        Grid<Producto> grid = new Grid<>(Producto.class, false);
        grid.setItems(/* tu lista de productos */);
        grid.addColumn(Producto::getNombre).setHeader("Nombre").setAutoWidth(true);
        grid.addColumn(Producto::getPrecio).setHeader("Precio").setAutoWidth(true);
        grid.addColumn(Producto::getCantidad).setHeader("Stock").setAutoWidth(true);
        grid.addColumn(
                new ComponentRenderer<>(producto -> {
                    Button botonAgregar = new Button();
                    botonAgregar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonAgregar.addClickListener(e -> {
                        producto.disminuirCantidad();
                        venta2.getProductos().add(producto);
                        grid2.getDataProvider().refreshAll();
                        h32.setText("Precio Total:");
                        h33.setText(String.valueOf(venta2.getPrecioTotal()));
                    });
                    botonAgregar.setIcon(new Icon(VaadinIcon.PLUS));

                    Button botonEliminar = new Button();
                    botonEliminar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
                    botonEliminar.addClickListener(e -> {
                        producto.aumentarCantidad();
                        venta2.getProductos().remove(producto);
                        grid2.getDataProvider().refreshAll();
                        h32.setText("Precio Total:");
                        h33.setText(String.valueOf(venta2.getPrecioTotal()));
                    });
                    botonEliminar.setIcon(new Icon(VaadinIcon.MINUS));

                    HorizontalLayout buttons = new HorizontalLayout(botonAgregar, botonEliminar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);

        List<Producto> productos = Util.listaProducto;
        grid.setItems(productos);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        layoutColumn3.add(h6,grid2,h32,h33,grid);




    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        int i=0;
        for(Cliente cliente: Util.listaClientes){
            sampleItems.add(new SampleItem(String.valueOf(i), cliente.getNombre(), null));
            i++;
        }
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}
