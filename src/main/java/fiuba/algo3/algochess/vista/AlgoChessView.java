package fiuba.algo3.algochess.vista;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algochess.controlador.ChatProxyPrintStream;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlgoChessView implements Observer {
    private static final String STYLE_PATH = "ChatStyle.css";

    private Stage stage;
    private List<Node> escenas = new ArrayList<>();
    private TableroView tableroView;
    private ChatBox chat;
    public AlgoChessView(Stage stage) {
        this.stage = stage;

        Tablero tablero = new Tablero();
        tableroView = new TableroView(tablero);

        AdministradorDeTurnos.getInstancia().addObserver(this);

        Menu menu = new Menu(tablero, this);

        escenas.add(new ShopView(tablero, tableroView));
        escenas.add(new ButtonPasarTurno());

        // Creo el chat y redirecciono la salida estandar hacia este utilizando un proxy
        chat = new ChatBox();
        System.setOut(new ChatProxyPrintStream(System.out, chat));

        stage.setScene(new Scene(new HBox(menu)));
    }

    @Override
    public void change() {
        VBox vBox = new VBox(escenas.get(0), chat);
        vBox.getStylesheets().add(new File(STYLE_PATH).toString());
        vBox.getStyleClass().add("vbox");
        vBox.setMinHeight(640);
        vBox.setMaxHeight(640);
        stage.setScene(new Scene(new HBox(tableroView, vBox)));
        tableroView.setDisable(false);
        escenas.remove(0);
    }
}
