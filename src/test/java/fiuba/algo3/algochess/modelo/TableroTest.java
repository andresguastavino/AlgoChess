package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {
    @Test
    void seColocaUnaUnidadAliadaEnUnCasilleroDelSectorAliadoVacioConExito() {
        Tablero tablero = new Tablero();

        Unidad unidad = new UnidadDeInfanteria(tablero.getJugadorA());
        Posicion posicion = new Posicion(2, 2);

        assertDoesNotThrow(() -> tablero.posicionarUnidad(unidad, posicion));
        assertEquals(unidad, tablero.getUnidadEnPosicion(posicion));
    }

    @Test
    void seVerificaQueNoSePuedeColocarUnaUnidadAliadaEnUnCasilleroOcupadoEnElSectorAliado() {
        Tablero tablero = new Tablero();

        Posicion posicion = new Posicion(2, 2);
        Unidad unidad = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad, posicion);

        assertThrows(RuntimeException.class, () -> tablero.posicionarUnidad(unidad2, posicion));
    }

    @Test
    void seVerificaQueNoSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorEnemigo() {
        Tablero tablero = new Tablero();

        Unidad unidad = new UnidadDeInfanteria(tablero.getJugadorB());
        Posicion posicion = new Posicion(0, 0);

        assertThrows(RuntimeException.class, () -> tablero.posicionarUnidad(unidad, posicion));
    }

    @Test
    void seVerificaQueAlAtacarUnaUnidadEnemigaEnTerrenoAliadoSeLeQuitaUnCincoPorCientoMasDeVida() {
        Tablero tablero = new Tablero();
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(objetivo, new Posicion(0, 10));

        objetivo.moverHaciaAtras();
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        objetivo.moverHaciaAtras();

        int danio = 10;
        double vidaPrevia = objetivo.getVida();
        double vidaEsperada = vidaPrevia - (danio + (danio * 0.05));

        objetivo.disminuirVida(danio);

        assertEquals(vidaEsperada, objetivo.getVida());
    }

    @Test
    void seVerificaQueAlAtacarUnaUnidadEnemigaEnTerrenoEnemigoNoSeLeQuitaUnCincoPorCientoMasDeVida() {
        Tablero tablero = new Tablero();
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(objetivo, new Posicion(0, 10));

        int danio = 10;
        double vidaPrevia = objetivo.getVida();
        double vidaEsperada = vidaPrevia - danio;

        objetivo.disminuirVida(danio);

        assertEquals(vidaEsperada, objetivo.getVida());
    }

    @Test
    void sePosicionarDosUnidadesACortaDistanciaYUnaALarga() {
        Tablero tablero = new Tablero();

        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        Posicion posicion = new Posicion(3, 3);
        Posicion posicionAlejada = new Posicion(17, 2);

        tablero.posicionarUnidad(unidad1, posicion);
        tablero.posicionarUnidad(unidad2, posicion.posicionAtras());
        tablero.posicionarUnidad(unidad3, posicionAlejada);

        assertEquals(1, tablero.getUnidadesADistanciaCorta(unidad1).size());
        assertTrue(tablero.getUnidadesADistanciaCorta(unidad1).contains(unidad2));
        assertFalse(tablero.getUnidadesADistanciaCorta(unidad1).contains(unidad3));
    }

    @Test
    void sePosicionarDosUnidadesAMediaDistanciaYUnaALarga() {
        Tablero tablero = new Tablero();

        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        Posicion posicion = new Posicion(3, 3);
        Posicion posicionAlejada = new Posicion(17, 2);

        tablero.posicionarUnidad(unidad1, posicion);
        tablero.posicionarUnidad(unidad2, new Posicion(8, 3));
        tablero.posicionarUnidad(unidad3, posicionAlejada);

        assertEquals(1, tablero.getUnidadesADistanciaMedia(unidad1).size());
        assertTrue(tablero.getUnidadesADistanciaMedia(unidad1).contains(unidad2));
        assertFalse(tablero.getUnidadesADistanciaMedia(unidad1).contains(unidad3));
    }

    @Test
    void sePosicionarDosUnidadesALargaDistanciaYUnoACorta() {
        Tablero tablero = new Tablero();

        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        Posicion posicion = new Posicion(3, 3);
        Posicion posicionAlejada = new Posicion(17, 2);

        tablero.posicionarUnidad(unidad1, posicion);
        tablero.posicionarUnidad(unidad2, posicion.posicionAtras());
        tablero.posicionarUnidad(unidad3, posicionAlejada);

        assertEquals(1, tablero.getUnidadesADistanciaLarga(unidad1).size());
        assertTrue(tablero.getUnidadesADistanciaLarga(unidad1).contains(unidad3));
        assertFalse(tablero.getUnidadesADistanciaLarga(unidad1).contains(unidad2));
    }
}
