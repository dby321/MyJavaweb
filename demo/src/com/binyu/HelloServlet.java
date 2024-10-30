package com.binyu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author dongbinyu
 * @version 1.0
 * @project MyJavaweb
 * @description hello servlet
 * @date 2024/10/30 21:25:11
 */
@WebServlet(name = "helloServlet",value = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        PrintWriter writer=resp.getWriter();
        writer.println("hello "+username);
    }
}
