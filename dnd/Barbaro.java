package dnd;

public class Barbaro extends PersonajeBase {
    public Barbaro(String nombre, int edad, String raza, String antecedente) {
        super(nombre, edad, raza, "Bárbaro", antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL BÁRBARO ---");
        System.out.println(nombre + " canaliza su furia ancestral en el combate.");
        System.out.println("Como " + raza + ", ha sobrevivido en tierras salvajes, confiando en su fuerza y valor.");
        System.out.println("Su pasado como " + antecedente.toLowerCase() + " forjó su espíritu indomable.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println("¡" + nombre + " el Bárbaro ruge listo para la batalla! ");
        System.out.println("\n¡Bienvenido, " + nombre + " el " + clase + " " + raza + "!");
        System.out.println("Tu aventura comienza ahora... ");
    }
}
