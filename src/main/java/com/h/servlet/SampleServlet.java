package com.h.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * 最基础的servlet
 */
public class SampleServlet extends HttpServlet {

    // gradle jetty: http://localhost:23001/hang535/servlet
    // maven jetty: http://localhost:23001/servlet
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        OutputStream stream = null;
        try {
            HttpSession session = request.getSession(); // 如果不调用request.getSession()，则不会自动生成session
            session.setAttribute("f", 111);
            session.setAttribute("g", "wolegequ");


            StringBuilder sb = new StringBuilder();
            sb.append(String.format("request:%s", request.getRequestURL().toString())).append("\r\n");
            sb.append("Nice to meet you.");

            String requestURI = sb.toString();
            stream = response.getOutputStream();
            stream.write(requestURI.getBytes("UTF-8"));

        } catch (IOException e) {
            e.printStackTrace();
            if (null != stream) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}