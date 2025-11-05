package dnd;

public class Brujo extends PersonajeBase {
    public Brujo(String nombre, int edad, Raza raza, Antecedente antecedente) {
        super(nombre, edad, raza, Clase.BRUJO, antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL BRUJO ---");
        System.out.println(nombre + " obtuvo su poder a través de un pacto con una entidad sobrenatural.");
        System.out.println("Como " + formatearEnum(raza) + ", su conexión con lo arcano es profunda.");
        System.out.println("Su pasado como " + formatearEnum(antecedente).toLowerCase() + " moldeó su ambición y destino.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println("¡" + nombre + " el " + formatearEnum(clase) + " desata su energía oculta!");
        System.out.println("¡Bienvenido, " + nombre + " el " + formatearEnum(clase) + " " + formatearEnum(raza) + "!");
        System.out.println("Tu aventura comienza ahora...");
    }
}
