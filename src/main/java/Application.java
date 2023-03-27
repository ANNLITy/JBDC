import DAO.CityDAO;
import DAO.CityDAOImpl;
import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import src.main.java.model.City;
import src.main.java.model.Employee;


public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City city = new City("Belgorod");
        cityDAO.create(city);

        Employee employee = new Employee(33, "Anton", "Antonov", "male", 27, city);
        employeeDAO.create(employee);

        for (Employee employee1 : employeeDAO.readAll()) {
            System.out.println(employee1);
        }

        for (City city1 : cityDAO.readAll()) {
            System.out.println(city1);
        }
    }
}