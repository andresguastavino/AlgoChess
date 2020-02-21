package fiuba.algo3.algochess.vista;


import fiuba.algo3.algochess.controlador.buttonHandler.EmpezarJuegoHandler;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

public class ButtonEmpezarJuego extends Button {

	public ButtonEmpezarJuego(AlgoChessView manejador) {
        super();
        this.setMinSize(132,66);
        this.setMaxSize(132,66);
        this.setText("Start");
        this.setTextAlignment(TextAlignment.CENTER);
        this.setOnAction(new EmpezarJuegoHandler(manejador));
    }
}
