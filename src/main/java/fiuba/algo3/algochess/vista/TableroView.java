package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.controlador.movecontroller.MovimientoAdelanteController;
import fiuba.algo3.algochess.controlador.movecontroller.MovimientoAtrasController;
import fiuba.algo3.algochess.controlador.movecontroller.MovimientoDerechaController;
import fiuba.algo3.algochess.controlador.movecontroller.MovimientoIzquierdaController;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.unidadview.UnidadView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class TableroView extends Group {
    private Tablero tablero;
    private int width = 20;
    private int heigth = 20;

    private int tileWidth = 32;
    private int tileHeigth = 32;

    private Pane[][] panes;

    public TableroView(Tablero tablero) {
        GridPane table = new GridPane();
        this.tablero = tablero;
        this.width = tablero.getWidth();
        this.heigth = tablero.getHeight();
        panes = new Pane[width * tileWidth][heigth * tileHeigth];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                Pane v = new Pane();
                v.setMinHeight(tileHeigth);
                v.setMinWidth(tileWidth);
                panes[i][j] = v;
                table.add(v, i, j);
            }
        }

        table.setVgap(0);
        table.setHgap(0);
        table.setGridLinesVisible(true);
        table.setBackground(
                new Background(
                        new BackgroundImage(
                                new Image("background.png"),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                BackgroundSize.DEFAULT)
                ));
        this.addView(table);
    }


    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeigth() {
        return tileHeigth;
    }

    public void addViewOnMap(Node view, int x, int y) {
        panes[x][y].getChildren().remove(view);
        panes[x][y].getChildren().add(view);
    }

    public void removeView(Node view) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
    }

    public void updateView(Node view, int x, int y) {
        removeView(view);
        addViewOnMap(view, x, y);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void pintarCasillasDelJugadorActual() {
        int columna = 0;
        int limite = 10;

        if(tablero.getJugadorB() == AdministradorDeTurnos.getInstancia().jugadorActual()) {
            columna = 10;
            limite = 20;
        }

        for(int i = 0; i < width; i++) {
            for(int j = columna; j < limite; j++) {
                panes[i][j].setStyle("-fx-background-color: rgba(70,222,32,0.43)");
            }
        }
    }

    public void resetearCasillas() {
        int columna = 10;
        int limite = 20;

        if(tablero.getJugadorB() == AdministradorDeTurnos.getInstancia().jugadorActual()) {
            columna = 0;
            limite = 10;
        }

        for(int i = 0; i < width; i++) {
            for(int j = columna; j < limite; j++) {
                panes[i][j].setStyle("-fx-background-color: rgba(255,255,255,0)");
            }
        }
    }

    private boolean paneVacio(Pane pane) {
        return pane.getChildren().isEmpty();
    }

    public ArrayList<Pane> getPanesAdyacentes(Unidad unidad, UnidadView unidadView) {
        ArrayList<Pane> panesAdyacentes = new ArrayList<Pane>();

        try {
            if(paneVacio(paneAdelante(unidad))) {
                paneAdelante(unidad).setOnMouseClicked(new MovimientoAdelanteController(unidad, unidadView));
                panesAdyacentes.add(paneAdelante(unidad));
            }
        } catch(Exception e) {
            // TODO EXCEPTION
        }

        try {
            if(paneVacio(paneAtras(unidad))) {
                paneAtras(unidad).setOnMouseClicked(new MovimientoAtrasController(unidad, unidadView));
                panesAdyacentes.add(paneAtras(unidad));
            }
        } catch(Exception e) {
            // TODO EXCEPTION
        }

        try {
            if(paneVacio(paneDerecha(unidad))) {
                paneDerecha(unidad).setOnMouseClicked(new MovimientoDerechaController(unidad, unidadView));
                panesAdyacentes.add(paneDerecha(unidad));
            }
        } catch(Exception e) {
            // TODO EXCEPTION
        }

        try {
            if(paneVacio(paneIzquierda(unidad))) {
                paneIzquierda(unidad).setOnMouseClicked(new MovimientoIzquierdaController(unidad, unidadView));
                panesAdyacentes.add(paneIzquierda(unidad));
            }
        } catch(Exception e) {
            // TODO EXCEPTION
        }

        panesAdyacentes.forEach(pane -> pane.setStyle("-fx-background-color: #79f281"));

        return panesAdyacentes;
    }

    public Pane paneActual(Unidad unidad) {
        panes[unidad.getX()][unidad.getY()].setStyle("-fx-background-color: #46b1f2");

        return panes[unidad.getX()][unidad.getY()];
    }

    public Pane paneAdelante(Unidad unidad) {
        return panes[unidad.getX()][unidad.getY() + 1];
    }

    public Pane paneAtras(Unidad unidad) {
        return panes[unidad.getX()][unidad.getY() - 1];
    }

    public Pane paneDerecha(Unidad unidad) {
        return panes[unidad.getX() + 1][unidad.getY()];
    }

    public Pane paneIzquierda(Unidad unidad) {
        return panes[unidad.getX() - 1][unidad.getY()];
    }
}
