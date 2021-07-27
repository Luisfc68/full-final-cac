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
import model.Usuario;

/**
 *
 * @author Luis
 */
public class UsuarioDaoImp implements UsuarioDAO{

    @Override
    public Usuario getByName(String name) throws PersistenciaException{
        Connection conn = null;
        try{
            
            conn = ConectorBD.getInstance().conectar();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select id_usuario,nombre_usuario,clave from usuario where nombre_usuario like '"+name+"'");
            if(!rs.next())
                return null;
            Usuario u = new Usuario();
            u.setId(rs.getInt(1));
            u.setNombreUsuario(rs.getString(2));
            u.setClave(rs.getString(3));
            return u;
            
        }catch(SQLException e){
            throw new PersistenciaException(e.getMessage());
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
    public Usuario getById(int id)  throws PersistenciaException{
        Connection conn = null;
        try{
            
            conn = ConectorBD.getInstance().conectar();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select id_usuario,nombre_usuario,clave from usuario where id_usuario = "+id);
            if(!rs.next())
                return null;
            Usuario u = new Usuario();
            u.setId(rs.getInt(1));
            u.setNombreUsuario(rs.getString(2));
            u.setClave(rs.getString(3));
            return u;
            
        }catch(SQLException e){
            throw new PersistenciaException("Error buscando usuario");
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
    public void insert(Usuario u) throws PersistenciaException{
        Connection conn = null;
        try{
            conn = ConectorBD.getInstance().conectar();
            PreparedStatement stm = conn.prepareStatement("insert into usuario(nombre_usuario,clave) values(?,?)");
            stm.setString(1, u.getNombreUsuario());
            stm.setString(2, u.getClave());
            stm.execute();
        }catch(SQLException e){
            throw new PersistenciaException("Error insertando usuario");
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
    public Usuario delete(int id)  throws PersistenciaException{
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void update(Usuario u)  throws PersistenciaException{
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
