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
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=CSS/paginaPessoal.css>");
            out.println("</head>");
            out.println("<body>");
            out.println("<span class=\"pageTitle\">Cadastro de usuário</span>");
            out.println("<form action=\"Inscrevase\" method=\"post\" accept-charset=\"utf-8\">");
            out.println("   <table class=\"centerBox\">"
                    +   "       <tr>"
                    + "             <td>Nome:</td>"
                    +   "           <td><input type=\"text\" name=\"nome\" required=\"required\" class=\"text-field\"></td>"
                    + "         </tr>");
            out.println("       <tr>"
                    + "             <td>E-mail:</td>"
                    +   "           <td><input type=\"email\" name=\"email\" required=\"required\" class=\"text-field\"></td>"
                    + "         </tr>");
            out.println("       <tr>"
                    + "             <td>Login:</td>"
                    +   "           <td><input type=\"text\" name=\"login\" required=\"required\" class=\"text-field\"></td>"
                    + "         </tr>");
            out.println("       <tr>"
                    + "             <td>Senha:</td>"
                    +   "           <td><input type=\"password\" name=\"senha\" required=\"required\" class=\"text-field\"></td>"
                    + "         </tr>");
            out.println("       <tr>"
                    + "             <td>Estado:</td>"
                    +   "           <td><select name=\"estado\" required=\"required\">\n" +
                        "	<option value=\"AC\">Acre</option>\n" +
                        "	<option value=\"AL\">Alagoas</option>\n" +
                        "	<option value=\"AM\">Amazonas</option>\n" +
                        "	<option value=\"AP\">Amapá</option>\n" +
                        "	<option value=\"BA\">Bahia</option>\n" +
                        "	<option value=\"CE\">Ceará</option>\n" +
                        "	<option value=\"DF\">Distrito Federal</option>\n" +
                        "	<option value=\"ES\">Espírito Santo</option>\n" +
                        "	<option value=\"GO\">Goiás</option>\n" +
                        "	<option value=\"MA\">Maranão</option>\n" +
                        "	<option value=\"MG\">Minas Gerais</option>\n" +
                        "	<option value=\"MS\">Mato Grosso do Sul</option>\n" +
                        "	<option value=\"MT\">Mato Grosso</option>\n" +
                        "	<option value=\"PA\">Pará</option>\n" +
                        "	<option value=\"PB\">Paraíba</option>\n" +
                        "	<option value=\"PE\">Pernambuco</option>\n" +
                        "	<option value=\"PI\">Piauí</option>\n" +
                        "	<option value=\"PR\">Paraná</option>\n" +
                        "	<option value=\"RJ\">Rio de Janeiro</option>\n" +
                        "	<option value=\"RN\">Rio Grande do Norte</option>\n" +
                        "	<option value=\"RS\">Rio Grande do Sul</option>\n" +
                        "	<option value=\"RO\">Rondônia</option>\n" +
                        "	<option value=\"RR\">Roraima</option>\n" +
                        "	<option value=\"SC\">Santa Catarina</option>\n" +
                        "	<option value=\"SE\">Sergipe</option>\n" +
                        "	<option value=\"SP\">São Paulo</option>\n" +
                        "	<option value=\"TO\">Tocantins</option>\n" +
                        "   </select></td>"
                    + "         </tr>");
                    //+   "   <input type=\"text\" name=\"estado\" class=\"text-field\"><br>");
            out.println("       <tr>"
                    + "             <td>Cidade:</td>"
                    +   "           <td><input type=\"text\" name=\"cidade\" required=\"required\" class=\"text-field\"></td>"
                    + "         </tr>");
            out.println("       <tr>"
                    + "             <td>Bairro:</td>"
                    +   "           <td><input type=\"text\" name=\"bairro\" required=\"required\" class=\"text-field\"></td>"
                    + "         </tr>");
            out.println("       <tr>"
                    + "             <td>Rua:</td>"
                    +   "           <td><input type=\"text\" name=\"rua\" required=\"required\" class=\"text-field\"></td>"
                    + "         </tr>");
            out.println("       <tr>"
                    + "             <td>Numero:</td>"
                    +   "           <td><input type=\"text\" name=\"numero\" required=\"required\" class=\"text-field\"></td>"
                    + "         </tr>");
            out.println("   </table><br><br>"
                    + "     <span class=\"centerBox\"> <input type=\"submit\" value=\"Cadastrar\" class=\"buttom\">");
            out.println("   <input type=\"reset\" value=\"Limpar\" class=\"buttom\">"
                    + "     <a href=\"Login\"><button type=\"button\">Cancelar</button></a></span>");
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
