package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.modelo.unidades.Unidad;

public class EstadoCasillaOcupada extends EstadoCasilla {
    private Unidad ocupante;

    EstadoCasillaOcupada(Casilla casilla, Unidad ocupante) {
        super(casilla);
        this.ocupante = ocupante;
        ocupante.setCasilla(casilla);
    }

    @Override
    public void setOcupante(Unidad ocupante) {
        throw new CasillaOcupadaException();
    }

    @Override
    public Unidad getOcupante() {
        return ocupante;
    }

    @Override
    public Unidad removeOcupante() {
        casilla.setEstado(new EstadoCasillaVacia(casilla));
        return ocupante;
    }
}
