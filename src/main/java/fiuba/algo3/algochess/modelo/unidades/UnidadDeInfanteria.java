package fiuba.algo3.algochess.modelo.unidades;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.habilidades.AtaqueACortaDistancia;
import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.habilidades.Habilidad;

import java.util.List;

public class UnidadDeInfanteria extends Unidad {
    private final static int CANTIDAD_DE_UNIDADES_DEL_BATALLON = 3;
    private final static int VIDA_INICIAL = 100;
    private final static int DANIO_INICIAL = 10;
    private final static int COSTO = 1;

    private Habilidad habilidad;
    private Batallon miBatallon;

    public UnidadDeInfanteria(Jugador propietario) {
        super(propietario, VIDA_INICIAL, COSTO);
        habilidad = new AtaqueACortaDistancia(this, DANIO_INICIAL);
        miBatallon = new Batallon(this, CANTIDAD_DE_UNIDADES_DEL_BATALLON);
    }

    public UnidadDeInfanteria() {
        super(VIDA_INICIAL, COSTO);
        habilidad = new AtaqueACortaDistancia(this, DANIO_INICIAL);
        miBatallon = new Batallon(this, CANTIDAD_DE_UNIDADES_DEL_BATALLON);
    }

    public void usarHabilidad(Unidad objetivo) {
        if(AdministradorDeTurnos.getInstancia().turnoDe(propietario)) {
            habilidad.usarHabilidad(objetivo);
            AdministradorDeTurnos.getInstancia().cambiarTurnos();
        }
    }

    @Override
    public void enlistarse(Batallon batallon) {
        batallon.enlistarUnidad(this);
    }

    private void reclutarUnidades() {
        List<Unidad> unidadesAdyacentes = casilla.getUnidadesAdyacentes();
        miBatallon.enlistarUnidades(unidadesAdyacentes);
    }

    @Override
    public void moverHaciaAdelante() {
        if(AdministradorDeTurnos.getInstancia().turnoDe(propietario)) {
            reclutarUnidades();
            miBatallon.moverHaciaAdelante();
            AdministradorDeTurnos.getInstancia().cambiarTurnos();
        }
    }

    @Override
    public void moverALaDerecha() {
        if(AdministradorDeTurnos.getInstancia().turnoDe(propietario)) {
            reclutarUnidades();
            miBatallon.moverALaDerecha();
            AdministradorDeTurnos.getInstancia().cambiarTurnos();
        }
    }

    @Override
    public void moverHaciaAtras() {
        if(AdministradorDeTurnos.getInstancia().turnoDe(propietario)) {
            reclutarUnidades();
            miBatallon.moverHaciaAtras();
            AdministradorDeTurnos.getInstancia().cambiarTurnos();
        }
    }

    @Override
    public void moverALaIzquierda() {
        if(AdministradorDeTurnos.getInstancia().turnoDe(propietario)) {
            reclutarUnidades();
            miBatallon.moverALaIzquierda();
            AdministradorDeTurnos.getInstancia().cambiarTurnos();
        }
    }

    @Override
    protected void moverEnBatallonHaciaAdelante() {
        casilla.moverUnidadHaciaAdelante();
        notifyObservers();
    }

    @Override
    protected void moverEnBatallonALaDerecha() {
        casilla.moverUnidadALaDerecha();
        notifyObservers();
    }

    @Override
    protected void moverEnBatallonHaciaAtras() {
        casilla.moverUnidadHaciaAtras();
        notifyObservers();
    }

    @Override
    protected void moverEnBatallonALaIzquierda() {
        casilla.moverUnidadALaIzquierda();
        notifyObservers();
    }
}
