package fiuba.algo3.algochess.controlador.movecontroller;

import fiuba.algo3.algochess.vista.unidadview.UnidadView;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public abstract class MoveHandler implements EventHandler<MouseEvent> {
    protected UnidadView unidadView;
    protected Unidad unidad;

    public MoveHandler(Unidad unidad, UnidadView unidadView) {
        this.unidadView = unidadView;
        this.unidad = unidad;
    }

    public abstract void handle(MouseEvent mouseEvent);
}
