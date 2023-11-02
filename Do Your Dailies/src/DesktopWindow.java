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
        menu.add(createStatsMenuItem());

        Panel windowMainPanel = new Panel();
        add(windowMainPanel);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private JMenuItem createAddTaskMenuItem() {
        /**
         * Listener event for when the 'Add Task' menu button is
         */
        class AddTaskItemListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

            }
        }

        JMenuItem item = new JMenuItem("Add Task");
        ActionListener listener = new AddTaskItemListener();
        item.addActionListener(listener);
        return item;
    }

    private JMenuItem createStatsMenuItem() {
        /**
         * Listener event for when the 'stats' menu button is
         */
        class AddStatsItemListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

            }
        }

        JMenuItem statsItem = new JMenuItem("Stats");
        ActionListener statsListener = new AddStatsItemListener();
        statsItem.addActionListener(statsListener);
        return statsItem;
    }
}
