import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddTaskFrame extends JFrame {

    public AddTaskFrame() {
        this.setTitle("Add Task");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(700, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints lableConstraints = new GridBagConstraints();
        lableConstraints.anchor = GridBagConstraints.LINE_START;
        panel.add(createLabel());
        panel.add(createAddTaskConfirmButton());

        this.add(panel);
    }

    private JLabel createLabel() {
        JLabel label = new JLabel("Add Text: ");
        return label;
    }

    private JButton createAddTaskConfirmButton() {
        JButton confirmTaskButton = new JButton("Add Task");
        return confirmTaskButton;
    }
}
