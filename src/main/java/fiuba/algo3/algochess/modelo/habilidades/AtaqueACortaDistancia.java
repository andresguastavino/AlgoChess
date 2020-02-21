package fiuba.algo3.algochess.modelo.habilidades;

import fiuba.algo3.algochess.modelo.excepciones.NoSePuedeAtacarAAliados;
import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.unidades.Unidad;

public class AtaqueACortaDistancia extends Habilidad {
    private int danio;

    public AtaqueACortaDistancia(Unidad portador, int danio) {
        super(portador);
        this.danio = danio;
    }

    @Override
    public void usarHabilidad(Unidad objetivo) {
        if (portador.soyAliadoDe(objetivo))
            throw new NoSePuedeAtacarAAliados();

        if(!objetivo.estaACortaDistancia(portador))
            throw new UnidadFueraDeRango();

        objetivo.disminuirVida(danio);
    }
}
