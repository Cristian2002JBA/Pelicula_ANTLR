package com.pelicula;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    private static final String EXTENSION = "movie";

    private static final String DIRBASE = "src/test/resources/";

    public static void main(String[] args) throws IOException {
        String files[] = args.length == 0 ? new String[] { "falla_doble_declaracion." + EXTENSION } : args;
        System.out.println("Dirbase: " + DIRBASE);

        for (String file : files) {
            System.out.println("START: " + file);

            CharStream in = CharStreams.fromFileName(DIRBASE + file);
            Director_cutLexer lexer = new Director_cutLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Director_cutParser parser = new Director_cutParser(tokens);

            Director_cutParser.ProgramContext tree = parser.program();

            System.out.println("\n--- EJECUCIÓN DEL PROGRAMA ---");
            DirectorCutVisitor visitor = new DirectorCutVisitor();
            visitor.visit(tree);

            System.out.println("\nFINISH: " + file);
        }
    }
}
