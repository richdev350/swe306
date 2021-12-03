package com.reservation.backend.api;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.*;

@WebServlet(name = "LoginTest", value = "/api/test/login")
public class LoginTest extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        // Hello
        PrintWriter out = response.getWriter();
        out.println(message);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // an json example
        // https://www.liaoxuefeng.com/wiki/1252599548343744/1320418650619938
        // https://www.runoob.com/w3cnote/fastjson-intro.html
        JSONObject respObj = new JSONObject();
        resp.setContentType("application/json");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println(respObj);

    }

    public void destroy() {
    }
}
