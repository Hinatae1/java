package s10_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomNumberGUI extends JFrame {
    private JLabel numberLabel;

    public RandomNumberGUI() {
        
        setTitle("West Grid 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(10, 1)); 

        
        Color[] buttonColors = {
            Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
            Color.ORANGE, Color.PINK, Color.CYAN, Color.MAGENTA,
            Color.GRAY, Color.LIGHT_GRAY
        };

        
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton();
            button.setBackground(buttonColors[i]); 
            button.setOpaque(true);                
            button.setBorderPainted(false);        
            buttonPanel.add(button);

            
            button.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    generateRandomNumber(); // 랜덤 숫자 생성
                }
            });
        }
        add(buttonPanel, BorderLayout.WEST);

        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null); 
        numberLabel = new JLabel("", JLabel.CENTER);
        numberLabel.setFont(new Font("Arial", Font.BOLD, 20));
        centerPanel.add(numberLabel);
        add(centerPanel, BorderLayout.CENTER);

        
        setVisible(true);
    }

    
    private void generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(10); // 0~9 사이 랜덤 정수
        int x = 50 + random.nextInt(151);      // x 좌표 (50~200)
        int y = 50 + random.nextInt(151);      // y 좌표 (50~200)

        
        numberLabel.setText(String.valueOf(randomNumber));
        numberLabel.setBounds(x, y, 50, 50);

        
        repaint();
    }

    public static void main(String[] args) {
        new RandomNumberGUI();
    }
}

