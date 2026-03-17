import javax.swing.*;
import java.awt.*;

public class BmiApp extends JFrame{
    static void main(String[] args) {
        InputPanel mypanel = new InputPanel();
        OutputPanel mypanel2 = new OutputPanel();
        JFrame f = new JFrame("BMI Calculator");
        ButtonGroup unitgrp = new ButtonGroup();

        f.setContentPane(mypanel.inputpanel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(700,400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        //group unit buttons
        unitgrp.add(mypanel.metricRadioButton);
        unitgrp.add(mypanel.englishRadioButton);

        //action listeners - radio button
        mypanel.metricRadioButton.addActionListener(e -> {
            mypanel.unitweight.setText("kg");
            mypanel.unitheight.setText("m");
        });

        mypanel.englishRadioButton.addActionListener(e->{
            mypanel.unitweight.setText("lbs");
            mypanel.unitheight.setText("in");
        });

        mypanel.calculateButton.addActionListener(e->{
            String weighttxt=mypanel.textFieldweight.getText();
            String heighttxt=mypanel.textFieldheight.getText();

            try {
                double w = Double.parseDouble(weighttxt);
                double h = Double.parseDouble(heighttxt);

                //check what is the selectd unit is
                String unit ;
                if (mypanel.metricRadioButton.isSelected()){
                    unit="metric";
                }
                else{  //mypanel.englishRadioButton.isSelected()
                    unit="english";
                }

                //calling method with h,w,unit(as defined in BMICalculator.java)
                double bmi = BMICalculator.calculateBMI(h,w,unit);
                String status = BMICalculator.getStatus(bmi);
                String tip = BMICalculator.getHealthTip(status);

                String bmistr=String.valueOf(Math.round(bmi * 100.0) / 100.0);//convert bmi into Str

                //set values to mypanel2
                mypanel2.bmival.setText(bmistr);
                mypanel2.statusval.setText(status);
                mypanel2.tipval.setText(tip);

                f.setContentPane(mypanel2.outputpanel);
                f.revalidate();
                f.repaint();

            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(f,"Enter a valid number");
            }

        });

        mypanel2.backbtn.addActionListener(e->{
            f.setContentPane(mypanel.inputpanel);
            f.revalidate();
            f.repaint();
        });


    }//main method end
}//BmiApp cls end
