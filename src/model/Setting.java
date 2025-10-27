package model;

import java.io.Serializable;

public class Setting implements Serializable {

    private boolean isDarkTheme;

    public Setting() {
        this.isDarkTheme = false;
    }

    public boolean isDarkTheme() {
        return isDarkTheme;
    }

    public void setIsDarkTheme(boolean isDarkTheme) {
        this.isDarkTheme = isDarkTheme;
    }

}
