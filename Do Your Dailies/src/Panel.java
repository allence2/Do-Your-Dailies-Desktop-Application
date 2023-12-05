import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    private GridBagConstraints comp = new GridBagConstraints();
    private ArrayList<String> tasks;
    private JPanel taskSection;

    public Panel(int gridHeight, int gridWidth, ArrayList<String> tasks) {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.setLayout(new GridBagLayout());
        // this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        taskSection = new JPanel();
        comp.anchor = GridBagConstraints.LINE_START;
        comp.gridx = 0;
        comp.fill = GridBagConstraints.BOTH;
        this.add(taskSection, comp);

        this.tasks = tasks;

    }

    public void updateTaskView(ArrayList<String> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            taskSection.add(new JCheckBox(tasks.get(i)));
        }
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }
}
