/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import model.candidato;
import model.eleicao;
import model.voto;
import model.eleitor;
import util.conectadb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author helel
 */
public class eleicaoDAO
{
    public boolean salvar(eleicao e_eleicao) throws ClassNotFoundException 
    {
       Connection conexao = null;
     
       try 
        {
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();
             String sql = "INSERT INTO eleicoes(id) VALUES ('" + e_eleicao.getId() + "')";
            // Recupera o ID gerado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                e_eleicao.setId(rs.getInt(1));
            }

            // Salva os candidatos associados
            for (candidato candidato : e_eleicao.getCandidatos()) 
            {
                salvarCandidato(conexao, e_eleicao.getId(), candidato);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(eleicao e_eleicao) throws ClassNotFoundException 
    {
        Connection conexao = null;
        try 
        {    
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();
            // Remove os candidatos associados
            String sql = "DELETE from pesquisa WHERE id = " + e_eleicao.getId();
            stmt.executeUpdate(sql); //GO - Executar - Insert / Delete / Update
            return true;

        } catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
    }
    public eleicao buscarPorId(eleicao e_eleicao) throws ClassNotFoundException
    {
        eleicao eleicao = null;
        Connection conexao = null;
        try
        {
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();         
            String sql = "SELECT * FROM pesquisa where id = '" + e_eleicao.getId()+ "'";
            int n_reg = 0;
            ResultSet rs = stmt.executeQuery(sql);  
            if (rs.next()) 
            {
                eleicao = new eleicao();
                eleicao.setId(rs.getInt("id"));
                e_eleicao.setAberta(rs.getBoolean("aberta"));
                e_eleicao.setId(Integer.parseInt(rs.getString("id")));
                e_eleicao.setCandidatos(buscarCandidatos(conexao, n_reg)); 
                n_reg++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eleicao;
    }

    public List<eleicao> listarTodas() throws ClassNotFoundException {
        List<eleicao> eleicoes = new ArrayList<>();
        Connection conexao = null;
        try 
        {
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement();         
            String sql = "SELECT * FROM eleicoes";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) 
            {
                eleicao eleicao = new eleicao();
                eleicao.setId(rs.getInt("id"));
                eleicao.setAberta(rs.getBoolean("aberta"));
                eleicao.setCandidatos(buscarCandidatos(conexao, rs.getInt("id")));
                eleicoes.add(eleicao);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return eleicoes;
    }

    private void salvarCandidato(Connection conn, int eleicaoId, candidato candidato) throws SQLException {
        String sql = "INSERT INTO candidatos (eleicao_id, nome, votos) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eleicaoId);
            stmt.setString(2, candidato.getNome());
            stmt.setInt(3, candidato.getVotos());
            stmt.executeUpdate();
        }
    }

    private void deletarCandidatos(Connection conn, int eleicaoId) throws SQLException {
        String sql = "DELETE FROM candidatos WHERE eleicao_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eleicaoId);
            stmt.executeUpdate();
        }
    }

    private List<candidato> buscarCandidatos(Connection conn, int eleicaoId) throws SQLException {
        String sql = "SELECT * FROM candidatos WHERE eleicao_id = ?";
        List<candidato> candidatos = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eleicaoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                candidato candidato = new candidato();
                candidato.setId(rs.getInt("id"));
                candidato.setNome(rs.getString("nome"));
                candidato.setVotos(rs.getInt("votos"));
                candidatos.add(candidato);
            }
        }
        return candidatos;
    }
}

