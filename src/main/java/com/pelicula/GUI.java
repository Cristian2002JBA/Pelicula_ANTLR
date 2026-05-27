package com.pelicula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.BoxLayout;
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
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.formdev.flatlaf.FlatDarculaLaf;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.pelicula.translators.AssemblyX86TranslatorVisitor;
import com.pelicula.translators.CTranslatorVisitor;
import com.pelicula.translators.CppTranslatorVisitor;
import com.pelicula.translators.JavaScriptTranslatorVisitor;
import com.pelicula.translators.PythonTranslatorVisitor;
import com.pelicula.translators.ReverseTranslator;
import com.pelicula.translators.TypeScriptTranslatorVisitor;

public class GUI extends JFrame {

    // ── Visual Studio Blue Palette ──
    static final Color BG_DARK         = new Color(30, 30, 30);
    static final Color BG_EDITOR       = new Color(30, 30, 30);
    static final Color BG_SIDEBAR      = new Color(51, 51, 51);
    static final Color BG_TOOLBAR      = new Color(37, 37, 38);
    static final Color BG_CONSOLE      = new Color(24, 24, 24);
    static final Color ACCENT_PRIMARY  = new Color(0, 122, 204);     // VS Code Blue
    static final Color ACCENT_HOVER    = new Color(28, 151, 234);    // Lighter Blue
    static final Color ACCENT_SUCCESS  = new Color(78, 201, 176);    // Teal Green
    static final Color ACCENT_RUN      = new Color(22, 163, 74);     // Green for Run
    static final Color TEXT_PRIMARY     = new Color(212, 212, 212);
    static final Color TEXT_SECONDARY   = new Color(150, 150, 150);
    static final Color TEXT_MUTED       = new Color(100, 100, 100);
    static final Color BORDER_COLOR     = new Color(60, 60, 60);
    static final Color BTN_BG          = new Color(14, 99, 156);     // Button blue
    static final Color BTN_HOVER       = new Color(17, 119, 187);    // Button hover

    RSyntaxTextArea editorArea;
    JTextArea consoleArea;
    JLabel statusLabel;
    String currentFilePath = null;
    JFileChooser fileChooser;
    GhostTextCompleter ghostCompleter;

    public GUI() {
        // Configuramos el tema oscuro y los estilos de la interfaz al arrancar
        initLookAndFeel();
        setTitle("\uD83C\uDFAC Director's Cut IDE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 850);
        setLocationRelativeTo(null); // Centramos la ventana en pantalla
        getContentPane().setBackground(BG_DARK);
        fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(true);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            private final java.util.Set<String> SUPPORTED = new java.util.HashSet<>(
                java.util.Arrays.asList("movie", "py", "js", "ts", "c", "cpp", "asm"));
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) return true;
                String name = f.getName();
                int lastDot = name.lastIndexOf('.');
                if (lastDot == -1) return true; // sin extensión
                String ext = name.substring(lastDot + 1).toLowerCase();
                return SUPPORTED.contains(ext);
            }

