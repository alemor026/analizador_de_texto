package codigo;

import java.io.File;

/**
 *
 * @author Alejandra Morales
 */
public class Principal {
    public static void main(String[] args) {
        String ruta = "C:\Users\Usuaria\Documents\NetBeansProjects\Analizador\AnalizadorDeTexto\src\codigo/Lexer.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
