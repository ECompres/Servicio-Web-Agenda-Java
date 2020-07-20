/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.UsuariosDAO;
import Modelos.Usuarios;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Emmanuel
 */
@WebService(serviceName = "UsuariosService")
public class UsuariosService {

    UsuariosDAO dao = new UsuariosDAO();

    @WebMethod(operationName = "listarUsuarios")
    public List<Usuarios> listarUsuarios() {
        List datos = dao.listarUsuarios();
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarUsuario")
    public String agregarUsuario(@WebParam(name = "NOMBRES") String NOMBRES, @WebParam(name = "APELLIDOS") String APELLIDOS, @WebParam(name = "EMAIL") String EMAIL, @WebParam(name = "PASSWORD") String PASSWORD, @WebParam(name = "TIPO_USUARIO") int TIPO_USUARIO) {
        String datos = dao.add(NOMBRES, APELLIDOS, EMAIL, PASSWORD, TIPO_USUARIO);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarID")
    public Usuarios listarID(@WebParam(name = "ID") int ID) {
        Usuarios user = dao.listarID(ID);
        return user;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizar")
    public String actualizar(@WebParam(name = "ID") int ID, @WebParam(name = "NOMBRES") String NOMBRES, @WebParam(name = "APELLIDOS") String APELLIDOS, @WebParam(name = "EMAIL") String EMAIL, @WebParam(name = "PASSWORD") String PASSWORD, @WebParam(name = "TIPO_USUARIO") int TIPO_USUARIO) {
        String datos = dao.edit(ID, NOMBRES, APELLIDOS, EMAIL, PASSWORD, TIPO_USUARIO);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarUsuario")
    public Usuarios eliminarUsuario(@WebParam(name = "ID") int ID) {
        Usuarios user = dao.delete(ID);
        return user;
    }
}