            @Override
            public String getDescription() {
                return "Archivos Película y otros lenguajes (*.movie, *.py, *.js, *.ts, *.c, *.cpp, *.asm)";
            }
        });

        createEditor();
        createConsole();
        JPanel centerPanel = createSplitPane();
        JPanel headerPanel = createHeader();
        JMenuBar menuBar = createMenuBar();
        statusLabel = createStatusBar();

        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
        setJMenuBar(menuBar);

        setupKeyboardShortcuts();
        editorArea.addCaretListener(e -> updateStatusBarCursor());
        updateStatusBarCursor();
    }

    private void initLookAndFeel() {
        FlatDarculaLaf.setup();
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Component.focusColor", ACCENT_PRIMARY);
        UIManager.put("Button.arc", 20);
        UIManager.put("TextComponent.arc", 8);
        UIManager.put("ScrollBar.width", 10);
        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("ScrollBar.thumbInsets", new Insets(2,2,2,2));
        UIManager.put("TitlePane.unifiedBackground", true);
    }

    private void createEditor() {
        editorArea = new RSyntaxTextArea(20, 60) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (ghostCompleter != null) {
                    ghostCompleter.paintGhost(g);
                }
            }
        };
        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/pelicula", "com.pelicula.PeliculaTokenMaker");
        editorArea.setSyntaxEditingStyle("text/pelicula");
        editorArea.setCodeFoldingEnabled(true);
        editorArea.setTabSize(4);
        editorArea.setTabsEmulated(false);
        editorArea.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
        editorArea.setCurrentLineHighlightColor(new Color(40, 40, 50));
        editorArea.setFadeCurrentLineHighlight(true);
        editorArea.setRoundedSelectionEdges(true);
        editorArea.setSelectionColor(new Color(ACCENT_PRIMARY.getRed(), ACCENT_PRIMARY.getGreen(), ACCENT_PRIMARY.getBlue(), 70));
        editorArea.setMarginLineEnabled(false);
        editorArea.setAntiAliasingEnabled(true);
        editorArea.setBackground(BG_EDITOR);
        editorArea.setForeground(TEXT_PRIMARY);
        editorArea.setCaretColor(Color.WHITE);

        try {
            Theme theme = Theme.load(getClass().getResourceAsStream("/org/fife/ui/rsyntaxtextarea/themes/monokai.xml"));
            theme.apply(editorArea);
            // Override after theme application
            editorArea.setBackground(BG_EDITOR);
            editorArea.setCurrentLineHighlightColor(new Color(40, 40, 50));
            editorArea.setSelectionColor(new Color(ACCENT_PRIMARY.getRed(), ACCENT_PRIMARY.getGreen(), ACCENT_PRIMARY.getBlue(), 70));
            editorArea.setCaretColor(Color.WHITE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ghost text inline autocomplete
        ghostCompleter = new GhostTextCompleter(editorArea);
    }

    private void createConsole() {
        consoleArea = new JTextArea();
        consoleArea.setEditable(false);
        consoleArea.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        consoleArea.setBackground(BG_CONSOLE);
        consoleArea.setForeground(ACCENT_SUCCESS);
        consoleArea.setCaretColor(ACCENT_SUCCESS);
        consoleArea.setMargin(new Insets(10, 12, 10, 12));
        PrintStream ps = new PrintStream(new TextAreaOutputStream(consoleArea));
        System.setOut(ps);
        System.setErr(ps);
    }

    // ── Header with VS Blue Gradient ──
    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 78, 146), getWidth(), 0, ACCENT_PRIMARY);
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        header.setPreferredSize(new Dimension(0, 52));

        JLabel titleLabel = new JLabel("  \uD83C\uDFAC  Director's Cut IDE");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        header.add(titleLabel, BorderLayout.WEST);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
        btnPanel.setOpaque(false);

        btnPanel.add(createPillButton("\u2795  Nuevo", e -> nuevoArchivo(), BTN_BG, BTN_HOVER));
        btnPanel.add(createPillButton("\uD83D\uDCC2  Abrir", e -> cargarArchivo(), BTN_BG, BTN_HOVER));
        btnPanel.add(createPillButton("\uD83D\uDCBE  Guardar", e -> guardarArchivo(), BTN_BG, BTN_HOVER));
        btnPanel.add(createPillButton("\uD83C\uDFAC  ← .movie", e -> importarAMovie(), new Color(80, 40, 120), new Color(110, 60, 160)));
        btnPanel.add(createPillButton("\u25B6  Ejecutar", e -> ejecutarCompilacion(), ACCENT_RUN, new Color(34, 197, 94)));
        btnPanel.add(createPillButton("\uD83D\uDDD1  Limpiar", e -> consoleArea.setText(""), BTN_BG, BTN_HOVER));
        btnPanel.add(createPillButton("\uD83D\uDCE4  Exportar", e -> {
            mostrarMenuExportar(btnPanel.getComponent(btnPanel.getComponentCount()-1));
        }, BTN_BG, BTN_HOVER));

        header.add(btnPanel, BorderLayout.EAST);
        return header;
    }

    // ── Google-style pill/rounded buttons ──
    private JButton createPillButton(String text, java.awt.event.ActionListener action, Color normalBg, Color hoverBg) {
        JButton btn = new JButton(text) {
            private boolean hovering = false;
            {
                addMouseListener(new MouseAdapter() {
                    @Override public void mouseEntered(MouseEvent e) { hovering = true; repaint(); }
                    @Override public void mouseExited(MouseEvent e) { hovering = false; repaint(); }
                });
            }
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color bg = hovering ? hoverBg : normalBg;
                g2.setColor(bg);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 24, 24);
                super.paintComponent(g);
            }
        };
        btn.setFont(new Font("SansSerif", Font.BOLD, 12));
        btn.setForeground(Color.WHITE);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setMargin(new Insets(7, 18, 7, 18));
        btn.addActionListener(action);
        return btn;
    }

    private JPanel createSplitPane() {
        RTextScrollPane editorScroll = new RTextScrollPane(editorArea);
        editorScroll.setLineNumbersEnabled(true);
        editorScroll.getGutter().setBackground(BG_EDITOR);
        editorScroll.getGutter().setBorderColor(BORDER_COLOR);
        editorScroll.getGutter().setLineNumberColor(TEXT_MUTED);
        editorScroll.getGutter().setLineNumberFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        editorScroll.setBorder(BorderFactory.createEmptyBorder());

        // Console panel with header
        JPanel consolePanel = new JPanel(new BorderLayout());
        consolePanel.setBackground(BG_CONSOLE);
        JLabel consoleTitle = new JLabel("   \u25B8 TERMINAL");
        consoleTitle.setFont(new Font("SansSerif", Font.BOLD, 11));
        consoleTitle.setForeground(TEXT_SECONDARY);
        consoleTitle.setPreferredSize(new Dimension(0, 28));
        consoleTitle.setBackground(new Color(37, 37, 38));
        consoleTitle.setOpaque(true);
        consoleTitle.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, BORDER_COLOR));
        consolePanel.add(consoleTitle, BorderLayout.NORTH);

        JScrollPane consoleScroll = new JScrollPane(consoleArea);
        consoleScroll.setBorder(BorderFactory.createEmptyBorder());
        consolePanel.add(consoleScroll, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, editorScroll, consolePanel);
        splitPane.setResizeWeight(0.72);
        splitPane.setDividerLocation(520);
        splitPane.setDividerSize(4);
        splitPane.setBorder(BorderFactory.createEmptyBorder());
        splitPane.setBackground(BORDER_COLOR);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_DARK);

        // Activity Bar (left sidebar)
        JPanel activityBar = new JPanel();
        activityBar.setLayout(new BoxLayout(activityBar, BoxLayout.Y_AXIS));
        activityBar.setBackground(BG_SIDEBAR);
        activityBar.setPreferredSize(new Dimension(48, 0));
        activityBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, BORDER_COLOR));

        activityBar.add(Box.createVerticalStrut(12));
        activityBar.add(createSidebarIcon("\uD83D\uDCC4", "Archivos"));
        activityBar.add(Box.createVerticalStrut(6));
        activityBar.add(createSidebarIcon("\u25B6", "Ejecutar"));
        activityBar.add(Box.createVerticalStrut(6));
        activityBar.add(createSidebarIcon("\uD83D\uDD0D", "Buscar"));
        activityBar.add(Box.createVerticalGlue());
        activityBar.add(createSidebarIcon("\u2699", "Configuración"));
        activityBar.add(Box.createVerticalStrut(12));

        panel.add(activityBar, BorderLayout.WEST);
        panel.add(splitPane, BorderLayout.CENTER);
        panel.setBorder(new EmptyBorder(0, 0, 0, 0));
        return panel;
    }

    private JLabel createSidebarIcon(String icon, String tooltip) {
        JLabel label = new JLabel(icon, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 20));
        label.setForeground(TEXT_MUTED);
        label.setToolTipText(tooltip);
        label.setMaximumSize(new Dimension(48, 40));
        label.setPreferredSize(new Dimension(48, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { label.setForeground(ACCENT_PRIMARY); }
            @Override public void mouseExited(MouseEvent e) { label.setForeground(TEXT_MUTED); }
        });
        return label;
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
        bar.setBackground(BG_TOOLBAR);
        bar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_COLOR));

        JMenu fileMenu = new JMenu("Archivo");
        fileMenu.setForeground(TEXT_SECONDARY);
        JMenuItem newItem = new JMenuItem("Nuevo", KeyEvent.VK_N);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        newItem.addActionListener(e -> nuevoArchivo());
        JMenuItem openItem = new JMenuItem("Abrir", KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        openItem.addActionListener(e -> cargarArchivo());
        JMenuItem saveItem = new JMenuItem("Guardar", KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        saveItem.addActionListener(e -> guardarArchivo());
        JMenuItem exitItem = new JMenuItem("Salir");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        bar.add(fileMenu);

        JMenu runMenu = new JMenu("Ejecutar");
        runMenu.setForeground(TEXT_SECONDARY);
        JMenuItem runItem = new JMenuItem("Compilar y Ejecutar");
        runItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
        runItem.addActionListener(e -> ejecutarCompilacion());
        runMenu.add(runItem);
        bar.add(runMenu);

        JMenu exportMenu = new JMenu("Exportar");
        exportMenu.setForeground(TEXT_SECONDARY);
        String[] lenguajes = {"Python", "JavaScript", "TypeScript", "C", "C++", "Assembly"};
        for (String lang : lenguajes) {
            JMenuItem item = new JMenuItem("Traducir a " + lang);
            item.addActionListener(e -> ejecutarTraduccion(lang.equals("C++") ? "Cpp" : lang));
            exportMenu.add(item);
        }
        exportMenu.addSeparator();
        JMenuItem importItem = new JMenuItem("\uD83C\uDFAC Importar a Película (.movie)");
        importItem.addActionListener(e -> importarAMovie());
        exportMenu.add(importItem);
        bar.add(exportMenu);

        return bar;
    }

    private JLabel createStatusBar() {
        JLabel label = new JLabel("  \u25CF  Listo");
        label.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, BORDER_COLOR),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        label.setFont(new Font("SansSerif", Font.PLAIN, 11));
        label.setForeground(Color.WHITE);
        label.setBackground(ACCENT_PRIMARY);
        label.setOpaque(true);
        return label;
    }

    private void updateStatusBarCursor() {
        try {
            int caretPos = editorArea.getCaretPosition();
            int line = editorArea.getLineOfOffset(caretPos);
            int col = caretPos - editorArea.getLineStartOffset(line);
            String fileName = (currentFilePath == null) ? "Sin archivo" : new File(currentFilePath).getName();
            statusLabel.setText("  \u25CF  " + fileName + "        Ln " + (line + 1) + ", Col " + (col + 1) + "        Director's Cut  \u2022  UTF-8");
        } catch (Exception e) {
            statusLabel.setText("  \u25CF  Listo");
        }
    }

    private void setupKeyboardShortcuts() {
        InputMap im = editorArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = editorArea.getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK), "run");
        am.put("run", new AbstractAction() { public void actionPerformed(ActionEvent e) { ejecutarCompilacion(); } });
    }

    // Lanza la evaluación del código escrito en el editor
    private void ejecutarCompilacion() {
        // Limpiamos la consola para no mezclar ejecuciones anteriores
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
            String ext = "";
            switch (lenguaje) {
                case "Python": codigo = new PythonTranslatorVisitor().visit(tree); ext = "py"; break;
                case "JavaScript": codigo = new JavaScriptTranslatorVisitor().visit(tree); ext = "js"; break;
                case "TypeScript": codigo = new TypeScriptTranslatorVisitor().visit(tree); ext = "ts"; break;
                case "C": codigo = new CTranslatorVisitor().visit(tree); ext = "c"; break;
                case "Cpp": codigo = new CppTranslatorVisitor().visit(tree); ext = "cpp"; break;
                case "Assembly": codigo = new AssemblyX86TranslatorVisitor().visit(tree); ext = "asm"; break;
            }
            String baseName = "salida";
            if (currentFilePath != null) {
                String name = new File(currentFilePath).getName();
                int dotIndex = name.lastIndexOf('.');
                baseName = (dotIndex > 0) ? name.substring(0, dotIndex) : name;
            }
            JFileChooser fc = new JFileChooser();
            fc.setSelectedFile(new File(baseName + "." + ext));
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

    private void nuevoArchivo() {
        if (!editorArea.getText().trim().isEmpty() && currentFilePath == null) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Deseas guardar los cambios antes de crear un nuevo archivo?", "Nuevo Archivo", JOptionPane.YES_NO_CANCEL_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                guardarArchivo();
            } else if (confirm == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        editorArea.setText("");
        consoleArea.setText("");
        currentFilePath = null;
        setTitle("\uD83C\uDFAC Director's Cut IDE - Nuevo Archivo");
        updateStatusBarCursor();
    }

    private void cargarArchivo() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                editorArea.read(br, null);
                currentFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                setTitle("\uD83C\uDFAC Director's Cut IDE - " + fileChooser.getSelectedFile().getName());
                updateStatusBarCursor();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al abrir: " + ex.getMessage());
            }
        }
    }

    private void guardarArchivo() {
        if (currentFilePath == null) {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selected = fileChooser.getSelectedFile();
                if (!selected.getName().contains(".")) {
                    selected = new File(selected.getParent(), selected.getName() + ".movie");
                }
                currentFilePath = selected.getAbsolutePath();
                setTitle("\uD83C\uDFAC Director's Cut IDE - " + selected.getName());
            } else return;
        }
        try (FileWriter fw = new FileWriter(currentFilePath)) {
            editorArea.write(fw);
            JOptionPane.showMessageDialog(this, "Archivo guardado correctamente.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
        }
    }

    private void importarAMovie() {
        // Detectar extensión del archivo actualmente abierto
        String ext = "";
        if (currentFilePath != null) {
            int dot = currentFilePath.lastIndexOf('.');
            if (dot >= 0) ext = currentFilePath.substring(dot + 1).toLowerCase();
        }

        // Si el archivo abierto no es de un lenguaje soportado, usar fileChooser
        java.util.Set<String> LANGS = new java.util.HashSet<>(
            java.util.Arrays.asList("py", "js", "ts", "c", "cpp", "asm"));

        File sourceFile = null;
        String sourceExt = ext;

        if (LANGS.contains(ext) && currentFilePath != null) {
            sourceFile = new File(currentFilePath);
        } else {
            // Si no estamos en un archivo soportado, le pedimos al usuario que elija el archivo original
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override public boolean accept(File f) {
                    if (f.isDirectory()) return true;
                    String n = f.getName().toLowerCase();
                    return n.endsWith(".py") || n.endsWith(".js") || n.endsWith(".ts")
                        || n.endsWith(".c") || n.endsWith(".cpp") || n.endsWith(".asm");
                }
                @Override public String getDescription() {
                    return "Lenguajes soportados (*.py, *.js, *.ts, *.c, *.cpp, *.asm)";
                }
            });
            if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return; // Si cancela, no hacemos nada
            sourceFile = fc.getSelectedFile();
            int dot = sourceFile.getName().lastIndexOf('.');
            sourceExt = (dot >= 0) ? sourceFile.getName().substring(dot + 1).toLowerCase() : "";
        }

        if (!LANGS.contains(sourceExt)) {
            JOptionPane.showMessageDialog(this, "Extensión no soportada para importar: ." + sourceExt);
            return;
        }

        try {
            // Leer el archivo fuente
            StringBuilder sb = new StringBuilder();
            try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(sourceFile))) {
                String line;
                while ((line = br.readLine()) != null) sb.append(line).append("\n");
            }

            // Traducir inversamente a Película
            String movieCode = ReverseTranslator.translate(sb.toString(), sourceExt);

            // Sugerir nombre del archivo de salida: mismoNombre.movie
            String baseName = sourceFile.getName();
            int dot = baseName.lastIndexOf('.');
            String outName = (dot > 0 ? baseName.substring(0, dot) : baseName) + ".movie";

            JFileChooser saveFc = new JFileChooser();
            saveFc.setCurrentDirectory(sourceFile.getParentFile());
            saveFc.setSelectedFile(new File(sourceFile.getParentFile(), outName));
            if (saveFc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

            File outFile = saveFc.getSelectedFile();
            if (!outFile.getName().contains(".")) {
                outFile = new File(outFile.getParent(), outFile.getName() + ".movie");
            }
            try (FileWriter fw = new FileWriter(outFile)) {
                fw.write(movieCode);
            }

            // Abrir el resultado en el editor
            editorArea.setText(movieCode);
            currentFilePath = outFile.getAbsolutePath();
            setTitle("\uD83C\uDFAC Director's Cut IDE - " + outFile.getName());
            JOptionPane.showMessageDialog(this,
                "Importado y guardado como " + outFile.getName() + " correctamente.\n" +
                "Revisa el c\u00f3digo generado antes de ejecutar.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al importar: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
}