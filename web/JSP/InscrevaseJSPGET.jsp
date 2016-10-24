<%-- 
    Document   : InscrevaseJSP
    Created on : Oct 23, 2016, 4:03:12 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Inscreva-se</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/inscrevaseJSPGET.css">
    </head>
    <body>
        <div class="header">
		<div class="header_inner">
			<div class="header_menu">
				<span class="header_toggle header_toggle_discover">
					<img class="img_discover" src="IMG/discover.png" height="28" width="28">
				</span>
				<span class="header_toggle header_toggle_menu">
					<span></span>
				</span>
				<a class="header_logo" href="index.html">
					<span class="header_logo_img">
						<img class = "header_logo_img" src="IMG/Pottermore.png">
					</span>
				</a>
				<span class="header_toggle header_toggle_cart">Cart</span>
			</div>
		</div>
	</div>
        <div class="main_article">
		<div class="carousel_item-content">
			<div class="carousel_item-content-inner">
				<h1>Cadastro de usuário</h1>
                                <form action="InscrevaseServlet" method="post" accept-charset="utf-8">
                                    Nome: <input type="text" name="nome" class="text-field"><br>
                                    E-mail: <input type="text" name="email" class="text-field"><br>
                                    Login: <input type="text" name="login" class="text-field"><br>
                                    Senha: <input type="text" name="senha" class="text-field"><br>
                                    Estado: <input type="text" name="estado" class="text-field"><br>
                                    Cidade: <input type="text" name="cidade" class="text-field"><br>
                                    Bairro: <input type="text" name="bairro" class="text-field"><br>
                                    Rua: <input type="text" name="rua" class="text-field"><br>
                                    Numero: <input type="text" name="numero" class="text-field"><br>
                                    <input type="submit" value="Cadastrar" class="buttom">
                                </form>
			</div>	
		</div>
	</div>
        
    </body>
</html>
