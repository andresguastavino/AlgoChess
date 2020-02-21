package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.tablero.Posicion;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.algochess.modelo.unidades.Curandero;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CuranderoTest {
    @Test
    void unCuranderoCuraAUnaUNidadDeInfanteriaYSuVidaDeberiaAumentarEn15() {
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero(tablero.getJugadorA());
        Unidad aliado = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(curandero, new Posicion(0, 0));
        tablero.posicionarUnidad(aliado, new Posicion(1, 0));

        double vidaPrevia = aliado.getVida();

        curandero.usarHabilidad(aliado);

        assertEquals(vidaPrevia + 15, aliado.getVida());
    }
    
    @Test
    void unCuranderoIntentaCurarPeroElObjetivoEstaFueraDeRango() {
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero(tablero.getJugadorA());
        Unidad aliado = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(curandero, new Posicion(0, 0));
        tablero.posicionarUnidad(aliado, new Posicion(5, 0));


        assertThrows(UnidadFueraDeRango.class,() -> curandero.usarHabilidad(aliado));
    }
}