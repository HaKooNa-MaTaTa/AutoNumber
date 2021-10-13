package com.igonincompany.autonumber.servlets;

import com.igonincompany.autonumber.utils.CreateNumber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/next")
public class NextServlet extends HttpServlet {

    CreateNumber createNumber = new CreateNumber();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("Unicode");
        PrintWriter printWriter = response.getWriter();

        printWriter.println(createNumber.createNumber(CreateNumber.NEXT));
    }
}