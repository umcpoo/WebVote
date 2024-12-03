<%-- 
    Document   : excluireleitor
    Created on : Dec 3, 2024, 2:33:44 AM
    Author     : helel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.*"%>
<%@page import="model.eleitor"%>
<%@page import="model.dao.eleitorDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h3>Exclusão</h3>
        <%
        //Entrada/Receber
         int id = Integer.parseInt(request.getParameter("id"));
         // Instância e atrib de valor
        eleitor eleit = new eleitor();
        eleit.setId(id); 
        //Apagar
        eleitorDAO eleitDAO = new eleitorDAO();
        if(eleitDAO.delEleitor(eleit)){
            out.println("Registro excluído com sucesso!");
        }else{
           out.println("Erro! Registro não excluído!!!");
        }
        %>
        <script src="../bootstrap.bundle.min.js"></script>
    </body>
</html>

