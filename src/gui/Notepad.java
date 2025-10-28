package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.undo.UndoManager;
import model.Setting;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Notepad extends javax.swing.JFrame {

    private Point mouse;
    private Setting setting;
    private final RSyntaxTextArea textArea;
    private final RTextScrollPane scrollPane;
    private File fileOpened;
    private JFileChooser fileChooser;
    private final UndoManager undoManager = new UndoManager();

    public Notepad() {
        setting = Setting.loadFromFile();
        try {
            if (setting.isDarkTheme()) {
                javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
            } else {
                javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println("Error al cargar tema inicial: " + ex.getMessage());
        }
        initComponents();
        fileChooser = new JFileChooser();

        if (setting.isDarkTheme()) {
            dark_jrb.setSelected(true);
        } else {
            light_jrb.setSelected(true);
        }

        textArea = new RSyntaxTextArea(20, 60);
        textArea.setCodeFoldingEnabled(true);
        textArea.getDocument().addUndoableEditListener(undoManager);
        scrollPane = new RTextScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setLineNumbersEnabled(setting.getShowLineNumbers());
        checkbox_lineNumbers.setSelected(setting.getShowLineNumbers());

        toolbar.setVisible(setting.getShowToolbar());
        checkbox_toolbar.setSelected(setting.getShowToolbar());
        setSyntax();
        setFileFilters();
        setTheme();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settings_jd = new javax.swing.JDialog();
        settings_panel = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exitSettings_btn = new javax.swing.JLabel();
        dialogTitle = new javax.swing.JLabel();
        editorSettingsTitle = new javax.swing.JLabel();
        editor_separator = new javax.swing.JSeparator();
        checkbox_lineNumbers = new javax.swing.JCheckBox();
        displaySettingsTitle = new javax.swing.JLabel();
        display_separator = new javax.swing.JSeparator();
        light_jrb = new javax.swing.JRadioButton();
        dark_jrb = new javax.swing.JRadioButton();
        checkbox_toolbar = new javax.swing.JCheckBox();
        toolbar = new javax.swing.JPanel();
        startSpace = new javax.swing.JLabel();
        undo_btn = new javax.swing.JButton();
        margin3 = new javax.swing.JLabel();
        redo_btn = new javax.swing.JButton();
        margin2 = new javax.swing.JLabel();
        capture_btn = new javax.swing.JLabel();
        margin1 = new javax.swing.JLabel();
        settings_btn = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();
        file_menu = new javax.swing.JMenu();
        newFile_jmi = new javax.swing.JMenuItem();
        openFile_jmi = new javax.swing.JMenuItem();
        saveFile_jmi = new javax.swing.JMenuItem();
        saveAs_jmi = new javax.swing.JMenuItem();
        exit_jmi = new javax.swing.JMenuItem();
        edit_menu = new javax.swing.JMenu();
        undo_jmi = new javax.swing.JMenuItem();
        redo_jmi = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        copy_jmi = new javax.swing.JMenuItem();
        paste_jmi = new javax.swing.JMenuItem();
        cut_jmi = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        selectAll_jmi = new javax.swing.JMenuItem();
        help_menu = new javax.swing.JMenu();
        settings_jmi = new javax.swing.JMenuItem();

        settings_jd.setMinimumSize(new java.awt.Dimension(391, 459));
        settings_jd.setModal(true);
        settings_jd.setUndecorated(true);
        settings_jd.setResizable(false);

        settings_panel.setBackground(new java.awt.Color(195, 202, 190));
        settings_panel.setMaximumSize(new java.awt.Dimension(391, 459));
        settings_panel.setMinimumSize(new java.awt.Dimension(391, 459));
        settings_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(195, 202, 190));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                headerMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        settings_panel.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 300, 20));

        exitSettings_btn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        exitSettings_btn.setForeground(new java.awt.Color(0, 0, 0));
        exitSettings_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitSettings_btn.setText("X");
        exitSettings_btn.setToolTipText("Close");
        exitSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitSettings_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitSettings_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitSettings_btnMouseExited(evt);
            }
        });
        settings_panel.add(exitSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 22, 25));

        dialogTitle.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        dialogTitle.setForeground(new java.awt.Color(0, 0, 0));
        dialogTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dialogTitle.setText("Settings");
        dialogTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        settings_panel.add(dialogTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 20));

        editorSettingsTitle.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        editorSettingsTitle.setForeground(new java.awt.Color(102, 102, 102));
        editorSettingsTitle.setText("EDITOR");
        settings_panel.add(editorSettingsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        editor_separator.setForeground(new java.awt.Color(102, 102, 102));
        settings_panel.add(editor_separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 330, 10));

        checkbox_lineNumbers.setForeground(new java.awt.Color(0, 0, 0));
        checkbox_lineNumbers.setText("Show Line Numbers");
        checkbox_lineNumbers.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ui/toggle-off.png"))); // NOI18N
        checkbox_lineNumbers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ui/toggle-off.png"))); // NOI18N
        checkbox_lineNumbers.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ui/toggle-on.png"))); // NOI18N
        checkbox_lineNumbers.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkbox_lineNumbersStateChanged(evt);
            }
        });
        settings_panel.add(checkbox_lineNumbers, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        displaySettingsTitle.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        displaySettingsTitle.setForeground(new java.awt.Color(102, 102, 102));
        displaySettingsTitle.setText("DISPLAY");
        settings_panel.add(displaySettingsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        display_separator.setForeground(new java.awt.Color(102, 102, 102));
        settings_panel.add(display_separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 330, 10));

        light_jrb.setForeground(new java.awt.Color(0, 0, 0));
        light_jrb.setText("Light Theme");
        light_jrb.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                light_jrbStateChanged(evt);
            }
        });
        settings_panel.add(light_jrb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        dark_jrb.setForeground(new java.awt.Color(0, 0, 0));
        dark_jrb.setText("Dark Theme");
        dark_jrb.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dark_jrbStateChanged(evt);
            }
        });
        settings_panel.add(dark_jrb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        checkbox_toolbar.setForeground(new java.awt.Color(0, 0, 0));
        checkbox_toolbar.setText("Toggle Toolbar");
        checkbox_toolbar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ui/toggle-off.png"))); // NOI18N
        checkbox_toolbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ui/toggle-off.png"))); // NOI18N
        checkbox_toolbar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ui/toggle-on.png"))); // NOI18N
        checkbox_toolbar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkbox_toolbarStateChanged(evt);
            }
        });
        settings_panel.add(checkbox_toolbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        javax.swing.GroupLayout settings_jdLayout = new javax.swing.GroupLayout(settings_jd.getContentPane());
        settings_jd.getContentPane().setLayout(settings_jdLayout);
        settings_jdLayout.setHorizontalGroup(
            settings_jdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settings_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );
        settings_jdLayout.setVerticalGroup(
            settings_jdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settings_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(890, 530));
        setPreferredSize(new java.awt.Dimension(890, 530));

        toolbar.setBackground(new java.awt.Color(51, 51, 51));
        toolbar.setMinimumSize(new java.awt.Dimension(808, 28));
        toolbar.setPreferredSize(new java.awt.Dimension(808, 28));
        toolbar.setLayout(new javax.swing.BoxLayout(toolbar, javax.swing.BoxLayout.X_AXIS));

        startSpace.setText("    ");
        toolbar.add(startSpace);

        undo_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dark/undo.png"))); // NOI18N
        undo_btn.setToolTipText("Undo");
        undo_btn.setBorderPainted(false);
        undo_btn.setContentAreaFilled(false);
        undo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undo_btnActionPerformed(evt);
            }
        });
        toolbar.add(undo_btn);

        margin3.setText("    ");
        toolbar.add(margin3);

        redo_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dark/redo.png"))); // NOI18N
        redo_btn.setToolTipText("Redo");
        redo_btn.setBorderPainted(false);
        redo_btn.setContentAreaFilled(false);
        redo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redo_btnActionPerformed(evt);
            }
        });
        toolbar.add(redo_btn);

        margin2.setText("    ");
        toolbar.add(margin2);

        capture_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dark/photo-capture.png"))); // NOI18N
        capture_btn.setToolTipText("Screenshot");
        capture_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                capture_btnMouseClicked(evt);
            }
        });
        toolbar.add(capture_btn);

        margin1.setText("    ");
        toolbar.add(margin1);

        settings_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dark/gears.png"))); // NOI18N
        settings_btn.setToolTipText("Settings");
        settings_btn.setBorderPainted(false);
        settings_btn.setContentAreaFilled(false);
        settings_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settings_btnActionPerformed(evt);
            }
        });
        toolbar.add(settings_btn);

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

        exit_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        exit_jmi.setText("Exit");
        exit_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_jmiActionPerformed(evt);
            }
        });
        file_menu.add(exit_jmi);

        menubar.add(file_menu);

        edit_menu.setText("Edit");

        undo_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        undo_jmi.setText("Undo");
        undo_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undo_jmiActionPerformed(evt);
            }
        });
        edit_menu.add(undo_jmi);

        redo_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        redo_jmi.setText("Redo");
        redo_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redo_jmiActionPerformed(evt);
            }
        });
        edit_menu.add(redo_jmi);
        edit_menu.add(jSeparator2);

        copy_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copy_jmi.setText("Copy");
        copy_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copy_jmiActionPerformed(evt);
            }
        });
        edit_menu.add(copy_jmi);

        paste_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        paste_jmi.setText("Paste");
        paste_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paste_jmiActionPerformed(evt);
            }
        });
        edit_menu.add(paste_jmi);

        cut_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cut_jmi.setText("Cut");
        cut_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cut_jmiActionPerformed(evt);
            }
        });
        edit_menu.add(cut_jmi);
        edit_menu.add(jSeparator1);

        selectAll_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        selectAll_jmi.setText("Select All");
        selectAll_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAll_jmiActionPerformed(evt);
            }
        });
        edit_menu.add(selectAll_jmi);

        menubar.add(edit_menu);

        help_menu.setText("Help");

        settings_jmi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_COMMA, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        settings_jmi.setText("Settings");
        settings_jmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settings_jmiActionPerformed(evt);
            }
        });
        help_menu.add(settings_jmi);

        menubar.add(help_menu);

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

    private void exitSettings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitSettings_btnMouseClicked
        settings_jd.dispose();
    }//GEN-LAST:event_exitSettings_btnMouseClicked

    private void exitSettings_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitSettings_btnMouseEntered
        exitSettings_btn.setOpaque(true);
        exitSettings_btn.setBackground(Color.decode("#FA3D3E"));
    }//GEN-LAST:event_exitSettings_btnMouseEntered

    private void exitSettings_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitSettings_btnMouseExited
        exitSettings_btn.setBackground(Color.decode("#C3CABE"));
    }//GEN-LAST:event_exitSettings_btnMouseExited

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        mouse = evt.getPoint();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        if (mouse == null) {
            return;
        }
        Point click = SwingUtilities.convertPoint(header, evt.getPoint(), settings_jd);
        int x = settings_jd.getX() + click.x - mouse.x;
        int y = settings_jd.getY() + click.y - mouse.y;
        this.settings_jd.setLocation(x, y);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseReleased
        mouse = null;
    }//GEN-LAST:event_headerMouseReleased

    private void light_jrbStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_light_jrbStateChanged
        if (light_jrb.isSelected() && dark_jrb.isSelected()) {
            dark_jrb.setSelected(false);
            setting.setIsDarkTheme(false);
            setTheme();
        } else if (!light_jrb.isSelected() && !dark_jrb.isSelected()) {
            light_jrb.setSelected(true);
            setting.setIsDarkTheme(false);
            setTheme();
        }
        setting.saveToFile();
    }//GEN-LAST:event_light_jrbStateChanged

    private void dark_jrbStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dark_jrbStateChanged
        if (light_jrb.isSelected() && dark_jrb.isSelected()) {
            light_jrb.setSelected(false);
            setting.setIsDarkTheme(true);
            setTheme();
        } else if (!light_jrb.isSelected() && !dark_jrb.isSelected()) {
            dark_jrb.setSelected(true);
            setting.setIsDarkTheme(true);
            setTheme();
        }
        setting.saveToFile();
    }//GEN-LAST:event_dark_jrbStateChanged

    private void copy_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copy_jmiActionPerformed
        textArea.copy();
    }//GEN-LAST:event_copy_jmiActionPerformed

    private void paste_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paste_jmiActionPerformed
        textArea.paste();
    }//GEN-LAST:event_paste_jmiActionPerformed

    private void cut_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cut_jmiActionPerformed
        textArea.cut();
    }//GEN-LAST:event_cut_jmiActionPerformed

    private void selectAll_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAll_jmiActionPerformed
        textArea.selectAll();
    }//GEN-LAST:event_selectAll_jmiActionPerformed

    private void undo_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undo_jmiActionPerformed
        if (undoManager.canUndo())
            undoManager.undo();
    }//GEN-LAST:event_undo_jmiActionPerformed

    private void redo_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redo_jmiActionPerformed
        if (undoManager.canRedo())
            undoManager.redo();
    }//GEN-LAST:event_redo_jmiActionPerformed

    private void capture_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capture_btnMouseClicked
        try {

            Dimension dimension = textArea.getPreferredSize();
            textArea.getCaret().setVisible(false);
            BufferedImage img = new BufferedImage(dimension.width, dimension.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = img.createGraphics();

            textArea.setSize(dimension);
            textArea.printAll(g2);
            g2.dispose();

            JFileChooser chooserImage = new JFileChooser();
            chooserImage.setDialogTitle("Guardar imagen");
            chooserImage.setFileFilter(new FileNameExtensionFilter("PNG File (*.png)", "png"));

            int userSelection = chooserImage.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooserImage.getSelectedFile();

                if (!selectedFile.getName().toLowerCase().endsWith(".png")) {
                    selectedFile = new File(selectedFile.getAbsolutePath() + ".png");
                }

                ImageIO.write(img, "png", selectedFile);
                JOptionPane.showMessageDialog(this, "Imagen guardada en:\n" + selectedFile.getAbsolutePath());
            }
        } catch (IOException ex) {
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al guardar la imagen: " + ex.getMessage());
        }
        textArea.getCaret().setVisible(true);
    }//GEN-LAST:event_capture_btnMouseClicked

    private void checkbox_lineNumbersStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkbox_lineNumbersStateChanged
        setting.setShowLineNumbers(checkbox_lineNumbers.isSelected());
        scrollPane.setLineNumbersEnabled(setting.getShowLineNumbers());
        setting.saveToFile();
    }//GEN-LAST:event_checkbox_lineNumbersStateChanged

    private void checkbox_toolbarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkbox_toolbarStateChanged
        setting.setShowToolbar(checkbox_toolbar.isSelected());
        toolbar.setVisible(setting.getShowToolbar());
        setting.saveToFile();
    }//GEN-LAST:event_checkbox_toolbarStateChanged

    private void settings_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settings_jmiActionPerformed
        settings_jd.setLocationRelativeTo(this);
        settings_jd.pack();
        settings_jd.setVisible(true);
    }//GEN-LAST:event_settings_jmiActionPerformed

    private void redo_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redo_btnActionPerformed
        redo_jmiActionPerformed(evt);
    }//GEN-LAST:event_redo_btnActionPerformed

    private void undo_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undo_btnActionPerformed
        undo_jmiActionPerformed(evt);
    }//GEN-LAST:event_undo_btnActionPerformed

    private void settings_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settings_btnActionPerformed
        settings_jmiActionPerformed(evt);
    }//GEN-LAST:event_settings_btnActionPerformed

    private void exit_jmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_jmiActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exit_jmiActionPerformed

    private void setTheme() {
        if (setting.isDarkTheme()) {
            textArea.setBackground(Color.decode("#313233"));
            textArea.setForeground(Color.decode("#D3FAFC"));
            textArea.setCaretColor(Color.WHITE);
            textArea.setSelectionColor(Color.decode("#F8EF9B"));
            textArea.setCurrentLineHighlightColor(Color.decode("#505050"));

            scrollPane.getGutter().setBackground(Color.decode("#2B2B2B"));
            scrollPane.getGutter().setBorderColor(Color.decode("#404040"));
            scrollPane.getGutter().setLineNumberColor(Color.decode("#999999"));

            toolbar.setBackground(new Color(51, 51, 51));
            undo_btn.setIcon(new ImageIcon(getClass().getResource("/icons/dark/undo.png")));
            redo_btn.setIcon(new ImageIcon(getClass().getResource("/icons/dark/redo.png")));
            settings_btn.setIcon(new ImageIcon(getClass().getResource("/icons/dark/gears.png")));
            capture_btn.setIcon(new ImageIcon(getClass().getResource("/icons/dark/photo-capture.png")));
        } else {
            textArea.setBackground(Color.decode("#FFFFFF"));
            textArea.setForeground(Color.decode("#2B2B2B"));
            textArea.setCaretColor(Color.BLACK);
            textArea.setSelectionColor(Color.decode("#BEFBFE"));
            textArea.setCurrentLineHighlightColor(Color.decode("#F0F4F4"));

            scrollPane.getGutter().setBackground(Color.decode("#F0F0F0"));
            scrollPane.getGutter().setBorderColor(Color.decode("#D0D0D0"));
            scrollPane.getGutter().setLineNumberColor(Color.decode("#787878"));

            toolbar.setBackground(Color.WHITE);
            undo_btn.setIcon(new ImageIcon(getClass().getResource("/icons/light/undo.png")));
            redo_btn.setIcon(new ImageIcon(getClass().getResource("/icons/light/redo.png")));
            settings_btn.setIcon(new ImageIcon(getClass().getResource("/icons/light/gears.png")));
            capture_btn.setIcon(new ImageIcon(getClass().getResource("/icons/light/photo-capture.png")));
        }

        try {
            if (setting.isDarkTheme()) {
                javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
            } else {
                javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println("Error al cargar tema inicial: " + ex.getMessage());
        }

        if (fileChooser != null) {
            fileChooser = new JFileChooser();
            setFileFilters();
        }

        SwingUtilities.updateComponentTreeUI(this);
        this.revalidate();
        this.repaint();
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

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Notepad snip = new Notepad();
            snip.setLocationRelativeTo(null);
            snip.setVisible(true);
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel capture_btn;
    private javax.swing.JCheckBox checkbox_lineNumbers;
    private javax.swing.JCheckBox checkbox_toolbar;
    private javax.swing.JMenuItem copy_jmi;
    private javax.swing.JMenuItem cut_jmi;
    private javax.swing.JRadioButton dark_jrb;
    private javax.swing.JLabel dialogTitle;
    private javax.swing.JLabel displaySettingsTitle;
    private javax.swing.JSeparator display_separator;
    private javax.swing.JMenu edit_menu;
    private javax.swing.JLabel editorSettingsTitle;
    private javax.swing.JSeparator editor_separator;
    private javax.swing.JLabel exitSettings_btn;
    private javax.swing.JMenuItem exit_jmi;
    private javax.swing.JMenu file_menu;
    private javax.swing.JPanel header;
    private javax.swing.JMenu help_menu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JRadioButton light_jrb;
    private javax.swing.JLabel margin1;
    private javax.swing.JLabel margin2;
    private javax.swing.JLabel margin3;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem newFile_jmi;
    private javax.swing.JMenuItem openFile_jmi;
    private javax.swing.JMenuItem paste_jmi;
    private javax.swing.JButton redo_btn;
    private javax.swing.JMenuItem redo_jmi;
    private javax.swing.JMenuItem saveAs_jmi;
    private javax.swing.JMenuItem saveFile_jmi;
    private javax.swing.JMenuItem selectAll_jmi;
    private javax.swing.JButton settings_btn;
    private javax.swing.JDialog settings_jd;
    private javax.swing.JMenuItem settings_jmi;
    private javax.swing.JPanel settings_panel;
    private javax.swing.JLabel startSpace;
    private javax.swing.JPanel toolbar;
    private javax.swing.JButton undo_btn;
    private javax.swing.JMenuItem undo_jmi;
    // End of variables declaration//GEN-END:variables
}
