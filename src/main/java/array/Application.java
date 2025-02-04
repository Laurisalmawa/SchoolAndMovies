package array;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        School school = new School();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to your school, how would you like to get your grades averages?: ");
        System.out.println("1. By array ");
        System.out.println("2. By list ");
        System.out.println("3. Yearly by array ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                school.giveAverageGradesArray();
                break;
            case 2:
                school.giveAverageGradesList();
                break;
            case 3:
                school.giveAverageGrades3dArray();
                break;
            default:
        }

        String[][] x = new String[][] {
                {"4","3","5"},
                {"2","4","5"}
        };
        List<List<String>> y = List.of(
                List.of("4","5","3"),
                List.of("2","5","3","4")
        );

    }

    public static int readNumber(String requirement) {
        System.out.println(requirement);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}