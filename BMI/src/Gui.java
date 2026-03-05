import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*; //to set borders-check exact positions

public class Gui {
    public static void main(String[] args) {
        new Gui();
    }

    public Gui(){
        //1. frame
        JFrame frame = new JFrame("BMI Calculator");
        frame.setSize(400,600);
        frame.setLayout(null); //to prevent auto positioning
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminate program when clicked close button

        //2. label for - BMI Calculator
        JLabel title = new JLabel("BMI Calculator");
        title.setFont(new Font("Arial",Font.BOLD,35));
        title.setForeground(Color.BLUE);
        title.setBounds(0,50,385,30);
        frame.add(title);
        //title.setBorder(new LineBorder(Color.BLACK, 2)); //setting a border to see the exact position
        title.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
