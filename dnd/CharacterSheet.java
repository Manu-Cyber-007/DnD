package dnd;
import java.util.Scanner;

public class CharacterSheet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===  CREADOR DE PERSONAJES DE D&D  ===");

        // --- Datos básicos ---
        System.out.print("Nombre del personaje: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        // --- RAZAS ---
        String[] razas = {"Enano", "Elfo", "Halfling", "Humano", "Dragonborn", "Gnomo", "Goliat", "Orco", "Tiefling"};
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
        for (int i = 0; i < razas.length; i++) System.out.println((i + 1) + ". " + razas[i]);
        System.out.print("Número elegido: ");
        int razaIndex = sc.nextInt() - 1;
        sc.nextLine();
        String raza = razas[razaIndex];
        System.out.println("\n Descripción de la raza " + raza + ":");
        System.out.println(descRazas[razaIndex]);

        // --- CLASES ---
        String[] clases = {"Bárbaro", "Bardo", "Brujo", "Clérigo", "Combatiente", "Druida", "Guardabosques", "Hechicero", "Mago", "Monje", "Paladín", "Pícaro"};
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
        for (int i = 0; i < clases.length; i++) System.out.println((i + 1) + ". " + clases[i]);
        System.out.print("Número elegido: ");
        int claseIndex = sc.nextInt() - 1;
        sc.nextLine();
        String clase = clases[claseIndex];
        System.out.println("\n Descripción de la clase " + clase + ":");
        System.out.println(descClases[claseIndex]);

        // --- ANTECEDENTES ---
        String[] antecedentes = {"Soldado", "Criminal", "Sabio", "Acolito"};
        System.out.println("\nElige un antecedente:");
        for (int i = 0; i < antecedentes.length; i++) System.out.println((i + 1) + ". " + antecedentes[i]);
        System.out.print("Número elegido: ");
        String antecedente = antecedentes[sc.nextInt() - 1];
        sc.nextLine();

        // --- Crear personaje ---
        PersonajeBase pj = switch (clase) {
            case "Bárbaro" -> new Barbaro(nombre, edad, raza, antecedente);
            case "Bardo" -> new Bardo(nombre, edad, raza, antecedente);
            case "Brujo" -> new Brujo(nombre, edad, raza, antecedente);
            case "Clérigo" -> new Clerigo(nombre, edad, raza, antecedente);
            case "Combatiente" -> new Combatiente(nombre, edad, raza, antecedente);
            case "Druida" -> new Druida(nombre, edad, raza, antecedente);
            case "Guardabosques" -> new Guardabosques(nombre, edad, raza, antecedente);
            case "Hechicero" -> new Hechicero(nombre, edad, raza, antecedente);
            case "Mago" -> new Mago(nombre, edad, raza, antecedente);
            case "Monje" -> new Monje(nombre, edad, raza, antecedente);
            case "Paladín" -> new Paladin(nombre, edad, raza, antecedente);
            case "Pícaro" -> new Picaro(nombre, edad, raza, antecedente);
            default -> new PersonajeGenerico(nombre, edad, raza, clase, antecedente);
        };

        // --- Tiradas de atributos ---
        System.out.println("\n--- Generación de atributos ---");
        System.out.println("Lanza 4d6, descarta el más bajo y suma los tres restantes. Ingresa tus resultados:");
        System.out.print("Fuerza: ");
        int fuerza = sc.nextInt();
        System.out.print("Destreza: ");
        int destreza = sc.nextInt();
        System.out.print("Constitución: ");
        int constitucion = sc.nextInt();
        System.out.print("Inteligencia: ");
        int inteligencia = sc.nextInt();
        System.out.print("Sabiduría: ");
        int sabiduria = sc.nextInt();
        System.out.print("Carisma: ");
        int carisma = sc.nextInt();
        sc.nextLine();

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
            baseHP = dado; // máximo valor del dado
             System.out.printf(" Máximo del dado d%d (%d) + Modificador Constitución (%+d)\n", dado, dado, modCon);
        }

        int hpInicial = baseHP + pj.getModificador(constitucion);
        if (hpInicial < 1) hpInicial = 1; // mínimo 1 HP

        // --- Historia personalizada ---
        System.out.println("\nAhora escribe una breve historia de tu personaje:");
        pj.setHistoria(sc.nextLine());

        // --- Mostrar ficha final ---
        pj.mostrarFicha();

       // --- Tabla de modificadores ---
        System.out.println("\n======  RESUMEN DE ATRIBUTOS ======");
        System.out.printf("Fuerza ............. %2d (%+d)\n", fuerza, pj.getModificador(fuerza));
        System.out.printf("Destreza ........... %2d (%+d)\n", destreza, pj.getModificador(destreza));
        System.out.printf("Constitución ....... %2d (%+d)\n", constitucion, pj.getModificador(constitucion));
        System.out.printf("Inteligencia ....... %2d (%+d)\n", inteligencia, pj.getModificador(inteligencia));
        System.out.printf("Sabiduría .......... %2d (%+d)\n", sabiduria, pj.getModificador(sabiduria));
        System.out.printf("Carisma ............ %2d (%+d)\n", carisma, pj.getModificador(carisma));
        System.out.println("-------------------------------------");
        System.out.printf(" Dado de golpe: d%d\n", dado);
        System.out.printf(" Puntos de Vida (HP inicial): %d\n", hpInicial);
        System.out.println("=====================================");
        // --- Presentar historia personalizada ---
        pj.presentarHistoria();

        sc.close();

        
    }
     // === MÉTODO AUXILIAR PARA CALCULAR HP INICIAL ===
     private static int getHitDie(String clase) {
        return switch (clase) {
            case "Bárbaro" -> 12;
            case "Paladín", "Guardabosques", "Combatiente" -> 10;
            case "Clérigo", "Druida", "Monje", "Pícaro", "Bardo" -> 8;
            case "Hechicero", "Mago", "Brujo" -> 6;
            default -> 8; // valor por defecto
        };
    }
}

