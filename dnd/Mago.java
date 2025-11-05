package dnd;

public class Mago extends PersonajeBase {
    public Mago(String nombre, int edad, Raza raza, Antecedente antecedente) {
        super(nombre, edad, raza, Clase.MAGO, antecedente);

    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL MAGO ---");
        System.out.println(nombre + " domina los secretos arcanos a través de años de estudio y disciplina.");
        System.out.println("Como " + formatearEnum(raza) + ", ha explorado la esencia misma de la magia.");
        System.out.println("Su pasado como " + formatearEnum(antecedente).toLowerCase() + " le dio acceso a conocimientos prohibidos.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println("¡" + nombre + " el " + formatearEnum(clase) + " invoca su poder místico!");
        System.out.println("¡Bienvenido, " + nombre + " el " + formatearEnum(clase) + " " + formatearEnum(raza) + "!");
        System.out.println("Tu aventura comienza ahora...");
    }
}
