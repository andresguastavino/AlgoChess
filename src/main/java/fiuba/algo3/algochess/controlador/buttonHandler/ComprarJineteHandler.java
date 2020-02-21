package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.ReproductorMusica;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Jinete;
import fiuba.algo3.algochess.vista.ShopView;
import fiuba.algo3.algochess.vista.TableroView;

public class ComprarJineteHandler extends CompraDeUnidadController {
    private ReproductorMusica reproductorMusica;

    public ComprarJineteHandler(Tablero tablero, TableroView tableroView, ShopView shopView) {
        super(tablero, tableroView, shopView);
        reproductorMusica = new ReproductorMusica("jinete.mp3");
    }

    @Override
    protected Unidad comprarUnidad() {
        reproductorMusica.reproducirEfectoDeSonido();
        return new Jinete();
    }
}
