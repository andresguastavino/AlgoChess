package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosicionTest {
    @Test
    void creoPosicionConX2yY2() {
        Posicion posicion = new Posicion(2, 2);

        assertEquals(2, posicion.getX());
        assertEquals(2, posicion.getY());
    }

    @Test
    void creoPosicionEnElX2yY2YSuPosicionAdelanteEstaEnElX2yY3() {
        Posicion posicion = new Posicion(2, 2);

        Posicion posicionAdelante = posicion.posicionAdelante();

        assertEquals(2, posicionAdelante.getX());
        assertEquals(3, posicionAdelante.getY());
    }

    @Test
    void creoPosicionEnElX2yY2YSuPosicionAtrasEstaEnElX2yY1() {
        Posicion posicion = new Posicion(2, 2);

        Posicion posicionAtras = posicion.posicionAtras();

        assertEquals(2, posicionAtras.getX());
        assertEquals(1, posicionAtras.getY());
    }

    @Test
    void creoPosicionEnElX2yY2YSuPosicionALaDerechaEstaEnElX3yY2() {
        Posicion posicion = new Posicion(2, 2);

        Posicion posicionADerecha = posicion.posicionADerecha();

        assertEquals(3, posicionADerecha.getX());
        assertEquals(2, posicionADerecha.getY());
    }

    @Test
    void creoPosicionEnElX2yY2YSuPosicionALaIzquierdaEstaEnElX1yY2() {
        Posicion posicion = new Posicion(2, 2);

        Posicion posicionAIzquierda = posicion.posicionAIzquierda();

        assertEquals(1, posicionAIzquierda.getX());
        assertEquals(2, posicionAIzquierda.getY());
    }

    @Test
    void laDistanciaEntreElPuntoConX2Y3yElPuntoConX3Y3Es1() {
        Posicion posicion1 = new Posicion(2, 3);
        Posicion posicion2 = new Posicion(3, 3);

        assertEquals(1, posicion1.distanciaAPosicion(posicion2));
    }

    @Test
    void laDistanciaEntreElPuntoConX2Y3yElPuntoConX3Y6Es3() {
        Posicion posicion1 = new Posicion(2, 3);
        Posicion posicion2 = new Posicion(3, 6);

        assertEquals(3, posicion1.distanciaAPosicion(posicion2));
    }
}
