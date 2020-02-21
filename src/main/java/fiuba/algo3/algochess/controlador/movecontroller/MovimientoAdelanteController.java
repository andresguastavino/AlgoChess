package fiuba.algo3.algochess.controlador.movecontroller;

import fiuba.algo3.algochess.controlador.AccionesController;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.unidadview.UnidadView;
import javafx.scene.input.MouseEvent;


public class MovimientoAdelanteController extends MoveHandler {
    public MovimientoAdelanteController(Unidad unidad, UnidadView unidadView) {
        super(unidad, unidadView);
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverHaciaAdelante();
        unidadView.setFrameUp();
        unidadView.change();
        AccionesController.getInstancia().reset();
    }
}
