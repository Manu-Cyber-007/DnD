package dnd;

// Clase abstracta
public abstract class PersonajeBase {
    protected String nombre;
    protected int edad;
    protected Raza raza;
    protected Clase clase;
    protected Antecedente antecedente;
    protected int nivel = 1;


    // Atributos comunes a todos los personajes
    protected int fuerza, destreza, constitucion, inteligencia, sabiduria, carisma;
    protected String historia;

    // Constructor
    public PersonajeBase(String nombre, int edad, Raza raza2, Clase clase, Antecedente antecedente2) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza2;
        this.clase = clase;
        this.antecedente = antecedente2;
    }

    // Método abstracto → cada clase lo implementa a su manera
    public abstract void presentarHistoria();

    // Mostrar ficha de personaje
    public void mostrarFicha() {
        System.out.println("\n==============================");
        System.out.println(" HOJA DE PERSONAJE D&D");
        System.out.println("==============================");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Nivel: " + nivel);
        System.out.println("Raza: " + formatearEnum(raza));
        System.out.println("Clase: " + formatearEnum(clase));
        System.out.println("Antecedente: " + formatearEnum(antecedente));

        System.out.println("\n--- ATRIBUTOS ---");
        System.out.printf("Fuerza: %d (%+d)\n", fuerza, getModificador(fuerza));
        System.out.printf("Destreza: %d (%+d)\n", destreza, getModificador(destreza));
        System.out.printf("Constitución: %d (%+d)\n", constitucion, getModificador(constitucion));
        System.out.printf("Inteligencia: %d (%+d)\n", inteligencia, getModificador(inteligencia));
        System.out.printf("Sabiduría: %d (%+d)\n", sabiduria, getModificador(sabiduria));
        System.out.printf("Carisma: %d (%+d)\n", carisma, getModificador(carisma));
    }

    // Método común para todos
    protected int getModificador(int valor) {
        return (valor - 10) / 2;
    }

    public void setAtributos(int fuerza, int destreza, int constitucion, int inteligencia, int sabiduria, int carisma) {
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.constitucion = constitucion;
        this.inteligencia = inteligencia;
        this.sabiduria = sabiduria;
        this.carisma = carisma;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

     // Formatear enums para mostrar con mayúscula inicial
    protected String formatearEnum(Enum<?> valor) {
        String texto = valor.name().toLowerCase();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}

