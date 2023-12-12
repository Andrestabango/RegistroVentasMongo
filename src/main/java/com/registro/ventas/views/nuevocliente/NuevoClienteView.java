package com.registro.ventas.views.nuevocliente;

import com.registro.ventas.models.Cliente;
import com.registro.ventas.utils.Util;
import com.registro.ventas.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Nuevo Cliente")
@Route(value = "nuevo-cliente", layout = MainLayout.class)
@Uses(Icon.class)
public class NuevoClienteView extends Composite<VerticalLayout> {

    public NuevoClienteView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H3 h3 = new H3();
        FormLayout formLayout2Col = new FormLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        EmailField emailField = new EmailField();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button guardar = new Button();
        Button botonSecundario = new Button();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);

        layoutColumn2.setWidth("800px");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("min-content");

        h3.setText("Información del Cliente");
        h3.setWidth("100%");

        formLayout2Col.setWidth("100%");

        textField.setLabel("Nombre:");
        textField2.setLabel("Cédula:");
        textField2.setWidth("372px");
        emailField.setLabel("Correo electrónico:");
        emailField.setWidth("372px");

        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");

        guardar.setText("Guardar");
        guardar.setWidth("min-content");
        guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Cliente cliente1 = new Cliente();

        guardar.addClickListener(event -> {
            // Obtener los valores de los campos y guardar en la lista de clientes
            String nombre = textField.getValue();
            String cedula = textField2.getValue();
            String correo = emailField.getValue();

            // Validar que los campos no estén vacíos antes de guardar
            if (!nombre.isEmpty() && !cedula.isEmpty() && !correo.isEmpty()) {
                cliente1.setNombre(nombre);
                cliente1.setCedula(cedula);
                cliente1.setCorreo(correo);

                Util.listaClientes.add(cliente1);

                // Navegar a la vista de clientes después de guardar
                getUI().ifPresent(ui -> ui.navigate("clientes"));
            } else {
                System.out.println("Ingrese datos correctos");
            }
        });

        botonSecundario.setText("Cancelar");
        botonSecundario.setWidth("min-content");

        getContent().add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(textField);
        formLayout2Col.add(textField2);
        formLayout2Col.add(emailField);
        layoutColumn2.add(layoutRow);
        layoutRow.add(guardar);
        layoutRow.add(botonSecundario);
    }
}
