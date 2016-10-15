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
            String sql = "SELECT * FROM usuario WHERE login LIKE ? AND senha LIKE ?;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, "%"+login+"%");
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
            String sql = "INSERT INTO usuario VALUES (?,?,?,?,?,?,?,?,?);";
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
}
