package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.modelo.unidades.UnidadNull;

public class EstadoCasillaVacia extends EstadoCasilla {
    private Unidad ocupante = new UnidadNull();

    EstadoCasillaVacia(Casilla casilla) {
        super(casilla);
    }

    @Override
    public void setOcupante(Unidad ocupante) {
        EstadoCasilla nuevoEstado = new EstadoCasillaOcupada(casilla, ocupante);
        casilla.setEstado(nuevoEstado);
    }

    @Override
    public Unidad getOcupante() {
        return ocupante;
    }

    @Override
    public Unidad removeOcupante() {
        return ocupante;
    }
}
