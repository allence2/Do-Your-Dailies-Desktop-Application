import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddTaskFrame extends JFrame {

    private JTextField inputArea;
    private ArrayList<String> tasks = new ArrayList<String>();
    FileWriter outputFile;
    private String fileNameOutput = "D:\\Daily Tasks\\Task #" + java.time.LocalDate.now() + ".txt";

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

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
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
                        tasks.add(currentInputTask);
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

    public void loadTasksFromFile() {
        try {
            Scanner fileReader = new Scanner(new File(fileNameOutput));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ':') {
                        tasks.add(line.substring(i + 2, line.length()));
                        i = line.length();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
