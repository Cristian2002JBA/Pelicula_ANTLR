package com.pelicula.translators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ReverseTranslator - Convierte código de lenguajes externos de vuelta a Película (.movie).
 * Lee el archivo línea por línea y busca patrones conocidos (como if, for, print)
 * para transformarlos a la sintaxis del Director_cut (plot_twist, replay, subtitle).
 */
public class ReverseTranslator {

    public static String translate(String sourceCode, String ext) {
        switch (ext.toLowerCase()) {
            case "py":  return fromPython(sourceCode);
            case "js":
            case "ts":  return fromJavaScript(sourceCode);
            case "c":   return fromC(sourceCode);
            case "cpp": return fromCpp(sourceCode);
            case "asm": return fromAssembly(sourceCode);
            default: throw new IllegalArgumentException("Extensión no soportada: " + ext);
        }
    }

    // ─────────────────────────────────────────────────────────────
    // PYTHON → PELÍCULA
    // ─────────────────────────────────────────────────────────────
    private static String fromPython(String code) {
        StringBuilder out = new StringBuilder("premiere {\n");
        String[] rawLines = code.split("\n");

        // Usamos una pila para recordar la indentación (los espacios al inicio de cada línea)
        // Esto nos ayuda a saber cuándo cerrar las llaves '}' automáticamente.
        java.util.Deque<Integer> indentStack = new java.util.ArrayDeque<>();
        indentStack.push(0);

        for (String raw : rawLines) {
            // Ignoramos las líneas en blanco o que sean solo comentarios
            String trimmed = raw.stripLeading();
            if (trimmed.isEmpty() || trimmed.startsWith("#")) continue;

            int spaces = raw.length() - trimmed.length();

            // Si la línea actual tiene menos espacios que la anterior, cerramos las llaves abiertas
            while (indentStack.size() > 1 && spaces < indentStack.peek()) {
                indentStack.pop();
                out.append(makeIndent(indentStack.size())).append("}\n");
            }

            String indent = makeIndent(indentStack.size());

            // Si encontramos un print(), lo cambiamos a subtitle()
            Matcher mPrint = Pattern.compile("^print\\((.+)\\)$").matcher(trimmed);
            if (mPrint.matches()) {
                out.append(indent).append("subtitle(").append(mPrint.group(1)).append(");\n");
                continue;
            }
            // Si es un if, lo cambiamos a plot_twist
            Matcher mIf = Pattern.compile("^if (.+):$").matcher(trimmed);
            if (mIf.matches()) {
                out.append(indent).append("plot_twist (").append(mIf.group(1)).append(") {\n");
                indentStack.push(spaces + 4);
                continue;
            }
            // Si es un elif, lo cambiamos a spin_off
            Matcher mElif = Pattern.compile("^elif (.+):$").matcher(trimmed);
            if (mElif.matches()) {
                out.append(indent).append("spin_off (").append(mElif.group(1)).append(") {\n");
                indentStack.push(spaces + 4);
                continue;
            }
            // Si es un else, lo cambiamos a alternate_ending
            if (trimmed.equals("else:")) {
                out.append(indent).append("alternate_ending {\n");
                indentStack.push(spaces + 4);
                continue;
            }
            // Si es un while, lo cambiamos a replay
            Matcher mWhile = Pattern.compile("^while (.+):$").matcher(trimmed);
            if (mWhile.matches()) {
                out.append(indent).append("replay (; ").append(mWhile.group(1)).append("; ) {\n");
                indentStack.push(spaces + 4);
                continue;
            }
            // Ignoramos la palabra pass
            if (trimmed.equals("pass")) continue;

            // Si es una asignación de variable, usamos 'star'
            Matcher mAssign = Pattern.compile("^([A-Za-z_][\\w]*)\\s*=\\s*(.+)$").matcher(trimmed);
            if (mAssign.matches()) {
                out.append(indent).append("star ").append(mAssign.group(1))
                   .append(" = ").append(stripSemicolon(mAssign.group(2))).append(";\n");
                continue;
            }
            // Cualquier otra cosa que no reconozcamos, la dejamos como un comentario
            out.append(indent).append("// ").append(trimmed).append("\n");
        }
        // Cerramos cualquier bloque que haya quedado abierto al final
        while (indentStack.size() > 1) {
            indentStack.pop();
            out.append(makeIndent(indentStack.size())).append("}\n");
        }
        out.append("}\n");
        return out.toString();
    }

    // ─────────────────────────────────────────────────────────────
    // JAVASCRIPT / TYPESCRIPT → PELÍCULA
    // ─────────────────────────────────────────────────────────────
    private static String fromJavaScript(String code) {
        return fromCStyleBraces(code, "js");
    }

