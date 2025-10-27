package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import model.Setting;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Notepad extends javax.swing.JFrame {

    private Setting setting = null;
    private final RSyntaxTextArea textArea;
    private final RTextScrollPane scrollPane;
    private File fileOpened;
    private final JFileChooser fileChooser = new JFileChooser();

    public Notepad() {
        initComponents();
        setting = new Setting();
        textArea = new RSyntaxTextArea(20, 60);
        textArea.setCodeFoldingEnabled(true);
        scrollPane = new RTextScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);
        setTheme(setting);
        setSyntax();

        setFileFilters();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JPanel();
        menubar = new javax.swing.JMenuBar();
        file_menu = new javax.swing.JMenu();
        newFile_jmi = new javax.swing.JMenuItem();
        openFile_jmi = new javax.swing.JMenuItem();
        saveFile_jmi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(850, 530));
        setPreferredSize(new java.awt.Dimension(850, 530));

        toolbar.setBackground(new java.awt.Color(204, 204, 204));
        toolbar.setMinimumSize(new java.awt.Dimension(808, 45));
        toolbar.setPreferredSize(new java.awt.Dimension(808, 45));

        javax.swing.GroupLayout toolbarLayout = new javax.swing.GroupLayout(toolbar);
        toolbar.setLayout(toolbarLayout);
        toolbarLayout.setHorizontalGroup(
            toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        toolbarLayout.setVerticalGroup(
            toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        getContentPane().add(toolbar, java.awt.BorderLayout.PAGE_START);

        file_menu.setText("File");

        newFile_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newFile_jmi.setText("New File");
        newFile_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFile_jmiActionPerformed(evt);
            }
        });
        file_menu.add(newFile_jmi);

        openFile_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openFile_jmi.setText("Open File");
        openFile_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFile_jmiActionPerformed(evt);
            }
        });
        file_menu.add(openFile_jmi);

        saveFile_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveFile_jmi.setText("Save");
        saveFile_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFile_jmiActionPerformed(evt);
            }
        });
        file_menu.add(saveFile_jmi);

        menubar.add(file_menu);

        setJMenuBar(menubar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFile_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFile_jmiActionPerformed

    }//GEN-LAST:event_newFile_jmiActionPerformed

    private void openFile_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFile_jmiActionPerformed
        textArea.setText("");
        fileChooser.setDialogTitle("Open File");
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.append(line + '\n');
                }
                if (textArea.getText().endsWith("\n")) {
                    textArea.setText(textArea.getText().substring(0, textArea.getText().lastIndexOf("\n")));
                }
                fileOpened = fileChooser.getSelectedFile();
                this.setTitle(fileOpened.getName() + " - Snip");
                setSyntax();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Unexpected Error while opening the file!" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_openFile_jmiActionPerformed

    private void saveFile_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFile_jmiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveFile_jmiActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println("Error al Cargar UI!");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Notepad snip = new Notepad();
            snip.setLocationRelativeTo(null);
            snip.setVisible(true);
        });
    }

    private void setTheme(Setting setting) {
        if (setting.isDarkTheme()) {

        } else {
            textArea.setBackground(Color.decode("#FFFFFF"));
            textArea.setForeground(Color.decode("#2B2B2B"));
            textArea.setCaretColor(Color.BLACK);
            textArea.setSelectionColor(Color.decode("#BEFBFE"));
            textArea.setCurrentLineHighlightColor(Color.decode("#F0F4F4"));
        }
    }

    private String getFileExtension() {
        if (fileOpened == null) {
            return "";
        } else {
            int lastDot = fileOpened.getName().lastIndexOf(".");
            return ((lastDot != -1) ? fileOpened.getName().substring(lastDot + 1) : "");
        }
    }

    private void setFileFilters() {
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text Files (*.txt)", "txt");
        FileNameExtensionFilter cFilter = new FileNameExtensionFilter("C, C++, C# Files (*.c, *.cpp, *.cs)", "c", "cpp", "cs");
        FileNameExtensionFilter webFilter = new FileNameExtensionFilter("Web Files (HTML, CSS, JavaScript)", "html", "css", "js");
        FileNameExtensionFilter pyFilter = new FileNameExtensionFilter("Python Files (*.py)", "py");
        FileNameExtensionFilter javaFilter = new FileNameExtensionFilter("Java Files (*.java)", "java");
        FileNameExtensionFilter phpFilter = new FileNameExtensionFilter("PHP Files (*.php)", "php");
        FileNameExtensionFilter jsonFilter = new FileNameExtensionFilter("JSON Files (*.json)", "json");
        FileNameExtensionFilter mdFilter = new FileNameExtensionFilter("Markdown Files (*.md)", "md");
        FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("CSV (*.csv)", "csv");

        FileNameExtensionFilter[] filters = {txtFilter, cFilter, webFilter, pyFilter, javaFilter, phpFilter, jsonFilter, mdFilter, csvFilter};
        for (FileNameExtensionFilter filter : filters) {
            fileChooser.addChoosableFileFilter(filter);
        }
    }

    private void setSyntax() {
        String fileType = getFileExtension();

        switch (fileType) {
            case "java" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
            case "py" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
            case "c" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
            case "cpp" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
            case "cs" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);
            case "html" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
            case "css" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSS);
            case "js" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
            case "php" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PHP);
            case "json" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
            case "csv" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSV);
            case "md" ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_MARKDOWN);
            default ->
                textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu file_menu;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem newFile_jmi;
    private javax.swing.JMenuItem openFile_jmi;
    private javax.swing.JMenuItem saveFile_jmi;
    private javax.swing.JPanel toolbar;
    // End of variables declaration//GEN-END:variables
}
