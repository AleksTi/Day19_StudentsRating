package ru.yandex.sashanc.controllers;

import org.apache.log4j.Logger;
import ru.yandex.sashanc.service.DisciplineServiceImpl;
import ru.yandex.sashanc.service.IDisciplineService;
import ru.yandex.sashanc.service.ILessonService;
import ru.yandex.sashanc.service.LessonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/schedule", name = "scheduleController")
public class ScheduleController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ScheduleController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDisciplineService disciplineService = new DisciplineServiceImpl();
        request.setAttribute("disciplines", disciplineService.getDisciplines());
        if (request.getParameter("disciplineId") != null) {
            ILessonService lessonService = new LessonServiceImpl();
            int disciplineId = Integer.parseInt(request.getParameter("disciplineId"));
            request.setAttribute("lessons", lessonService.getLessonsByDiscipline(disciplineId));
            logger.info("disciplineId = " + disciplineId);
        }
        request.getRequestDispatcher(request.getContextPath() + "pages/schedule.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
