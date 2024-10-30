package com.binyu;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author dongbinyu
 * @version 1.0
 * @project MyJavaweb
 * @description hello servlet
 * @date 2024/10/30 21:25:11
 */
//@WebServlet(name = "helloServlet",value = "/hello",initParams = {
//        @WebInitParam(name = "username",value = "binyu"),
//        @WebInitParam(name = "password",value = "123456")
//})
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        ServletConfig servletConfig = getServletConfig();
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name=initParameterNames.nextElement();
            String value=servletConfig.getInitParameter(name);
            System.out.println(name+"--"+value);
        }
//        应用域 getServletContext();
//        URL:http://localhost:8080/demo/hello.html
//        URI:/demo/hello.html
        ServletContext servletContext = getServletContext();
        ServletContext servletContext1 = req.getServletContext();
        ServletContext servletContext2 = servletConfig.getServletContext();
        System.out.println(servletContext==servletContext1);
        System.out.println(servletContext==servletContext2);
//        context-param
        System.out.println(servletContext.getContextPath());
        System.out.println(servletContext.getRealPath("/upload"));
        String characterEncoding = resp.getCharacterEncoding();
        System.out.println(characterEncoding);
//        解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        writer.println("hello "+username);
    }

}
