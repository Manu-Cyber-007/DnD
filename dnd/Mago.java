package dnd;

public class Mago extends PersonajeBase {
    public Mago(String nombre, int edad, String raza, String antecedente) {
        super(nombre, edad, raza, "Mago", antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL MAGO ---");
        System.out.println(nombre + " domina los secretos arcanos a través de años de estudio y disciplina.");
        System.out.println("Como " + raza + ", ha explorado la esencia misma de la magia.");
        System.out.println("Su pasado como " + antecedente.toLowerCase() + " le dio acceso a conocimientos prohibidos.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println("¡" + nombre + " el Mago invoca su poder místico! ");
        System.out.println("\n¡Bienvenido, " + nombre + " el " + clase + " " + raza + "!");
        System.out.println("Tu aventura comienza ahora... ");
    }
}
