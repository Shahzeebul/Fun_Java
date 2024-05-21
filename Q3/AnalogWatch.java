import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.time.LocalTime;

public class AnalogWatch extends JFrame {
    private WatchPanel watchPanel;

    public AnalogWatch() {
        super("Analog Watch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        watchPanel = new WatchPanel();
        add(watchPanel);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                watchPanel.repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AnalogWatch().setVisible(true);
            }
        });
    }
}

class WatchPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        // Draw the watch circle
        g2d.setColor(Color.BLACK);
        g2d.drawOval(50, 50, width - 100, height - 100);

        // Draw hour markers
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30);
            int x1 = (int) (centerX + 120 * Math.cos(angle));
            int y1 = (int) (centerY - 120 * Math.sin(angle));
            int x2 = (int) (centerX + 140 * Math.cos(angle));
            int y2 = (int) (centerY - 140 * Math.sin(angle));
            g2d.drawLine(x1, y1, x2, y2);
        }

        // Get the current time
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour() % 12;
        int minute = currentTime.getMinute();
        int second = currentTime.getSecond();

        // Draw hour hand
        double hourAngle = Math.toRadians((hour + minute / 60.0) * 30 - 90);
        drawHand(g2d, hourAngle, centerX, centerY, 50, 6, Color.BLACK);

        // Draw minute hand
        double minuteAngle = Math.toRadians((minute + second / 60.0) * 6 - 90);
        drawHand(g2d, minuteAngle, centerX, centerY, 80, 4, Color.BLUE);

        // Draw second hand
        double secondAngle = Math.toRadians(second * 6 - 90);
        drawHand(g2d, secondAngle, centerX, centerY, 90, 2, Color.RED);
    }

    private void drawHand(Graphics2D g2d, double angle, int centerX, int centerY, int length, int width, Color color) {
        int x2 = (int) (centerX + length * Math.cos(angle));
        int y2 = (int) (centerY + length * Math.sin(angle));

        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(new Line2D.Double(centerX, centerY, x2, y2));
    }
}
