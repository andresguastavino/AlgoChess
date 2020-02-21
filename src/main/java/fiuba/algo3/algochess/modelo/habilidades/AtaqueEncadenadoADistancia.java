package fiuba.algo3.algochess.modelo.habilidades;

import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.unidades.Unidad;

public class AtaqueEncadenadoADistancia extends Habilidad {
    private final static int DANIO = 20;

    public AtaqueEncadenadoADistancia(Unidad portador) {
        super(portador);
    }

    private List<Unidad> getUnidadesAAtacar(Unidad priverObjetivo) {
        List<Unidad> unidadesVisitadas = new LinkedList<>();
        List<Unidad> unidadesPorVisitar = new LinkedList<>();

        unidadesPorVisitar.add(priverObjetivo);

        while (unidadesPorVisitar.size() > 0) {
            Unidad unidad = unidadesPorVisitar.remove(0);
            List<Unidad> unidadesCercanas = unidad.unidadesAdyacentes();

            if (!unidadesVisitadas.contains(unidad))
                unidadesVisitadas.add(unidad);

            for (Unidad unidadCercana : unidadesCercanas) {
                if (!unidadesPorVisitar.contains(unidadCercana) && !unidadesVisitadas.contains(unidadCercana)) {
                    unidadesPorVisitar.add(unidadCercana);
                }
            }
        }

        return unidadesVisitadas;
    }

    @Override
    public void usarHabilidad(Unidad objetivo) {
        if(!objetivo.estaALargaDistancia(portador))
            throw new UnidadFueraDeRango();

        getUnidadesAAtacar(objetivo).forEach(unidad -> unidad.disminuirVida(DANIO));
    }
}
