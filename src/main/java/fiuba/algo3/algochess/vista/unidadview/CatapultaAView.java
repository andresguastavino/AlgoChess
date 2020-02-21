package fiuba.algo3.algochess.vista.unidadview;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.Sprite;
import fiuba.algo3.algochess.vista.TableroView;

public class CatapultaAView extends UnidadView {
    public CatapultaAView(Unidad unidad, TableroView tableroView) {
        super(unidad, tableroView, new Sprite("src/main/resources/catapultaA.png"));
    }

    @Override
    public void setFrameUp() {
        this.setFrame(0, 0);
    }

    @Override
    public void setFrameDown() {
        this.setFrame(5, 0);
    }

    @Override
    public void setFrameLeft() {
        this.setFrame(2, 4);
    }

    @Override
    public void setFrameRight() {
        this.setFrame(2, 0);
    }
}
