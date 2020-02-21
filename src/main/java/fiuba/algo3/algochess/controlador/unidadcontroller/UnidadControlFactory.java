package fiuba.algo3.algochess.controlador.unidadcontroller;

import fiuba.algo3.algochess.modelo.unidades.*;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.unidadview.UnidadView;

import java.util.HashMap;
import java.util.Map;

public class UnidadControlFactory {
    @FunctionalInterface
    private interface UnidadControlSupplier {
        UnidadController getUnidadController(Unidad unidad, UnidadView unidadView, TableroView tableroView);
    }

    private static final Map<String, UnidadControlSupplier> map = new HashMap<>(Map.ofEntries(
            Map.entry(UnidadDeInfanteria.class.getName(), UnidadInfanteriaController::new),
            Map.entry(Curandero.class.getName(), CuranderoController::new),
            Map.entry(Catapulta.class.getName(), CatapultaController::new),
            Map.entry(Jinete.class.getName(), JineteController::new)
    ));

    public static UnidadController getInstance(Unidad unidad, UnidadView unidadView, TableroView tablero) {
        return map.get(unidad.getClass().getName()).getUnidadController(unidad, unidadView, tablero);
    }
}
