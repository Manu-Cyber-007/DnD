package dnd;

public class Paladin extends PersonajeBase {
    public Paladin(String nombre, int edad, String raza, String antecedente) {
        super(nombre, edad, raza, "Paladín", antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL PALADÍN ---");
        System.out.println(nombre + " ha jurado proteger a los inocentes y castigar el mal.");
        System.out.println("Como " + raza + ", su determinación es tan firme como su fe.");
        System.out.println("Su pasado como " + antecedente.toLowerCase() + " marcó su camino hacia la justicia divina.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println("¡" + nombre + " el Paladín brilla con poder sagrado! ");
        System.out.println("\n¡Bienvenido, " + nombre + " el " + clase + " " + raza + "!");
        System.out.println("Tu aventura comienza ahora... ");
    }
}

