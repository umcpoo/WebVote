<%-- 
    Document   : cadastrareleicao
    Created on : Dec 3, 2024, 3:22:49 AM
    Author     : helel
--%>

<%@page import="model.dao.eleicaoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.*"%>
<%@page import="model.eleitor"%>
<%@page import="model.dao.eleitorDAO"%>
<%@page import="model.eleicao"%>
<%@page import="model.candidato"%>
<%@page import="model.dao.candidatoDAO"%>
<%@page import="model.dao.eleitorDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eleicao - cadastro</title>
        <link href="../bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h3>Cadastro</h3>
        <%                    
            //Select "Geral"
            eleicaoDAO eleiDAO = new eleicaoDAO();
            candidatoDAO candDAO = new candidatoDAO();
            List<candidato> lista = new ArrayList<>();
            lista = candDAO.listarcandidatos();
            eleicao eleic = new eleicao();
            eleic.abrirEleicao();
            eleic.setCandidatos(lista);
            for ( int i = 0; i <= lista.size()-1; i++)
            {
                out.println(eleic.getCandidatos().get(i).getNome());
                out.println(eleic.getCandidatos().get(i).getPartido());
            }
            if(eleiDAO.salvar(eleic))
            {
            out.println("Eleiçao criada com sucesso!");
            }   else
            {
                out.println("Erro! eleiçao não criada!!!");
            }
        %>
        <script src="../bootstrap.bundle.min.js"></script> 
    </body>
</html>
