import java.sql.*;
import java.util.Scanner;

class Department {
    private int id;
    private String name;

    // Constructor
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class StoreDepartmentInDatabase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input department details
        System.out.print("Enter department ID: ");
        int departmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter department name: ");
        String departmentName = scanner.nextLine();

        // Create Department object
        Department department = new Department(departmentId, departmentName);

        // Store Department object in database
        storeDepartment(department);

        scanner.close();
    }

    // Method to store Department object in database
    public static void storeDepartment(Department department) {
        String url = "jdbc:mysql://localhost/departments"; // Database URL
        String username = "your_username"; // Database username
        String password = "your_password"; // Database password

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO department (id, name) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set values for PreparedStatement
            preparedStatement.setInt(1, department.getId());
            preparedStatement.setString(2, department.getName());

            // Execute the PreparedStatement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Department inserted successfully.");
            } else {
                System.out.println("Failed to insert department.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
