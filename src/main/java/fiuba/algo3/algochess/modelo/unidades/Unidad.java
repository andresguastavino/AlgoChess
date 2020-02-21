package fiuba.algo3.algochess.modelo.unidades;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Casilla;
import fiuba.algo3.algochess.modelo.tablero.Jugador;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Unidad extends Observable {
    protected Casilla casilla;
    protected Jugador propietario;

    private double vida;
    private int costo;

    private double multiplicadorDeDanio;

    public Unidad(Jugador propietario, int vida, int costo) {
        this.multiplicadorDeDanio = 0;
        this.propietario = propietario;
        this.costo = costo;
        this.vida = vida;
    }

    public Unidad(int vida, int costo) {
        this.multiplicadorDeDanio = 0;
        this.costo = costo;
        this.vida = vida;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public void setMultiplicadorDeDanio(double valor) {
        multiplicadorDeDanio = valor;
    }

    public int getX() {
        return casilla.getPosicion().getX();
    }

    public int getY() {
        return casilla.getPosicion().getY();
    }

    public double getVida() {
        return vida;
    }

    public int getCosto() {
        return costo;
    }

    public Jugador propietario() {
        return propietario;
    }

    public void aumentarVida(int valor) {
        this.vida += valor;
        notifyObservers();
    }

    public void disminuirVida(int valor) {
        double vidaADisminuir = valor + valor * multiplicadorDeDanio * 0.01;
        this.vida -= vidaADisminuir;
        notifyObservers();

        if(this.vida <= 0) {
            propietario.quitarUnidad(this);
            casilla.removeOcupanteMuerto();
        }
    }

    private boolean perteneceA(Jugador jugador) {
        return jugador.equals(propietario);
    }

    public boolean soyAliadoDe(Unidad unidad) {
        return unidad.perteneceA(propietario);
    }

    public boolean soyEnemigoDe(Unidad unidad) {
        return !unidad.perteneceA(propietario);
    }

    public boolean esMiPropietario(Jugador jugador) {
        return jugador.equals(propietario);
    }

    public abstract void usarHabilidad(Unidad objetivo);

    public List<Unidad> unidadesAdyacentes() {
        return casilla.getUnidadesAdyacentes();
    }

    public List<Unidad> unidadesCerca() {
        return casilla.getUnidadesADistanciaCorta();
    }

    private List<Unidad> aliadosCerca() {
        return unidadesCerca()
                .stream()
                .filter(u -> u.soyAliadoDe(this))
                .collect(Collectors.toList());
    }

    public List<Unidad> enemigosCerca() {
        return unidadesCerca()
                .stream()
                .filter(u -> u.soyEnemigoDe(this))
                .collect(Collectors.toList());
    }

    public boolean tieneAliadosCerca() {
        return this.aliadosCerca().size() > 0;
    }

    public boolean noTieneAliadosCerca() {
        return !this.tieneAliadosCerca();
    }

    public boolean tieneEnemigosCerca() {
        return enemigosCerca().size() > 0;
    }

    public boolean noTieneEnemigosCerca() {
        return !tieneEnemigosCerca();
    }

    protected void enlistarse(Batallon batallon) {
        // Por defecto no hace nada.
    }

    private int distanciaACasilla(Casilla casilla) {
        return casilla.distanciaACasilla(this.casilla);
    }

    public boolean esAdyacente(Unidad unidad) {
        int distancia = unidad.distanciaACasilla(casilla);
        return distancia == 1;
    }

    public boolean estaACortaDistancia(Unidad unidad) {
        int distancia = unidad.distanciaACasilla(casilla);
        return casilla.valorEnRangoCorto(distancia);
    }

    public boolean estaAMediaDistancia(Unidad unidad) {
        int distancia = unidad.distanciaACasilla(casilla);
        return casilla.valorEnRangoMedio(distancia);
    }

    public boolean estaALargaDistancia(Unidad unidad) {
        int distancia = unidad.distanciaACasilla(casilla);
        return casilla.valorEnRangoLargo(distancia);
    }

    private boolean turnoValido(){
        return AdministradorDeTurnos.getInstancia().turnoDe(propietario);
    }

    public void moverHaciaAdelante() {
        if(this.turnoValido()) {
            casilla.moverUnidadHaciaAdelante();
            notifyObservers();
            AdministradorDeTurnos.getInstancia().cambiarTurnos();
        }
    }

    public void moverALaDerecha() {
        if(this.turnoValido()) {
            casilla.moverUnidadALaDerecha();
            notifyObservers();
            AdministradorDeTurnos.getInstancia().cambiarTurnos();
        }
    }

    public void moverHaciaAtras() {
        if(this.turnoValido()) {
            casilla.moverUnidadHaciaAtras();
            notifyObservers();
            AdministradorDeTurnos.getInstancia().cambiarTurnos();
        }
    }

    public void moverALaIzquierda() {
        if(AdministradorDeTurnos.getInstancia().turnoDe(propietario)) {
            casilla.moverUnidadALaIzquierda();
            notifyObservers();
            AdministradorDeTurnos.getInstancia().cambiarTurnos();
        }
    }

    protected void moverEnBatallonHaciaAdelante() {
    }

    protected void moverEnBatallonALaDerecha() {
    }

    protected void moverEnBatallonHaciaAtras() {
    }

    protected void moverEnBatallonALaIzquierda() {
    }
}
