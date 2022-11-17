package Unit1;

import javax.swing.*;

/**
 * This class represent an exercise where a user is prompt to provide three values for the quadratic formula
 * and then given the larger of the two roots. The objective of the exercise is to handle exceptions.
 *
 * @author Ruhan
 */
public class Exercise {
    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
    static public double root( double A, double B, double C ) throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        }
        else {
            double disc = B*B - 4*A*C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return  (-B + Math.sqrt(disc)) / (2*A);
        }
    }

    public static void main(String[] args) {
        int goAgain = JOptionPane.YES_OPTION;
        Double B;
        Double A;
        Double C;

        do {
            String question = "For the quadratic equation b^2 - 4ac please provide a number value for ";
            try {
                B = Double.valueOf(JOptionPane.showInputDialog(question + "b?"));
                A = Double.valueOf(JOptionPane.showInputDialog(question + "a?"));
                C = Double.valueOf(JOptionPane.showInputDialog(question + "c?"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number value");
                continue;
            }

            try {
                JOptionPane.showMessageDialog(null,
                        "The larger of the two roots are " + root(A, B, C));
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            goAgain = JOptionPane.showConfirmDialog(null,
                    "Would you like to do another equation?",
                    "Prompt to continue",
                    JOptionPane.YES_NO_OPTION);
        } while (goAgain == JOptionPane.YES_OPTION);
    }
}
