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
    private final JFileChooser fileChooser = new JFileChooser();
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

        textArea = new RSyntaxTextArea(20, 60);
        textArea.setCodeFoldingEnabled(true);
        textArea.getDocument().addUndoableEditListener(undoManager);
        scrollPane = new RTextScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);

        setSyntax();
        setFileFilters();
        setTheme();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settings_jd = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exit_settingsModal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        light_jrb = new javax.swing.JRadioButton();
        dark_jrb = new javax.swing.JRadioButton();
        toolbar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        settings_btn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        capture_btn = new javax.swing.JLabel();
        menubar = new javax.swing.JMenuBar();
        file_menu = new javax.swing.JMenu();
        newFile_jmi = new javax.swing.JMenuItem();
        openFile_jmi = new javax.swing.JMenuItem();
        saveFile_jmi = new javax.swing.JMenuItem();
        saveAs_jmi = new javax.swing.JMenuItem();
        edit_menu = new javax.swing.JMenu();
        undo_jmi = new javax.swing.JMenuItem();
        redo_jmi = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        copy_jmi = new javax.swing.JMenuItem();
        paste_jmi = new javax.swing.JMenuItem();
        cut_jmi = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        selectAll_jmi = new javax.swing.JMenuItem();

        settings_jd.setMaximumSize(new java.awt.Dimension(391, 459));
        settings_jd.setMinimumSize(new java.awt.Dimension(391, 459));
        settings_jd.setModal(true);
        settings_jd.setUndecorated(true);
        settings_jd.setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(391, 459));
        jPanel1.setMinimumSize(new java.awt.Dimension(391, 459));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(102, 102, 102));
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

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 300, 20));

        exit_settingsModal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exit_settingsModal.setForeground(new java.awt.Color(255, 255, 255));
        exit_settingsModal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_settingsModal.setText("X");
        exit_settingsModal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_settingsModalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_settingsModalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_settingsModalMouseExited(evt);
            }
        });
        jPanel1.add(exit_settingsModal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 22, 25));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Settings");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 20));

        light_jrb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        light_jrb.setForeground(new java.awt.Color(255, 255, 255));
        light_jrb.setText("Light Theme");
        light_jrb.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                light_jrbStateChanged(evt);
            }
        });
        jPanel1.add(light_jrb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        dark_jrb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dark_jrb.setForeground(new java.awt.Color(255, 255, 255));
        dark_jrb.setText("Dark Theme");
        dark_jrb.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dark_jrbStateChanged(evt);
            }
        });
        jPanel1.add(dark_jrb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        javax.swing.GroupLayout settings_jdLayout = new javax.swing.GroupLayout(settings_jd.getContentPane());
        settings_jd.getContentPane().setLayout(settings_jdLayout);
        settings_jdLayout.setHorizontalGroup(
            settings_jdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );
        settings_jdLayout.setVerticalGroup(
            settings_jdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(890, 530));
        setPreferredSize(new java.awt.Dimension(890, 530));

        toolbar.setBackground(new java.awt.Color(51, 51, 51));
        toolbar.setMinimumSize(new java.awt.Dimension(808, 45));
        toolbar.setPreferredSize(new java.awt.Dimension(808, 45));
        toolbar.setLayout(new javax.swing.BoxLayout(toolbar, javax.swing.BoxLayout.X_AXIS));

        jLabel4.setText("    ");
        toolbar.add(jLabel4);

        settings_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dark/gears.png"))); // NOI18N
        settings_btn.setToolTipText("Settings");
        settings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settings_btnMouseClicked(evt);
            }
        });
        toolbar.add(settings_btn);

        jLabel3.setText("    ");
        toolbar.add(jLabel3);

        capture_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dark/photo-capture.png"))); // NOI18N
        capture_btn.setToolTipText("Screenshot");
        capture_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                capture_btnMouseClicked(evt);
            }
        });
        toolbar.add(capture_btn);

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

    private void settings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settings_btnMouseClicked
        settings_jd.setLocationRelativeTo(this);
        settings_jd.pack();
        settings_jd.setVisible(true);
    }//GEN-LAST:event_settings_btnMouseClicked

    private void exit_settingsModalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_settingsModalMouseClicked
        settings_jd.dispose();
    }//GEN-LAST:event_exit_settingsModalMouseClicked

    private void exit_settingsModalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_settingsModalMouseEntered
        exit_settingsModal.setOpaque(true);
        exit_settingsModal.setBackground(Color.decode("#FA3D3E"));
    }//GEN-LAST:event_exit_settingsModalMouseEntered

    private void exit_settingsModalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_settingsModalMouseExited
        exit_settingsModal.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_exit_settingsModalMouseExited

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
    private javax.swing.JMenuItem copy_jmi;
    private javax.swing.JMenuItem cut_jmi;
    private javax.swing.JRadioButton dark_jrb;
    private javax.swing.JMenu edit_menu;
    private javax.swing.JLabel exit_settingsModal;
    private javax.swing.JMenu file_menu;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JRadioButton light_jrb;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem newFile_jmi;
    private javax.swing.JMenuItem openFile_jmi;
    private javax.swing.JMenuItem paste_jmi;
    private javax.swing.JMenuItem redo_jmi;
    private javax.swing.JMenuItem saveAs_jmi;
    private javax.swing.JMenuItem saveFile_jmi;
    private javax.swing.JMenuItem selectAll_jmi;
    private javax.swing.JLabel settings_btn;
    private javax.swing.JDialog settings_jd;
    private javax.swing.JPanel toolbar;
    private javax.swing.JMenuItem undo_jmi;
    // End of variables declaration//GEN-END:variables
}
