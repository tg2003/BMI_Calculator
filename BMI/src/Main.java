public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


import javax.swing.*;
import java.awt.event.*;

public class UnitHandler {

    public UnitHandler(JRadioButton metric, JRadioButton english,
                       JLabel heightUnit, JLabel weightUnit){

        metric.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                heightUnit.setText("meters");
                weightUnit.setText("kg");
            }
        });

        english.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                heightUnit.setText("inches");
                weightUnit.setText("pounds");
            }
        });
    }
}
