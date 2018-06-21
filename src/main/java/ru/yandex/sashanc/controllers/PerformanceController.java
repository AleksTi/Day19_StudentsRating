package ru.yandex.sashanc.controllers;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/students/performance", name = "performanceController")
public class PerformanceController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ru.yandex.sashanc.controllers.PerformanceController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("requestResource", "Hello from performance controller");
        request.getRequestDispatcher(request.getContextPath() + "/pages/performance.jsp").forward(request, response);
        logger.info("Method PerformanceController.doGet() have done");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
