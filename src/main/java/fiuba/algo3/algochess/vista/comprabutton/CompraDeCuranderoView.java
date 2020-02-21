package fiuba.algo3.algochess.vista.comprabutton;

import fiuba.algo3.algochess.controlador.buttonHandler.ComprarCuranderoHandler;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.vista.ShopView;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.Sprite;

public class CompraDeCuranderoView extends CompraDeUnidadView {
    public CompraDeCuranderoView(Tablero tablero, TableroView tableroView, ShopView shopView) {
        super(new ComprarCuranderoHandler(tablero, tableroView, shopView), tableroView,
                new Sprite("src/main/resources/caras.png", 12, 0, 27, 19, 50, 50),
                new Sprite("src/main/resources/caras.png", 13, 0, 27, 19, 50, 50)
        );
        this.setText("\nCurandero\nCosto(2)\nCura a distancia corta(15)");
        this.setWrapText(false);
    }
}
