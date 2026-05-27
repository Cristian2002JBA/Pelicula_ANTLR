package com.pelicula;

import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.pelicula.translators.*;

public class Main {

    private static final String EXTENSION = "movie";
    private static final String DIRBASE = "src/test/resources/";

    public static void main(String[] args) throws IOException {
        String files[] = args.length == 0 ? new String[] { "prueba." + EXTENSION } : args;
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

            System.out.println("\n--- GENERANDO TRADUCCIONES ---");

            // Generar Python
            PythonTranslatorVisitor pythonVisitor = new PythonTranslatorVisitor();
            guardarArchivo("traduccionSalida.py", pythonVisitor.visit(tree));

            // Generar JavaScript
            JavaScriptTranslatorVisitor jsVisitor = new JavaScriptTranslatorVisitor();
            guardarArchivo("traduccionSalida.js", jsVisitor.visit(tree));

            // Generar TypeScript
            TypeScriptTranslatorVisitor tsVisitor = new TypeScriptTranslatorVisitor();
            guardarArchivo("traduccionSalida.ts", tsVisitor.visit(tree));

            // Generar C
            CTranslatorVisitor cVisitor = new CTranslatorVisitor();
            guardarArchivo("traduccionSalida.c", cVisitor.visit(tree));

            // Generar C++
            CppTranslatorVisitor cppVisitor = new CppTranslatorVisitor();
            guardarArchivo("traduccionSalida.cpp", cppVisitor.visit(tree));

            // Generar Ensamblador x86 NASM
            AssemblyX86TranslatorVisitor asmVisitor = new AssemblyX86TranslatorVisitor();
            guardarArchivo("traduccionSalida.asm", asmVisitor.visit(tree));

            System.out.println("Todas las traducciones fueron generadas correctamente.");

            System.out.println("\nFINISH: " + file);
        }
    }

    private static void guardarArchivo(String nombreArchivo, String contenido) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(contenido);
            System.out.println(" - Generado: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar " + nombreArchivo + ": " + e.getMessage());
        }
    }
}
