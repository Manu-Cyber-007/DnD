package dnd;

public class PersonajeGenerico extends PersonajeBase {

    public PersonajeGenerico(String nombre, int edad, String raza, String clase, String antecedente) {
        super(nombre, edad, raza, clase, antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL PERSONAJE ---");
        System.out.println(nombre + " pertenece a la raza " + raza + " y ha tomado el camino de un " + clase.toLowerCase() + ".");
        System.out.println("Su pasado como " + antecedente.toLowerCase() + " marcó el inicio de su aventura.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el " + clase + " está listo para vivir su destino! ");
        System.out.println("\n¡Bienvenido, " + nombre + " el " + clase + " " + raza + "!");
        System.out.println("Tu aventura comienza ahora... ");
    }
}
