import java.util.ArrayList;

public class main {

    public static ArrayList<Pelicula> planOptimo(ArrayList<Pelicula> cartelera){

        ArrayList<Pelicula> solucion = new ArrayList<>();
        Pelicula candidato;

        int horaFinAnterior = 0;

        while(!cartelera.isEmpty()){
            candidato = Pelicula.seleccionarCandidato(cartelera);
            cartelera.remove(candidato);

            if(candidato.getHora() >= horaFinAnterior) {
                if (candidato.getHora() == horaFinAnterior) {
                    solucion.add(candidato);
                    horaFinAnterior = horaFinAnterior + candidato.getDuracion();
                }
                else{
                    solucion.add(candidato);
                    horaFinAnterior = horaFinAnterior + candidato.getDuracion() + (candidato.getHora() - horaFinAnterior);
                }
            }
        }
        return solucion;
    }

    public static void main(String[] args) {

        ArrayList<Pelicula> cartelera = new ArrayList<>();
        ArrayList<Pelicula> solucion = new ArrayList<>();

        Pelicula peli1 = new Pelicula(1,0,3);
        Pelicula peli2 = new Pelicula(2,1,3);
        Pelicula peli3 = new Pelicula(3,2,2);
        Pelicula peli4 = new Pelicula(4,4,2);
        Pelicula peli5 = new Pelicula(5,2,5);
        Pelicula peli6 = new Pelicula(6,6,1);
        Pelicula peli7 = new Pelicula(7,6,2);
        Pelicula peli8 = new Pelicula(8,5,4);

        cartelera.add(peli1);
        cartelera.add(peli2);
        cartelera.add(peli3);
        cartelera.add(peli4);
        cartelera.add(peli5);
        cartelera.add(peli6);
        cartelera.add(peli7);
        cartelera.add(peli8);

        solucion = planOptimo(cartelera);

        for(int i=0;i< solucion.size();i++){
            System.out.println(solucion.get(i).getSala()+ " ");
        }
    }
}
