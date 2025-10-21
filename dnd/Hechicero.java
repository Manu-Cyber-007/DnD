package dnd;

public class Hechicero extends PersonajeBase {
    public Hechicero(String nombre, int edad, String raza, String antecedente) {
        super(nombre, edad, raza, "Hechicero", antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL HECHICERO ---");
        System.out.println(nombre + " nació con magia en su sangre, un don innato que no entiende del todo.");
        System.out.println("Como " + raza + ", su energía interior lo distingue entre los demás.");
        System.out.println("Su vida como " + antecedente.toLowerCase() + " lo llevó a descubrir su poder oculto.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el Hechicero desata su magia interior! ");
        System.out.println("\n¡Bienvenido, " + nombre + " el " + clase + " " + raza + "!");
        System.out.println("Tu aventura comienza ahora... ");
    }
}
