package Password.Strength;

import java.util.Scanner;
import java.util.regex.Pattern;

          public class PasswordStrengthChecker {

	      public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter your password: ");
	        String password = scanner.nextLine();

	        Feedback feedback = checkPasswordStrength(password);
	        provideFeedback(feedback);
	    }

	    public static Feedback checkPasswordStrength(String password) {
	        boolean lengthCriteria = password.length() >= 8;
	        boolean uppercaseCriteria = Pattern.compile("[A-Z]").matcher(password).find();
	        boolean lowercaseCriteria = Pattern.compile("[a-z]").matcher(password).find();
	        boolean numberCriteria = Pattern.compile("[0-9]").matcher(password).find();
	        boolean specialCharCriteria = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();

	        Feedback feedback = new Feedback(
	                lengthCriteria,
	                uppercaseCriteria,
	                lowercaseCriteria,
	                numberCriteria,
	                specialCharCriteria
	        );

	        int strengthScore = feedback.getStrengthScore();
	        if (strengthScore == 5) {
	            feedback.setStrength("Strong");
	        } else if (strengthScore >= 3) {
	            feedback.setStrength("Moderate");
	        } else {
	            feedback.setStrength("Weak");
	        }

	        return feedback;
	    }

	    public static void provideFeedback(Feedback feedback) {
	        System.out.println("Password Strength: " + feedback.getStrength());

	        if (!feedback.isLengthCriteria()) {
	            System.out.println("- Password should be at least 8 characters long.");
	        }
	        if (!feedback.isUppercaseCriteria()) {
	            System.out.println("- Password should include at least one uppercase letter.");
	        }
	        if (!feedback.isLowercaseCriteria()) {
	            System.out.println("- Password should include at least one lowercase letter.");
	        }
	        if (!feedback.isNumberCriteria()) {
	            System.out.println("- Password should include at least one number.");
	        }
	        if (!feedback.isSpecialCharCriteria()) {
	            System.out.println("- Password should include at least one special character.");
	        }
	    }
	}

	class Feedback {
	    private boolean lengthCriteria;
	    private boolean uppercaseCriteria;
	    private boolean lowercaseCriteria;
	    private boolean numberCriteria;
	    private boolean specialCharCriteria;
	    private String strength;

	    public Feedback(boolean lengthCriteria, boolean uppercaseCriteria, boolean lowercaseCriteria,
	                    boolean numberCriteria, boolean specialCharCriteria) {
	        this.lengthCriteria = lengthCriteria;
	        this.uppercaseCriteria = uppercaseCriteria;
	        this.lowercaseCriteria = lowercaseCriteria;
	        this.numberCriteria = numberCriteria;
	        this.specialCharCriteria = specialCharCriteria;
	    }

	    public int getStrengthScore() {
	        int score = 0;
	        if (lengthCriteria) score++;
	        if (uppercaseCriteria) score++;
	        if (lowercaseCriteria) score++;
	        if (numberCriteria) score++;
	        if (specialCharCriteria) score++;
	        return score;
	    }

	    public boolean isLengthCriteria() {
	        return lengthCriteria;
	    }

	    public boolean isUppercaseCriteria() {
	        return uppercaseCriteria;
	    }

	    public boolean isLowercaseCriteria() {
	        return lowercaseCriteria;
	    }

	    public boolean isNumberCriteria() {
	        return numberCriteria;
	    }

	    public boolean isSpecialCharCriteria() {
	        return specialCharCriteria;
	    }

	    public String getStrength() {
	        return strength;
	    }

	    public void setStrength(String strength) {
	        this.strength = strength;
	    }
	}

