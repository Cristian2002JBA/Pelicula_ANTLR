package com.pelicula;

public class Simbolo {
    public enum TipoDato {
        INT, FLOAT, BOOLEAN, STRING
    }

    public TipoDato tipo;
    public Object valor;

    public Simbolo(TipoDato tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
}
