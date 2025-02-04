package array;

import java.util.List;

public class Report {

    public void printGrades(String[] subjects, double[] gradesAverage) {
        System.out.println("\nThe averages for your grades are: ");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + gradesAverage[i]);
        }
    }

    public void printGrades(String[] subjects, List<Double> gradesAverage) {
        System.out.println("\nThe averages for your grades are: ");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + gradesAverage.get(i));
        }
    }

    public void printGrades(String[] years, String[] subjects, double[][] gradesAverage) {
        System.out.println("\nThe averages for your grades are: ");
        for (int yearIndex = 0; yearIndex < years.length; yearIndex++) {
            System.out.println(years[yearIndex] + " :");
            for (int averIndex = 0; averIndex < subjects.length; averIndex++) {
                System.out.println(subjects[averIndex] + " :" + gradesAverage[yearIndex][averIndex]);
            }
        }
    }
}
