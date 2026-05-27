package com.pelicula.translators;

public class TypeScriptTranslatorVisitor extends JavaScriptTranslatorVisitor {

    @Override
    protected String getProgramStart() {
        return "// Traducción a TypeScript\n";
    }

    @Override
    protected String getDeclarationString(String id, String value, String type, boolean isCast, boolean isStar) {
        String tsType = "any";
        if (type != null) {
            switch(type) {
                case "ticket":
                case "rating": 
                    tsType = "number"; 
                    break;
                case "script": 
                    tsType = "string"; 
                    break;
                case "spoiler": 
                    tsType = "boolean"; 
                    break;
            }
        }
        return "let " + id + ": " + tsType + " = " + value + ";";
    }
}
