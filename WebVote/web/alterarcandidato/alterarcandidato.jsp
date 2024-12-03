<%-- 
    Document   : alterareleitor
    Created on : Dec 3, 2024, 2:56:45 AM
    Author     : helel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.candidato"%>
<%@page import="model.dao.candidatoDAO"%>
<%@page import="java.text.*"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Candidato - Alterar</title>
        <link href="../bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
     <body>
        <h3>Candidato - Dados</h3>
        <%           
        //Entrada/Receber
            int id = Integer.parseInt(request.getParameter("id"));
            
            // Instância e atrib de valor
            candidato cand = new candidato();
            cand.setId(id);
            //Select
            candidatoDAO candDAO = new candidatoDAO();
            if(candDAO.conscandid(cand)!= null){
            %>
                <b>Campos</b> <br>
                <form method="post" action="cadastrareleitor.jsp">
                Identificação: <input type="text" name="ident" value="<%= cand.getId()%>" readonly="true"> <p>                    
                    Nome: <input type="text" name="nome" value="<%= cand.getNome()%>" minlength="5" maxlength="10" > <p>
                    Partido <input type="text" name="partido" value="<%= cand.getPartido()%>" minlength="5" maxlength="10" > <p>             
            <%    
            }else{
               out.println("Registro não encontrado!!!");
            }

        %>
        <script src="../bootstrap.bundle.min.js"></script>
    </body>
</html>