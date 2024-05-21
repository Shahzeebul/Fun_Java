import javax.swing.*;
import java.awt.*;

public class GifDisplay extends JFrame {
    public GifDisplay() {
        setTitle("GIF Display");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the GIF image
        ImageIcon gifIcon = new ImageIcon(getClass().getResource("giphy.gif"));

        // Create a JLabel to display the GIF
        JLabel gifLabel = new JLabel(gifIcon);

        // Set the preferred size of the label (adjust as needed)
        gifLabel.setPreferredSize(new Dimension(300, 300));

        // Set layout to center the label
        setLayout(new BorderLayout());
        add(gifLabel, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Set the frame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GifDisplay());
    }
}
