package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdministradorDeTurnosTest {
    @Test
    public void pasoDeTurnoYElJugadorActualDeberiaCambiar() {
        Tablero t = new Tablero();
        AdministradorDeTurnos administradorDeTurnos = AdministradorDeTurnos.getInstancia();

        assertEquals(administradorDeTurnos.jugadorActual(), t.getJugadorA());
        administradorDeTurnos.cambiarTurnos();
        assertEquals(administradorDeTurnos.jugadorActual(), t.getJugadorB());
    }

    @Test
    public void jugadoresGastanTodosSusPuntosYSeVerificaQueSeFinalizaronLasCompras() {
        Tablero tablero = new Tablero();

        assertFalse(AdministradorDeTurnos.getInstancia().finalizaronCompras());

        for(int i = 0; i < 20; i++) {
            tablero.getJugadorA().comprarUnidad(new UnidadDeInfanteria());
            tablero.getJugadorB().comprarUnidad(new UnidadDeInfanteria());
        }

        assertTrue(AdministradorDeTurnos.getInstancia().finalizaronCompras());
    }
}
