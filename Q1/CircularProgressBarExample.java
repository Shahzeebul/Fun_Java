import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CircularProgressBar extends JPanel {
    private int progressValue;

    public CircularProgressBar() {
        progressValue = 0;
        setPreferredSize(new Dimension(200, 200));
    }

    public void updateProgress(int value) {
        progressValue = value;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        int startAngle = 90;
        int arcAngle = (int) (3.6 * progressValue);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawArc(x, y, diameter, diameter, startAngle, arcAngle);
    }
}

public class CircularProgressBarExample {
    private static int progressValue = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Circular Progress Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        CircularProgressBar circularProgressBar = new CircularProgressBar();
        frame.add(circularProgressBar, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Progress");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProgress(circularProgressBar);
            }
        });

        frame.add(startButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private static void updateProgress(CircularProgressBar circularProgressBar) {
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressValue++;
                circularProgressBar.updateProgress(progressValue);
                if (progressValue >= 100) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
    }
}
