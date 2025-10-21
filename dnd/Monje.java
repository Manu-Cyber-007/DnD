package dnd;

public class Monje extends PersonajeBase {
    public Monje(String nombre, int edad, String raza, String antecedente) {
        super(nombre, edad, raza, "Monje", antecedente);
    }

    @Override
    public void presentarHistoria() {
        System.out.println("\n--- HISTORIA DEL MONJE ---");
        System.out.println(nombre + " ha dedicado su vida a perfeccionar cuerpo y mente a través de la disciplina.");
        System.out.println("Como " + raza + ", busca el equilibrio interior en cada respiración.");
        System.out.println("Su vida anterior como " + antecedente.toLowerCase() + " fue el inicio de su camino espiritual.");
        System.out.println("Historia del jugador: " + historia);
        System.out.println(" ¡" + nombre + " el Monje canaliza su ki en perfecta armonía! ");
        System.out.println("\n¡Bienvenido, " + nombre + " el " + clase + " " + raza + "!");
        System.out.println("Tu aventura comienza ahora... ");
    }
}
