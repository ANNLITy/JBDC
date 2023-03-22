import POJO.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee(11, "Alla", "Sergeevna", "female", 2, 1);

        employeeDAO.create(employee);

        System.out.println(employeeDAO.readById(12));

        List<Employee> employeeList = employeeDAO.readAll();

        for (Employee employee1 : employeeList) {
            System.out.println(employee1);
        }

        employee = new Employee(4, "Sergey", "Andreev", "male", 30, 2);

        employeeDAO.updateEmployee(employee);

        System.out.println(employeeDAO.readById(12));

        employeeDAO.delete(employee);

        employeeList = employeeDAO.readAll();

        for (Employee employee1 : employeeList) {
            System.out.println(employee1);
        }
    }
}