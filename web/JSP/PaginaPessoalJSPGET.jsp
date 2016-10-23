<%-- 
    Document   : PaginaPessoaJSP
    Created on : Oct 18, 2016, 7:33:06 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Página Pessoal do Usuário</h1>
            <form action="PaginaPessoalClone" method="post" accept-charset="utf-8">
            <input type="hidden" name="sair" value="true" class="text-field"><br>
            <input type="submit" value="Sair" class="buttom">
            </form>
    </body>
</html>
