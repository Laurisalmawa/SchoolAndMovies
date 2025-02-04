package array;

import java.util.ArrayList;
import java.util.List;

public class School {
    Student student = new Student();
    Application application = new Application();
    Report report = new Report();

    public void giveAverageGrades3dArray() {
        // 1. Ingresar el año
        String[] years = student.inputYears();
        // 2. Ingresar materias
        String[] subjects = student.inputSubjects();
        // 3. Ingresar numero de notas
        int numGrades = application.readNumber("Type how many grades would you like to input per subject: ");
        // 4. Ingresar notas
        double[][][] yearlyGrades = student.inputGrades(years,subjects,numGrades);
        // 5. Calcular el promedio
        double[][] gradesAverages = calculateAverages(yearlyGrades, subjects.length);
        // 6. Mostrar el promedio
        report.printGrades(years, subjects, gradesAverages);
    }

    public void giveAverageGradesList() {
        // 1. Ingresar materias
        String[] subjects = student.inputSubjects();
        // 2. Ingresar notas
        List<List<Double>> grades = student.inputGrades(subjects);
        // 3. Calcular promedio
        List<Double> average =  calculateAverages(grades);
        // 4. Mostrar el promedio
        report.printGrades(subjects, average);
    }

    public void giveAverageGradesArray() {
        // 1. Ingresar materias
        String[] subjects = student.inputSubjects();
        // 2. Preguntar num notas
        int numGrades = application.readNumber("Type how many grades would you like to input per subject: ");
        // 3. Ingresar notas
        String[][] grades = student.inputGrades(subjects,numGrades);
        // 4. Calcular el promedio
        double[] averages = calculateAverages(grades);
        // 5. Mostrar el promedio
        report.printGrades(subjects,averages);
    }

    public double calculateAverages(String[] grades) {
        double result = 0;
        for(String grade: grades) {
            result += Double.parseDouble(grade);
        }
        return result/grades.length;
    }

    public double getAverageByLists(List<String> grades) {
        double result = 0;
        for (String grade: grades) {
            result += Double.parseDouble(grade);
        }

        return result/grades.size();
    }

    public double[] calculateAverages(
            String[] math,
            String[] english,
            String[] science,
            String[] physics,
            String[] history) {

        double[] subjects = new double[5];
        subjects[0] = calculateAverages(math);
        subjects[1] = calculateAverages(english);
        subjects[2] = calculateAverages(science);
        subjects[3] = calculateAverages(physics);
        subjects[4] = calculateAverages(history);

        return subjects;
    }

    public List<Double> calculateAverages(
            List<String> math,
            List<String> english,
            List<String> physics,
            List<String> history,
            List<String> science) {

        List<Double> subjects= new ArrayList<>();
        subjects.add(getAverageByLists(math));
        subjects.add(getAverageByLists(english));
        subjects.add(getAverageByLists(physics));
        subjects.add(getAverageByLists(history));
        subjects.add(getAverageByLists(science));

        return subjects;
    }

    public double[] calculateAverages(String[][] grades) {

        double[] subjects = new double[grades.length];
        for (int i = 0; i < grades.length; i++) {
            int j = 0;
            for (; j < grades[i].length; j++) {
                subjects[i] = subjects[i] + Double.parseDouble( grades[i][j]);
            }
            subjects[i] = subjects[i]/ grades[i].length;
        }
        return subjects;
    }

    public List<Double> calculateAverages(List<List<Double>> grades) {

        List<Double> subjects =  new ArrayList<>();
        for (int row = 0; row < grades.size(); row++) {
            double result = 0;
            int col = 0;
            for (; col < grades.get(row).size(); col++) {
                result = result + grades.get(row).get(col);
            }
            subjects.add(result/col);
        }
        return subjects;
    }

    // materias -> matematicas , ciencias, inglés
    // promedios ->  6.7,         8.4,      8.2   -> 2020
    // promedios ->  8.2,         7.5,     5.4   -> 2021
    // promedios ->  8.2,         7.5,     5.4   -> 2022

    // promedio 2020, 2021, 2022
    public double[][] calculateAverages(double[][][] yearly, int numSubjects) {

        double[][] average = new double[yearly.length][numSubjects];
        for (int i = 0; i < yearly.length; i++) {
            for (int j = 0; j < numSubjects; j++) {
                int k = 0;
                for (; k < yearly[i][j].length; k++) {
                    average[i][j] += yearly[i][j][k];
                }
                average[i][j] /= yearly[i][j].length;
            }
        }

        return average;
    }
}
