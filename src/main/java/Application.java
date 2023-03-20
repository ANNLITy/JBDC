import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "25SchooL";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

            statement.setInt(1, 1);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String firstName = "First_name: " + resultSet.getString(2);
                String secondName = "Last_name: " + resultSet.getString(3);
                String gender ="Gender: " + resultSet.getString(4);
                int age = resultSet.getInt(5);
                String cityID = "City_id: " + resultSet.getString(6);


                System.out.println(firstName);
                System.out.println(secondName);
                System.out.println(gender);
                System.out.println(age);
                System.out.println(cityID);


            }
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            Employee employee = new Employee(9, "Andrey", "Andreev", "male", 32, 1);
            employeeDAO.create(employee);

            employeeDAO.deleteById(7);

            employeeDAO.updateEmployeeById(4, employee);
            List<Employee> employees = employeeDAO.readAll();

            for (Employee employee1 : employees) {
                System.out.println(employee1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}