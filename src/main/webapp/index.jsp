<%@page import="java.util.ArrayList"%>
<%
    
    if(session.getAttribute("lista") == null){
        ArrayList<String> lis = new ArrayList<String>();
        session.setAttribute("lista",lis);
    }
    ArrayList<String> lista = (ArrayList<String>)session.getAttribute("lista");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><center>Gestor de tareas</center></h1>
        <h3><center>Nombre: Paola Alejandra Apaza Quispe</center></h3>
        <a href="NuevoServlet">Nuevo<br></a>
        
        <h3>Tabla de tareas</h3>
        
        <table border="1" cellspacing="0" cellpadding="5px">
            <tr>
                <td>id</td>
                <td>Tarea</td>
                <td>Completado</td>
                <td> </td>
                
            </tr>
            <%
            int c=0;
            if(lista != null){
               for(String item : lista){
                   //c++;
                   c=lista.indexOf(item)+1;
            %>
            <tr>
                <td><%= c %></td>
                <td><%= item %></td>
                <td>
                    <input type="checkbox" name="completo" value="" />
                </td>
                <td>
                    <a href="EditarServlet?tarea=<%= item %>">Editar</a>
                    <a href="ProcesaServlet?tarea=<%= item %>">Eliminar</a>
                </td>
            </tr>
            <%
                }
            }
            %>
        </table>
    </body>
</html>


