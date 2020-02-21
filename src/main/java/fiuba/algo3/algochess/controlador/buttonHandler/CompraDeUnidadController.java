package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.ShopView;
import fiuba.algo3.algochess.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class CompraDeUnidadController implements EventHandler<ActionEvent> {
    protected TableroView tableroView;
    protected Tablero tablero;
    protected ShopView shopView;

    public CompraDeUnidadController(Tablero tablero, TableroView tableroView, ShopView shopView) {
        this.tableroView = tableroView;
        this.tablero = tablero;
        this.shopView = shopView;
    }

    protected abstract Unidad comprarUnidad();

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            Unidad unidad = comprarUnidad();
            AdministradorDeTurnos.getInstancia().jugadorActual().comprarUnidad(unidad);
            shopView.setDisable(true);
            tableroView.setDisable(false);
            tableroView.pintarCasillasDelJugadorActual();
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(unidad, tablero, tableroView, shopView));
        } catch (RuntimeException e) {
            System.out.println("Dinero insuficiente\n"
                    + "No tienes suficiente dinero para comprar esta unidad");
        }
    }
}
