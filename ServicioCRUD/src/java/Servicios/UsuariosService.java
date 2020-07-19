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
}
