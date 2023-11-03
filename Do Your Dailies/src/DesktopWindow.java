import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DesktopWindow extends JFrame {

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;

    public DesktopWindow() {

        // MENU BAR
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        menu.add(createAddTaskMenuItem());
        menu.add(createManageTasksMenuItem());
        menu.add(createStatsMenuItem());
        menu.add(createSettingsMenuItem());

        Panel windowMainPanel = new Panel(9, 9);
        add(windowMainPanel);

        JPanel windowTaskSection = new JPanel();
        TasksView tasks = new TasksView();
        windowTaskSection.add(tasks);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private JMenuItem createAddTaskMenuItem() {
        /**
         * Listener event for when the 'Add Task' menu button is pressed
         */
        class TaskItemListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                JFrame addTaskFrame = new AddTaskFrame();
            }
        }

        JMenuItem addTaskItem = new JMenuItem("Add Task");
        ActionListener AddTaskListener = new TaskItemListener();
        addTaskItem.addActionListener(AddTaskListener);
        return addTaskItem;
    }

    private JMenuItem createManageTasksMenuItem() {
        /**
         * Listener event for when the 'Manage Tasks' menu button is pressed
         */
        class ManageTasksListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

            }
        }

        JMenuItem manageTasksItem = new JMenuItem("Manage Tasks");
        ActionListener statsListener = new ManageTasksListener();
        manageTasksItem.addActionListener(statsListener);
        return manageTasksItem;
    }

    private JMenuItem createStatsMenuItem() {
        /**
         * Listener event for when the 'stats' menu button is pressed
         */
        class StatsItemListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

            }
        }

        JMenuItem statsItem = new JMenuItem("Stats");
        ActionListener statsListener = new StatsItemListener();
        statsItem.addActionListener(statsListener);
        return statsItem;
    }

    private JMenuItem createSettingsMenuItem() {
        /**
         * Listener event for when the 'Settings' menu button is pressed
         */
        class SettingsItemListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

            }
        }

        JMenuItem settingsItem = new JMenuItem("Settings");
        ActionListener settingsListener = new SettingsItemListener();
        settingsItem.addActionListener(settingsListener);
        return settingsItem;
    }
}
