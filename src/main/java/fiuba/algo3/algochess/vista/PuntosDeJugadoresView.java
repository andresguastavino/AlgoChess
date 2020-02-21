package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PuntosDeJugadoresView extends HBox implements Observer {
    private Jugador jugadorA;
    private Jugador jugadorB;
    private Label label;

    public PuntosDeJugadoresView(Jugador jugadorA, Jugador jugadorB) {
        this.jugadorA = jugadorA;
        this.jugadorB = jugadorB;

        this.label = new Label("Puntos "+jugadorA.getBando() + ": " + jugadorA.getPuntos() + "   |    Puntos " + jugadorB.getBando() +": " + jugadorB.getPuntos());
        this.label.setStyle("-fx-font-weight: bold");
        this.label.setMinWidth(320);
        jugadorA.addObserver(this);
        jugadorB.addObserver(this);

        this.getChildren().add(label);
    }

    @Override
    public void change() {
        this.label.setText("Puntos "+jugadorA.getBando() + ": " + jugadorA.getPuntos() + "   |    Puntos " + jugadorB.getBando() +": " + jugadorB.getPuntos());
    }
}
