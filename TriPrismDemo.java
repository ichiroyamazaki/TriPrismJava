package TriPrism;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TriPrismDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean tryAgain = true;

            while (tryAgain) {
                System.out.println("TriPrism Calculator\n");
                System.out.println("[1] Without Decimal Point");
                System.out.println("[2] With Decimal Point\n");
                System.out.print("Choose an option: ");
                int option = readIntInput(scanner, 1, 2);
                System.out.println();

                System.out.println("Enter the dimensions of Triangular Prism 1:");
                System.out.print("Length: ");
                double length1 = readDoubleInput(scanner, option);
                System.out.print("Base: ");
                double base1 = readDoubleInput(scanner, option);
                System.out.print("Height: ");
                double height1 = readDoubleInput(scanner, option);

                TriPrism<Double> tp1 = new TriPrism<>(length1, base1, height1);
                double volume1 = tp1.calculateVolume();

                System.out.println("\nTriangular Prism 1");
                System.out.println("Length: " + formatDimension(tp1.getLength(), option));
                System.out.println("Base: " + formatDimension(tp1.getBase(), option));
                System.out.println("Height: " + formatDimension(tp1.getHeight(), option));
                System.out.println("The volume of the triangular prism is " + formatVolume(volume1, option) + ".");

                System.out.println("\nEnter the dimensions of Triangular Prism 2:");
                System.out.print("Length: ");
                double length2 = readDoubleInput(scanner, option);
                System.out.print("Base: ");
                double base2 = readDoubleInput(scanner, option);
                System.out.print("Height: ");
                double height2 = readDoubleInput(scanner, option);

                TriPrism<Double> tp2 = new TriPrism<>(length2, base2, height2);
                double volume2 = tp2.calculateVolume();

                System.out.println("\nTriangular Prism 2");
                System.out.println("Length: " + formatDimension(tp2.getLength(), option));
                System.out.println("Base: " + formatDimension(tp2.getBase(), option));
                System.out.println("Height: " + formatDimension(tp2.getHeight(), option));
                System.out.println("The volume of the triangular prism is " + formatVolume(volume2, option) + ".");

                System.out.print("\nTry again? [Y/N]: ");
                String tryAgainInput = scanner.next();
                tryAgain = tryAgainInput.equalsIgnoreCase("y") || tryAgainInput.equalsIgnoreCase("yes");
                System.out.println();
            }

            System.out.println("Thank you for using the TriPrism Calculator!");
        }
    }

    private static int readIntInput(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Invalid input. Please choose an option between " + min + " and " + max + ".");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static double readDoubleInput(Scanner scanner, int option) {
        while (true) {
            try {
                if (option == 1) {
                    int intValue = scanner.nextInt();
                    return (double) intValue;
                } else {
                    return scanner.nextDouble();
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static String formatDimension(double value, int option) {
        if (option == 2) {
            return String.format("%.2f", value);
        } else {
            return String.valueOf((int) value);
        }
    }

    private static String formatVolume(double volume, int option) {
        if (option == 2) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            return decimalFormat.format(volume);
        } else {
            return String.valueOf((int) volume);
        }
    }
}
