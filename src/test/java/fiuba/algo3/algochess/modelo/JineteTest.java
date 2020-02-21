package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.excepciones.NoSePuedeAtacarAAliados;
import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.tablero.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algochess.modelo.unidades.Jinete;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.*;

class JineteTest {
    @Test
    void unJineteAtacaUnaUnidadEnemigaADistanciaMediaYDeberiaRestarle15DeVida() {
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        tablero.posicionarUnidad(objetivo, new Posicion(9, 13));

        double vidaPrevia = objetivo.getVida();

        jinete.usarHabilidad(objetivo);

        assertEquals(vidaPrevia - 15, objetivo.getVida());
    }

    @Test
    void unJineteAtacaUnaUnidadCuerpoACuerpoAUnaUnidadEnemigaYDeberiaRestarle5DeVida() {
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        tablero.posicionarUnidad(objetivo, new Posicion(9, 10));

        double vidaPrevia = objetivo.getVida();

        jinete.usarHabilidad(objetivo);

        assertEquals(vidaPrevia - 5, objetivo.getVida());
    }

    @Test
    void unJineteAtacaAUnEnemigoADistanciaMediaTeniendoUnSoldadoAliadoCercaYDeberiaQuitarle15DeVida() {
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad aliado = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(aliado, new Posicion(8, 9));
        tablero.posicionarUnidad(objetivo, new Posicion(10, 13));

        double vidaPrevia = objetivo.getVida();

        jinete.usarHabilidad(objetivo);

        assertEquals(vidaPrevia - 15, objetivo.getVida());
    }

    @Test
    void unJineteAtacaAUnEnemigoADistanciaMediaTeniendoUnSoldadoEnemigoCercaDeberiaLanzarUnaExcepcion() {
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad enemigoCerca = new UnidadDeInfanteria(tablero.getJugadorB());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        tablero.posicionarUnidad(enemigoCerca, new Posicion(10, 10));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(objetivo, new Posicion(10, 14));

        assertThrows(UnidadFueraDeRango.class, () -> jinete.usarHabilidad(objetivo));
    }

    @Test
    void unJineteAtacaAUnEnemigoADistanciaCortaTeniendoUnSoldadoEnemigoCercaYDeberiaQuitarle5PuntosDeVida() {
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad enemigo = new UnidadDeInfanteria(tablero.getJugadorB());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        tablero.posicionarUnidad(enemigo, new Posicion(10, 10));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(objetivo, new Posicion(10, 11));

        double vidaPrevia = objetivo.getVida();

        jinete.usarHabilidad(objetivo);

        assertEquals(vidaPrevia - 5, objetivo.getVida());
    }

    @Test
    void unJineteAtacaAUnEnemigoADistanciaCortaTeniendoUnJineteAliadoCercaYDeberiaLanzarUnaExcepcion() {
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad aliado = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(aliado, new Posicion(9, 8));
        tablero.posicionarUnidad(objetivo, new Posicion(9, 10));

        assertThrows(UnidadFueraDeRango.class, () -> jinete.usarHabilidad(objetivo));
    }

    @Test
    void unJineteIntentaAtacarAUnAliadoYNoPuede() {
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad aliado = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        tablero.posicionarUnidad(aliado, new Posicion(9, 8));

        assertThrows(NoSePuedeAtacarAAliados.class, () -> jinete.usarHabilidad(aliado));
    }
}
