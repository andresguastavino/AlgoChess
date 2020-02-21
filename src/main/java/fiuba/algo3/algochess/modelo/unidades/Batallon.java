package fiuba.algo3.algochess.modelo.unidades;

import fiuba.algo3.algochess.modelo.excepciones.BatallonCompleto;
import fiuba.algo3.algochess.modelo.excepciones.NoSePuedeUnirABatallonRival;

import java.util.ArrayList;
import java.util.List;

public class Batallon {
    private int max_unidades;
    private List<Unidad> batallon;
    private Unidad capitan;

    public Batallon(Unidad capitan, int max_unidades) {
        batallon = new ArrayList<Unidad>(max_unidades);
        batallon.add(capitan);
        this.capitan = capitan;
        this.max_unidades = max_unidades;
    }

    private boolean batallonCompleto() {
        return batallon.size() == max_unidades;
    }

    private boolean batallonIncompleto(){
        return batallon.size() < max_unidades;
    }

    private void limpiarBatallon() {
        batallon.clear();
        batallon.add(capitan);
    }

    private void disolverBatallonSiEstaIncompleto() {
        if(batallonIncompleto())
            limpiarBatallon();
    }

    public void enlistarUnidad(Unidad unidad){
        if(batallonCompleto())
            throw new BatallonCompleto();
        if(unidad.soyEnemigoDe(capitan))
        	throw new NoSePuedeUnirABatallonRival();
        batallon.add(unidad);
    }

    public void enlistarUnidades(List<Unidad> unidades) {
        for(Unidad unidad : unidades){
            try {
                unidad.enlistarse(this);
            } catch(BatallonCompleto exception) {
                // Error al unirse al batallon.
            } catch(NoSePuedeUnirABatallonRival exception) {
            	// Error al unirse al batallon.
            }
        }
        disolverBatallonSiEstaIncompleto();
    }

    private void moverUnidadAdelante(Unidad unidad) {
        try {
            unidad.moverEnBatallonHaciaAdelante();
        } catch (RuntimeException exception) {
            // No se pudo mover.
        }
    }

    private void moverUnidadALaDerecha(Unidad unidad) {
        try {
            unidad.moverEnBatallonALaDerecha();
        } catch (RuntimeException exception) {
            // No se pudo mover.
        }
    }

    private void moverUnidadHaciaAtras(Unidad unidad) {
        try {
            unidad.moverEnBatallonHaciaAtras();
        } catch (RuntimeException exception) {
            // No se pudo mover.
        }
    }

    private void moverUnidadALaIzquierda(Unidad unidad) {
        try {
            unidad.moverEnBatallonALaIzquierda();
        } catch (RuntimeException exception) {
            // No se pudo mover.
        }
    }

    // Cada movimiento desarma el batallon y solo queda su capitan.
    public void moverHaciaAdelante() {
        for(Unidad unidad : batallon){
            moverUnidadAdelante(unidad);
        }
        limpiarBatallon();
    }

    public void moverALaDerecha() {
        for(Unidad unidad : batallon){
            moverUnidadALaDerecha(unidad);
        }
        limpiarBatallon();
    }

    public void moverHaciaAtras() {
        for(Unidad unidad : batallon){
            moverUnidadHaciaAtras(unidad);
        }
        limpiarBatallon();
    }

    public void moverALaIzquierda() {
        for(Unidad unidad : batallon){
            moverUnidadALaIzquierda(unidad);
        }
        limpiarBatallon();
    }
}
