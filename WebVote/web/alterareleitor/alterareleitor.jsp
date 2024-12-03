<%-- 
    Document   : alterareleitor
    Created on : Dec 3, 2024, 2:56:45 AM
    Author     : helel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.eleitor"%>
<%@page import="model.dao.eleitorDAO"%>
<%@page import="java.text.*"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eleitor - Alterar</title>
        <link href="../bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
     <body>
        <h3>Eleitor - Dados</h3>
        <%           
        //Entrada/Receber
            int id = Integer.parseInt(request.getParameter("id"));
            
            // Instância e atrib de valor
            eleitor eleit = new eleitor();
            eleit.setId(id);
            //Select
            eleitorDAO eleitDAO = new eleitorDAO();
            if(eleitDAO.veriVoto(eleit)!= null){
            %>
                <b>Campos</b> <br>
                <form method="post" action="cadastrareleitor.jsp">
                Identificação: <input type="text" name="ident" value="<%= eleit.getId()%>" readonly="true"> <p>                    
                    Nome: <input type="text" name="nome" value="<%= eleit.getNome()%>" minlength="5" maxlength="10" > <p>             
            <%    
            }else{
               out.println("Registro não encontrado!!!");
            }

        %>
        <script src="../bootstrap.bundle.min.js"></script>
    </body>
</html>