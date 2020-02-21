package fiuba.algo3.algochess.controlador.movecontroller;

import fiuba.algo3.algochess.controlador.AccionesController;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.unidadview.UnidadView;
import javafx.scene.input.MouseEvent;


public class MovimientoIzquierdaController extends MoveHandler {
    public MovimientoIzquierdaController(Unidad unidad, UnidadView unidadView) {
        super(unidad, unidadView);
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverALaIzquierda();
        unidadView.setFrameLeft();
        unidadView.update();
        AccionesController.getInstancia().reset();
    }
}
