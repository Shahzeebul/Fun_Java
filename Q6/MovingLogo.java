import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingLogo extends JFrame {
    private int windowWidth = 800;
    private int windowHeight = 600;
    private int logoSpeed = 1;

    private ImageIcon logoImage = new ImageIcon("logo.jpeg");
    private JLabel logoLabel;
    private int logoX = windowWidth / 2 - logoImage.getIconWidth() / 2;
    private int logoY = windowHeight / 2 - logoImage.getIconHeight() / 2;
    private int directionX = 1;
    private int directionY = 1;

    public MovingLogo() {
        setTitle("Moving Logo");
        setSize(windowWidth, windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        logoLabel = new JLabel(logoImage);
        logoLabel.setBounds(logoX, logoY, logoImage.getIconWidth(), logoImage.getIconHeight());
        add(logoLabel);

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveLogo();
                updateLogoLocation();
            }
        });
        timer.start();
    }

    private void moveLogo() {
        logoX += logoSpeed * directionX;

        if (logoX < 0 || logoX > windowWidth - logoImage.getIconWidth()) {
            directionX *= -1;
        }

        logoY += logoSpeed * directionY;

        if (logoY < 0 || logoY > windowHeight - logoImage.getIconHeight()) {
            directionY *= -1;
        }
    }

    private void updateLogoLocation() {
        logoLabel.setBounds(logoX, logoY, logoImage.getIconWidth(), logoImage.getIconHeight());
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MovingLogo movingLogo = new MovingLogo();
            movingLogo.setLocationRelativeTo(null);
            movingLogo.setLayout(null);
            movingLogo.setVisible(true);
        });
    }
}
