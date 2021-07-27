/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.PersistenciaException;
import java.util.List;
import model.Pedido;
import model.Usuario;

/**
 *
 * @author Luis
 */
public interface PedidoDAO {
    Pedido getById(int id) throws PersistenciaException;
    List<Pedido> getByUser(Usuario u) throws PersistenciaException;
    Pedido delete(int id) throws PersistenciaException;
    void update(Pedido p) throws PersistenciaException;
    void insert(Pedido p) throws PersistenciaException;
}
