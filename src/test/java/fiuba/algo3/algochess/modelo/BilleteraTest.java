package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.excepciones.PuntosInsuficientesException;
import fiuba.algo3.algochess.modelo.tablero.Billetera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BilleteraTest {
    @Test
    void creoBilleteraCon30Puntos() {
        Billetera billetera = new Billetera(20);

        assertEquals(20, billetera.getPuntos());
    }

    @Test
    void billeteraCon20PuntosPuedePagar20Puntos() {
        Billetera billetera = new Billetera(20);
        assertDoesNotThrow(() -> billetera.pagar(20));
    }

    @Test
    void billeteraCon10PuntosNoPuedePagar20Puntos() {
        Billetera billetera = new Billetera(10);

        assertThrows(PuntosInsuficientesException.class, () -> billetera.pagar(20));
    }
}
