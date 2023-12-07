import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class TasksView extends JComponent {

    public TasksView(JPanel pane, ArrayList<String> tasks) {
        updateTaskView(pane, tasks);
    }

    public void updateTaskView(JPanel pane, ArrayList<String> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            JCheckBox task = new JCheckBox(tasks.get(i));
            this.add(task);
        }
    }

}
