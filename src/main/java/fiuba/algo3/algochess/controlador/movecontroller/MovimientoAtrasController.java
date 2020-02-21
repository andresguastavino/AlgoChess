package fiuba.algo3.algochess.controlador.movecontroller;

import fiuba.algo3.algochess.controlador.AccionesController;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.unidadview.UnidadView;
import javafx.scene.input.MouseEvent;


public class MovimientoAtrasController extends MoveHandler {
    public MovimientoAtrasController(Unidad unidad, UnidadView unidadView) {
        super(unidad, unidadView);
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverHaciaAtras();
        unidadView.setFrameDown();
        unidadView.update();
        AccionesController.getInstancia().reset();
    }
}

