package fiuba.algo3.algochess.modelo.habilidades;

import fiuba.algo3.algochess.modelo.excepciones.NoSePuedeAtacarAAliados;
import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.unidades.Unidad;

public class AtaqueAMediaDistancia extends Habilidad {
	private int danio;

	AtaqueAMediaDistancia(Unidad portador, int danio) {
		super(portador);
		this.danio = danio;
	}

	@Override
	public void usarHabilidad(Unidad objetivo) {
		if (portador.soyAliadoDe(objetivo))
			throw new NoSePuedeAtacarAAliados();

		if(!objetivo.estaAMediaDistancia(portador))
			throw new UnidadFueraDeRango();

		objetivo.disminuirVida(danio);
	}
}
