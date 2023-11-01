import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Panel that will be added to the frame, that will contain the main information
 * and data input by the user
 */
public class Panel extends JPanel {

    // SCREEN SETTINGS
    private final int screenWidth = 700;
    private final int screenHeight = 600;

    public Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }
}
