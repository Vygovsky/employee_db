package ua.ukr.net.servlet;

import ua.ukr.net.dao.JdbcEmployeeDao;
import ua.ukr.net.model.Department;
import ua.ukr.net.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@WebServlet("/editEmployee")
public class EmployeeEditServlet extends HttpServlet {
    private JdbcEmployeeDao employeeDao = new JdbcEmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong( req.getParameter("id"));
        Employee employee = employeeDao.findById(id);
        req.setAttribute("employee", employee);
        req.getServletContext().getRequestDispatcher("/jsp/employee_update.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        Employee employee = new Employee();
        Department department=new Department();
        String id = req.getParameter("id");
        employee.setId(Long.parseLong(id));
        employee.setName(req.getParameter("name"));
        employee.setEmail(req.getParameter("email"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        employee.setBirthday(java.sql.Date.valueOf(date));
        department.setName(req.getParameter("organization"));
        employee.setDepartment(department);

        PrintWriter writer=resp.getWriter();
        writer.println("Organization : "+employee.getDepartment());

        employeeDao.update(employee);

        req.setAttribute("employee", employee);
        resp.sendRedirect("/employee/listEmployee");
        //req.getRequestDispatcher("/jsp/employee_list.jsp").forward(req, resp);

    }
}