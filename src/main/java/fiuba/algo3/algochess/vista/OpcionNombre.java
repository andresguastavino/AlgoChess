package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.controlador.TextoEventHandler;
import fiuba.algo3.algochess.controlador.buttonHandler.BotonEnviarEventHandler;
import fiuba.algo3.algochess.modelo.tablero.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OpcionNombre {
	private VBox principal;

	public OpcionNombre (Jugador jugador) {
		TextField texto = new TextField();
        texto.setPromptText("Nombre de " + jugador.getBando());
        texto.setMaxWidth(132);

        Label etiqueta = new Label();
        etiqueta.setText(texto.getText());
        etiqueta.setMaxWidth(132);

        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");

        HBox contenedorHorizontal = new HBox(botonEnviar);
        contenedorHorizontal.setSpacing(0);

        principal = new VBox(texto, contenedorHorizontal, etiqueta);
        principal.setSpacing(0);
        principal.setPadding(new Insets(0));
        
        BotonEnviarEventHandler botonEnviarEventHandler = new BotonEnviarEventHandler(texto, etiqueta, jugador);
        botonEnviar.setOnAction(botonEnviarEventHandler);

        TextoEventHandler textoEventHandler = new TextoEventHandler(botonEnviar);
        texto.setOnKeyPressed(textoEventHandler);
	}
	
	public VBox getOpcion() {
		return principal;
	}
	
}
