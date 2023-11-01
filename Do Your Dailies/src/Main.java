import javax.swing.*;

/**
 * Main class that will create the window and handle the window settings of the
 * application
 */
public class Main {

    public static void main(String[] args) {

        JFrame window = new DesktopWindow();

        window.setTitle("Do your dailies!");
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
