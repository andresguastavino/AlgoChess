package fiuba.algo3.algochess.vista;

import java.io.File;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;



public class ReproductorMusica {
	private String cancionActual;
	private AudioClip reproductor;
	
	public ReproductorMusica() {cancionActual = "110 Commander in Training.mp3";}
	
	public ReproductorMusica(String nombre) {cancionActual = nombre;}
	

	public void cambiarMusica(String nombre) {cancionActual = nombre;}
	
	public void reproducirMusica() {
		
		String path = "src/main/resources/"+cancionActual;
	    
	    Media media = new Media(new File(path).toURI().toString());
	    reproductor = new AudioClip(media.getSource()); 
	    reproductor.setCycleCount(AudioClip.INDEFINITE); 
	    reproductor.play(0.2);
		 
	}
	
	public void reproducirEfectoDeSonido() {
		
		String path = "src/main/resources/"+cancionActual;
	    
	    Media media = new Media(new File(path).toURI().toString());
	    reproductor = new AudioClip(media.getSource()); 
	    reproductor.play(0.05);
	}
	
}
