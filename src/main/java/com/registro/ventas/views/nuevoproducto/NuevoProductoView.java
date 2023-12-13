package com.registro.ventas.views.nuevoproducto;

import com.registro.ventas.models.Producto;
import com.registro.ventas.utils.Util;
import com.registro.ventas.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Nuevo Producto")
@Route(value = "nuevo-producto", layout = MainLayout.class)
public class NuevoProductoView extends Composite<VerticalLayout> {

    public NuevoProductoView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H3 h3 = new H3();
        TextField textField = new TextField();
        FormLayout formLayout2Col = new FormLayout();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button guardar = new Button();
        Button buttonSecondary = new Button();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);

        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("min-content");

        h3.setText("Información de Productos");
        h3.setWidth("min-content");

        textField.setLabel("Nombre del producto:");
        textField.setWidth("100%");

        formLayout2Col.setWidth("100%");

        textField2.setLabel("Precio:");
        textField2.setWidth("min-content");

        textField3.setLabel("Cantidad:");
        textField3.setWidth("min-content");

        layoutRow.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow);

        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");

        guardar.setText("Guardar");
        guardar.setWidth("min-content");
        guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        guardar.addClickListener(event -> {
            // Obtener los valores de los campos y guardar en la lista de productos
            String nombre = textField.getValue();
            String precioStr = textField2.getValue();
            String cantidadStr = textField3.getValue();

            // Crear una nueva instancia de Producto
            Producto producto1 = new Producto();
            if (!nombre.isEmpty() && precioStr != null && cantidadStr != null) {
                // Validar que los campos no estén vacíos antes de guardar
                float precio = Float.parseFloat(precioStr);
                Integer cantidad = Integer.valueOf(cantidadStr);

                producto1.setNombre(nombre);
                producto1.setPrecio(precio);
                producto1.setCantidad(cantidad);

                Util.listaProducto.add(producto1);

                // Navegar a la vista de productos después de guardar
                getUI().ifPresent(ui -> ui.navigate("productos"));
            } else {
                Notification.show("Por favor, llene todos los campos", 3000, Notification.Position.MIDDLE);
            }
        });
        buttonSecondary.setText("Cancelar");
        buttonSecondary.setWidth("min-content");

        getContent().add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(textField);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(textField2);
        formLayout2Col.add(textField3);
        layoutColumn2.add(layoutRow);
        layoutRow.add(guardar);
        layoutRow.add(buttonSecondary);
    }
}
