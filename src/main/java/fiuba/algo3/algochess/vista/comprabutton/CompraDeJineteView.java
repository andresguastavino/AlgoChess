package fiuba.algo3.algochess.vista.comprabutton;

import fiuba.algo3.algochess.controlador.buttonHandler.ComprarJineteHandler;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.vista.ShopView;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.Sprite;

public class CompraDeJineteView extends CompraDeUnidadView {
    public CompraDeJineteView(Tablero tablero, TableroView tableroView, ShopView shopView) {
        super(new ComprarJineteHandler(tablero, tableroView, shopView), tableroView,
                new Sprite("src/main/resources/caras.png", 8, 0, 27, 19, 50, 50),
                new Sprite("src/main/resources/caras.png", 9, 0, 27, 19, 50, 50)
        );
        this.setText("Jinete\nCosto(3)\nAtaque a distancia media(15)\nAtaque a distancia corta(5)");
        this.setWrapText(false);
    }
}
