package com.sangle.example.dispatcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CustomServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(CustomServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("CustomServlet doGet() method is invoked");
        req.getRequestDispatcher("/user").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         System.err.println("CustomServlet doPost() method is invoked");
        super.doPost(req, resp);
    }
}