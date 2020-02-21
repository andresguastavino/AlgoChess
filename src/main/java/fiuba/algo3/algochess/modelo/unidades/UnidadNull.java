package fiuba.algo3.algochess.modelo.unidades;

import fiuba.algo3.algochess.modelo.tablero.Casilla;
import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.tablero.JugadorNull;

import java.util.ArrayList;
import java.util.List;

public class UnidadNull extends Unidad {
    private static final int VIDA_DEFAULT = 100;
    private static final int COSTO_DEFAULT = 0;

    public UnidadNull() {
        super(new JugadorNull(), VIDA_DEFAULT, COSTO_DEFAULT);
    }

    @Override
    public boolean soyAliadoDe(Unidad unidad) {
        return false;
    }

    @Override
    public boolean soyEnemigoDe(Unidad unidad) {
        return false;
    }

    @Override
    public boolean esMiPropietario(Jugador jugador) {
        return false;
    }

    @Override
    public void disminuirVida(int danio) {
        //No tiene vida que disminuir.
    }

    @Override
    public void usarHabilidad(Unidad objetivo) {
        // No realiza ninguna accion.
    }

    @Override
    public void aumentarVida(int vida) {
        // No se aumneta la vida.
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    private boolean perteneceA(Jugador jugador) {
        return false;
    }

    public List<Unidad> unidadesAdyacentes() {
        return new ArrayList<>();
    }

    public List<Unidad> unidadesCerca() {
        return new ArrayList<>();
    }

    private List<Unidad> aliadosCerca() {
        return new ArrayList<>();
    }

    public List<Unidad> enemigosCerca() {
        return new ArrayList<>();
    }

    public boolean tieneAliadosCerca() {
        return false;
    }

    public boolean noTieneAliadosCerca() {
        return true;
    }

    public boolean tieneEnemigosCerca() {
        return false;
    }

    public boolean noTieneEnemigosCerca() {
        return !tieneEnemigosCerca();
    }

    public boolean estaACortaDistancia(Unidad unidad) {
        return false;
    }

    public boolean estaAMediaDistancia(Unidad unidad) {
        return false;
    }

    public boolean estaALargaDistancia(Unidad unidad) {
        return false;
    }

    @Override
    public void moverHaciaAdelante() {

    }

    @Override
    public void moverALaDerecha() {
    }

    @Override
    public void moverHaciaAtras() {
    }

    @Override
    public void moverALaIzquierda() {
    }
}
