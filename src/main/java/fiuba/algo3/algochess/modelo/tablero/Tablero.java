package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.excepciones.NoExisteCasillaEnPosicionException;
import fiuba.algo3.algochess.modelo.excepciones.NoSePuedePosicionarEnTerrenoEnemigo;
import fiuba.algo3.algochess.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Tablero {
    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;

    private Jugador jugadorA;
    private Jugador jugadorB;

    private List<Casilla> casillas;
    private List<Unidad> unidades;

    public Tablero() {
        jugadorA = new Jugador();
        jugadorB = new Jugador();
        unidades = new LinkedList<>();
        setCasillasVacias();

        AdministradorDeTurnos.getInstancia().actual(jugadorA);
        AdministradorDeTurnos.getInstancia().enEspera(jugadorB);
    }

    private void setCasillasVacias() {
        casillas = new ArrayList<>();
        inicializarFilasDeCasillas(0, FILAS / 2, jugadorA);
        inicializarFilasDeCasillas(FILAS / 2, FILAS, jugadorB);
    }

    private void inicializarFilasDeCasillas(int filaInicial, int filaFinal, Jugador propietario) {
        for (int i = 0; i < COLUMNAS; i++) {
            for (int j = filaInicial; j < filaFinal; j++) {
                Casilla casilla = new Casilla(this, new Posicion(i, j));
                casilla.setPropietario(propietario);
                casillas.add(casilla);
            }
        }
    }

    protected Casilla getCasillaEnPosicion(Posicion posicion) {
        Optional<Casilla> optionalCasilla = casillas
                .stream()
                .filter(c -> c.estaEnPosicion(posicion))
                .findFirst();

        if(optionalCasilla.isPresent())
            return optionalCasilla.get();

        throw new NoExisteCasillaEnPosicionException();
    }

    public int getWidth() {
        return COLUMNAS;
    }

    public int getHeight() {
        return FILAS;
    }

    private boolean puedePosicionarUnidadEnPosicion(Unidad unidad, Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        return casilla.esTerrenoAliadoPara(unidad);
    }

    private boolean noPuedePosicionarUnidadEnPosicion(Unidad unidad, Posicion posicion) {
        return !puedePosicionarUnidadEnPosicion(unidad, posicion);
    }

    public void posicionarUnidad(Unidad unidad, Posicion posicion) {
        if (noPuedePosicionarUnidadEnPosicion(unidad, posicion))
            throw new NoSePuedePosicionarEnTerrenoEnemigo();

        Casilla casilla = getCasillaEnPosicion(posicion);
        casilla.setOcupante(unidad);
        unidades.add(unidad);
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
    }

    public void quitarUnidad(Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        Unidad unidad = casilla.removeOcupante();
        unidades.remove(unidad);
    }

    public Unidad getUnidadEnPosicion(Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        return casilla.getOcupante();
    }

    public List<Unidad> getUnidadesAdyacencesAUnidad(Unidad unidad) {
        return unidades
                .stream()
                .filter(u -> u.esAdyacente(unidad))
                .collect(toList());
    }

    public List<Unidad> getUnidadesADistanciaCorta(Unidad unidad) {
        return unidades
                .stream()
                .filter(u -> u.estaACortaDistancia(unidad))
                .collect(toList());
    }

    public List<Unidad> getUnidadesADistanciaMedia(Unidad unidad) {
        return unidades
                .stream()
                .filter(u -> u.estaAMediaDistancia(unidad))
                .collect(toList());
    }

    public List<Unidad> getUnidadesADistanciaLarga(Unidad unidad) {
        return unidades
                .stream()
                .filter(u -> u.estaALargaDistancia(unidad))
                .collect(toList());
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public Jugador getJugadorA() {
        return jugadorA;
    }

    public Jugador getJugadorB() {
        return jugadorB;
    }
}
