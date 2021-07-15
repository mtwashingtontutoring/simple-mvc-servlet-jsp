package com.example.simple_mvc.controllers;

import com.example.simple_mvc.models.Model;

import java.io.*;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/reservations")
public class FormServlet extends HttpServlet {
    public final String TEMPLATE_BASE = "/WEB-INF/jsp";
    public final String RESERVATION_FORM = TEMPLATE_BASE + "/reservation-form.jsp";
    public final String RESERVATION_SUMMARY_FORM = TEMPLATE_BASE + "/reservation-summary.jsp";

    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp
    ) {
        // set any necessary request attributes
        req.setAttribute("formName", "My Form");

        try {
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher(RESERVATION_FORM);

            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest req, HttpServletResponse resp
    ) {
        try {
            // get the form variables from the
            String param1 = req.getParameter("param1");
            String param2 = req.getParameter("param2");
            String param3 = req.getParameter("param3");
            String param4 = req.getParameter("param4");

            // Do validation here
            boolean hasErrors = false;

            Model model = new Model();

            try {
                model.setParam1(Integer.parseInt(param1));
                if(model.getParam1() < 0 || model.getParam1() > 12) {
                    throw new Exception();
                }
            } catch(Exception e) {
                hasErrors = true;
                model.setParam1(null);
                req.setAttribute("param1Errors", "must enter a number from 0-12");
            }

            if (param2.length() == 1 && "abc".contains(param2)) {
                model.setParam2(param2.charAt(0));
            } else{
                hasErrors = true;
                model.setParam2(null);
                req.setAttribute("param2Errors", "must enter a, b or c");
            }

            try {
                model.setParam3(LocalDate.parse(param3));
            } catch(Exception e) {
                hasErrors = true;
                model.setParam3(null);
                req.setAttribute("param3Errors", "must enter a valid date");
            }

            if (param4.length() >= 6) {
                model.setParam4(param4);
            } else{
                hasErrors = true;
                model.setParam4(null);
                req.setAttribute("param4Errors", "must enter 6 char min");
            }

            req.setAttribute("model", model);

            if(hasErrors) {
                doGet(req, resp);
                return;
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher(RESERVATION_SUMMARY_FORM);
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}