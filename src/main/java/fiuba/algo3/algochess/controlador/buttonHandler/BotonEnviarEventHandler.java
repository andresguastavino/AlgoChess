package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.modelo.tablero.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BotonEnviarEventHandler implements EventHandler<ActionEvent> {

    private TextField textField;
    private Label label;
    private Jugador jugador;

    public BotonEnviarEventHandler(TextField textField, Label label, Jugador jugador) {
        this.textField = textField;
        this.label = label;
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (this.textField.getText().trim().equals("")) {

            this.label.setText("Debe ingresar un texto");
            this.label.setTextFill(Color.web("#FF0000"));

        } else {

            jugador.setBando(textField.getText());
        }
    }
}
