package dnd;

public class Clerigo extends PersonajeBase {
    public Clerigo(String nombre, int edad, String raza, String antecedente) {
        super(nombre, edad, raza, "Clérigo", antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL CLÉRIGO ---");
        System.out.println(nombre + " es un fiel servidor de su deidad, canalizando poder divino para sanar o castigar.");
        System.out.println("Como " + raza + ", su fe es tan fuerte como su espíritu.");
        System.out.println("Su pasado como " + antecedente.toLowerCase() + " lo preparó para una vida de devoción.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el Clérigo bendice el campo de batalla con su fe! ");
        System.out.println("\n¡Bienvenido, " + nombre + " el " + clase + " " + raza + "!");
        System.out.println("Tu aventura comienza ahora... ");
    }
}
