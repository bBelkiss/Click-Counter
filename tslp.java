import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tslp extends JFrame {

    private int clickCount = 0;
    private JLabel label;

    public tslp() {
        setTitle("Click Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        label = new JLabel("Cantidad de clicks: 0");
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton clickButton = new JButton("Click");
        clickButton.setFont(new Font("Arial", Font.PLAIN, 16));
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementClickCount();
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 16));
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetClickCount();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.add(label);
        panel.add(clickButton);
        panel.add(resetButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void incrementClickCount() {
        clickCount++;
        updateLabel();
    }

    private void resetClickCount() {
        clickCount = 0;
        updateLabel();
    }

    private void updateLabel() {
        label.setText("Cantidad de clicks: " + clickCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new tslp().setVisible(true);
            }
        });
    }
}
