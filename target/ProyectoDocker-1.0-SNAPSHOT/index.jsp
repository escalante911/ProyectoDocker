<%-- 
    Document   : index
    Created on : 15/02/2021, 10:09:19 AM
    Author     : joescalante
--%>


<%@page import="com.mycompany.proyectodocker.Usuarios"%>
<%@page import="DAO.UsuariosDaoMysql"%>
<%@page import="conexion.Conexion"%>
<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/style.css"> 
    </head>
    <body>
        
        <div class="wrapper fadeInDown">
        <div id="formContent">
          <!-- Tabs Titles -->
      
          <!-- Icon -->
          <div class="fadeIn first">
            
          </div>
      
          <!-- Login Form -->
          <form action="index.jsp" method="post">
            <input type="text" name="nameh" class="fadeIn second" name="name" placeholder="name" required="required">
            <input type="text" name="edad" class="fadeIn second" name="edad" placeholder="edad" required="required">
            <input type="submit" name="enviar" class="fadeIn fourth" value="Agregar Dato">
          </form>
          
          <%
            UsuariosDaoMysql us =new UsuariosDaoMysql();
             if (request.getParameter("enviar") != null) {
                String nombre = request.getParameter("nameh");
                String edad = request.getParameter("edad");
                us.insertar(nombre, edad);
            }
              %>     
        </div>
      </div>
    </body>
</html>
