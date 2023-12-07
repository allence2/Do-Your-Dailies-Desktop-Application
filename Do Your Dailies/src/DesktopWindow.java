import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DesktopWindow extends JFrame {

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;
    private ArrayList<Task> dailyTasksList = new ArrayList<Task>();
    private FileWriter outputFile;
    private String fileNameOutput = "D:\\Daily Tasks\\Task #" + java.time.LocalDate.now() + ".txt";
    private JPanel taskSection;
    private JPanel historySection;
    private JPanel quoteSection;
    private ActionListener listener;

    /**
     * Default Constructor to add elements to create the GUI application
     */
    public DesktopWindow() {

        /*
         * MENU BAR SECTION
         */
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        menu.add(createAddTaskMenuItem());
        menu.add(createManageTasksMenuItem());
        menu.add(createStatsMenuItem());
        menu.add(createSettingsMenuItem());

        loadTasksFromFile();

        listener = new taskListener();

        // Main window panel
        JPanel pane = new JPanel();
        pane.setBackground(Color.DARK_GRAY);
        pane.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        pane.setLayout(new GridBagLayout());

        GridBagConstraints comp = new GridBagConstraints();

        // Panel on the left of the main window panel that contains a checklist of
        // current tasks
        taskSection = new JPanel();
        taskSection.setLayout(new BoxLayout(taskSection, BoxLayout.PAGE_AXIS));
        comp.fill = GridBagConstraints.VERTICAL;
        comp.gridheight = 3;
        comp.gridx = 0;
        comp.gridy = 0;
        pane.add(taskSection, comp);

        /*
         * Panel below the menu bar that houses the current task list, past history,
         * and quote section
         */
        // Panel windowMainPanel = new Panel(9, 9, dailyTasksList);
        // add(windowMainPanel);

        add(pane);

        updateTasks();

        JPanel windowTaskSection = new JPanel();
        TasksView viewOfTasks = new TasksView();
        windowTaskSection.add(viewOfTasks);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    /**
     * Creates a menu button for 'Add Task' that will create a new window for the
     * user to create a task to add to their daily todo list
     * 
     * @return JMenuItem of the 'Add Task' button
     */
    private JMenuItem createAddTaskMenuItem() {
        class TaskItemListener implements ActionListener {

            /*
             * Method processed when the 'Add Task' menu button is pressed
             */
            public void actionPerformed(ActionEvent event) {
                AddTaskFrame addTaskFrame = new AddTaskFrame(dailyTasksList);
                dailyTasksList = addTaskFrame.getTasks();
                /*
                 * Doesn't load the external tasks file on initial call due to it not being
                 * created
                 *
                 * if (initialLoadFlag) {
                 * addTaskFrame.loadTasksFromFile();
                 * }
                 * initialLoadFlag = false;
                 * // addTaskFrame.printTasks();
                 */
            }
        }

        JMenuItem addTaskItem = new JMenuItem("Add Task");
        ActionListener AddTaskListener = new TaskItemListener();
        addTaskItem.addActionListener(AddTaskListener);
        return addTaskItem;
    }

    private JMenuItem createManageTasksMenuItem() {
        /*
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
        /*
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
        /*
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

    class taskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateTasks();
        }

    }

    private void updateTasks() {
        for (int i = 0; i < dailyTasksList.size(); i++) {
            taskSection.add(new JCheckBox(dailyTasksList.get(i).getDescription()));
        }
    }

    public void loadTasksFromFile() {
        try {
            Scanner fileReader = new Scanner(new File(fileNameOutput));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ':') {
                        dailyTasksList.add(new Task(line.substring(i + 2, line.length()), 0));
                        i = line.length();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
