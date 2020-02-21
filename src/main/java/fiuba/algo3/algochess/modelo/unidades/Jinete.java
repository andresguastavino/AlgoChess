package fiuba.algo3.algochess.modelo.unidades;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.habilidades.Habilidad;
import fiuba.algo3.algochess.modelo.habilidades.AtaqueJinete;

public class Jinete extends Unidad {
	private final static int VIDA_INICIAL = 100;
	private final static int COSTO = 3;

	private Habilidad habilidad;

	public Jinete(Jugador propietario) {
		super(propietario, VIDA_INICIAL, COSTO);
		habilidad = new AtaqueJinete(this);
	}

	public Jinete() {
		super(VIDA_INICIAL, COSTO);
		habilidad = new AtaqueJinete(this);
	}

	@Override
	public void usarHabilidad(Unidad objetivo) {
		if (AdministradorDeTurnos.getInstancia().turnoDe(propietario)) {
			habilidad.usarHabilidad(objetivo);
			AdministradorDeTurnos.getInstancia().cambiarTurnos();
		}
	}
}
