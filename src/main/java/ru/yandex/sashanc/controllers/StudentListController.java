package ru.yandex.sashanc.controllers;

import ru.yandex.sashanc.service.IPersonService;
import ru.yandex.sashanc.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/teachers/studentlist", name = "studentLIstController")
public class StudentListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IPersonService personService = new PersonService();
        request.setAttribute("students", personService.getPersons("student"));
        request.getRequestDispatcher(request.getContextPath() + "/pages/students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
