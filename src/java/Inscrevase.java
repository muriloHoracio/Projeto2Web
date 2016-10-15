/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author murilo
 */
@WebServlet(urlPatterns = {"/Inscrevase"})
public class Inscrevase extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inscrevase</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadastro de usuário</h1>");
            out.println("<form action=\"Inscrevase\" method=\"post\" accept-charset=\"utf-8\">");
            out.println("Nome: <input type=\"text\" name=\"nome\" class=\"text-field\"><br>");
            out.println("E-mail: <input type=\"text\" name=\"email\" class=\"text-field\"><br>");
            out.println("Login: <input type=\"text\" name=\"login\" class=\"text-field\"><br>");
            out.println("Senha: <input type=\"text\" name=\"senha\" class=\"text-field\"><br>");
            out.println("Estado: <input type=\"text\" name=\"estado\" class=\"text-field\"><br>");
            out.println("Cidade: <input type=\"text\" name=\"cidade\" class=\"text-field\"><br>");
            out.println("Bairro: <input type=\"text\" name=\"bairro\" class=\"text-field\"><br>");
            out.println("Rua: <input type=\"text\" name=\"rua\" class=\"text-field\"><br>");
            out.println("Numero: <input type=\"text\" name=\"numero\" class=\"text-field\"><br>");
            out.println("<input type=\"submit\" value=\"Cadastrar\" class=\"buttom\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO userDao = new UsuarioDAO();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login de usuário</h1>");
            if(userDao.insereUsuario(request.getParameter("nome"),request.getParameter("email"),request.getParameter("login"),request.getParameter("senha"),request.getParameter("estado"),request.getParameter("cidade"),request.getParameter("bairro"),request.getParameter("rua"),request.getParameter("numero"))){
                out.println("<h1>Usuário Cadastrado com Sucesso!</h1>");
                out.println("<a href=\"Login\">Fazer login</a>");
            } else {
                out.println("<h1>Houve um problema ao tentar cadastrar o usuário</h1>");
                out.println("<a href=\"Inscrevase\">Tente novamente</a>");
            }
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
