package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.modelo.excepciones.NoSePuedePosicionarEnTerrenoEnemigo;
import fiuba.algo3.algochess.modelo.tablero.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.*;
import fiuba.algo3.algochess.vista.unidadview.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PosicionarUnidadEvent implements EventHandler<MouseEvent> {
    private Unidad unidad;
    private Tablero tablero;
    private TableroView tableroView;
    private ShopView shopView;

    public PosicionarUnidadEvent(Unidad unidad, Tablero tablero, TableroView tableroView, ShopView shopView) {
        this.unidad = unidad;
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.shopView = shopView;
    }

    public void handle(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();
        int x = (int) mouseX / tableroView.getTileWidth();
        int y = (int) mouseY / tableroView.getTileHeigth();

        try {
            if (unidad != null) {
                tablero.posicionarUnidad(unidad, new Posicion(x, y));
                tableroView.resetearCasillas();
                shopView.setDisable(false);
                tableroView.setDisable(true);

                if(AdministradorDeTurnos.getInstancia().turnoDe(tablero.getJugadorB()))
                    ViewFactoryB.getInstance(unidad, tableroView);
                else
                    ViewFactoryA.getInstance(unidad, tableroView);

                AdministradorDeTurnos.getInstancia().administrarCompras();
                unidad = null;
            }
        } catch (NoSePuedePosicionarEnTerrenoEnemigo e) {
            System.out.println(
                    "Casilla invalida\n"
                    + "Ese lado del mapa no te pertenece para posicionar unidades"
            );
        } catch (CasillaOcupadaException e) {
            System.out.println(
                    "Casilla ocupada\n"
                    + "Esa casilla ya esta ocupada por otra unidad"
            );
        }
    }
}
