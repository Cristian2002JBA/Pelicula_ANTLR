package com.pelicula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.pelicula.translators.AssemblyX86TranslatorVisitor;
import com.pelicula.translators.CTranslatorVisitor;
import com.pelicula.translators.CppTranslatorVisitor;
import com.pelicula.translators.JavaScriptTranslatorVisitor;
import com.pelicula.translators.PythonTranslatorVisitor;
import com.pelicula.translators.TypeScriptTranslatorVisitor;

public class GUI extends JFrame {
    private JTextArea editorArea;
    private JTextArea consoleArea;
    private JTextArea lineNumbersArea;
    private JLabel statusLabel;
    private String currentFilePath = null;
    private JFileChooser fileChooser;

    public GUI() {
        initLookAndFeel();
        setTitle("Editor y Traductor de Películas - Sin archivo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 800);
        setLocationRelativeTo(null);
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de película (*.movie)", "movie"));

        createEditor();
        createConsole();
        JPanel centerPanel = createSplitPane();
        JToolBar toolBar = createToolBar();
        JMenuBar menuBar = createMenuBar();  // Barra de menú simplificada
        statusLabel = createStatusBar();

        setLayout(new BorderLayout());
        add(toolBar, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
        setJMenuBar(menuBar);

        setupKeyboardShortcuts();
        editorArea.addCaretListener(e -> updateStatusBarCursor());
        updateStatusBarCursor();
    }

    private void initLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) { }
        }
    }

    private void createEditor() {
        editorArea = new JTextArea();
        editorArea.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
        editorArea.setTabSize(4);
        editorArea.setMargin(new Insets(5, 5, 5, 5));
        editorArea.setBackground(new Color(250, 250, 250));
        editorArea.setForeground(Color.BLACK);
        editorArea.setCaretColor(Color.BLUE);
    }

    private void createConsole() {
        consoleArea = new JTextArea();
        consoleArea.setEditable(false);
        consoleArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        consoleArea.setBackground(new Color(30, 30, 30));
        consoleArea.setForeground(new Color(0, 255, 0));
        consoleArea.setMargin(new Insets(5, 5, 5, 5));
        PrintStream ps = new PrintStream(new TextAreaOutputStream(consoleArea));
        System.setOut(ps);
        System.setErr(ps);
    }

    private JPanel createSplitPane() {
        lineNumbersArea = new JTextArea("1");
        lineNumbersArea.setEditable(false);
        lineNumbersArea.setFont(editorArea.getFont());
        lineNumbersArea.setBackground(new Color(240, 240, 240));
        lineNumbersArea.setForeground(Color.GRAY);
        lineNumbersArea.setMargin(new Insets(5, 5, 5, 5));
        lineNumbersArea.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));

        JScrollPane editorScroll = new JScrollPane(editorArea);
        editorScroll.setRowHeaderView(lineNumbersArea);
        editorScroll.setBorder(BorderFactory.createEmptyBorder());

        editorArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { updateLineNumbers(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { updateLineNumbers(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { updateLineNumbers(); }
        });
        editorArea.addCaretListener(e -> updateLineNumbers());
        updateLineNumbers();

        JScrollPane consoleScroll = new JScrollPane(consoleArea);
        consoleScroll.setBorder(BorderFactory.createTitledBorder("Consola de Salida"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, editorScroll, consoleScroll);
        splitPane.setResizeWeight(0.7);
        splitPane.setDividerLocation(500);
        splitPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(splitPane, BorderLayout.CENTER);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        return panel;
    }

    private void updateLineNumbers() {
        String text = editorArea.getText();
        int lines = text.split("\n", -1).length;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= lines; i++) sb.append(i).append("\n");
        lineNumbersArea.setText(sb.toString());
        JScrollPane scrollPane = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, editorArea);
        if (scrollPane != null) {
            JViewport rowHeader = scrollPane.getRowHeader();
            if (rowHeader != null) rowHeader.setViewPosition(scrollPane.getViewport().getViewPosition());
        }
    }

    private JToolBar createToolBar() {
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        toolbar.setRollover(true);
        toolbar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JButton openBtn = new JButton("  Abrir");
        openBtn.addActionListener(e -> cargarArchivo());
        JButton saveBtn = new JButton("  Guardar");
        saveBtn.addActionListener(e -> guardarArchivo());
        JButton runBtn = new JButton("  Ejecutar");
        runBtn.addActionListener(e -> ejecutarCompilacion());
        JButton clearBtn = new JButton("  Limpiar consola");
        clearBtn.addActionListener(e -> consoleArea.setText(""));
        JButton exportBtn = new JButton("  Exportar a...");
        exportBtn.addActionListener(e -> mostrarMenuExportar(exportBtn));

        toolbar.add(openBtn);
        toolbar.add(saveBtn);
        toolbar.add(Box.createHorizontalStrut(10));
        toolbar.add(runBtn);
        toolbar.add(Box.createHorizontalStrut(10));
        toolbar.add(clearBtn);
        toolbar.add(Box.createHorizontalStrut(10));
        toolbar.add(exportBtn);
        toolbar.add(Box.createHorizontalGlue());
        return toolbar;
    }

    private void mostrarMenuExportar(Component anchor) {
        String[] lenguajes = {"Python", "JavaScript", "TypeScript", "C", "Cpp", "Assembly"};
        JPopupMenu popup = new JPopupMenu();
        for (String lang : lenguajes) {
            JMenuItem item = new JMenuItem(lang);
            item.addActionListener(e -> ejecutarTraduccion(lang));
            popup.add(item);
        }
        popup.show(anchor, 0, anchor.getHeight());
    }

    private JMenuBar createMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem openItem = new JMenuItem("Abrir", KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        openItem.addActionListener(e -> cargarArchivo());
        JMenuItem saveItem = new JMenuItem("Guardar", KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        saveItem.addActionListener(e -> guardarArchivo());
        JMenuItem exitItem = new JMenuItem("Salir");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        bar.add(fileMenu);
        return bar;
    }

    private JLabel createStatusBar() {
        JLabel label = new JLabel("Listo");
        label.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        label.setFont(new Font("SansSerif", Font.PLAIN, 11));
        return label;
    }

    private void updateStatusBarCursor() {
        try {
            int caretPos = editorArea.getCaretPosition();
            int line = editorArea.getLineOfOffset(caretPos);
            int col = caretPos - editorArea.getLineStartOffset(line);
            String fileName = (currentFilePath == null) ? "Sin archivo" : new File(currentFilePath).getName();
            statusLabel.setText("Archivo: " + fileName + "   Línea: " + (line + 1) + "   Columna: " + (col + 1));
        } catch (Exception e) {
            statusLabel.setText("Listo");
        }
    }

    private void setupKeyboardShortcuts() {
        InputMap im = editorArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = editorArea.getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK), "run");
        am.put("run", new AbstractAction() { public void actionPerformed(ActionEvent e) { ejecutarCompilacion(); } });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK), "export");
        am.put("export", new AbstractAction() { public void actionPerformed(ActionEvent e) {
            Component exportButton = ((JToolBar) getContentPane().getComponent(0)).getComponentAtIndex(7);
            if (exportButton instanceof JButton) mostrarMenuExportar(exportButton);
        } });
    }

    private void ejecutarCompilacion() {
        consoleArea.setText("");
        try {
            CharStream in = CharStreams.fromString(editorArea.getText());
            Director_cutLexer lexer = new Director_cutLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Director_cutParser parser = new Director_cutParser(tokens);
            Director_cutParser.ProgramContext tree = parser.program();

            System.out.println("--- EJECUTANDO PROGRAMA ---");
            DirectorCutVisitor visitor = new DirectorCutVisitor();
            visitor.visit(tree);
            System.out.println("Ejecución finalizada correctamente.");
        } catch (Exception ex) {
            System.err.println("Error sintáctico/semántico: " + ex.getMessage());
        }
        updateStatusBarCursor();
    }

    private void ejecutarTraduccion(String lenguaje) {
        try {
            CharStream in = CharStreams.fromString(editorArea.getText());
            Director_cutLexer lexer = new Director_cutLexer(in);
            Director_cutParser parser = new Director_cutParser(new CommonTokenStream(lexer));
            Director_cutParser.ProgramContext tree = parser.program();

            String codigo = "";
            switch (lenguaje) {
                case "Python": codigo = new PythonTranslatorVisitor().visit(tree); break;
                case "JavaScript": codigo = new JavaScriptTranslatorVisitor().visit(tree); break;
                case "TypeScript": codigo = new TypeScriptTranslatorVisitor().visit(tree); break;
                case "C": codigo = new CTranslatorVisitor().visit(tree); break;
                case "Cpp": codigo = new CppTranslatorVisitor().visit(tree); break;
                case "Assembly": codigo = new AssemblyX86TranslatorVisitor().visit(tree); break;
            }
            JFileChooser fc = new JFileChooser();
            fc.setSelectedFile(new File("salida." + lenguaje.toLowerCase()));
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (FileWriter fw = new FileWriter(fc.getSelectedFile())) {
                    fw.write(codigo);
                    JOptionPane.showMessageDialog(this, "Exportado a " + lenguaje + " con éxito.");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al traducir: " + ex.getMessage());
        }
    }

    private void cargarArchivo() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                editorArea.read(br, null);
                currentFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                setTitle("Editor y Traductor de Películas - " + fileChooser.getSelectedFile().getName());
                updateLineNumbers();
                updateStatusBarCursor();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al abrir: " + ex.getMessage());
            }
        }
    }

    private void guardarArchivo() {
        if (currentFilePath == null) {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                currentFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                setTitle("Editor y Traductor de Películas - " + fileChooser.getSelectedFile().getName());
            } else return;
        }
        try (FileWriter fw = new FileWriter(currentFilePath)) {
            editorArea.write(fw);
            JOptionPane.showMessageDialog(this, "Archivo guardado correctamente.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
}