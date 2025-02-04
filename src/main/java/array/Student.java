package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

    public String[] inputYears() {
        System.out.println("Enter the years separating them by a comma: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(",");
    }

    public String[] inputSubjects() {
        System.out.println("Enter your subjects separating them by a comma:");
        Scanner scanner = new Scanner(System.in);
        String stringSubjects = scanner.nextLine();

        return stringSubjects.split(",");
    }

    public String[][] inputGrades(String[] subjects, int numGrades) {
        String[][] subjectsGrades = new String[subjects.length][numGrades];
        Scanner scanner = new Scanner(System.in);

        for (int row = 0; row < subjects.length; row++) {
            System.out.println("\nType " + subjects[row] + " grades: ");
            for (int col = 0; col < numGrades; col++) {
                System.out.print("Grade " + (col + 1) + " : ");
                subjectsGrades[row][col] = scanner.nextLine();
            }
        }
        return subjectsGrades;
    }

    public List<List<Double>> inputGrades(String[] subjects) {
        List<List<Double>> subjectsGrades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int row = 0; row < subjects.length; row++) {
            System.out.println("\nType " + subjects[row] + " grades: ");
            boolean quit = true;
            subjectsGrades.add(new ArrayList<>());

            do {
                System.out.println("Type a valid number for your grade or any other key to quit: ");
                String stringGrade = scanner.nextLine();

                try {
                    double grade = Double.parseDouble(stringGrade);
                    subjectsGrades.get(row).add(grade);
                } catch (Exception e) {
                    if (subjectsGrades.get(row).isEmpty()) {
                        System.out.println("You must type at least one grade");
                    } else {
                        quit = false;
                    }
                }

            }while(quit);
        }
        return subjectsGrades;
    }

    public double[][][] inputGrades(String[] years, String[] subjects, int numGrades) {

        double[][][] yearGrades = new double[years.length][subjects.length][numGrades];
        Scanner scanner = new Scanner(System.in);

        for (int yearIndex = 0; yearIndex < years.length; yearIndex++) {
            System.out.println("\nType your grades on the year " + years[yearIndex] + " :");
            for (int subjectIndex = 0; subjectIndex < subjects.length; subjectIndex++) {
                System.out.println("For " + subjects[subjectIndex] + " :");
                for (int gradeIndex = 0; gradeIndex < numGrades; ) {
                    System.out.print("Grade " + (gradeIndex+1) + " :");
                    String stringGrade = scanner.nextLine();
                    try {
                        double grade = Double.parseDouble(stringGrade);
                        yearGrades[yearIndex][subjectIndex][gradeIndex] = grade;
                        gradeIndex++;
                    } catch (Exception e) {
                        System.out.println("Type a valid number");
                    }
                }
            }
        }
        return yearGrades;
    }
}
