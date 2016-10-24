/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author murilo
 */
public class UsuarioDAO {
    private Connection con;
    private PreparedStatement ppst;
    public boolean logar(String login, String senha){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proj2web", "murilo", "murilo");
            String sql = "SELECT * FROM usertable WHERE login LIKE ? AND senha LIKE ?;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, login);
            ppst.setString(2, senha);
            ResultSet rs = ppst.executeQuery();
            if(rs.next()){
                con.close();
                return true;
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean insereUsuario(String nome, String email, String login, String senha, String estado, String cidade, String bairro, String rua, String numero) {
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proj2web", "murilo", "murilo");
            String sql = "INSERT INTO usertable VALUES (?,?,?,?,?,?,?,?,?);";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, nome);
            ppst.setString(2, email);
            ppst.setString(3, login);
            ppst.setString(4, senha);
            ppst.setString(5, estado);
            ppst.setString(6, cidade);
            ppst.setString(7, bairro);
            ppst.setString(8, rua);
            ppst.setString(9, numero);
            ppst.executeUpdate();
            con.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public String getNextDataId(String user){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proj2web", "murilo", "murilo");
            String sql = "SELECT * FROM data WHERE login LIKE ? ;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, user);
            ResultSet rs = ppst.executeQuery();
            String lastId=null;
            while(rs.next()){
                lastId = rs.getInt("id")+"";
            }
            con.close();
            return lastId;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String getImages(String user){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proj2web", "murilo", "murilo");
            String sql = "SELECT * FROM data WHERE login LIKE ? AND type LIKE ?;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, user);
            ppst.setString(2, "image/%");
            ResultSet rs = ppst.executeQuery();
            String result = "";
            while(rs.next()){
                result += "<img src=\""+rs.getString("file")+"\" height=\"10%\" width=\"10%\">\n";
            }
            con.close();
            System.out.println(""+result);
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean insereData(int id, String user, String file, String fileOldName, String type, String description) {
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proj2web", "murilo", "murilo");
            String sql = "INSERT INTO data VALUES (?,?,?,?,?,?);";
            ppst = con.prepareStatement(sql);
            ppst.setInt(1, id);
            ppst.setString(2, user);
            ppst.setString(3, file);
            ppst.setString(4, type);
            ppst.setString(5, description);
            ppst.setString(6, fileOldName);
            ppst.executeUpdate();
            con.close();
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return false;
    }
    
    public String listFiles(String user){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proj2web", "murilo", "murilo");
            String sql = "SELECT * FROM data WHERE login LIKE ?;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, user);
            ResultSet rs = ppst.executeQuery();
            String out = "";
            out += "<table>";
            while(rs.next()){
                out += "<tr>";
                out += "<form action=\"PaginaPessoal\" method=\"post\" accept-charset=\"utf-8\" enctype=\"multipart/form-data\">";
                out += "<input type=\"hidden\" name=\"fileToDownload\" value=\""+rs.getString("file")+"\">";
                out += "<input type=\"hidden\" name=\"fileType\" value=\""+rs.getString("type")+"\">";
                out += "<input type=\"hidden\" name=\"fileOldName\" value=\""+rs.getString("fileOldName")+"\">";
                out += "<td class=\"dataDescription\">";
                out += rs.getString("description");
                out += "</td>";
                out += "<td>";
                out += "<input type=\"submit\" name=\"downloadButton\" value=\"Download\"><br>";
                out += "</td>";
                out += "</form>";
                out += "</tr>";
            }
            out += "</table>";
            return out;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public String displayFiles(String user){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proj2web", "murilo", "murilo");
            String sql = "SELECT * FROM data WHERE login LIKE ?;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, user);
            ResultSet rs = ppst.executeQuery();
            String out = "";
            out += "<table>";
            while(rs.next()){
                if(!rs.getString("type").split("/")[0].equals("text")){
                    out += "<tr>";
                    if(rs.getString("type").split("/")[0].equals("image")){
                        out += "<td>";
                            out += "<a href=\""+rs.getString("file")+"\"><img src=\""+rs.getString("file")+"\" alt=\""+rs.getString("description")+"\" class=\"thumbnail\"/></a>";
                        out += "</td>";
                    } else if(rs.getString("type").split("/")[0].equals("video")){
                        out += "<td>";
                            out += "<a href=\""+rs.getString("file")+"\"><img src=\"uploads/videoStandardLogo.png\" alt=\""+rs.getString("description")+"\" class=\"thumbnail\"/></a>";
                            //out += "<iframe src=\""+rs.getString("file")+"\" class=\"videoPlayer\"></iframe>";
                        //out += "</td><td><a href=\""+rs.getString("file")+"\"><button type=\"button\" id=\"fullScreenButton\">Full Screen</button></a></td>";
                        out += "</td>";
                    }                    
                    out += "</tr>";
                }
                out += "<tr>";
                out += "<td class=\"dataDescription\">";
                out += rs.getString("description");
                out += "</td>";
                out += "</tr>";
            }
            out += "</table>";
            return out;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public String buscaFiles(String user, String query, String path){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proj2web", "murilo", "murilo");
            String sql = "SELECT * FROM data WHERE login LIKE ? AND description ILIKE ? ORDER BY id DESC;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, user);
            ppst.setString(2, "%"+query+"%");
            ResultSet rs = ppst.executeQuery();
            String out = "";
            out += "<table class=\"dataTable\">";
            while(rs.next()){
                out     +=  "<tr>"
                        +   "   <td>"
                        +   "       <form action=\"PaginaPessoal\" method=\"post\" accept-charset=\"utf-8\" style=\"display:block;\">"
                        +   "           <input type=\"hidden\" name=\"postType\" value=\"downloadFile\">"
                        +   "           <input type=\"hidden\" name=\"dataFileName\" value=\""+rs.getString("file")+"\">"
                        +   "           <input type=\"hidden\" name=\"fileType\" value=\""+rs.getString("type")+"\">"
                        +   "           <input type=\"hidden\" name=\"dataFileOldName\" value=\""+rs.getString("fileoldname")+"\">"
                        +   "           <input type=\"submit\" name=\"downloadButton\" value=\"Download\" class=\"buttons_small\" style=\"font-size:13px; height:25px;margin-top:2px;margin-bottom:2px;width:100px;\">"
                        +   "       </form>"
                        +   "       <form action=\"PaginaPessoal\" method=\"post\" accept-charset=\"utf-8\" style=\"display:block;\">"
                        +   "           <input type=\"hidden\" name=\"postType\" value=\"removeFile\">"
                        +   "           <input type=\"hidden\" name=\"dataFileName\" value=\""+rs.getString("file")+"\">"
                        +   "           <input type=\"submit\" name=\"removeButton\" value=\"Excluir\" class=\"buttons_small\" style=\"font-size:13px; height:25px;margin-top:2px;margin-bottom:2px;width:100px;\">"
                        +   "       </form>"
                        +   "   </td>";
                if(rs.getString("type").split("/")[0].equals("text")){
                    out +=  "<td>"
                        +   "   <span style=\"display:block;text-align:center;margin-bottom:15px;\">"+rs.getString("fileoldname")+"</span>"
                        +   "</td>";
                } else if(rs.getString("type").split("/")[0].equals("image")){
                    out +=  "<td>"
                        +   "   <a href=\""+rs.getString("file")+"\"><img src=\""+rs.getString("file")+"\" alt=\""+rs.getString("description")+"\" class=\"thumbnail\"/></a>"
                        +   "</td>";
                } else if(rs.getString("type").split("/")[0].equals("video")){
                    out +=  "<td>" 
                        +   "   <div class=\"centerBox\">"
                        +   "       <video controls name=\"media\" height=\"200px\">"
                        +   "           <source src=\""+path+"/"+rs.getString("file")+"\" type=\"video/x-flv\">"
                        +   "           <source src=\""+path+"/"+rs.getString("file")+"\" type=\"video/mp4\">"
                        +   "           <source src=\""+path+"/"+rs.getString("file")+"\" type=\"video/3gpp\">"
                        +   "           <source src=\""+path+"/"+rs.getString("file")+"\" type=\"video/x-msvideo\">"
                        +   "           <source src=\""+path+"/"+rs.getString("file")+"\" type=\"video/x-ms-wmv\">"
                        +   "           <source src=\""+path+"/"+rs.getString("file")+"\" type=\"video/webm\">"
                        +   "       </video>"
                        +   "   </div>"
                        +   "</td>";
                } else if(rs.getString("type").split("/")[0].equals("audio")){
                    out +=  "<td class=\"descriptionCell\">"
                        +   "   <div class=\"centerBox\">"
                        +   "       <audio controls>"
                        +   "           <source src=\""+path+"/"+rs.getString("file")+"\" type=\"audio/mpeg\">"
                        +   "           <source src=\""+path+"/"+rs.getString("file")+"\" type=\"audio/vnd.wav\">"
                        +   "       </audio>"
                        +   "   </div>"
                        +   "</td>";
                }
                out     += "</tr>";
                out     +=  "<tr>"
                        +   "   <td>"
                        +   "   </td>"
                        +   "   <td class=\"dataDescription\">"
                        +   "       "+rs.getString("description")
                        +   "   </td>"
                        +   "</tr>"
                        +   "<tr><td><br><br></td><td><br><hr><br></td></tr>";
            }
            out += "</table>";
            return out;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean removeData(String file) {
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proj2web", "murilo", "murilo");
            String sql = "DELETE FROM data WHERE file LIKE ?";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, file);
            ppst.executeUpdate();
            con.close();
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return false;
    }
}
