/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.PersistenciaException;
import model.Usuario;

/**
 *
 * @author Luis
 */
public interface UsuarioDAO {
    Usuario getByName(String name) throws PersistenciaException;
    Usuario getById(int id) throws PersistenciaException;
    Usuario delete(int id) throws PersistenciaException;
    void update(Usuario u) throws PersistenciaException;
    void insert(Usuario u) throws PersistenciaException;
}
