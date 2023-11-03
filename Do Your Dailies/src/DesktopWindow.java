import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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

        Panel windowMainPanel = new Panel();
        add(windowMainPanel);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private JMenuItem createManageTasksMenuItem() {
        /**
         * Listener event for when the 'stats' menu button is
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

    private JMenuItem createAddTaskMenuItem() {
        /**
         * Listener event for when the 'Add Task' menu button is
         */
        class TaskItemListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

            }
        }

        JMenuItem item = new JMenuItem("Add Task");
        ActionListener listener = new TaskItemListener();
        item.addActionListener(listener);
        return item;
    }

    private JMenuItem createStatsMenuItem() {
        /**
         * Listener event for when the 'stats' menu button is
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
}
