package fiuba.algo3.algochess.controlador.buttonHandler;


import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PasarTurnoHandler implements EventHandler<ActionEvent> {
	
	public void handle(ActionEvent event) {
		AdministradorDeTurnos.getInstancia().cambiarTurnos();
		System.out.println("Turno Pasado");
    }

}
