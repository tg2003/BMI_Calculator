import javax.swing.*;
import java.awt.event.*;

public class SubmitHandler {

    public SubmitHandler(JButton submit, JTextField heightField, JTextField weightField,
                         JRadioButton metric, JRadioButton english, JFrame frame) {

        submit.addActionListener(e -> {

            try {
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());

                double bmi;

                if (metric.isSelected()) {
                    height = height / 100;
                    bmi = weight / (height * height);
                }
                else if (english.isSelected()) {
                    bmi = 703 * weight / (height * height);
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Select a unit system");
                    return;
                }

                bmi = Math.round(bmi * 100.0) / 100.0;
                new BMIResultPage(bmi);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Enter valid numeric values");
            }

        });
    }
}
