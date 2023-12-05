import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
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
    private final int screenWidth = 600;
    private final int screenHeight = 650;
    private GridBagConstraints comp = new GridBagConstraints();
    private ArrayList<String> tasks;
    private JPanel taskSection;
    private JPanel historySection;

    public Panel(int gridHeight, int gridWidth, ArrayList<String> tasks) {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.setLayout(new GridBagLayout());
        // this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        taskSection = new JPanel();
        taskSection.setLayout(new BoxLayout(taskSection, BoxLayout.PAGE_AXIS));
        comp.fill = GridBagConstraints.VERTICAL;
        comp.gridheight = 3;
        comp.gridx = 0;
        comp.gridy = 0;
        this.add(taskSection, comp);

        historySection = new JPanel();
        comp.gridx = 1;
        comp.gridy = 0;
        historySection.add(new TextArea());
        this.add(historySection);

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
