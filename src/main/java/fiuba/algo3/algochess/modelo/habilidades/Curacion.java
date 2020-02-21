package fiuba.algo3.algochess.modelo.habilidades;

import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.unidades.Unidad;

public class Curacion extends Habilidad {
    private final static int PUNTOS_DE_CURACION = 15;

    public Curacion(Unidad portador) {
        super(portador);
    }

    private void curar(Unidad objetivo) {
        if (portador.estaACortaDistancia(objetivo))
            objetivo.aumentarVida(PUNTOS_DE_CURACION);
        else
            throw new UnidadFueraDeRango();
    }

    @Override
    public void usarHabilidad(Unidad objetivo) {
        curar(objetivo);
    }
}
