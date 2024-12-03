/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author helel
 */
public class candidato 
{
    private int id;
    private String nome;
    private String partido;
    private int votos;
    /**
     * @return the nome
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /**
     * @return the partido
     */
    public String getPartido()
    {
        return partido;
    }

    /**
     * @param partido the partido to set
     */
    public void setPartido(String partido)
    {
        this.partido = partido;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the votos
     */
    public int getVotos()
    {
        return votos;
    }

    /**
     * @param votos the votos to set
     */
    public void setVotos(int votos)
    {
        this.votos = votos;
    }
    
    
}
