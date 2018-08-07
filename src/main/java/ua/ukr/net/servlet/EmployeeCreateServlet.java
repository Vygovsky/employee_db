package ua.ukr.net.servlet;

import ua.ukr.net.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/create")
public class EmployeeCreateServlet extends HttpServlet {
    private Employee employee;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/employee_create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String name = req.getParameter("name");
        String mail = req.getParameter("mail");
        String date = req.getParameter("date");
*/
        resp.setCharacterEncoding("UTF-8");

        employee.setName(req.getParameter("name"));
        employee.setEmail(req.getParameter("mail"));
        employee.setBirthday(req.getParameter("date"));

        req.setAttribute("user", employee);
        doGet(req, resp);


    }
}
