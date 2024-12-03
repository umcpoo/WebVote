<%-- 
    Document   : excluircandidato
    Created on : Dec 3, 2024, 2:30:18 AM
    Author     : helel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.candidato"%>
<%@page import="model.dao.candidatoDAO"%>
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
        candidato cand = new candidato();
        cand.setId(id); 
       
        //Apagar
        candidatoDAO candDAO = new candidatoDAO();
        if(candDAO.delCandidato(cand)){
            out.println("Registro excluído com sucesso!");
        }else{
           out.println("Erro! Registro não excluído!!!");
        }
        %>
        <script src="../bootstrap.bundle.min.js"></script>
    </body>
</html>
