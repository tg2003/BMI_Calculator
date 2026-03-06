import javax.swing.*;
import java.awt.event.*;
class BMIResultPage{

    BMIResultPage(double bmi){

        JFrame frame = new JFrame("BMI Result");

        JLabel bmiValue = new JLabel("Your BMI: "+String.format("%.2f",bmi));
        JLabel category = new JLabel();

        if(bmi<18.5)
            category.setText("Underweight");
        else if(bmi<25)
            category.setText("Normal");
        else if(bmi<30)
            category.setText("Overweight");
        else
            category.setText("Obese");

        bmiValue.setBounds(120,70,200,30);
        category.setBounds(150,110,200,30);

        frame.add(bmiValue);
        frame.add(category);

        frame.setSize(400,250);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

