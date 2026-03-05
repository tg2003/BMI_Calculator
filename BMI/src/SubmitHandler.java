
import javax.swing.*;
import java.awt.event.*;

public class SubmitHandler {

    public SubmitHandler(JButton submit,
                         JTextField heightField,
                         JTextField weightField,
                         JRadioButton metric,
                         JRadioButton english,
                         JFrame frame){

        submit.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                String heightText = heightField.getText();
                String weightText = weightField.getText();

                if(heightText.isEmpty() || weightText.isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Fields cannot be empty");
                    return;
                }

                double height;
                double weight;

                try{
                    height = Double.parseDouble(heightText);
                    weight = Double.parseDouble(weightText);
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame,"Enter numeric values");
                    return;
                }

                double bmi;

                if(metric.isSelected()){
                    bmi = weight/(height*height);
                }
                else{
                    bmi = 703*weight/(height*height);
                }

                new BMIResultPage(bmi);

            }
        });
    }
}


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