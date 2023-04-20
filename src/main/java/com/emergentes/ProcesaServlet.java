
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Tarea = request.getParameter("tarea");
        HttpSession ses = request.getSession();
        ArrayList<String> lista =(ArrayList<String>) ses.getAttribute("lista");
        
        lista.remove(Tarea);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
