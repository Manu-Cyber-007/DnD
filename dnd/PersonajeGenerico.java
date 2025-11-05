package dnd;

public class PersonajeGenerico extends PersonajeBase {

    public PersonajeGenerico(String nombre, int edad, Raza raza, Clase clase, Antecedente antecedente) {
        super(nombre, edad, raza, clase, antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL PERSONAJE ---");
        System.out.println(nombre + " pertenece a la raza " + formatearEnum(raza) + " y ha tomado el camino de un " + formatearEnum(clase).toLowerCase() + ".");
        System.out.println("Su pasado como " + formatearEnum(antecedente).toLowerCase() + " marcó el inicio de su aventura.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el " + formatearEnum(clase) + " está listo para vivir su destino! ");
        System.out.println(" ¡Bienvenido, " + nombre + " el " + formatearEnum(clase) + " " + formatearEnum(raza) + "!");
        System.out.println(" Tu aventura comienza ahora... ");
    }
}
