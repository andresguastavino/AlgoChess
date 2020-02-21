package fiuba.algo3.algochess.modelo.unidades;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.excepciones.NoSePuedeMoverLaUnidad;
import fiuba.algo3.algochess.modelo.habilidades.Habilidad;
import fiuba.algo3.algochess.modelo.habilidades.AtaqueEncadenadoADistancia;
import fiuba.algo3.algochess.modelo.tablero.Jugador;

public class Catapulta extends Unidad {
	private final static int VIDA_INICIAL = 50;
	private final static int COSTO = 5;

	private Habilidad habilidad;

	public Catapulta(Jugador propietario) {
		super(propietario, VIDA_INICIAL, COSTO);
		habilidad = new AtaqueEncadenadoADistancia(this);
	}

	public Catapulta() {
		super(VIDA_INICIAL, COSTO);
		habilidad = new AtaqueEncadenadoADistancia(this);
	}

	// Esta unidad no puede curarse.
	@Override
	public void aumentarVida(int vida) {
	}

	@Override
	public void usarHabilidad(Unidad objetivo) {
		if(AdministradorDeTurnos.getInstancia().turnoDe(propietario)) {
			habilidad.usarHabilidad(objetivo);
			AdministradorDeTurnos.getInstancia().cambiarTurnos();
		}
	}

	// Esta unidad no puede moverse.
	@Override
	public void moverHaciaAdelante() {
		throw new NoSePuedeMoverLaUnidad();
	}

	@Override
	public void moverALaDerecha() {
		throw new NoSePuedeMoverLaUnidad();
	}

	@Override
	public void moverHaciaAtras() {
		throw new NoSePuedeMoverLaUnidad();
	}

	@Override
	public void moverALaIzquierda() {
		throw new NoSePuedeMoverLaUnidad();
	}
}
