package fiuba.algo3.algochess.vista;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.LinkedList;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.TextAlignment;

public class ChatBox extends ScrollPane {
    private static final int DEFAULT_WIDTH = 320;
    private static final int DEFAULT_HEIGHT = 200;

    private List<Label> messages;
    private VBox chat;

    public ChatBox() {
        messages = new LinkedList<>();
        chat = new VBox();
        chat.getStyleClass().add("chat");
        this.getStyleClass().add("chatbox");
        this.setContent(chat);
    }

    public void addMessage(String message) {
        Label label = new Label(message);
        label.setMinWidth(DEFAULT_WIDTH * 0.95);
        label.setMaxWidth(DEFAULT_WIDTH * 0.95);
        label.setAlignment(Pos.CENTER_LEFT);
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        messages.add(label);
        chat.getChildren().add(label);
        this.setVvalue(this.getHeight() + DEFAULT_HEIGHT);
    }

    public void update() {
        chat.getChildren().removeAll(messages);
        chat.getChildren().addAll(messages);
    }

    public void clear() {
        chat.getChildren().clear();
        messages.clear();
    }
}
