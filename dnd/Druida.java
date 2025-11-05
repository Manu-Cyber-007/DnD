package dnd;

public class Druida extends PersonajeBase {
    public Druida(String nombre, int edad, Raza raza, Antecedente antecedente) {
        super(nombre, edad, raza, Clase.DRUIDA, antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL DRUIDA ---");
        System.out.println(nombre + " protege los ciclos naturales de la vida y la muerte.");
        System.out.println("Como " + formatearEnum(raza) + ", se comunica con los espíritus de la naturaleza.");
        System.out.println("Su experiencia como " + formatearEnum(antecedente).toLowerCase() + " lo conectó profundamente con el mundo natural.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el Druida invoca la fuerza de la naturaleza! ");
        System.out.println(" ¡Bienvenido, " + nombre + " el " + formatearEnum(clase) + " " + formatearEnum(raza) + "!");
        System.out.println(" Tu aventura comienza ahora... ");
    }
}
