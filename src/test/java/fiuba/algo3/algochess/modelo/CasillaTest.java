package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.tablero.Casilla;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CasillaTest {
	@Test
    void posicionarUnaUnidadEnUnaCasillaVaciaNoLanzaExcepcion() {
		Casilla casilla = new Casilla();
		Unidad unidad = new UnidadDeInfanteria();

		assertDoesNotThrow(() -> casilla.setOcupante(unidad));
	}

    @Test
    void sePosicionaUnaUnidadYElOcupanteEsLaMismaUnidad() {
        Casilla casilla = new Casilla();
        Unidad unidad = new UnidadDeInfanteria();

        casilla.setOcupante(unidad);

        assertEquals(unidad, casilla.getOcupante());
    }

    @Test
    void posicionarUnidadEnUnaCasillaOcupadaLanzaUnaExcepcion() {
        Casilla casilla = new Casilla();
        Unidad unidad1 = new UnidadDeInfanteria();
        Unidad unidad2 = new UnidadDeInfanteria();

        casilla.setOcupante(unidad1);

        assertThrows(RuntimeException.class, () -> casilla.setOcupante(unidad2));
    }
}