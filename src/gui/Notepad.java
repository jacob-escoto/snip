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
        saveAs_jmi = new javax.swing.JMenuItem();

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

        saveAs_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveAs_jmi.setText("Save As");
        saveAs_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAs_jmiActionPerformed(evt);
            }
        });
        file_menu.add(saveAs_jmi);

        menubar.add(file_menu);

        setJMenuBar(menubar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFile_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFile_jmiActionPerformed
        if (textArea.getText().length() != 0 && fileOpened == null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Do you want to save the file?", "Save File", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                saveFile_jmiActionPerformed(evt);
                if (fileOpened == null) {
                    return;
                }
            } else if (confirm == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }

        textArea.setText("");
        fileOpened = null;
        this.setTitle("Untitled - Snip");
        setSyntax();
    }//GEN-LAST:event_newFile_jmiActionPerformed

    private void openFile_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFile_jmiActionPerformed
        textArea.setText("");
        fileChooser.setDialogTitle("Open File");
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile(), StandardCharsets.UTF_8))) {
                String content = "";
                String line;
                while ((line = br.readLine()) != null) {
                    content += line + '\n';
                }
                if (content.endsWith("\n")) {
                    content = content.substring(0, content.length() - 1);
                }
                textArea.setText(content);
                textArea.setCaretPosition(0);

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
        if (fileOpened == null) {
            saveAs_jmiActionPerformed(evt);
            return;
        }
        try {
            String content = textArea.getText();
            java.nio.file.Files.write(fileOpened.toPath(), content.getBytes(StandardCharsets.UTF_8));
            this.setTitle(fileOpened.getName() + " - Snip");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveFile_jmiActionPerformed

    private void saveAs_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAs_jmiActionPerformed
        fileChooser.setDialogTitle("Save File");

        if (fileOpened != null) {
            fileChooser.setSelectedFile(fileOpened);
        } else {
            fileChooser.setSelectedFile(new File("Untitled.txt"));
        }
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            if (!fileToSave.getName().contains(".")) {
                fileToSave = new File(fileToSave.getParent(), fileToSave.getName() + ".txt");
            }
            if (fileToSave.exists()) {
                int confirm = JOptionPane.showConfirmDialog(this,
                        "File already exists. Do you want to overwrite it?",
                        "Confirm Overwrite",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            try {
                String content = textArea.getText();
                java.nio.file.Files.write(fileToSave.toPath(), content.getBytes(StandardCharsets.UTF_8));
                fileOpened = fileToSave;
                this.setTitle(fileOpened.getName() + " - Snip");
                setSyntax();
                JOptionPane.showMessageDialog(this, "File saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveAs_jmiActionPerformed

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
    private javax.swing.JMenuItem saveAs_jmi;
    private javax.swing.JMenuItem saveFile_jmi;
    private javax.swing.JPanel toolbar;
    // End of variables declaration//GEN-END:variables
}
