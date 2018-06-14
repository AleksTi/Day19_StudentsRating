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

@WebServlet(urlPatterns = "/registration", name = "regController")
public class RegistrationController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(RegistrationController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath() + "pages/registration.jsp").forward(req, resp);
        logger.info("Method \"LoginController.doGet()\" have done");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        PersonService personService = new PersonService();

        if (personService.createPerson(name, surname, email, password, role)) {
            Person person = personService.getPersonByEmail(email);
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("surname", surname);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("role", person.getRole());
            request.getRequestDispatcher(request.getContextPath() + "/").forward(request, response);
            logger.info("\"if\" condition of method \"RegistrationController.doPost()\" have done");
            logger.info("Регистрация нового пользователя выполнена - " + name + " - " + surname + " - " + email + " - " + password + " - " + role);
        } else {
            request.setAttribute("regResult", "regFalse");
            request.getRequestDispatcher(request.getContextPath() + "pages/registration.jsp").forward(request, response);
            logger.info("\"else\" condition of Method \"RegistrationController.doPost()\" have done");
            logger.info("Регистрация нового пользователя НЕ выполнена - " + name + " - " + surname + " - " + email + " - " + password + " - " + role);
        }
        logger.info("Method \"LoginController.doPost()\" have done");
    }
}
