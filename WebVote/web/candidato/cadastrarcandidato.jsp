<%-- 
    Document   : cadastroeleitor
    Created on : Dec 3, 2024, 2:47:12 AM
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
        <h3>Candidato</h3>
        <%
        //Entrada/Receber
        String nome = request.getParameter("nome");
        String partido = request.getParameter("partido");
        int votos = 0;
        // Instância e atrib de valor
        candidato cand = new candidato();
        cand.setNome(nome);
        cand.setPartido(partido);     
        cand.setVotos(votos);
        //Insert
        candidatoDAO candDAO = new candidatoDAO();
        if(candDAO.insCandidato(cand)){
            out.println("Registro inserido com sucesso!");
        }else{
           out.println("Erro! Registro não inserido!!!");
        }
        %>
        <script src="../bootstrap.bundle.min.js"></script>
    </body>
</html>
