/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.candidato;
import model.voto;
/**
 *
 * @author helel
 */

public class eleicao
{
    private int id;
    private List<candidato> candidatos; // Lista de candidatos participantes
    private List<voto> votos;
    private boolean aberta; // Indica se a eleição está aberta ou encerrada

    // Construtores
    public eleicao() 
    {
        this.candidatos = new ArrayList<>();
    }

    public eleicao(int id, boolean aberta) {
        this.id = id;
        this.aberta = aberta;
        this.candidatos = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() 
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public boolean isAberta() 
    {
        return aberta;
    }

    public void setAberta(boolean aberta) 
    {
        this.aberta = aberta;
    }

    // Métodos
    public void adicionarCandidato(candidato candidato) 
    {
        this.candidatos.add(candidato);
    }

    public void removerCandidato(candidato candidato) 
    {
        this.candidatos.remove(candidato);
    }

    public void encerrarEleicao() 
    {
        this.aberta = false;
    }

    public void abrirEleicao() 
    {
        this.aberta = true;
    }
}
