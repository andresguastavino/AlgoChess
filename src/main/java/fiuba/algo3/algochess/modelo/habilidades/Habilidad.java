package fiuba.algo3.algochess.modelo.habilidades;

import fiuba.algo3.algochess.modelo.unidades.Unidad;

public abstract class Habilidad {
	protected Unidad portador;

	public Habilidad(Unidad portador){
		this.portador = portador;
	}

	public abstract void usarHabilidad(Unidad objetivo);
}
