/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author helel
 */
public class voto
{
    private int id;
    private int candidatoId;

    public voto(int id, int candidatoId) 
    {
        this.id = id;
        this.candidatoId = candidatoId;
    }

    // Getters e Setters
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public int getCandidatoId() 
    {
        return candidatoId;
    }

    public void setCandidatoId(int candidatoId) 
    {
        this.candidatoId = candidatoId;
    }
}
    
