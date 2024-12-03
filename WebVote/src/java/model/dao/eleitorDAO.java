/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.conectadb;
import java.sql.Statement;
import model.eleitor;
/**
 *
 * @author helel
 */
public class eleitorDAO
{
    public boolean insEleitor(eleitor e_eleitor) throws ClassNotFoundException
    {
        Connection conexao = null;
        try
        {
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();
                        //INSERT INTO eleitores(id, nome,votou) VALUES ('1','teste,'false');         
            String sql = "INSERT INTO eleitores(id, nome, votou) VALUES ('" + e_eleitor.getId()+ "'," + "'" + e_eleitor.getNome()+ "'," + "'" + e_eleitor.isVotou()+ "')";
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }   catch(SQLException ex)
        {
            System.out.println("Erro:" + ex);
            return false;
        }
    }
    public boolean altEleitor(eleitor e_eleitor) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();
                        //UPDATE eleitores nome='eleitor teste' WHERE id = 8;
            String sql = "UPDATE eleitores SET nome='" + e_eleitor.getNome()+ "' WHERE id = " + e_eleitor.getId();
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }   catch(SQLException ex)
        {
            System.out.println("Erro:" + ex);
            return false;
        }
    }
    public boolean delEleitor(eleitor e_eleitor) throws ClassNotFoundException
    {
        Connection conexao = null;
        try
        {
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();
                             
            String sql = "DELETE FROM eleitores WHERE id = " + e_eleitor.getId();
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }   catch(SQLException ex)
        {
            System.out.println("Erro:" + ex);
            return false;
        }
    }
    public boolean votoEleitor(eleitor e_eleitor) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();
                        //UPDATE candidatos SET id='id',nome='candidato teste',partido='partido teste' WHERE id = 8;
            String sql = "UPDATE candidatos SET votou='" + e_eleitor.isVotou()+ "' WHERE id = " + e_eleitor.getId();
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }   catch(SQLException ex)
        {
            System.out.println("Erro:" + ex);
            return false;
        }
    }
    public eleitor veriVoto(eleitor e_eleitor) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();                                 
            String sql = "SELECT * FROM eleitores where id = '" + e_eleitor.getId()+ "'";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            int n_reg = 0;
            while (rs.next()) 
            {                 
               e_eleitor.isVotou();
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0)
            {
                return null;
            }else
            {
                return e_eleitor;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    }
}
