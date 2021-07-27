/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import excepciones.PersistenciaException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pedido;
import model.Usuario;
import persistencia.PedidoDAO;
import persistencia.PedidoDaoImp;

/**
 *
 * @author Luis
 */
@WebServlet(name = "PedidoServlet", urlPatterns = {"/PedidoServlet"})
public class PedidoServlet extends HttpServlet {

    private final PedidoDAO pd;    
    
    public PedidoServlet() {
        this.pd = new PedidoDaoImp();
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try{
            
            Pedido p = new Pedido();
            p.setUsuario((Usuario)session.getAttribute("usuario"));
            p.setNombre(request.getParameter("nombre"));
            p.setApellido(request.getParameter("apellido"));
            p.setCorreo(request.getParameter("correo"));
            p.setDireccion(request.getParameter("direccion"));
            p.setLocalidad(request.getParameter("localidad"));
            p.setProvincia(request.getParameter("provincia"));
            p.setTitularTarjeta(request.getParameter("nombre-titular"));
            p.setFechaVencimiento(request.getParameter("vencimiento"));
            p.setCodPostal(Integer.parseInt(request.getParameter("cod-postal")));
            p.setNumeroTarjeta(Long.parseLong(request.getParameter("numero-tarjeta")));
            p.setCodSeguridad(Integer.parseInt(request.getParameter("cod-tarjeta")));
            if(request.getParameter("formapago").equals("credito"))
                p.setPagoTarjeta(true);
            else
                p.setPagoTarjeta(false);
            
            pd.insert(p);
            session.setAttribute("exitoPedido", true);
            
        }catch(PersistenciaException | NumberFormatException e){ 
            System.err.println(e.getMessage());
            session.setAttribute("exitoPedido", false);
            
        }finally{
            request.getRequestDispatcher("./exito.jsp").forward(request, response);
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
