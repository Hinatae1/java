package s10_1;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderExampleGUI extends JFrame {
    private JLabel valueLabel;

    public SliderExampleGUI() {
        
        setTitle("Slider Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());  
        
        JSlider slider = new JSlider(100, 200, 100);
        slider.setMajorTickSpacing(20);  
        slider.setMinorTickSpacing(1);   
        slider.setPaintTicks(true);      
        slider.setPaintLabels(true);    

        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        for (int i = 100; i <= 200; i += 20) {
            labelTable.put(i, new JLabel(String.valueOf(i))); 
        }
        slider.setLabelTable(labelTable);

        valueLabel = new JLabel("100");
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                valueLabel.setText("" + value);
            }
        });
        add(slider);
        add(valueLabel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SliderExampleGUI();  
    }
}


