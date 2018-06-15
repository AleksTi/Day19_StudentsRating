package ru.yandex.sashanc.controllers;

import org.apache.log4j.Logger;
import ru.yandex.sashanc.pojo.Person;
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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        PersonService personService = new PersonService();
        Person person = personService.getPersonByEmail(email);

        if (personService.checkPerson(person, pass)) {
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("role", person.getRole());
            request.getSession().setAttribute("name", person.getName());
            request.getSession().setAttribute("surname", person.getSurname());
            request.getRequestDispatcher(request.getContextPath() + "/").forward(request, response);
            logger.info("\"if\" condition of Method \"LoginController.doPost()\" have done");
        } else {
            request.setAttribute("message", "authErr");
            request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request, response);
            logger.info("\"else\" condition of Method \"LoginController.doPost()\" have done");
        }
        logger.info("Method \"LoginController.doPost()\" have done");
    }
}
