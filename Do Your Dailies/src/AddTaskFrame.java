import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddTaskFrame extends JFrame {

    private JTextField inputArea;
    private ArrayList<Task> tasks;
    FileWriter outputFile;
    private String fileNameOutput = "D:\\Daily Tasks\\Task #" + java.time.LocalDate.now() + ".txt";

    public AddTaskFrame(ArrayList<Task> tasks) {
        this.tasks = tasks;

        // AddTaskFrame WINDOW SETTINGS
        this.setTitle("Add Task");
        this.setResizable(false);
        this.setSize(400, 60);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(createLabel());
        panel.add(createTextFieldInput());
        panel.add(createAddTaskConfirmButton());

        this.add(panel);
    }

    private JLabel createLabel() {
        JLabel label = new JLabel("Add Task: ");
        return label;
    }

    private JTextField createTextFieldInput() {
        inputArea = new JTextField("", 50);
        inputArea.setColumns(50);
        return inputArea;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i).getDescription());
        }
    }

    private JButton createAddTaskConfirmButton() {
        JButton confirmTaskButton = new JButton("Add Task");

        class AddTaskListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                if (!inputArea.getText().replaceAll("\\s", "").isEmpty()) {
                    try {
                        outputFile = new FileWriter(new File(fileNameOutput), true);
                        String currentInputTask = inputArea.getText();
                        tasks.add(new Task(currentInputTask, 0));
                        outputFile.write("Task #" + tasks.size() + ": " + currentInputTask + "\n");
                        outputFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                inputArea.setText("");
            }
        }
        ActionListener addTaskListner = new AddTaskListener();
        confirmTaskButton.addActionListener(addTaskListner);
        return confirmTaskButton;
    }
}
