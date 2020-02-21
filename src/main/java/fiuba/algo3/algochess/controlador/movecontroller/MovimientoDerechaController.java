package fiuba.algo3.algochess.controlador.movecontroller;

import fiuba.algo3.algochess.controlador.AccionesController;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.unidadview.UnidadView;
import javafx.scene.input.MouseEvent;


public class MovimientoDerechaController extends MoveHandler {
    public MovimientoDerechaController(Unidad unidad, UnidadView unidadView) {
        super(unidad, unidadView);
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverALaDerecha();
        unidadView.setFrameRight();
        unidadView.update();
        AccionesController.getInstancia().reset();
    }
}
