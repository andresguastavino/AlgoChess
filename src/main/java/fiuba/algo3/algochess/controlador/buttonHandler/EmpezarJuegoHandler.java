package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.modelo.unidades.Observable;
import fiuba.algo3.algochess.vista.AlgoChessView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EmpezarJuegoHandler extends Observable implements EventHandler<ActionEvent> {
	AlgoChessView manejador;
	
	public EmpezarJuegoHandler(AlgoChessView manejador) {
		addObserver(manejador);
	}

	@Override
	public void handle(ActionEvent event) {
		notifyObservers();
	}

}
