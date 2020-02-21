package fiuba.algo3.algochess.vista.comprabutton;

import fiuba.algo3.algochess.controlador.buttonHandler.CompraDeUnidadController;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.Sprite;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;

public abstract class CompraDeUnidadView extends Button {
    private static final int DEFAULT_BUTTON_WIDTH = 320;
    private static final int DEFAULT_BUTTON_HEIGHT = 100;

    protected CompraDeUnidadController cuc;
    protected TableroView tableroView;
    protected Sprite spriteA;
    protected Sprite spriteB;

    public CompraDeUnidadView(CompraDeUnidadController cuc, TableroView tableroView, Sprite spriteA, Sprite spriteB) {
        this.tableroView = tableroView;
        this.spriteA = spriteA;
        this.spriteB = spriteB;
        this.cuc = cuc;

        this.setMinSize(DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);
        this.setMaxSize(DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);
        this.setTextAlignment(TextAlignment.CENTER);

        HBox hb = new HBox();
        hb.getChildren().add(getImageViewA());
        hb.getChildren().add(getImageViewB());

        this.setGraphic(hb);

        this.setOnAction(cuc);
    }

    private ImageView getImageViewA() {
        Image img = getImageA();
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(img.getHeight());
        imageView.setFitWidth(img.getWidth());

        return imageView;
    }

    private ImageView getImageViewB() {
        Image img = getImageB();
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(img.getHeight());
        imageView.setFitWidth(img.getWidth());

        return imageView;
    }

    private Image getImageA() {
        return SwingFXUtils.toFXImage(spriteA.getActualFrame(), null) ;
    }

    private Image getImageB() {
        return SwingFXUtils.toFXImage(spriteB.getActualFrame(), null) ;
    }
}
