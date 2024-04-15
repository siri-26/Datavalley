import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Project {
    private String studentName;
    private int completionTime;

    public Project(String studentName, int completionTime) {
        this.studentName = studentName;
        this.completionTime = completionTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getCompletionTime() {
        return completionTime;
    }
}

public class StudentProjectAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Project> projects = new ArrayList<>();

        // Input number of projects
        System.out.print("Enter the number of student projects: ");
        int numOfProjects = scanner.nextInt();

        // Input project details
        for (int i = 1; i <= numOfProjects; i++) {
            System.out.println("Enter details for project " + i + ":");
            System.out.print("Student name: ");
            String studentName = scanner.next();
            System.out.print("Completion time (in days): ");
            int completionTime = scanner.nextInt();
            projects.add(new Project(studentName, completionTime));
        }

        // Analyze projects
        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        double totalCompletionTime = 0;

        for (Project project : projects) {
            totalCompletionTime += project.getCompletionTime();
            if (project.getCompletionTime() == 0) {
                onTimeCount++;
            } else if (project.getCompletionTime() > 0) {
                lateCount++;
            } else {
                earlyCount++;
            }
        }

        // Calculate average completion time
        double averageCompletionTime = totalCompletionTime / numOfProjects;

        // Display results
        System.out.println("\nProject Analysis:");
        System.out.println("Number of projects completed on time: " + onTimeCount);
        System.out.println("Number of projects completed late: " + lateCount);
        System.out.println("Number of projects completed early: " + earlyCount);
        System.out.println("Average completion time (in days): " + averageCompletionTime);

        scanner.close();
    }
}
