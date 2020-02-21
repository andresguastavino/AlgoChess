package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.excepciones.FinDelJuegoException;
import fiuba.algo3.algochess.modelo.excepciones.PuntosInsuficientesException;
import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JugadorTest {
    @Test
    void seVerificaQueAlComprarUnaUnidadDeInfanteriaSeLeRestanLosPuntosCorrespondientesAlJugador() {
        Tablero tablero = new Tablero();
        Unidad unidad = new UnidadDeInfanteria();
        Jugador jugador = tablero.getJugadorA();
        int puntosPrevios = jugador.getPuntos();

        jugador.comprarUnidad(unidad);

        assertEquals(puntosPrevios - unidad.getCosto(), jugador.getPuntos());
    }

    @Test
    void seVerificaQueAlComprarUnJineteSeLeRestanLosPuntosCorrespondientesAlJugador() {
        Tablero tablero = new Tablero();
        Unidad unidad = new Jinete();
        Jugador jugador = tablero.getJugadorA();
        int puntosPrevios = jugador.getPuntos();

        jugador.comprarUnidad(unidad);

        assertEquals(puntosPrevios - unidad.getCosto(), jugador.getPuntos());
    }

    @Test
    void seVerificaQueAlComprarUnCuranderoSeLeRestanLosPuntosCorrespondientesAlJugador() {
        Tablero tablero = new Tablero();
        Unidad unidad = new Curandero();
        Jugador jugador = tablero.getJugadorA();
        int puntosPrevios = jugador.getPuntos();

        jugador.comprarUnidad(unidad);

        assertEquals(puntosPrevios - unidad.getCosto(), jugador.getPuntos());
    }

    @Test
    void seVerificaQueAlComprarUnaCatapultaSeLeRestanLosPuntosCorrespondientesAlJugador() {
        Tablero tablero = new Tablero();
        Unidad unidad = new Catapulta();
        Jugador jugador = tablero.getJugadorA();
        int puntosPrevios = jugador.getPuntos();

        jugador.comprarUnidad(unidad);

        assertEquals(puntosPrevios - unidad.getCosto(), jugador.getPuntos());
    }

    @Test
    void seVerificaQueAlIntentarComprarUnidadesSinPuntosSeLanzaUnaExcepcion() {
        Tablero tablero = new Tablero();
        Jugador jugador = tablero.getJugadorA();

        for (int i = 0; i < 20; i++) {
            jugador.comprarUnidad(new UnidadDeInfanteria());
        }

        assertEquals(jugador.getPuntos(), 0);
        assertThrows(PuntosInsuficientesException.class, () -> jugador.comprarUnidad(new Jinete()));
    }

    @Test
    void seVerificaQueAlQuedarseSinUnidadesElJugadorPierdeElJuego() {
        Tablero tablero = new Tablero();
        UnidadDeInfanteria unidad = new UnidadDeInfanteria();
        tablero.getJugadorA().comprarUnidad(unidad);

        assertThrows(FinDelJuegoException.class, ()-> {
            unidad.disminuirVida(100);
        });
    }
}