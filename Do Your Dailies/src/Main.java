import javax.swing.*;

/**
 * Main class that will create the window and handle the window settings of the
 * application
 */
public class Main extends JFrame {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        Panel panel = new Panel();
        window.setSize(panel.getScreenWidth(), panel.getScreenHeight());
        window.setTitle("Do your dailies!");
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
