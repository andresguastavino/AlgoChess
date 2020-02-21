package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.vista.ChatBox;

import java.io.PrintStream;

public class ChatProxyPrintStream extends PrintStream {
    private ChatBox chat;
    private PrintStream originalStream;


    public ChatProxyPrintStream(PrintStream originalStream, ChatBox chat) {
        super(originalStream);
        this.originalStream = originalStream;
        this.chat = chat;
    }

    public void print(final String str) {
        originalStream.print(str);
        chat.addMessage(str);
    }
    public void println(final String str) {
        originalStream.println(str);
        chat.addMessage(str);
    }
}
