import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que implementa el Nivel Léxico.
 * Contiene el main, el clasificador, y las estructuras Token/TipoToken 
 * como clases/enumeraciones estáticas internas.
 */
public class Minilexer {

    // --- 1. ESTRUCTURAS DE DATOS INTERNAS (Requisitos 8 & 9) ---

    /**
     * Enumeración que define los tipos de tokens permitidos.
     */
    public enum TipoToken {
        PALABRA_CLAVE,
        IDENTIFICADOR,
        LITERAL_NUMERICO,
        OPERADOR,
        DELIMITADOR
    }

    /**
     * Clase que representa un Token con su tipo y su lexema.
     */
    public static class Token {
        private TipoToken tipo;
        private String lexema;

        public Token(TipoToken tipo, String lexema) {
            this.tipo = tipo;
            this.lexema = lexema;
        }

        // Sobreescritura de toString para formato de salida: Token: <TIPO, "lexema">
        @Override
        public String toString() {
            // Reemplazamos "_" por espacio para que coincida con el formato del ejemplo (e.g., PALABRA CLAVE)
            return String.format("Token: <%s, \"%s\">", tipo.toString().replace("_", " "), lexema);
        }
    }

    // --- 2. LÓGICA DE CLASIFICACIÓN (Requisito 19) ---

    /**
     * Método estático para clasificar tokens según las reglas definidas (Requisitos 22-28).
     */
    public static TipoToken clasificarToken(String lexema) {
        // Palabras Clave: if, int
        if (lexema.equals("if") || lexema.equals("int")) {
            return TipoToken.PALABRA_CLAVE;
        }
        
        // Delimitadores: ;, (, )
        else if (lexema.equals(";") || lexema.equals("(") || lexema.equals(")")) {
            return TipoToken.DELIMITADOR;
        }

        // Operadores: =, ==, +
        else if (lexema.equals("=") || lexema.equals("==") || lexema.equals("+")) {
            return TipoToken.OPERADOR;
        }
        
        // Literales Numéricos: [0-9]+
        else if (lexema.matches("[0-9]+")) {
            return TipoToken.LITERAL_NUMERICO;
        }
        
        // Identificadores (else final)
        else {
            return TipoToken.IDENTIFICADOR;
        }
    }

    // --- 3. MÉTODO PRINCIPAL (Requisitos 5 & 12) ---

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Mini Analizador Léxico (Nivel Léxico Simplificado)");
        System.out.println("Introduce las instrucciones (separando todos los tokens con espacios).");
        System.out.println("Ejemplo: int valor = 3 ; if ( valor == 5 ) valor = 0 ;");
        System.out.print("> ");
        
        String entrada = scanner.nextLine();
        
        if (entrada.trim().isEmpty()) {
            System.out.println("Usando ejemplo por defecto:");
            entrada = "int valor = 3 ; if ( valor == 5 ) valor = 0 ;";
        }

        // Separar instrucciones usando split() (Requisito 16)
        String[] lexemasRaw = entrada.split(" ");
        
        // Para almacenar los tokens generados (Requisito 30)
        List<Token> listaTokens = new ArrayList<>();

        System.out.println("\n--- Resultado del Análisis Léxico ---\n");
        
        // Bucle de clasificación e impresión (Requisito 29)
        for (String lexema : lexemasRaw) {
            // Ignorar espacios vacíos que pueda generar el split
            if (lexema.trim().isEmpty()) continue;

            // Clasificar y crear el objeto Token
            TipoToken tipo = clasificarToken(lexema);
            Token nuevoToken = new Token(tipo, lexema);
            
            // Almacenar e imprimir
            listaTokens.add(nuevoToken);
            System.out.println(nuevoToken);
        }

        scanner.close();
    }
}