package dnd;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class CharacterSheet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("===  CREADOR DE PERSONAJES DE D&D  ===");

        // --- Datos básicos ---
        System.out.print("Nombre del personaje: ");
        String nombre = sc.nextLine();

        int edad;
        do {
            System.out.print("Edad: ");
            edad = sc.nextInt();
            if (edad <= 0) {
                System.out.println("Valor inválido. La edad debe ser un número positivo mayor que cero.");
            }
        } while (edad <= 0);
        sc.nextLine();

        // --- RAZAS ---
        Raza[] razas = Raza.values();
        String[] descRazas = {
            "Los Enanos son fuertes, resistentes y orgullosos de sus tradiciones subterráneas.",
            "Los Elfos son ágiles, longevos y profundamente conectados con la magia y la naturaleza.",
            "Los Halflings son pequeños, alegres y sorprendentemente valientes para su tamaño.",
            "Los Humanos son versátiles y ambiciosos, capaces de adaptarse a cualquier entorno.",
            "Los Dragonborn descienden de dragones, poseyendo una presencia imponente y un aliento elemental.",
            "Los Gnomos son curiosos inventores y amantes de la magia y los artefactos.",
            "Los Goliat son gigantescos montañeses con una fuerza física impresionante.",
            "Los Orcos son guerreros feroces que buscan honor y gloria en la batalla.",
            "Los Tieflings llevan sangre infernal, marcados por su carisma y su misterioso destino."
        };

        System.out.println("\nElige una raza:");
        for (int i = 0; i < razas.length; i++) System.out.println((i + 1) + ". " + formatearEnum(razas[i]));
        System.out.print("Número elegido: ");
        Raza raza = razas[sc.nextInt() - 1];
        sc.nextLine();
        System.out.println("\nDescripción de la raza " + formatearEnum(raza) + ":");
        System.out.println(descRazas[raza.ordinal()]);

        // --- CLASES ---
        Clase[] clases = Clase.values();
        String[] descClases = {
            "Los Bárbaros canalizan su furia interior en poder devastador.",
            "Los Bardos usan la música y la palabra para inspirar y manipular la magia.",
            "Los Brujos obtienen su poder mediante pactos con entidades sobrenaturales.",
            "Los Clérigos canalizan poder divino para sanar o destruir en nombre de su fe.",
            "Los Combatientes dominan todo tipo de armas y tácticas de guerra.",
            "Los Druidas protegen la naturaleza y canalizan la fuerza de los elementos.",
            "Los Guardabosques son exploradores y cazadores expertos.",
            "Los Hechiceros nacen con magia en la sangre, controlando poder innato.",
            "Los Magos canalizan el poder arcano mediante el estudio y la disciplina.",
            "Los Monjes perfeccionan cuerpo y mente a través de la meditación y el entrenamiento.",
            "Los Paladines son campeones sagrados guiados por juramentos de justicia.",
            "Los Pícaros dominan el sigilo, la astucia y los golpes precisos."
        };

        System.out.println("\nElige una clase:");
        for (int i = 0; i < clases.length; i++) System.out.println((i + 1) + ". " + formatearEnum(clases[i]));
        System.out.print("Número elegido: ");
        Clase clase = clases[sc.nextInt() - 1];
        sc.nextLine();
        System.out.println("\nDescripción de la clase " + formatearEnum(clase) + ":");
        System.out.println(descClases[clase.ordinal()]);

        // --- ANTECEDENTES ---
        Antecedente[] antecedentes = Antecedente.values();
        System.out.println("\nElige un antecedente:");
        for (int i = 0; i < antecedentes.length; i++) System.out.println((i + 1) + ". " + formatearEnum(antecedentes[i]));
        System.out.print("Número elegido: ");
        Antecedente antecedente = antecedentes[sc.nextInt() - 1];
        sc.nextLine();

        // --- Crear personaje ---
        PersonajeBase pj = crearPersonaje(nombre, edad, raza, clase, antecedente);

        // --- Tiradas de atributos ---
        System.out.println("\n--- Generación de atributos ---");
        System.out.print("¿Quieres que el programa tire tus atributos automáticamente? (si/no): ");
        String auto = sc.nextLine().trim().toLowerCase();

        int fuerza, destreza, constitucion, inteligencia, sabiduria, carisma;

        if (auto.equals("si")) {
            fuerza = tirar4d6(rand, "Fuerza");
            destreza = tirar4d6(rand, "Destreza");
            constitucion = tirar4d6(rand, "Constitución");
            inteligencia = tirar4d6(rand, "Inteligencia");
            sabiduria = tirar4d6(rand, "Sabiduría");
            carisma = tirar4d6(rand, "Carisma");
        } else {
            System.out.println("Lanza 4d6, descarta el más bajo y suma los tres restantes.");
            System.out.println("Ingresa valores entre 3 y 18.");

            fuerza = leerAtributo(sc, "Fuerza");
            destreza = leerAtributo(sc, "Destreza");
            constitucion = leerAtributo(sc, "Constitución");
            inteligencia = leerAtributo(sc, "Inteligencia");
            sabiduria = leerAtributo(sc, "Sabiduría");
            carisma = leerAtributo(sc, "Carisma");
        }

        pj.setAtributos(fuerza, destreza, constitucion, inteligencia, sabiduria, carisma);

        // --- Calcular puntos de vida ---
        int dado = getHitDie(clase);
        int modCon = pj.getModificador(constitucion);
        System.out.println("\nTu clase usa un dado de golpe d" + dado + ".");
        System.out.print("¿Quieres tirar el dado para calcular tus puntos de vida? (si/no): ");
        String decision = sc.nextLine().trim().toLowerCase();

        int baseHP;
        if (decision.equals("si")) {
            System.out.print("Introduce el resultado de tu tirada de d" + dado + ": ");
            int tirada = sc.nextInt();
            sc.nextLine();
            baseHP = tirada;
            System.out.printf(" Tirada d%d (%d) + Modificador Constitución (%+d)\n", dado, tirada, modCon);
        } else {
            baseHP = dado;
            System.out.printf(" Máximo del dado d%d (%d) + Modificador Constitución (%+d)\n", dado, dado, modCon);
        }

        int hpInicial = Math.max(1, baseHP + modCon);

        // --- Historia personalizada ---
        System.out.println("\nAhora escribe una breve historia de tu personaje:");
        pj.setHistoria(sc.nextLine());

        // --- Mostrar ficha final ---
        pj.mostrarFicha();

        // --- Resumen de atributos ---
        System.out.println("\n======  RESUMEN DE ATRIBUTOS ======");
        mostrarAtributo("Fuerza", fuerza, pj);
        mostrarAtributo("Destreza", destreza, pj);
        mostrarAtributo("Constitución", constitucion, pj);
        mostrarAtributo("Inteligencia", inteligencia, pj);
        mostrarAtributo("Sabiduría", sabiduria, pj);
        mostrarAtributo("Carisma", carisma, pj);
        System.out.println("-------------------------------------");
        System.out.printf(" Dado de golpe: d%d\n", dado);
        System.out.printf(" Puntos de Vida (HP inicial): %d\n", hpInicial);
        System.out.println("=====================================");

        // --- Historia personalizada ---
        pj.presentarHistoria();
        sc.close();
    }

    // === MÉTODOS AUXILIARES ===

    private static int getHitDie(Clase clase) {
        return switch (clase) {
            case BARBARO -> 12;
            case PALADIN, GUARDABOSQUES, COMBATIENTE -> 10;
            case CLERIGO, DRUIDA, MONJE, PICARO, BARDO -> 8;
            case HECHICERO, MAGO, BRUJO -> 6;
            default -> 8;
        };
    }

    private static int tirar4d6(Random rand, String atributo) {
        int[] dados = new int[4];
        for (int i = 0; i < 4; i++) dados[i] = rand.nextInt(6) + 1;
        Arrays.sort(dados);
        int total = dados[1] + dados[2] + dados[3];
        System.out.printf("%s: [%d, %d, %d, %d] => %d\n", atributo, dados[0], dados[1], dados[2], dados[3], total);
        return total;
    }

    private static int leerAtributo(Scanner sc, String nombre) {
        int valor;
        do {
            System.out.print(nombre + ": ");
            valor = sc.nextInt();
            if (valor < 3 || valor > 18) {
                System.out.println("Valor inválido. Debe estar entre 3 y 18.");
            }
        } while (valor < 3 || valor > 18);
        return valor;
    }

    private static void mostrarAtributo(String nombre, int valor, PersonajeBase pj) {
        System.out.printf("%s ............. %2d (%+d)\n", nombre, valor, pj.getModificador(valor));
    }

    private static String formatearEnum(Enum<?> valor) {
        String texto = valor.name().toLowerCase();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }

    private static PersonajeBase crearPersonaje(String nombre, int edad, Raza raza, Clase clase, Antecedente antecedente) {
        return switch (clase) {
            case BARBARO -> new Barbaro(nombre, edad, raza, antecedente);
            case MAGO -> new Mago(nombre, edad, raza, antecedente);
            case DRUIDA -> new Druida(nombre, edad, raza, antecedente);
            default -> new PersonajeGenerico(nombre, edad, raza, clase, antecedente);
        };
    }
}