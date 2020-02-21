package fiuba.algo3.algochess.controlador.movecontroller;

import javafx.scene.input.MouseEvent;

public class MovimientoControllerNull extends MoveHandler {
    public MovimientoControllerNull() {
        super(null, null);
    }

    public void handle(MouseEvent mouseEvent){}
}
