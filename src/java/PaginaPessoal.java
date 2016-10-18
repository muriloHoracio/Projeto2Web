/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.UsuarioDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author murilo
 */
@WebServlet(urlPatterns = {"/PaginaPessoal"})
@MultipartConfig(fileSizeThreshold=1024*1024*2,
                 maxFileSize=1024*1024*10,
                 maxRequestSize=1024*1024*50)
public class PaginaPessoal extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int id = 0;
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
        UsuarioDAO userDao = new UsuarioDAO();
        
        if(request.getSession().getAttribute("login")==null){
            response.sendRedirect("Login");
            return;
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PaginaPessoal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Página Pessoal do Usuário</h1>");
            out.println("<div>");
            out.println(userDao.getImages(request.getSession().getAttribute("login").toString()));
            out.println("</div>");
            out.println("<form action=\"PaginaPessoal\" method=\"post\" accept-charset=\"utf-8\" enctype=\"multipart/form-data\">");
            out.println("<input type=\"file\" name=\"arquivo\" value=\"\" />");
            out.println("<input type=\"submit\" name=\"enviar\" value=\"Enviar\" />");
            out.println("</form>");
            out.println("<form action=\"PaginaPessoal\" method=\"post\" accept-charset=\"utf-8\">");
            out.println("<input type=\"hidden\" name=\"sair\" value=\"true\" class=\"text-field\"><br>");
            out.println("<input type=\"submit\" value=\"Sair\" class=\"buttom\">");
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
        if(request.getParameter("sair")!=null){
            request.getSession().invalidate();
            response.sendRedirect("Login");
            return;
        }
        UsuarioDAO userDao = new UsuarioDAO();
        String user = request.getSession().getAttribute("login").toString();
        Part part = request.getPart("arquivo");
        String images_path = request.getServletContext().getRealPath("/uploads");
        InputStream in = part.getInputStream();
        if(part.getContentType().equals("image/png")){
            String id = userDao.getNextDataId(user);
            if(id==null){
                id = "-1";
            }
            int newId = Integer.parseInt(id)+1;
            userDao.insereData(user, "image/png", "uploads/"+user+newId+".png", newId);
            FileOutputStream out = new FileOutputStream(new File(images_path+"/"+user+newId+".png"));
            byte [] buffer = new byte[1024];
            int read = 0;
            while((read = in.read(buffer))!=-1)
                out.write(buffer, 0, read);
            out.close();
        }
        doGet(request, response);
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
