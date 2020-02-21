package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.excepciones.NoSePuedeMoverLaUnidad;
import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.tablero.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;

import fiuba.algo3.algochess.modelo.unidades.Catapulta;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CatapultaTest {
    @Test
    void creoCatapultaLeAumentoLaVidaEn20PeroSuVidaSigueSiendoLaMisma() {
        Catapulta catapulta = new Catapulta();

        double vidaPrevia = catapulta.getVida();

        catapulta.aumentarVida(50);

        assertEquals(vidaPrevia, catapulta.getVida());
    }

    @Test
    void catapultaIntentaAtacarAUnObjetivoPeroNoEstaEnRango() {
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(catapulta, new Posicion(0, 0));
        tablero.posicionarUnidad(objetivo, new Posicion(1, 1));

        assertThrows(UnidadFueraDeRango.class, () -> catapulta.usarHabilidad(objetivo));
    }

    @Test
    void catapultaAtacaAUnObjetivoYLeResta20DeVidaAlObjetivoYAUnaUnidadQueEstaJuntoAElla() {
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());
        Unidad adyacente = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(catapulta, new Posicion(0, 0));
        tablero.posicionarUnidad(objetivo, new Posicion(0, 15));
        AdministradorDeTurnos.getInstancia().cambiarTurnos();
        tablero.posicionarUnidad(adyacente, new Posicion(0, 16));

        double vidaPreviaObjetivo = objetivo.getVida();
        double vidaPreviaAdyacente = adyacente.getVida();

        catapulta.usarHabilidad(objetivo);

        assertEquals(vidaPreviaObjetivo - 20, objetivo.getVida());
        assertEquals(vidaPreviaAdyacente - 20, adyacente.getVida());
    }
    
    @Test
    void creoCatapultaYLaIntentoMoverParaCualquierDireccionYNoPuedo() {
    	Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(tablero.getJugadorA());
        tablero.posicionarUnidad(catapulta, new Posicion(5, 5));
        assertThrows(NoSePuedeMoverLaUnidad.class,()  -> catapulta.moverALaDerecha());
        assertThrows(NoSePuedeMoverLaUnidad.class,()  -> catapulta.moverALaIzquierda());
        assertThrows(NoSePuedeMoverLaUnidad.class,()  -> catapulta.moverHaciaAdelante());
        assertThrows(NoSePuedeMoverLaUnidad.class,()  -> catapulta.moverHaciaAtras());
    }
}
