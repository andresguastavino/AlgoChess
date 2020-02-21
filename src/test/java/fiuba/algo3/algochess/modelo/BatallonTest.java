package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.unidades.Jinete;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.algochess.modelo.tablero.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BatallonTest {
    @Test
    void armoUnBatallonEnFilaYAlMoverLaUnidadDelMedioAdelanteDeberiaMoverseTodoElBatallon() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(1,3));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(unidad2, new Posicion(2,3));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(unidad3, new Posicion(3,3));

        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        unidad2.moverHaciaAdelante();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(1, 4)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(2, 4)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(3, 4)));
    }

    @Test
    void armoUnBatallonEnFilaYAlMoverLaUnidadDelMedioAtrasDeberiaMoverseTodoElBatallon() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(1,3));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(unidad2, new Posicion(2,3));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(unidad3, new Posicion(3,3));

        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        unidad2.moverHaciaAtras();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(1, 2)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(2, 2)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(3, 2)));
    }

    @Test
    void armoUnBatallonEnColumnaYAlMoverLaUnidadDelMedioHaciaLaDerechaDeberiaMoverseTodoElBatallon() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(3,0));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(unidad2, new Posicion(3,1));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(unidad3, new Posicion(3,2));

        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        unidad2.moverALaDerecha();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(4, 0)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(4, 1)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(4, 2)));
    }

    @Test
    void armoUnBatallonEnColumnaYAlMoverLaUnidadDelMedioHaciaLaIzquierdaDeberiaMoverseTodoElBatallon() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(3,0));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(unidad2, new Posicion(3,1));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(unidad3, new Posicion(3,2));

        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        unidad2.moverALaIzquierda();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(2, 0)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(2, 1)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(2, 2)));
    }

    @Test
    void verificoQueNoSeArmaUnBatallonConUnidadesQueNoSeanDeInfanteria() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new Jinete(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(3,4));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(unidad2, new Posicion(4,4));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(unidad3, new Posicion(5,4));

        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        unidad2.moverHaciaAtras();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(3, 4)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(4, 3)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(5, 4)));
    }
}
