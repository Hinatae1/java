package s10_1;

import javax.swing.*;
import java.awt.event.*;

public class MenuExampleGUI extends JFrame {

    public MenuExampleGUI() {
        
        setTitle("메뉴 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        
        //메뉴 바
        JMenuBar menuBar = new JMenuBar();

        //파일메뉴
        JMenu fileMenu = new JMenu("파일");

        //편집메뉴
        JMenu editMenu = new JMenu("편집");     

        //보기메뉴(화면확대, 쪽윤곽)
        JMenu viewMenu = new JMenu("보기");
        JMenuItem zoomItem = new JMenuItem("화면확대");
        JMenuItem outlineItem = new JMenuItem("쪽윤곽");
        viewMenu.add(zoomItem);
        viewMenu.add(outlineItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuExampleGUI();
    }
}

