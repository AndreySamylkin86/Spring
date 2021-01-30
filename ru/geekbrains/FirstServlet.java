package ru.geekbrains;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/firstServlet")
public class FirstServlet implements Servlet {
    private ServletConfig config;

    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    public ServletConfig getServletConfig() {
        return this.config;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().println("<h1>Привет, Андрей!!!</h1>");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
