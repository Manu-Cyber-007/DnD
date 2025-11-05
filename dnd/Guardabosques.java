package dnd;

public class Guardabosques extends PersonajeBase {
    public Guardabosques(String nombre, int edad, Raza raza, Antecedente antecedente) {
        super(nombre, edad, raza, Clase.GUARDABOSQUES, antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL GUARDABOSQUES ---");
        System.out.println(nombre + " domina el arte de la caza y la exploración.");
        System.out.println("Como " + formatearEnum(raza) + ", conoce los secretos de los bosques y las montañas.");
        System.out.println("Su pasado como " + formatearEnum(antecedente).toLowerCase() + " lo llevó a proteger la naturaleza y a sus aliados.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el Guardabosques acecha con precisión mortal! ");
        System.out.println(" ¡Bienvenido, " + nombre + " el " + formatearEnum(clase) + " " + formatearEnum(raza) + "!");
        System.out.println(" Tu aventura comienza ahora... ");
    }
}
