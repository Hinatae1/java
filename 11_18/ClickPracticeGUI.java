package s10_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ClickPracticeGUI extends JFrame {
    private JLabel labelC;

    public ClickPracticeGUI() {
        
        setTitle("클릭 연습 응용프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null); 

        labelC = new JLabel("C");
        labelC.setFont(new Font("Arial", Font.BOLD, 40));
        labelC.setBounds(100, 100, 50, 50);  // 초기 위치 (100, 100)
        add(labelC);

        labelC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                moveLabelRandomly(); // "C" 클릭 시 호출되는 메소드
            }
        });
        setVisible(true);
    }
    
    private void moveLabelRandomly() {
        Random random = new Random();
        int x = 50 + random.nextInt(300); // x 좌표 (50 ~ 350)
        int y = 50 + random.nextInt(300); // y 좌표 (50 ~ 350)
        labelC.setBounds(x, y, 50, 50);
    }

    public static void main(String[] args) {
        new ClickPracticeGUI();
    }
}

