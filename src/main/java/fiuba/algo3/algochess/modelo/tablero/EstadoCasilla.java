package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.unidades.Unidad;

public abstract class EstadoCasilla {
    Casilla casilla;

    EstadoCasilla(Casilla casilla){
        this.casilla = casilla;
    }

    public abstract void setOcupante(Unidad ocupante);
    public abstract Unidad getOcupante();
    public abstract Unidad removeOcupante();
}
