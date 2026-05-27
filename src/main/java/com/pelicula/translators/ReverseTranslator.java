package com.pelicula.translators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ReverseTranslator - Convierte código de lenguajes externos de vuelta a Película (.movie).
 * Respeta EXACTAMENTE la gramática Director_cut.g4:
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

       
        java.util.Deque<Integer> indentStack = new java.util.ArrayDeque<>();
        indentStack.push(0);

        for (String raw : rawLines) {
           
            String trimmed = raw.stripLeading();
            if (trimmed.isEmpty() || trimmed.startsWith("#")) continue;

            int spaces = raw.length() - trimmed.length();

            
            while (indentStack.size() > 1 && spaces < indentStack.peek()) {
                indentStack.pop();
                out.append(makeIndent(indentStack.size())).append("}\n");
            }

            String indent = makeIndent(indentStack.size());

            // print(x)
            Matcher mPrint = Pattern.compile("^print\\((.+)\\)$").matcher(trimmed);
            if (mPrint.matches()) {
                out.append(indent).append("subtitle(").append(mPrint.group(1)).append(");\n");
                continue;
            }
            // if cond:
            Matcher mIf = Pattern.compile("^if (.+):$").matcher(trimmed);
            if (mIf.matches()) {
                out.append(indent).append("plot_twist (").append(mIf.group(1)).append(") {\n");
                indentStack.push(spaces + 4);
                continue;
            }
            // elif cond:
            Matcher mElif = Pattern.compile("^elif (.+):$").matcher(trimmed);
            if (mElif.matches()) {
                out.append(indent).append("spin_off (").append(mElif.group(1)).append(") {\n");
                indentStack.push(spaces + 4);
                continue;
            }
            // else:
            if (trimmed.equals("else:")) {
                out.append(indent).append("alternate_ending {\n");
                indentStack.push(spaces + 4);
                continue;
            }
            // while cond:
            Matcher mWhile = Pattern.compile("^while (.+):$").matcher(trimmed);
            if (mWhile.matches()) {
                out.append(indent).append("replay (; ").append(mWhile.group(1)).append("; ) {\n");
                indentStack.push(spaces + 4);
                continue;
            }
            // pass
            if (trimmed.equals("pass")) continue;

            // var = value  (declarations / assignments)
            Matcher mAssign = Pattern.compile("^([A-Za-z_][\\w]*)\\s*=\\s*(.+)$").matcher(trimmed);
            if (mAssign.matches()) {
                out.append(indent).append("star ").append(mAssign.group(1))
                   .append(" = ").append(stripSemicolon(mAssign.group(2))).append(";\n");
                continue;
            }
            // Anything else → comment
            out.append(indent).append("// ").append(trimmed).append("\n");
        }
        // Close any remaining open blocks
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
    // ASSEMBLY → PELÍCULA (best-effort: all as comments)
    // ─────────────────────────────────────────────────────────────
    private static String fromAssembly(String code) {
        StringBuilder out = new StringBuilder("premiere {\n");
        out.append("    // Código importado desde Assembly (traducción aproximada)\n");
        for (String line : code.split("\n")) {
            String t = line.strip();
            if (t.isEmpty() || t.startsWith(";")) continue;
            out.append("    // ").append(t).append("\n");
        }
        out.append("}\n");
        return out.toString();
    }

    // ─────────────────────────────────────────────────────────────
    // SHARED: C / C++ / JS / TS brace-based translator
    // ─────────────────────────────────────────────────────────────
    private static String fromCStyleBraces(String code, String lang) {
        StringBuilder out = new StringBuilder("premiere {\n");

        // For C/C++ we start collecting only after we enter main()
        boolean isCFamily = lang.equals("c") || lang.equals("cpp");
        boolean insideMain = !isCFamily; // JS/TS: always "inside"

        // depth tracks nesting level inside premiere { }
        int depth = 1;
        // mainBraceDepth: the brace depth of the outer main() opener so we know when to stop
        int mainBraceDepth = 0;

        for (String raw : code.split("\n")) {
            String trimmed = raw.strip();

            // Always skip blank lines and single-line comments
            if (trimmed.isEmpty() || trimmed.startsWith("//") || trimmed.startsWith("/*")
                    || trimmed.startsWith("*")) continue;

            // C-family: skip preprocessor and main() signature
            if (isCFamily) {
                if (trimmed.startsWith("#")) continue;
                // Detect int main(...)  {
                if (!insideMain && trimmed.matches("int\\s+main\\s*\\(.*")) {
                    insideMain = true;
                    mainBraceDepth = depth;
                    // If the line ends with '{', don't count it as a content line
                    continue;
                }
                if (!insideMain) continue;
            }

            // ── Handle closing braces ──
            if (trimmed.equals("}") || trimmed.equals("};")) {
                depth--;
                if (isCFamily && depth < mainBraceDepth) break; // left main()
                if (depth >= 1) {
                    out.append(makeIndent(depth)).append("}\n");
                }
                continue;
            }

            // Skip boilerplate
            if (trimmed.equals("return 0;")) continue;

            String indent = makeIndent(depth);

            // ── PRINT ──
            // console.log(x);
            Matcher mConsole = Pattern.compile("^console\\.log\\((.+)\\);?$").matcher(trimmed);
            if (mConsole.matches()) {
                out.append(indent).append("subtitle(").append(mConsole.group(1)).append(");\n");
                continue;
            }
            // printf("...", val);
            Matcher mPrintf = Pattern.compile("^printf\\(\"[^\"]*\",\\s*(.+)\\);?$").matcher(trimmed);
            if (mPrintf.matches()) {
                out.append(indent).append("subtitle(").append(mPrintf.group(1)).append(");\n");
                continue;
            }
            // std::cout << val << std::endl;
            Matcher mCout = Pattern.compile("^std::cout\\s*<<\\s*(.+?)\\s*<<\\s*std::endl;?$").matcher(trimmed);
            if (mCout.matches()) {
                out.append(indent).append("subtitle(").append(mCout.group(1)).append(");\n");
                continue;
            }

            // ── IF / ELSE IF / ELSE ──
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

            // ── FOR ──
            // for (init; cond; update) {
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
            // while (cond) {
            Matcher mWhile = Pattern.compile("^while\\s*\\((.+)\\)\\s*\\{?$").matcher(trimmed);
            if (mWhile.matches()) {
                out.append(indent).append("replay (; ").append(fixCond(mWhile.group(1))).append("; ) {\n");
                depth++;
                continue;
            }

            // ── VARIABLE DECLARATIONS ──
            // JS/TS: let/const/var name[: type] = value;
            Matcher mJsDecl = Pattern.compile("^(?:let|const|var)\\s+([A-Za-z_][\\w]*)(?:\\s*:\\s*[\\w<>\\[\\]]+)?\\s*=\\s*(.+);?$").matcher(trimmed);
            if (mJsDecl.matches()) {
                out.append(indent).append("star ").append(mJsDecl.group(1))
                   .append(" = ").append(stripSemicolon(mJsDecl.group(2))).append(";\n");
                continue;
            }
            // C/C++: [type] varname = value;
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

            // ── ASSIGNMENT ──
            Matcher mAssign = Pattern.compile("^([A-Za-z_][\\w]*)\\s*=\\s*(.+);?$").matcher(trimmed);
            if (mAssign.matches()) {
                out.append(indent).append(mAssign.group(1))
                   .append(" = ").append(stripSemicolon(mAssign.group(2))).append(";\n");
                continue;
            }

            // Lone opening brace
            if (trimmed.equals("{")) { depth++; continue; }

            // Anything else → comment
            out.append(indent).append("// ").append(trimmed).append("\n");
        }
        out.append("}\n");
        return out.toString();
    }

    // ─────────────────────────────────────────────────────────────
    // HELPERS
    // ─────────────────────────────────────────────────────────────

    /** Normaliza comparadores JS (=== → ==) y booleans */
    private static String fixCond(String cond) {
        return cond.strip()
            .replace("===", "==")
            .replace("!==", "!=")
            .replace("True",  "true")
            .replace("False", "false");
    }

    /**
     * Limpia la parte init/update de un for:
     *   "int i = 0"   → "i = 0"
     *   "let i = 0"   → "i = 0"
     *   "auto i = 5"  → "i = 5"
     *   "i = i + 1"   → "i = i + 1"
     */
    private static String cleanForPart(String part) {
        part = part.strip();
        // Remove C/JS type prefix
        part = part.replaceFirst("^(?:int|float|double|auto|let|const|var)\\s+", "");
        // Strip trailing semicolons
        if (part.endsWith(";")) part = part.substring(0, part.length() - 1).strip();
        return part;
    }

    private static String makeIndent(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) sb.append("    ");
        return sb.toString();
    }

    private static String stripSemicolon(String s) {
        s = s.strip();
        if (s.endsWith(";")) s = s.substring(0, s.length() - 1).strip();
        return s;
    }
}
