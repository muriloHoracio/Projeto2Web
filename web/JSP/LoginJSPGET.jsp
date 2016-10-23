<%-- 
    Document   : loginJSP
    Created on : Oct 17, 2016, 2:46:38 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/login.css">
        <title>Login</title>
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
			<nav class="header_navigation">
				<nav class="primary_navigation">
					<ul class="primary_navigation_list">
						<li class="primary_navigation_item">
							<a class="primary_navigation_link" href="">Opcao 1</a>
						</li>
						<li class="primary_navigation_item">
							<a class="primary_navigation_link" href="">Opcao 1</a>
						</li>
						<li class="primary_navigation_item">
							<a class="primary_navigation_link" href="">Opcao 1</a>
						</li>
						<li class="primary_navigation_item">
							<a class="primary_navigation_link" href="">Opcao 1</a>
						</li>
						<li class="primary_navigation_item">
							<a class="primary_navigation_link" href="">Opcao 1</a>
						</li>
						<li class="primary_navigation_item">
							<a class="primary_navigation_link" href="">Opcao 1</a>
						</li>
						<li class="primary_navigation_item">
							<a class="primary_navigation_link" href="">Opcao 1</a>
						</li>
						<li class="primary_navigation_item">
							<a class="primary_navigation_link" href="">Opcao 1</a>
						</li>
					</ul>
				</nav>
			</nav>
		</div>
	</div>
        <div class="main_article">
		<div class="carousel_item-content">
			<div class="carousel_item-content-inner">
				<h1 class="carousel_item-title">Entry Pottermore</h1>
                                <div class="div-form">
                                    <form action="LoginServlet" method="post" accept-charset="utf-8">
                                        <div class="div-form"> 
                                            <div class="text-field_input">
                                                <h2 class="h2_login">Usuário:</h2>    
                                                <input type="text" name="login" class="text-field_input_campo"><br> 
                                            </div>
                                            
                                            <div class="text-field_input">
                                                <h2 class="h2_login">Senha:</h2>
                                                <input type="password" name="senha" class="text-field_input_campo"><br> 
                                            </div>
                                            
                                        </div>
                                        <div>
                                            <input type="submit" value="Logar" class="buttom_logar">
                                        </div>
                                    </form>
                                </div>
                                <h2 class="">Ainda não tem uma conta?</h2>
                                <a href=Inscrevase class="buttom_logar">Inscreva-se</a>
			</div>	
		</div>
	</div>
        <div class="bottom">
		<footer class="footer">
			<h2 class="footer_social_header">
				<span>Find us on</span>
			</h2>
			<div class="footer_social_main social_share">
				<div class="social_button">
					<a href="http://facebook.com/pottermore">
						<span class="social_icon"><img src="IMG/facebook.png" height="16" width="8" style="margin-top:10px;"></span>
					</a>
				</div>
				<div class="social_button">
					<a href="http://facebook.com/pottermore">
						<span class="social_icon"><img src="IMG/twitter.png" height="16" width="16" style="margin-top:10px;"></span>
					</a>
				</div>
				<div class="social_button">
					<a href="http://facebook.com/pottermore">
						<span class="social_icon"><img src="IMG/insta.png" height="16" width="16" style="margin-top:10px;"></span>
					</a>
				</div>
				<div class="social_button">
					<a href="http://facebook.com/pottermore">
						<span class="social_icon"><img src="IMG/tumblr.png" height="16" width="16" style="margin-top:10px;"></span>
					</a>
				</div>
				<div class="social_button">
					<a href="http://facebook.com/pottermore">
						<span class="social_icon"><img src="IMG/gp.png" height="16" width="16" style="margin-top:10px;"></span>
					</a>
				</div>
			</div>
			<div class="footer_sites">
				<ul>
					<li>
						<a href="index.html">about</a>
					</li>
					<li>
						<a href="index.html">press</a>
					</li>
					<li>
						<a href="index.html">faqs</a>
					</li>
					<li>
						<a href="index.html">contact us</a>
					</li>
					<li>
						<a href="index.html">terms & conditions</a>
					</li>
					<li>
						<a href="index.html">privacy & cookies policy</a>
					</li>
					<li>
						<a href="index.html">about</a>
					</li>
				</ul>
			</div>
		</footer>
	</div>
    </body>
</html>
