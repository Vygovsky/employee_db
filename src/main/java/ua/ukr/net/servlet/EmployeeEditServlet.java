package ua.ukr.net.servlet;

import ua.ukr.net.dao.JdbcEmployeeDao;
import ua.ukr.net.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@WebServlet("/editEmployee")
public class EmployeeEditServlet extends HttpServlet {
    private JdbcEmployeeDao employeeDao = new JdbcEmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/employee_update.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        Long id = Long.parseLong(req.getParameter("id"));
        employeeDao.findById(id);
        Employee employee = new Employee();
        employee.setId(id);
        employee.setEmail(req.getParameter("email"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        employee.setBirthday(java.sql.Date.valueOf(date));

        employeeDao.update(employee);

        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/jsp/employee_list.jsp").forward(req, resp);

    }
}
