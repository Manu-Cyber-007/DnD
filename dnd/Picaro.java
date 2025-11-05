package dnd;

public class Picaro extends PersonajeBase {
    public Picaro(String nombre, int edad, Raza raza, Antecedente antecedente) {
        super(nombre, edad, raza, Clase.PICARO, antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL PÍCARO ---");
        System.out.println(nombre + " vive en las sombras, confiando en su ingenio y destreza.");
        System.out.println("Como " + formatearEnum(raza) + ", ha aprendido a moverse sin ser visto y golpear sin aviso.");
        System.out.println("Su pasado como " + formatearEnum(antecedente).toLowerCase() + " lo convirtió en un maestro del sigilo.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println("¡" + nombre + " el Pícaro acecha entre las sombras! ");
        System.out.println(" ¡Bienvenido, " + nombre + " el " + formatearEnum(clase) + " " + formatearEnum(raza) + "!");
        System.out.println(" Tu aventura comienza ahora... ");
    }
}
