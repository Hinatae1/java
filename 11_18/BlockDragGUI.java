package s10_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockDragGUI extends JFrame {
    private List<JLabel> blocks;  
    private int offsetX, offsetY; 

    public BlockDragGUI() {
        
        setTitle("블록 생성 및 드래깅 배치");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null); 
        blocks = new ArrayList<>(); 

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_M) {
                    createBlock(); 
                }
            }
        });
        setFocusable(true); 
        
        setVisible(true);
    }

    private void createBlock() {
        Random rand = new Random();
        int x = 100 + rand.nextInt(300); // x 좌표 (100~400)
        int y = 100 + rand.nextInt(300); // y 좌표 (100~400)

        Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
      
        JLabel block = new JLabel();
        block.setBackground(randomColor);
        block.setOpaque(true); 
        block.setBounds(x, y, 80, 80); 

        block.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {               
                offsetX = e.getX();
                offsetY = e.getY();
            }
        });
        block.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {               
                int newX = e.getXOnScreen() - offsetX;
                int newY = e.getYOnScreen() - offsetY;
                block.setLocation(newX, newY); 
            }
        });       
        add(block);
        blocks.add(block);   
        repaint();
    }
    public static void main(String[] args) {
        new BlockDragGUI(); 
    }
}

