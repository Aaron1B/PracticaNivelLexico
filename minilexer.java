import java.util.Scanner;

public class minilexer {

    public enum TipoToken {
            Palabra_clave, Identificador, Literal_numerico, Operador, Delimitador
        }

    public class Token {
            String lexema;
            TipoToken tipo;

            public Token(String Lexema, TipoToken tipo) {
                this.tipo = tipo;
                this.lexema = lexema;
            }

        }
    public TipoToken clasificarToken( String lexema){
        for (String instruccion: ejemplo.split(" ")); 
        }
    }


    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        String ejemplo = "int valor = 3 ;if ( valor == 5 ) valor = 0";
        System.out.print(ejemplo.split(" "));

        String[] tokens = ejemplo.split(" ");



    }
    
}
