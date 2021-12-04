package com.reservation.backend.api;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
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
        // https://www.liaoxuefeng.com/wiki/1252599548343744/1320418650619938
        // https://www.runoob.com/w3cnote/fastjson-intro.html
        JSONObject respObj = new JSONObject();
        // Hello
        PrintWriter out = response.getWriter();
        // Hello
        out.println(respObj);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies
        ) {
            out.println(cookie.getName() + ": " + cookie.getValue());
        }
        resp.setContentType("application/json");
    }

    public void destroy() {
    }
}