    // ─────────────────────────────────────────────────────────────
    // C → PELÍCULA
    // ─────────────────────────────────────────────────────────────
    private static String fromC(String code) {
        return fromCStyleBraces(code, "c");
    }

    // ─────────────────────────────────────────────────────────────
    // C++ → PELÍCULA
    // ─────────────────────────────────────────────────────────────
    private static String fromCpp(String code) {
        return fromCStyleBraces(code, "cpp");
    }

    // ─────────────────────────────────────────────────────────────
    // ASSEMBLY → PELÍCULA 
    // ─────────────────────────────────────────────────────────────
    private static String fromAssembly(String code) {
        StringBuilder out = new StringBuilder("premiere {\n");
        out.append("    // Como Assembly es muy complejo, solo lo pasamos como comentarios\n");
        for (String line : code.split("\n")) {
            String t = line.strip();
            if (t.isEmpty() || t.startsWith(";")) continue;
            out.append("    // ").append(t).append("\n");
        }
        out.append("}\n");
        return out.toString();
    }

    // ─────────────────────────────────────────────────────────────
    // TRADUCTOR COMPARTIDO para lenguajes con llaves { } (C, C++, JS, TS)
    // ─────────────────────────────────────────────────────────────
    private static String fromCStyleBraces(String code, String lang) {
        StringBuilder out = new StringBuilder("premiere {\n");

        // Para C y C++, solo empezamos a traducir lo que esté dentro de la función main()
        boolean isCFamily = lang.equals("c") || lang.equals("cpp");
        boolean insideMain = !isCFamily; 

        // Llevamos la cuenta de cuántas llaves { hemos abierto
        int depth = 1;
        // Guardamos en qué nivel empezó el main() para saber cuándo terminar
        int mainBraceDepth = 0;

        for (String raw : code.split("\n")) {
            String trimmed = raw.strip();

            // Ignoramos líneas vacías o comentarios puros
            if (trimmed.isEmpty() || trimmed.startsWith("//") || trimmed.startsWith("/*")
                    || trimmed.startsWith("*")) continue;

            // En C/C++ ignoramos los #include y buscamos dónde empieza el main()
            if (isCFamily) {
                if (trimmed.startsWith("#")) continue;
                
                if (!insideMain && trimmed.matches("int\\s+main\\s*\\(.*")) {
                    insideMain = true;
                    mainBraceDepth = depth;
                    continue;
                }
                if (!insideMain) continue;
            }

            // ── Manejo de llaves de cierre '}' ──
            if (trimmed.equals("}") || trimmed.equals("};")) {
                depth--;
                if (isCFamily && depth < mainBraceDepth) break; // Salimos del main()
                if (depth >= 1) {
                    out.append(makeIndent(depth)).append("}\n");
                }
                continue;
            }

            // Ignoramos código repetitivo o cierres de programa
            if (trimmed.equals("return 0;")) continue;

            String indent = makeIndent(depth);

            // ── IMPRESIONES ──
            // Cambiamos console.log() de JS/TS a subtitle()
            Matcher mConsole = Pattern.compile("^console\\.log\\((.+)\\);?$").matcher(trimmed);
            if (mConsole.matches()) {
                out.append(indent).append("subtitle(").append(mConsole.group(1)).append(");\n");
                continue;
            }
            // Cambiamos printf() de C a subtitle()
            Matcher mPrintf = Pattern.compile("^printf\\(\"[^\"]*\",\\s*(.+)\\);?$").matcher(trimmed);
            if (mPrintf.matches()) {
                out.append(indent).append("subtitle(").append(mPrintf.group(1)).append(");\n");
                continue;
            }
            // Cambiamos std::cout de C++ a subtitle()
            Matcher mCout = Pattern.compile("^std::cout\\s*<<\\s*(.+?)\\s*<<\\s*std::endl;?$").matcher(trimmed);
            if (mCout.matches()) {
                out.append(indent).append("subtitle(").append(mCout.group(1)).append(");\n");
                continue;
            }

            // ── CONDICIONALES ──
            Matcher mIf = Pattern.compile("^if\\s*\\((.+)\\)\\s*\\{?$").matcher(trimmed);
            if (mIf.matches()) {
                out.append(indent).append("plot_twist (").append(fixCond(mIf.group(1))).append(") {\n");
                depth++;
                continue;
            }
            Matcher mElseIf = Pattern.compile("^else\\s+if\\s*\\((.+)\\)\\s*\\{?$").matcher(trimmed);
            if (mElseIf.matches()) {
                out.append(indent).append("spin_off (").append(fixCond(mElseIf.group(1))).append(") {\n");
                depth++;
                continue;
            }
            if (trimmed.matches("^else\\s*\\{?$")) {
                out.append(indent).append("alternate_ending {\n");
                depth++;
                continue;
            }

            // ── CICLOS (FOR / WHILE) ──
            // Convertimos los for clásicos a replay
            Matcher mFor = Pattern.compile("^for\\s*\\(([^;]*);([^;]*);([^)]*)\\)\\s*\\{?$").matcher(trimmed);
            if (mFor.matches()) {
                String init = cleanForPart(mFor.group(1));
                String cond = fixCond(mFor.group(2).strip());
                String upd  = cleanForPart(mFor.group(3));
                out.append(indent).append("replay (").append(init).append("; ").append(cond)
                   .append("; ").append(upd).append(") {\n");
                depth++;
                continue;
            }
            // Convertimos los while a replay
            Matcher mWhile = Pattern.compile("^while\\s*\\((.+)\\)\\s*\\{?$").matcher(trimmed);
            if (mWhile.matches()) {
                out.append(indent).append("replay (; ").append(fixCond(mWhile.group(1))).append("; ) {\n");
                depth++;
                continue;
            }

            // ── VARIABLES ──
            // Para JS/TS usamos 'star' para variables (ignorando let/const/var)
            Matcher mJsDecl = Pattern.compile("^(?:let|const|var)\\s+([A-Za-z_][\\w]*)(?:\\s*:\\s*[\\w<>\\[\\]]+)?\\s*=\\s*(.+);?$").matcher(trimmed);
            if (mJsDecl.matches()) {
                out.append(indent).append("star ").append(mJsDecl.group(1))
                   .append(" = ").append(stripSemicolon(mJsDecl.group(2))).append(";\n");
                continue;
            }
            // Para C/C++ adivinamos el tipo de Película según el tipo original (int = ticket, float = rating, etc.)
            Matcher mCDecl = Pattern.compile("^(float|double|int|char\\*|bool|auto|std::string|unsigned)\\s+([A-Za-z_][\\w]*)\\s*=\\s*(.+);?$").matcher(trimmed);
            if (mCDecl.matches()) {
                String ctype = mCDecl.group(1);
                String id    = mCDecl.group(2);
                String val   = stripSemicolon(mCDecl.group(3));
                String kw;
                if (ctype.equals("float") || ctype.equals("double")) kw = "rating " + id;
                else if (ctype.equals("char*") || ctype.equals("std::string")) kw = "script " + id;
                else if (ctype.equals("bool")) kw = "spoiler " + id;
                else kw = "ticket " + id;
                out.append(indent).append(kw).append(" = ").append(val).append(";\n");
                continue;
            }

            // ── ASIGNACIONES SIMPLES ──
            Matcher mAssign = Pattern.compile("^([A-Za-z_][\\w]*)\\s*=\\s*(.+);?$").matcher(trimmed);
            if (mAssign.matches()) {
                out.append(indent).append(mAssign.group(1))
                   .append(" = ").append(stripSemicolon(mAssign.group(2))).append(";\n");
                continue;
            }

            // Si hay una llave { suelta, aumentamos el nivel de profundidad
            if (trimmed.equals("{")) { depth++; continue; }

            // Lo que no reconozcamos se queda como comentario para que el usuario lo revise
            out.append(indent).append("// ").append(trimmed).append("\n");
        }
        out.append("}\n");
        return out.toString();
    }

    // ─────────────────────────────────────────────────────────────
    // HELPERS (FUNCIONES DE APOYO)
    // ─────────────────────────────────────────────────────────────

    /** Normaliza comparadores JS (=== → ==) y booleanos (True -> true) */
    private static String fixCond(String cond) {
        return cond.strip()
            .replace("===", "==")
            .replace("!==", "!=")
            .replace("True",  "true")
            .replace("False", "false");
    }

    /**
     * Limpia la parte inicial de un for quitando el tipo de variable:
     *   "int i = 0"   → "i = 0"
     *   "let i = 0"   → "i = 0"
     */
    private static String cleanForPart(String part) {
        part = part.strip();
        part = part.replaceFirst("^(?:int|float|double|auto|let|const|var)\\s+", "");
        if (part.endsWith(";")) part = part.substring(0, part.length() - 1).strip();
        return part;
    }

    /** Genera espacios vacíos para mantener el código ordenado (indentado) */
    private static String makeIndent(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) sb.append("    ");
        return sb.toString();
    }

    /** Quita el punto y coma final de una línea si lo tiene */
    private static String stripSemicolon(String s) {
        s = s.strip();
        if (s.endsWith(";")) s = s.substring(0, s.length() - 1).strip();
        return s;
    }
}
