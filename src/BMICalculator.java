public class BMICalculator {
    public static double calculateBMI(double height, double weight, String unit){
        // for Metric type
        if(unit.equals("metric")){
            return weight / (height * height);
        }
        // for English type
        else{
            return 703 * weight / (height * height);
        }
    }

    public static String getStatus(double bmi){
        if (bmi < 18.5) {
            return "Underweight 😢";
        } else if (bmi < 25.0) {
            return "Normal 😊";
        } else if (bmi < 30.0) {
            return "Overweight 😟";
        } else {
            return "Obese 😨";
        }
    }

    public static String getHealthTip(String status){
        switch (status) {
            case "Underweight 😢":
                return "Eat more nutritious foods and consult a doctor.";
            case "Normal 😊":
                return "Great job! Keep maintaining a balanced diet and exercise.";
            case "Overweight 😟":
                return "Try regular exercise and reduce sugary foods.";
            case "Obese 😨":
                return "Please consult a doctor for a proper health plan.";
            default:
                return "Invalid BMI value.";
        }
    }
}
