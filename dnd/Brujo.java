package dnd;

public class Brujo extends PersonajeBase {
    public Brujo(String nombre, int edad, String raza, String antecedente) {
        super(nombre, edad, raza, "Brujo", antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL BRUJO ---");
        System.out.println(nombre + " obtuvo su poder mediante un pacto con una entidad sobrenatural.");
        System.out.println("Como " + raza + ", su conexión con lo arcano lo hace misterioso y temido.");
        System.out.println("Su pasado como " + antecedente.toLowerCase() + " lo llevó a buscar poder más allá de lo mortal.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el Brujo invoca el poder de su patrón oscuro! ");
        System.out.println("\n¡Bienvenido, " + nombre + " el " + clase + " " + raza + "!");
        System.out.println("Tu aventura comienza ahora... ");
    }
}
