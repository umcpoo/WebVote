/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import model.candidato;
import util.conectadb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author helel
 */
public class candidatoDAO
{
     public List<candidato> listarcandidatos() throws ClassNotFoundException
     {
        Connection conexao = null;
        List<candidato> candidatos = new ArrayList<>();
        try
        {
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement(); 
            String sql = "SELECT * FROM candidatos";
            ResultSet rs = stmt.executeQuery(sql);
            int n_reg = 0;
            while (rs.next()) 
            {
                candidato candidato = new candidato();
                candidato.setId(rs.getInt("id"));
                candidato.setNome(rs.getString("nome"));
                candidato.setPartido(rs.getString("partido"));
                candidatos.add(candidato);
                n_reg++;
            }
            conexao.close();
            if (n_reg==0)
            {
                return null;
            }
            else
            {
                return candidatos;
            }
            
        } 
            catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return candidatos;
    }
    public boolean insCandidato(candidato c_candidato) throws ClassNotFoundException
    {
        Connection conexao = null;
        try
        {
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();
                        //INSERT INTO candidatos(id, nome,partido) VALUES ('1','50');         
            String sql = "INSERT INTO candidatos(id, nome, partido) VALUES ('" + c_candidato.getId()+ "'," + "'" + c_candidato.getNome()+ "'," + "'" + c_candidato.getPartido() + "')";
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }   catch(SQLException ex)
        {
            System.out.println("Erro:" + ex);
            return false;
        }
    }
    public boolean altCandidato(candidato c_candidato) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();
                        //UPDATE candidatos SET id='id',nome='candidato teste',partido='partido teste' WHERE id = 8;
            String sql = "UPDATE candidatos SET id='" + c_candidato.getId()+ "'," +
                                                "nome='" + c_candidato.getNome()+ "'," +
                                                "partido=" + c_candidato.getPartido()+ ", " +
                                                 "' WHERE id = " + c_candidato.getId();
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }   catch(SQLException ex)
        {
            System.out.println("Erro:" + ex);
            return false;
        }
    }
    public boolean delCandidato(candidato c_candidato) throws ClassNotFoundException
    {
        Connection conexao = null;
        try
        {
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();
                        //INSERT INTO candidatos(id, nome,partido) VALUES ('1','50');         
            String sql = "DELETE FROM candidatos WHERE id = " + c_candidato.getId();
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }   catch(SQLException ex)
        {
            System.out.println("Erro:" + ex);
            return false;
        }
    }
    public candidato conscandid(candidato c_cand) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();                                 
            String sql = "SELECT * FROM candidatos where id = '" + c_cand.getId()+ "'";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            int n_reg = 0;
            while (rs.next()) {                 
                c_cand.setNome(rs.getString("nome"));  
                c_cand.setPartido(rs.getString("partido"));   
                c_cand.setVotos(Integer.parseInt(rs.getString("votos")));
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return c_cand;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    }
}
