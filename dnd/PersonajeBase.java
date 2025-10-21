package dnd;

// Clase abstracta
public abstract class PersonajeBase {
    protected String nombre;
    protected int edad;
    protected String raza;
    protected String clase;
    protected String antecedente;
    protected int nivel = 1;

    // Atributos comunes a todos los personajes
    protected int fuerza, destreza, constitucion, inteligencia, sabiduria, carisma;
    protected String historia;

    // Constructor
    public PersonajeBase(String nombre, int edad, String raza, String clase, String antecedente) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.clase = clase;
        this.antecedente = antecedente;
    }

    // Método abstracto → cada clase lo implementa a su manera
    public abstract void presentarHistoria();

    // Mostrar ficha de personaje
    public void mostrarFicha() {
        System.out.println("\n==============================");
        System.out.println("🧙 HOJA DE PERSONAJE D&D");
        System.out.println("==============================");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Nivel: " + nivel);
        System.out.println("Raza: " + raza);
        System.out.println("Clase: " + clase);
        System.out.println("Antecedente: " + antecedente);

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
}

