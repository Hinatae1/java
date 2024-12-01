package s10_1;

import java.awt.*;
import javax.swing.*;

public class YGridLayout {
	 public static void main(String[] args) {
	        
	        JFrame frame = new JFrame("4x4 Color 프레임");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(900, 400);
	        
	        // GridLayout 설정 (4x4)
	        frame.setLayout(new GridLayout(4, 4));

	        // 색상 배열 생성
	        Color[] colors = {
	            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
	            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.LIGHT_GRAY,
	            Color.PINK, Color.GRAY, Color.WHITE, Color.BLACK,
	            Color.BLACK, Color.ORANGE, Color.BLUE, Color.MAGENTA
	        };

	        // 버튼 추가 및 색상, 번호 적용
	        for (int i = 0; i < colors.length; i++) {
	            JButton button = new JButton(" " + (i)); // 번호 추가 (1부터 시작, 여백 포함)
	            button.setBackground(colors[i]);             // 배경색 설정
	            button.setOpaque(true);                      // 배경색 표시를 위해 필요
	            button.setBorderPainted(false);              // 테두리 제거
	            button.setEnabled(false);                    // 버튼 클릭 비활성화
	            button.setFont(new Font("Arial", Font.BOLD, 20)); // 텍스트 폰트 크기

	            // 텍스트를 왼쪽 정렬
	            button.setHorizontalAlignment(SwingConstants.LEFT);
	            button.setVerticalAlignment(SwingConstants.CENTER); // 수직 중앙 정렬
	            
	            frame.add(button); 
	        }

	        // 프레임 표시
	        frame.setVisible(true);
	    }
	}

