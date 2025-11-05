package dnd;

// Clase concreta que hereda de PersonajeBase (herencia)
public class Personaje extends PersonajeBase {

    public Personaje(String nombre, int edad, Raza raza, Clase clase, Antecedente antecedente) {
        super(nombre, edad, raza, clase, antecedente);
    }

    // Implementa el método abstracto (polimorfismo)
    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL PERSONAJE ---");
        System.out.println(historia);
        System.out.println(" ¡Bienvenido, " + nombre + " el " + formatearEnum(clase) + " " + formatearEnum(raza) + "!");
        System.out.println(" Tu aventura comienza ahora... ");
    }
}
