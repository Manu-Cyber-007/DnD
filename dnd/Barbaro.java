package dnd;

public class Barbaro extends PersonajeBase {
    public Barbaro(String nombre, int edad, Raza raza, Antecedente antecedente) {
        super(nombre, edad, raza, Clase.BARBARO, antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL BÁRBARO ---");
        System.out.println(nombre + " canaliza su furia ancestral en el combate.");
        System.out.println("Como " + formatearEnum(raza) + ", ha sobrevivido en tierras salvajes, confiando en su fuerza y valor.");
        System.out.println("Su pasado como " + formatearEnum(antecedente).toLowerCase() + " forjó su espíritu indomable.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println("¡" + nombre + " el Bárbaro ruge listo para la batalla! ");
        System.out.println(" ¡Bienvenido, " + nombre + " el " + formatearEnum(clase) + " " + formatearEnum(raza) + "!");
        System.out.println(" Tu aventura comienza ahora... ");
    }
}
