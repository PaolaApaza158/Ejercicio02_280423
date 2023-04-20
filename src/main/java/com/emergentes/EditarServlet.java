
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

@WebServlet(name = "EditarServlet", urlPatterns = {"/EditarServlet"})
public class EditarServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Editar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Editar Tarea</h1>");
            out.println("<form action='' method='post'>");
            out.println("<label>Id a editar</label><br><br>");
            out.println("<input type='int' name='id'><br>");
            out.println("<label>Tarea</label><br><br>");
            out.println("<input type='text' name='editada'><br>");
            out.println("<input type='submit' value='Enviar'> ");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Tarea = request.getParameter("editada");
        int Id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<String> lista =(ArrayList<String>) ses.getAttribute("lista");
        lista.set((Id-1), Tarea);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    
    }
}
