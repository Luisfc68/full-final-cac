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
public class Pedido {
    
    private boolean pagoTarjeta; //True tarjeta false mercado-pago
    private String nombre,apellido,correo,direccion,localidad,provincia,titularTarjeta;
    private int id,codPostal,numeroTarjeta,codSeguridad;
    private Usuario usuario;

    public boolean isPagoTarjeta() {
        return pagoTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public int getId() {
        return id;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public int getCodSeguridad() {
        return codSeguridad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setPagoTarjeta(boolean pagoTarjeta) {
        this.pagoTarjeta = pagoTarjeta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setCodSeguridad(int codSeguridad) {
        this.codSeguridad = codSeguridad;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
