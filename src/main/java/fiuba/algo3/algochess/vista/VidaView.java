package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.unidades.Observer;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VidaView extends Rectangle implements Observer {
    private static final int ANCHO_BARRA = 32;
    private static final int ALTO_BARRA = 3;
    private static final int X_BARRA = 0;
    private static final int Y_BARRA = 1;

    private double vidaMax;

    private TableroView tableroView;
    private Unidad unidad;

    public VidaView(Unidad unidad, TableroView tableroView) {
        unidad.addObserver(this);
        this.unidad = unidad;
        this.tableroView = tableroView;

        vidaMax = unidad.getVida();

        setWidth(ANCHO_BARRA);
        setHeight(ALTO_BARRA);
        setX(X_BARRA);
        setY(Y_BARRA);
        setFill(Color.GREEN);

        tableroView.addViewOnMap(this, unidad.getX(), unidad.getY());
    }

    public void update() {
        if(unidad.getVida() <= 0) {
            tableroView.removeView(this);
        } else {
            if(unidad.getVida() > vidaMax){
                setWidth(ANCHO_BARRA);
            } else {
                setWidth(unidad.getVida() * ANCHO_BARRA / vidaMax);
            }
            tableroView.updateView(this, unidad.getX(), unidad.getY());
        }
    }

    @Override
    public void change() {
        update();
    }
}
