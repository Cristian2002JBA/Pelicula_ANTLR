package com.pelicula;

import java.io.OutputStream;

import javax.swing.JTextArea;

/**
 * Redirige la salida estándar (System.out) y de error (System.err) 
 * hacia el componente JTextArea de la interfaz gráfica (consola integrada).
 */
public class TextAreaOutputStream extends OutputStream {
    private JTextArea textArea;

    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        textArea.append(String.valueOf((char) b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}