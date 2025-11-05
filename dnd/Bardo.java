package dnd;

public class Bardo extends PersonajeBase {
    public Bardo(String nombre, int edad, Raza raza, Antecedente antecedente) {
        super(nombre, edad, raza, Clase.BARDO, antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL BARDO ---");
        System.out.println(nombre + " domina la música, la palabra y la magia que surge de la inspiración.");
        System.out.println("Como " + formatearEnum(raza) + ", recorre tabernas, cortes y caminos, llevando historias y canciones.");
        System.out.println("Su vida anterior como " + formatearEnum(antecedente).toLowerCase() + " le enseñó el poder de las emociones humanas.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el Bardo inspira a todos con su melodía! ");
        System.out.println(" ¡Bienvenido, " + nombre + " el " + formatearEnum(raza) + " " + formatearEnum(raza) + "!");
        System.out.println(" Tu aventura comienza ahora... ");
    }
}
