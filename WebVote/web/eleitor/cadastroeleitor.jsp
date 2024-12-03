<%-- 
    Document   : cadastroeleitor
    Created on : Dec 3, 2024, 2:47:12 AM
    Author     : helel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h3>Eleitor</h3>
        <%
        //Entrada/Receber
        String nome = request.getParameter("nome");
        boolean votou = false;

        // Instância e atrib de valor
        eleitor eleit = new eleitor();
        eleit.setNome(nome);
        eleit.setVotou(votou);      
        //Insert
        eleitorDAO eleitDAO = new eleitorDAO();
        if(eleitDAO.insEleitor(eleit)){
            out.println("Registro inserido com sucesso!");
        }else{
           out.println("Erro! Registro não inserido!!!");
        }
        %>
        <script src="../bootstrap.bundle.min.js"></script>
    </body>
</html>
