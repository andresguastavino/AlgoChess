package fiuba.algo3.algochess.controlador.unidadcontroller;

import fiuba.algo3.algochess.controlador.AccionesController;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.unidadview.UnidadView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class UnidadController implements EventHandler<MouseEvent> {
    protected Unidad unidad;
    protected UnidadView unidadView;
    protected TableroView tableroView;

    public UnidadController(Unidad unidad, UnidadView unidadView, TableroView tableroView) {
        this.unidad = unidad;
        this.unidadView = unidadView;
        this.tableroView = tableroView;
    }

    public void handle(MouseEvent mouseEvent) {
        if(AdministradorDeTurnos.getInstancia().turnoDe(unidad.propietario()) && !AccionesController.getInstancia().tieneAutor()) {
            ArrayList<Pane> panes = tableroView.getPanesAdyacentes(unidad, unidadView);
            panes.add(tableroView.paneActual(unidad));

            AccionesController.getInstancia().agregarUnidad(unidad, panes);
        } if (AccionesController.getInstancia().tieneAutor()) {
            AccionesController.getInstancia().agregarObjetivo(unidad);
        }
    }
}
