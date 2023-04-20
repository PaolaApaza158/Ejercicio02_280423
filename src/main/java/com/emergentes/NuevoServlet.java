
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

@WebServlet(name = "NuevoServlet", urlPatterns = {"/NuevoServlet"})
public class NuevoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Nuevo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Crear nueva tarea</h1>");
            out.println("<form action='' method='post'>");
            out.println("<label>Tarea</label><br>");
            out.println("<input type='text' name='tarea'><br>");
            out.println("<input type='submit' value='Enviar'> ");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Tarea = request.getParameter("tarea");
        HttpSession ses = request.getSession();
        ArrayList<String> lista =(ArrayList<String>) ses.getAttribute("lista");
        lista.add(Tarea);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
