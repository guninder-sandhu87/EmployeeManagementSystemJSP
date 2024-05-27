package dao;

import entity.Employee;
import entity.User;

public interface DbDao {

    public void insertAdminUser(User user);

    public void insertEmployee(Employee employee);

    public Employee searchEmployeeById(int id);

    public Employee searchEmployeeByName(String name);

    public void removeEmployee(Employee employee);

    public Employee[] listAllEmployee();


}
