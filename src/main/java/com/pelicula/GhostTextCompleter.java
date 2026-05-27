package com.pelicula;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

/**
 * Clase encargada de mostrar sugerencias de texto "fantasma" en el editor (al estilo de Copilot).
 * Muestra una sugerencia difuminada después del cursor que el usuario puede aceptar pulsando la tecla Tab.
 */
public class GhostTextCompleter {

    private static final Color GHOST_COLOR = new Color(100, 140, 180, 120);

    private final RSyntaxTextArea editor;
    private String ghostSuffix = null;
    private final List<String> keywords;

    public GhostTextCompleter(RSyntaxTextArea editor) {
        this.editor = editor;
        this.keywords = Arrays.asList(
            "premiere", "cast", "star",
            "ticket", "rating", "script", "spoiler",
            "hit", "flop",
            "subtitle", "audition",
            "plot_twist", "spin_off", "alternate_ending", "replay"
        );

        // Paint ghost text as an overlay
        editor.addCaretListener(e -> editor.repaint());

        editor.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { updateGhost(); }
            @Override public void removeUpdate(DocumentEvent e) { updateGhost(); }
            @Override public void changedUpdate(DocumentEvent e) { updateGhost(); }
        });

        // Interceptamos la tecla Tab para autocompletar la palabra sugerida
        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB && ghostSuffix != null) {
                    e.consume(); // Evitamos que el Tab inserte un espacio o salte el foco
                    acceptGhost();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    // Si el usuario pulsa Escape, ocultamos la sugerencia
                    ghostSuffix = null;
                    editor.repaint();
                }
            }
        });
    }

    private void updateGhost() {
        SwingUtilities.invokeLater(() -> {
            String prefix = getCurrentWordPrefix();
            if (prefix == null || prefix.length() < 2) {
                ghostSuffix = null;
                editor.repaint();
                return;
            }
            String match = null;
            for (String kw : keywords) {
                if (kw.startsWith(prefix) && !kw.equals(prefix)) {
                    match = kw;
                    break;
                }
            }
            if (match != null) {
                ghostSuffix = match.substring(prefix.length());
            } else {
                ghostSuffix = null;
            }
            editor.repaint();
        });
    }

    // Método auxiliar para detectar qué palabra está escribiendo el usuario actualmente
    private String getCurrentWordPrefix() {
        try {
            int caretPos = editor.getCaretPosition();
            int lineStart = editor.getLineStartOffset(editor.getLineOfOffset(caretPos));
            String lineText = editor.getText(lineStart, caretPos - lineStart);
            
            // Recorremos hacia atrás para encontrar el inicio de la palabra actual
            int wordStart = lineText.length();
            while (wordStart > 0) {
                char c = lineText.charAt(wordStart - 1);
                if (Character.isLetterOrDigit(c) || c == '_') {
                    wordStart--;
                } else {
                    break;
                }
            }
            if (wordStart < lineText.length()) {
                return lineText.substring(wordStart);
            }
        } catch (BadLocationException e) {
            // ignore
        }
        return null;
    }

    private void acceptGhost() {
        if (ghostSuffix == null) return;
        String toInsert = ghostSuffix;
        ghostSuffix = null;
        try {
            editor.getDocument().insertString(editor.getCaretPosition(), toInsert, null);
        } catch (BadLocationException e) {
            // ignore
        }
    }

    /**
     * Call this from the editor's paintComponent to render the ghost text.
     */
    public void paintGhost(Graphics g) {
        if (ghostSuffix == null || ghostSuffix.isEmpty()) return;
        try {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            int caretPos = editor.getCaretPosition();
            java.awt.Rectangle caretRect = editor.modelToView(caretPos);
            if (caretRect == null) return;
            g2.setFont(editor.getFont());
            g2.setColor(GHOST_COLOR);
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(ghostSuffix, caretRect.x, caretRect.y + fm.getAscent());
            g2.dispose();
        } catch (BadLocationException e) {
            // ignore
        }
    }
}
