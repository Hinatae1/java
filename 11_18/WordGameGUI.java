package s10_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordGameGUI extends JFrame {
    private static final String[] textOptions = {
        "Java is a powerful programming language",
        "Swing is used for building GUI applications",
        "The quick brown fox jumps over the lazy dog",
        "Game development is fun and creative"
    };
    
    private List<String> words;    // 단어 목록
    private List<JLabel> wordLabels; // 화면에 표시될 단어들
    private String targetSentence;  // 목표 문장
    private StringBuilder currentSentence;  // 사용자가 클릭한 단어로 만든 문장
    private JPanel wordPanel;
    private JLabel sentenceLabel;

    public WordGameGUI() {
        // JFrame 설정
        setTitle("Word Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // 목표 문장과 단어 초기화
        currentSentence = new StringBuilder();
        wordLabels = new ArrayList<>();
        
        // 하단에 문장 표시
        sentenceLabel = new JLabel("Complete the sentence:", JLabel.CENTER);
        sentenceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(sentenceLabel, BorderLayout.SOUTH);

        // 중앙에 단어들이 표시될 패널
        wordPanel = new JPanel(null);  // null 레이아웃을 사용하여 단어를 랜덤 위치에 배치
        add(wordPanel, BorderLayout.CENTER);

        // "New Text" 버튼 생성
        JButton newTextButton = new JButton("단어 조합 게임! 순서대로 단어를 클릭하세요[New Text]");
        newTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateNewText();
            }
        });
        add(newTextButton, BorderLayout.NORTH);

        // 프레임을 보이게 설정
        setVisible(true);
    }

    private void generateNewText() {
        // 기존의 단어들을 삭제
        wordPanel.removeAll();
        wordLabels.clear();
        currentSentence.setLength(0); // 사용자가 클릭한 문장 초기화

        // 랜덤하게 하나의 텍스트를 선택
        int index = (int) (Math.random() * textOptions.length);
        targetSentence = textOptions[index];

        // 선택된 텍스트를 단어 단위로 나누기
        String[] wordsArray = targetSentence.split(" ");
        words = new ArrayList<>();
        for (String word : wordsArray) {
            words.add(word);
        }

        // 단어를 랜덤하게 섞기
        Collections.shuffle(words);

        // 단어들을 JLabel로 변환하여 랜덤 위치에 배치
        int yPosition = 50;
        for (String word : words) {
            JLabel wordLabel = new JLabel(word);
            wordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            wordLabel.setForeground(Color.BLACK);
            wordLabel.setBounds((int) (Math.random() * 600) + 50, yPosition, 200, 30); // 랜덤 위치에 배치
            wordPanel.add(wordLabel);

            wordLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // 단어를 클릭할 때마다 문장에 추가
                    currentSentence.append(word).append(" ");
                    sentenceLabel.setText("단어 조합>>" + currentSentence.toString());

                    // 문장이 완성되었는지 체크
                    if (currentSentence.toString().trim().equals(targetSentence)) {
                        JOptionPane.showMessageDialog(null, "You Win!");
                    }
                }
            });

            wordLabels.add(wordLabel);
            yPosition += 40;
        }

        wordPanel.revalidate();
        wordPanel.repaint();
    }

    public static void main(String[] args) {
        new WordGameGUI();  // 프로그램 시작
    }
}

