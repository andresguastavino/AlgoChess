package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.excepciones.FinDelJuegoException;
import fiuba.algo3.algochess.modelo.unidades.Observable;
import fiuba.algo3.algochess.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Observable {
    private static final int PUNTOS_INICIALES = 20;
    private static final String NOMBRE_DEFAULT_BANDO_A = "A";
    private static final String NOMBRE_DEFAULT_BANDO_B = "B";

    private String bando;
    private List<Unidad> unidades;
    private Billetera billetera;
    private GestorDeCompras gestorDeCompras;

    private static int numeroJugador = 1;

    protected Jugador() {
        unidades = new ArrayList<>();
        billetera = new Billetera(PUNTOS_INICIALES);
        gestorDeCompras = new GestorDeCompras(this);

        if(numeroJugador == 1){
            bando = NOMBRE_DEFAULT_BANDO_A;
        } else {
            bando = NOMBRE_DEFAULT_BANDO_B;
        }
        numeroJugador++;
    }

    public String getBando() {
        return bando;
    }

    public int getPuntos() {
        return billetera.getPuntos();
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    void agregarUnidad(Unidad unidad) {
        unidad.setPropietario(this);
        unidades.add(unidad);
    }

    public void comprarUnidad(Unidad unidad) {
        gestorDeCompras.comprarUnidad(unidad, billetera);
        notifyObservers();
    }

    public void quitarUnidad(Unidad unidad) {
        unidades.remove(unidad);
        if(unidades.isEmpty()) {
            throw new FinDelJuegoException();
        }
    }

    /*public boolean perdioElJuego() {
        return getUnidades().size() == 0 && !gestorDeCompras.puedeComprar();
    }*/

    public boolean esMiUnidad(Unidad unidad) {
        return unidades.contains(unidad);
    }

    public boolean noEsMiUnidad(Unidad unidad) {
        return !esMiUnidad(unidad);
    }

	public void setBando(String nombre) {
		this.bando = nombre;
		
	}
}
