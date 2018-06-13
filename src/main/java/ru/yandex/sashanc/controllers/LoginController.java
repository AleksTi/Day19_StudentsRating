package ru.yandex.sashanc.controllers;

import org.apache.log4j.Logger;
import ru.yandex.sashanc.data.dao.IPersonDao;
import ru.yandex.sashanc.data.dao.PersonDaoImpl;
import ru.yandex.sashanc.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login", name = "loginController")
public class LoginController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LoginController.class);
    IPersonDao personDao = new PersonDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String catId = req.getParameter("id");
        resp.getWriter().println("Hello from Servlet. I'm very glad to see you! Your parameter is = " + catId);
        logger.info("\"HelloServlet.doGet()\" method have done");
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setAttribute("message", "Hello from setAttribute() method!");
//        request.getRequestDispatcher("/login.jsp").forward(request, response);
//        logger.info("\"LoginServlet.doGet()\" method have done");
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        if ("email".equals(email) && "password".equals(pass)) {
            request.getSession().setAttribute("email", email);
            PersonService personService = new PersonService();
            request.setAttribute("students", personService.getPersons("student"));
            request.getRequestDispatcher(request.getContextPath() + "pages/students.jsp").forward(request, response);
            //response.sendRedirect(request.getContextPath() + "pages/students.jsp");
        } else {
            request.setAttribute("message", "authErr");
            request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request, response);
        }
        logger.info("\"LoginServlet.doPost()\" method have done");
    }
}
