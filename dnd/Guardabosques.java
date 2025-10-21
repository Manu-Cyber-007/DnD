package dnd;

public class Guardabosques extends PersonajeBase {
    public Guardabosques(String nombre, int edad, String raza, String antecedente) {
        super(nombre, edad, raza, "Guardabosques", antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL GUARDABOSQUES ---");
        System.out.println(nombre + " domina el arte de la caza y la exploración.");
        System.out.println("Como " + raza + ", conoce los secretos de los bosques y las montañas.");
        System.out.println("Su pasado como " + antecedente.toLowerCase() + " lo llevó a proteger la naturaleza y a sus aliados.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el Guardabosques acecha con precisión mortal! ");
        System.out.println("\n¡Bienvenido, " + nombre + " el " + clase + " " + raza + "!");
        System.out.println("Tu aventura comienza ahora... ");
    }
}
