package s10_1;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayerGUI extends JFrame {
    private Clip audioClip;  // 오디오 클립

    public AudioPlayerGUI() {
        // JFrame 설정
        setTitle("Audio Player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // 메뉴 바 생성
        JMenuBar menuBar = new JMenuBar();

        // "오디오" 메뉴 생성
        JMenu audioMenu = new JMenu("오디오");

        // "연주" 메뉴 아이템
        JMenuItem playItem = new JMenuItem("연주");
        playItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAudio();
            }
        });

        // "종료" 메뉴 아이템
        JMenuItem stopItem = new JMenuItem("종료");
        stopItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAudio();
            }
        });

        // 메뉴에 아이템 추가
        audioMenu.add(playItem);
        audioMenu.add(stopItem);

        // 메뉴 바에 "오디오" 메뉴 추가
        menuBar.add(audioMenu);

        // 메뉴 바를 프레임에 설정
        setJMenuBar(menuBar);

        // 프레임을 보이게 설정
        setVisible(true);
    }

    // 오디오 연주 기능
    private void playAudio() {
        // JFileChooser로 파일 선택
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("오디오 파일 선택");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("WAV 파일", "wav"));
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File audioFile = fileChooser.getSelectedFile();
            try {
                // 선택한 파일로 오디오 클립을 열기
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);
                audioClip.start();  // 오디오 연주 시작
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "오디오 파일을 연주할 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // 오디오 종료 기능
    private void stopAudio() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();  // 오디오 종료
        }
    }

    public static void main(String[] args) {
        new AudioPlayerGUI();  // 프로그램 시작
    }
}

