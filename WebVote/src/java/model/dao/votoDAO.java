/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import util.conectadb;
import java.sql.Statement;
import model.voto;
/**
 *
 * @author helel
 */
public class votoDAO
{
    
    public boolean insVoto(voto v_voto) throws ClassNotFoundException
    {
        Connection conexao = null;
        try
        {
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();
                        //INSERT INTO votos(id, candidatoid) VALUES ('1','50');         
            String sql = "INSERT INTO votos(id, candidatoid) VALUES ('" + v_voto.getId()+ "'," + "'" + v_voto.getCandidatoId() + "')";
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return false;
        }
    }   
}