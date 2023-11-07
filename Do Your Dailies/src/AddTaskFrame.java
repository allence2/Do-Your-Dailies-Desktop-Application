import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddTaskFrame extends JFrame {

    private JTextField inputArea;
    private ArrayList<String> tasks;

    public AddTaskFrame() {
        this.setTitle("Add Task");
        this.setResizable(false);

        this.setSize(700, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints lableConstraints = new GridBagConstraints();
        lableConstraints.anchor = GridBagConstraints.LINE_START;
        panel.add(createLabel());
        panel.add(createTextFieldInput());
        panel.add(createAddTaskConfirmButton());

        this.add(panel);
    }

    private JLabel createLabel() {
        JLabel label = new JLabel("Add Text: ");
        return label;
    }

    private JTextField createTextFieldInput() {
        inputArea = new JTextField("", 40);

        return inputArea;
    }

    private JButton createAddTaskConfirmButton() {
        JButton confirmTaskButton = new JButton("Add Task");

        class AddTaskListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                tasks.add(inputArea.getText());
                try {
                    PrintWriter outputFile = new PrintWriter("Tasks " + java.time.LocalDate.now() + ".txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        ActionListener addTaskListner = new AddTaskListener();
        confirmTaskButton.addActionListener(addTaskListner);
        return confirmTaskButton;
    }
}
