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
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            out.println("<title>Login</title>");            
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=CSS/paginaPessoal.css>");
            out.println("</head>");
            out.println("<body>");
            out.println("<span class=\"pageTitle\">Login de usuário</span>");
            out.println("<div class=\"centerBox\">");
            out.println("   <form action=\"Login\" method=\"post\" accept-charset=\"utf-8\">");
            out.println("   <table>"
                    + "         <tr>"
                    + "             <td style=\"text-align:right;\">Nome do usuário:</td>"
                    +   "           <td><input type=\"text\" name=\"login\" required=\"required\" class=\"text-field\"></td>"
                    + "         </tr>");
            out.println("       <tr>"
                    + "             <td style=\"text-align:right;\">Senha:</td>"
                    +   "           <td><input type=\"password\" name=\"senha\" required=\"required\" class=\"text-field\"></td>");
            out.println("       </tr>"
                    + "     </table>"
                    + "     <span><input type=\"submit\" value=\"Logar\" class=\"buttom\"><a href=\"Inscrevase\"><button type=\"button\" style=\"width:200px;\">Abrir uma conta</button></a></span>");
            out.println("   </form>");
            out.println("</div>");
            
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
            if(userDao.logar(request.getParameter("login"), request.getParameter("senha"))){
                out.println("<h1>Usuário Logado!</h1>");
                request.getSession().setAttribute("login", request.getParameter("login"));
                response.sendRedirect("PaginaPessoal");
                return;
            }else{
                out.println("<h1>Usuário Não logado!</h1>");
                out.println("<a href=\"Login\">Tente novamente</a>");
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
