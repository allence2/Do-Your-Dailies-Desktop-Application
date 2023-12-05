import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * Panel that will be added to the frame, that will contain the main information
 * and data input by the user
 */
public class Panel extends JPanel {

    // SCREEN SETTINGS
    private final int screenWidth = 100;
    private final int screenHeight = 150;
    private ArrayList<String> tasks;
    private JPanel userInformationPanel;

    public Panel(int gridHeight, int gridWidth, ArrayList<String> tasks) {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.tasks = tasks;
    }

    public void updateTaskView(ArrayList<String> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            this.add(new JCheckBox(tasks.get(i)));
        }
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }
}
