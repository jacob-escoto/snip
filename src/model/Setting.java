package model;

import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Setting implements Serializable {

    private static final String APP_FOLDER = ".snip";
    private static final String SETTINGS_FILE = "settings.cfgt";

    private boolean isDarkTheme;
    private boolean showLineNumbers;
    private boolean showToolbar;

    public Setting() {
        this.isDarkTheme = false;
        this.showLineNumbers = true;
        this.showToolbar = true;
    }

    public boolean isDarkTheme() {
        return isDarkTheme;
    }

    public void setIsDarkTheme(boolean isDarkTheme) {
        this.isDarkTheme = isDarkTheme;
    }

    public boolean getShowLineNumbers() {
        return showLineNumbers;
    }

    public void setShowLineNumbers(boolean showLineNumbers) {
        this.showLineNumbers = showLineNumbers;
    }
    
    public boolean getShowToolbar() {
        return showToolbar;
    }

    public void setShowToolbar(boolean showToolbar) {
        this.showToolbar = showToolbar;
    }
    
    public static File getSettingsFile() {
        File folder = new File(System.getProperty("user.home"), APP_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return new File(folder, SETTINGS_FILE);
    }

    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(getSettingsFile()))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Setting loadFromFile() {
        File file = getSettingsFile();
        if (!file.exists()) {
            Setting defaults = new Setting();
            defaults.saveToFile();
            return defaults;
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(file))) {
            return (Setting) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new Setting();
        }
    }
}
