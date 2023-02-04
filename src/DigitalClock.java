import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class DigitalClock extends JFrame {
    private JLabel timeLabel = new JLabel();
    private JPanel panel = new JPanel();
    private Calendar cal = new GregorianCalendar();

    public DigitalClock() {
        // the design and dimensions of the frame of the clock
        setTitle("Digital Clock by Abdulvakil");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(new Color(0,32,63));
        panel.setLayout(new GridBagLayout());
        add(panel);

        timeLabel.setForeground(new Color(173, 239, 209));
        timeLabel.setFont(new Font("Arial", Font.BOLD, 60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(timeLabel);

        // centering the frame on the screen of the device
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - getWidth() / 2,
                screenSize.height / 2 - getHeight() / 2);

        // start the clock
        Thread clockThread = new Thread() {
            public void run() {
                while (true) {
                    cal = Calendar.getInstance();
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int minute = cal.get(Calendar.MINUTE);
                    int second = cal.get(Calendar.SECOND);
                    timeLabel.setText(String.format("%02d:%02d:%02d", hour, minute, second));
                }
            }
        };
        clockThread.start();
    }

    public static void main(String[] args) {
        DigitalClock clock = new DigitalClock();
        clock.setVisible(true);
    }
}