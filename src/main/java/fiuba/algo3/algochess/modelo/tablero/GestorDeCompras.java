package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.unidades.Unidad;

public class GestorDeCompras {

    protected Jugador propietario;

    GestorDeCompras(Jugador propietario) {
        this.propietario = propietario;
    }

    public void comprarUnidad(Unidad unidad, Billetera billetera) {
        billetera.pagar(unidad.getCosto());
        propietario.agregarUnidad(unidad);
    }
}
