package fiuba.algo3.algochess.vista.unidadview;

import fiuba.algo3.algochess.controlador.unidadcontroller.UnidadControlFactory;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.Sprite;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.VidaView;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class UnidadView implements Observer {
    private TableroView tableroView;
    private Unidad unidad;

    private ImageView unitImage;
    private Sprite sprite;

    public UnidadView(Unidad unidad, TableroView tableroView, Sprite sprite) {
        unidad.addObserver(this);

        this.sprite = sprite;
        this.unidad = unidad;
        this.tableroView = tableroView;

        unitImage = new ImageView();
        unitImage.setImage(getImage());
        unitImage.setFitWidth(getImage().getWidth());
        unitImage.setFitHeight(getImage().getHeight());

        unitImage.setOnMouseClicked(UnidadControlFactory.getInstance(unidad, this, tableroView));

        tableroView.addViewOnMap(unitImage, unidad.getX(), unidad.getY());

        new VidaView(unidad, tableroView);
    }

    public void setFrame(int x, int y) {
        sprite.setActualFrame(x, y);
    }

    public Image getImage() {
        return SwingFXUtils.toFXImage(sprite.getActualFrame(), null);
    }

    public void update() {
        if (unidad.getVida() <= 0) {
            tableroView.removeView(unitImage);
        } else {
            unitImage.setImage(getImage());
            tableroView.addViewOnMap(unitImage, unidad.getX(), unidad.getY());
        }
    }

    @Override
    public void change() {
        update();
    }

    public abstract void setFrameUp();

    public abstract void setFrameDown();

    public abstract void setFrameLeft();

    public abstract void setFrameRight();

}
