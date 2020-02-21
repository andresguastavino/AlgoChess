package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Curandero;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.ReproductorMusica;
import fiuba.algo3.algochess.vista.ShopView;
import fiuba.algo3.algochess.vista.TableroView;

public class ComprarCuranderoHandler extends CompraDeUnidadController {
    private ReproductorMusica reproductorMusica;

    public ComprarCuranderoHandler(Tablero tablero, TableroView tableroView, ShopView shopView) {
        super(tablero, tableroView, shopView);
        reproductorMusica = new ReproductorMusica("curandero.mp3");
    }

    @Override
    protected Unidad comprarUnidad() {
        reproductorMusica.reproducirEfectoDeSonido();
        return new Curandero();
    }
}
