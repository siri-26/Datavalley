import java.sql.*;

public class PatientInformationDisplay {
    public static void main(String[] args) {
        try {
            // Establishing connection
            Connection connection = DriverManager.getConnection("jdbc_url", "username", "password");

            // Creating statement
            Statement statement = connection.createStatement();

            // Input patient ID from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter patient ID: ");
            int patientId = scanner.nextInt();

            // SQL query to fetch patient information
            String sql = "SELECT id, name, problem, bill FROM patients WHERE id = " + patientId;

            // Executing query
            ResultSet resultSet = statement.executeQuery(sql);

            // Displaying patient information
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String problem = resultSet.getString("problem");
                double bill = resultSet.getDouble("bill");

                System.out.println("Patient ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Problem: " + problem);
                System.out.println("Bill: " + bill);
            } else {
                System.out.println("Patient not found with ID: " + patientId);
            }

            // Closing resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
