package dao;

import entity.Employee;
import entity.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;


public class DbDaoImplementation implements DbDao {

    private Connection dbConnection;
    private final Logger logger = LogManager.getLogger();

    private void getConnection() {
        //String url = "jdbc:mysql://localhost:3306/EmployeeManagement";
        //this is to run on docker as have named mysql container as mysql_compose in docker compose file
        String url = "jdbc:mysql://mysql_compose:3306/EmployeeManagement";
        String userName = "root";
        String password = "password";

        try {

            logger.info("Trying to connect to db");
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, userName, password);
            logger.info("Connected");


        } catch (SQLException sqlException) {

            logger.error("Error in connecting to db", sqlException);
        } catch (ClassNotFoundException e) {
            logger.error("Error in connecting to db", e);
        }


    }


    @Override
    public void insertAdminUser(User user) {
        getConnection();
        String insertUserQuery = "INSERT INTO USERS (userName,constants.Role) VALUES (?,?)";
        PreparedStatement insertUser=null;
        try {

            insertUser = dbConnection.prepareStatement(insertUserQuery);
            int row = insertUser.executeUpdate();
            logger.info("inserted {} rows in user table ", row);
        } catch (SQLException e) {
            logger.error("Unable to insert User. ", e);
        }
        finally{
            closePreparedStatementAndConnection(insertUser);
        }
    }

    @Override
    public boolean validateUser(String userName, String password) {
        getConnection();
        String validateUserQuery = "SELECT pass FROM Credential WHERE userName=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbConnection.prepareStatement(validateUserQuery);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return false;
            } else if (!resultSet.isBeforeFirst()) {
                logger.info("  No employee found with name {} ", userName);
                return false;
            } else {
                resultSet.next();
                if (resultSet.getString("pass").equals(password)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            logger.error("Unable to verify user :", e);
        } finally {
            closePreparedStatementAndConnection(preparedStatement);
        }
        return false;
    }

    @Override
    public void insertEmployee(Employee employee) {
        getConnection();
        logger.info("Trying to insert employee");
        String insertEmployeeQuery = "INSERT INTO `EMPLOYEE`(firstName,lastName,age,position,salary) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbConnection.prepareStatement(insertEmployeeQuery);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3,employee.getAge());
            preparedStatement.setString(4,employee.getPosition());
            preparedStatement.setDouble(5,employee.getSalary());
            int row = preparedStatement.executeUpdate();
            logger.info("employee added");
        } catch (SQLException exception) {
            logger.error("Unable to insert employee",exception);
        }
        finally {
            closePreparedStatementAndConnection(preparedStatement);
        }


    }

    @Override
    public Employee searchEmployeeById(int id) {
        getConnection();
        return null;
    }

    @Override
    public Employee searchEmployeeByName(String name) {
        getConnection();
        return null;
    }

    @Override
    public void removeEmployee(Employee employee) {
        getConnection();

    }

    @Override
    public Employee[] listAllEmployee() {
        getConnection();
        return new Employee[0];
    }

    private void closePreparedStatementAndConnection(PreparedStatement preparedStatement) {

        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            logger.error("Unable to close prepared statement {}", preparedStatement, e);
        }
        try {
            if (dbConnection != null) {
                logger.info("Closing db connection");
                dbConnection.close();
                logger.info("closed");
            }
        } catch (SQLException e) {
            logger.error("Unable to close connection", e);
        }
    }
}
