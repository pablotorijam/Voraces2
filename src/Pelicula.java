import java.util.ArrayList;

public class Pelicula {

    private int sala;
    private int hora;
    private int duracion;

    public Pelicula(int sala, int hora, int duracion){
        this.sala=sala;
        this.hora=hora;
        this.duracion=duracion;
    }

    public int getSala() {
        return sala;
    }

    public int getHora() {
        return hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public static Pelicula seleccionarCandidato(ArrayList<Pelicula> cartelera){

        Pelicula candidato= cartelera.get(0);

        for(int i=0;i< cartelera.size();i++){
            if((cartelera.get(i).getDuracion()+cartelera.get(i).getHora()) < (candidato.getDuracion())+ candidato.getHora())
                candidato= cartelera.get(i);
        }

        return candidato;
    }
}
