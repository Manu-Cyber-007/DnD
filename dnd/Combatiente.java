package dnd;

public class Combatiente extends PersonajeBase {
    public Combatiente(String nombre, int edad, Raza raza, Antecedente antecedente) {
        super(nombre, edad, raza, Clase.COMBATIENTE, antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL COMBATIENTE ---");
        System.out.println(nombre + " es un soldado versátil que domina armas y tácticas por igual.");
        System.out.println("Como " + formatearEnum(raza) + ", ha pasado su vida entrenando para cualquier enfrentamiento.");
        System.out.println("Su pasado como " + formatearEnum(antecedente).toLowerCase() + " lo formó en la dureza del combate.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el Combatiente nunca rehúye una pelea! ");
        System.out.println(" ¡Bienvenido, " + nombre + " el " + formatearEnum(clase) + " " + formatearEnum(raza) + "!");
        System.out.println(" Tu aventura comienza ahora... ");
    }
}
