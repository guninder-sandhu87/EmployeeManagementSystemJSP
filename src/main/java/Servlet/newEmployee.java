package Servlet;

import dao.DbDao;
import dao.DbDaoImplementation;
import entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;

public class newEmployee extends HttpServlet {
    private final Logger logger = LogManager.getLogger();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");

        String position = req.getParameter("position");
        int age=0;
        double salary=0;
        try{
           age = Integer.parseInt(req.getParameter("age"));
           salary = Double.parseDouble(req.getParameter("salary"));
        }
        catch(NumberFormatException numberFormatException){
            logger.error("unable to convert from String {}",numberFormatException.getMessage());
        }
        Employee employee = new Employee(fname,lname,age,position,salary);
        DbDao dbDao = new DbDaoImplementation();
        dbDao.insertEmployee(employee);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Employee Added</h1>");


    }
}
