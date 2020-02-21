package fiuba.algo3.algochess.modelo;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.algochess.modelo.unidades.UnidadNull;

import static org.junit.jupiter.api.Assertions.*;

public class UnidadNullTest {
    @Test
    void creoUnidadNullYNoPuedoBajarleNiSubirleLaVida() {
    	Unidad unidad = new UnidadNull();
    	double vidaActual = unidad.getVida();
    	unidad.disminuirVida(20);    	
    	assertEquals(unidad.getVida(), vidaActual);
    	unidad.aumentarVida(20);
    	assertEquals(unidad.getVida(), vidaActual);
    }
    @Test
    void creoUnidadNullYNoEsAliadoNiEnemigoDeOtraUnidad() {
    	Unidad unidad = new UnidadNull();
    	Unidad unidad2 = new UnidadDeInfanteria();
    	
    	assertFalse(unidad.soyAliadoDe(unidad2));
    	assertFalse(unidad.soyEnemigoDe(unidad2));
    }

}
