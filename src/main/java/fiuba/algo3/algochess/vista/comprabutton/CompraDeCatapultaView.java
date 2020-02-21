package fiuba.algo3.algochess.vista.comprabutton;

import fiuba.algo3.algochess.controlador.buttonHandler.ComprarCatapultaHandler;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.vista.ShopView;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.Sprite;

public class CompraDeCatapultaView extends CompraDeUnidadView {
    public CompraDeCatapultaView(Tablero tablero, TableroView tableroView, ShopView shopView) {
        super(new ComprarCatapultaHandler(tablero, tableroView, shopView), tableroView,
                new Sprite("src/main/resources/caras.png", 6, 0, 27, 19, 50, 50),
                new Sprite("src/main/resources/caras.png", 7, 0, 27, 19, 50, 50)
        );
        this.setText("Catapulta\nCosto(5)\nAtaque a distancia larga(20)");
        this.setWrapText(false);
    }
}
