package dao;

import entity.Employee;
import entity.User;

import java.sql.*;



public class DbDaoImplementation implements DbDao{

    private Connection dbConnection;

    private void getConnection(){
        String url="";
        String user="";
        String password="";
        try {
            DriverManager.getConnection(url, user, password);
        }catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }
    @Override
    public void insertAdminUser(User user) {

    }

    @Override
    public void insertEmployee(Employee employee) {

    }

    @Override
    public Employee searchEmployeeById(int id) {
        return null;
    }

    @Override
    public Employee searchEmployeeByName(String name) {
        return null;
    }

    @Override
    public void removeEmployee(Employee employee) {

    }

    @Override
    public Employee[] listAllEmployee() {
        return new Employee[0];
    }
}
