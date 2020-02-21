package fiuba.algo3.algochess.vista;


import fiuba.algo3.algochess.controlador.buttonHandler.PasarTurnoHandler;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

public class ButtonPasarTurno extends Button{
	
	public ButtonPasarTurno() {
        super();
        this.setMinSize(320,56);
        this.setMaxSize(320,56);
        this.setText("Pasar Turno");
        this.setTextAlignment(TextAlignment.CENTER);
        this.setOnAction(new PasarTurnoHandler());
    }
}
