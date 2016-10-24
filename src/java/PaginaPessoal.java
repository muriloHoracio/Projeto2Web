/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.UsuarioDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
@MultipartConfig//(fileSizeThreshold=1024*1024*2,maxFileSize=1024*1024*10,maxRequestSize=1024*1024*50)
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
        request.getRequestDispatcher("JSP/PaginaPessoal.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        if(request.getParameter("postType")==null||request.getParameter("postType").equals("")){
            doGet(request, response);
        }else if(request.getParameter("postType").equals("uploadFile")){
            String user = request.getSession().getAttribute("login").toString();
            UsuarioDAO userDao = new UsuarioDAO();
            String filesPath = request.getServletContext().getRealPath("/uploads");
            String description = request.getParameter("description");
            Part filePart = request.getPart("file");
            if(!(filePart.getSubmittedFileName()==null||filePart.getSubmittedFileName().equals(""))){
                String extensao;
                String[] filenameSplitted = filePart.getSubmittedFileName().split("\\.");
                extensao = filenameSplitted[filenameSplitted.length-1];
                InputStream fileContent = filePart.getInputStream();
                String fileNameInStorage = userDao.getNextDataId(user);
                if(fileNameInStorage==null){
                    fileNameInStorage = "-1";
                }
                int newId = Integer.parseInt(fileNameInStorage)+1;
                fileNameInStorage = user+newId+"."+extensao;
                userDao.insereData(newId, user, "uploads/"+fileNameInStorage, filePart.getSubmittedFileName(), filePart.getContentType(), description);
                FileOutputStream out = new FileOutputStream(new File(filesPath+"/"+fileNameInStorage));
                byte [] buffer = new byte[1024];
                int read = 0;
                while((read = fileContent.read(buffer))!=-1)
                    out.write(buffer, 0, read);
                out.close();
            }
            doGet(request, response);
        }else if(request.getParameter("postType").equals("uploadText")){
            UsuarioDAO userDao = new UsuarioDAO();
            String user = request.getSession().getAttribute("login").toString();
            String filesPath = request.getServletContext().getRealPath("/uploads");
            String fileNameInStorage = userDao.getNextDataId(user);
            if(fileNameInStorage==null){
                fileNameInStorage = "-1";
            }
            int newId = Integer.parseInt(fileNameInStorage)+1;
            fileNameInStorage = user+newId+".txt";
            userDao.insereData(newId, user, "uploads/"+fileNameInStorage, request.getParameter("titulo"), "text/plain", request.getParameter("texto"));
            File f = new File(filesPath+"/"+fileNameInStorage);
            FileWriter fileWriter = new FileWriter(f);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            PrintWriter printer = new PrintWriter(buffWriter);
            printer.println(request.getParameter("texto"));
            printer.flush();
            printer.close();
            doGet(request, response);
        }else if(request.getParameter("postType").equals("sair")){
            request.getSession().invalidate();
            response.sendRedirect("Login");
            return;
        }else if(request.getParameter("postType").equals("downloadFile")){
            String file = request.getParameter("dataFileName");
            response.setContentType(request.getParameter("fileType"));
            response.setHeader("Content-disposition","attachment; filename="+request.getParameter("dataFileOldName"));
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(new File(request.getServletContext().getRealPath("")+"/"+file));
            byte[] buffer = new byte[1024];
            int length;
            while((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            doGet(request, response);
        }else if(request.getParameter("postType").equals("removeFile")){
            String file = request.getParameter("dataFileName");
            UsuarioDAO userDao = new UsuarioDAO();
            userDao.removeData(file);
            File f = new File(request.getServletContext().getRealPath("")+"/"+file);
            f.delete();
            doGet(request, response);
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
