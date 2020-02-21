package fiuba.algo3.algochess.vista.unidadview;

import fiuba.algo3.algochess.modelo.unidades.*;
import fiuba.algo3.algochess.vista.TableroView;

import java.util.HashMap;
import java.util.Map;

public class ViewFactoryA {
    @FunctionalInterface
    private interface UnidadViewSupplier {
        UnidadView getViewIntance(Unidad unidad, TableroView tableroView);
    }

    private static final Map<String, UnidadViewSupplier> map = new HashMap<>(Map.ofEntries(
            Map.entry(UnidadDeInfanteria.class.getName(), UnidadInfanteriaBView::new),
            Map.entry(Catapulta.class.getName(), CatapultaBView::new),
            Map.entry(Curandero.class.getName(), CuranderoBView::new),
            Map.entry(Jinete.class.getName(), JineteBView::new)
    ));

    @SuppressWarnings("UnusedReturnValue")
    public static UnidadView getInstance(Unidad unidad, TableroView tablero) {
        return map.get(unidad.getClass().getName()).getViewIntance(unidad, tablero);
    }
}
