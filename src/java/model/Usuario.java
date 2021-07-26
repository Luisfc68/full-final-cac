/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luis
 */
public class Usuario {
    
    private String nombreUsuario,clave;
    private int id;
    
    public Usuario(){}
    
    public Usuario(int id, String nombreUsuario, String clave){
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }
    
    public Usuario(String nombreUsuario, String clave){
        this.clave = clave;
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getNombreUsuario(){
        return nombreUsuario;
    }
        
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getClave(){
        return clave;
    }
    
    public void setClave(String clave){
        this.clave = clave;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
}
