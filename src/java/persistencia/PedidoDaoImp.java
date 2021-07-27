/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import model.Usuario;

/**
 *
 * @author Luis
 */
public class PedidoDaoImp implements PedidoDAO{

    @Override
    public Pedido getById(int id) throws PersistenciaException {
        Connection conn = null;
        try{
            
            conn = ConectorBD.getInstance().conectar();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select id_pedido,nombre,apellido,correo,direccion,localidad,provincia,"
                    + "cod-postal,forma-pago,nombre-titular,numero-tarjeta,codigo-seguridad"
                    + " from pedido where id_pedido = "+id);
            if(!rs.next())
                return null;
            Pedido p = new Pedido();
            
            p.setId(rs.getInt(1));
            p.setNombre(rs.getString(2));
            p.setApellido(rs.getString(3));
            p.setCorreo(rs.getString(4));
            p.setDireccion(rs.getString(5));
            p.setLocalidad(rs.getString(6));
            p.setProvincia(rs.getString(7));
            p.setCodPostal(rs.getInt(8));
            p.setPagoTarjeta(rs.getBoolean(9));
            p.setTitularTarjeta(rs.getString(10));
            p.setNumeroTarjeta(rs.getInt(11));
            p.setCodSeguridad(rs.getInt(12));
            
            return p;
            
        }catch(SQLException e){
            throw new PersistenciaException("Error buscando pedido");
        }finally{
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            
        }
    }

    @Override
    public List<Pedido> getByUser(Usuario u) throws PersistenciaException {
        
        Connection conn = null;
        List<Pedido> pedidos = new ArrayList<>();
        try{
            
            conn = ConectorBD.getInstance().conectar();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select id_pedido,nombre,apellido,correo,direccion,localidad,provincia,"
                    + "cod-postal,forma-pago,nombre-titular,numero-tarjeta,codigo-seguridad"
                    + " from pedido where id_usuario = "+u.getId());
            
            while(rs.next()){
                Pedido p = new Pedido();
            
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setCorreo(rs.getString(4));
                p.setDireccion(rs.getString(5));
                p.setLocalidad(rs.getString(6));
                p.setProvincia(rs.getString(7));
                p.setCodPostal(rs.getInt(8));
                p.setPagoTarjeta(rs.getBoolean(9));
                p.setTitularTarjeta(rs.getString(10));
                p.setNumeroTarjeta(rs.getInt(11));
                p.setCodSeguridad(rs.getInt(12));

                pedidos.add(p);
            }
            
            return pedidos;
            
        }catch(SQLException e){
            throw new PersistenciaException("Error buscando pedidos");
        }finally{
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            
        }
        
    }

    @Override
    public void insert(Pedido p) throws PersistenciaException {
        Connection conn = null;
        try{
            conn = ConectorBD.getInstance().conectar();
            PreparedStatement stm = conn.prepareStatement("insert into pedido(id_usuario,nombre,apellido,correo,"
                    + "direccion,localidad,provincia,cod-postal,forma-pago,nombre-titular,numero-tarjeta,"
                    + "codigo-seguridad) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            stm.setInt(1,p.getUsuario().getId());
            stm.setString(2, p.getNombre());
            stm.setString(3, p.getApellido());
            stm.setString(4, p.getCorreo());
            stm.setString(5, p.getDireccion());
            stm.setString(6, p.getLocalidad());
            stm.setString(7, p.getProvincia());
            stm.setInt(8,p.getCodPostal());
            stm.setBoolean(9, p.isPagoTarjeta());
            stm.setString(10, p.getTitularTarjeta());
            stm.setInt(11,p.getNumeroTarjeta());
            stm.setInt(12, p.getCodSeguridad());
            
            stm.execute();
            
        }catch(SQLException e){
            throw new PersistenciaException("Error insertando pedido");
        }finally{
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
        }
    }
    
    @Override
    public Pedido delete(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void update(Pedido p) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
