 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.ContactosDAO;
import Modelos.Contactos;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Emmanuel
 */
@WebService(serviceName = "ContactosService")
public class ContactosService {
    ContactosDAO dao = new ContactosDAO();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarContactos")
    public List<Contactos> listarContactos(@WebParam(name = "ID_USUARIO") int ID_USUARIO) {
        List datos = dao.listarContactos(ID_USUARIO);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarContacto")
    public String agregarContacto(@WebParam(name = "ID_USUARIO") int ID_USUARIO, @WebParam(name = "NOMBRES") String NOMBRES, @WebParam(name = "APELLIDOS") String APELLIDOS, @WebParam(name = "EMAIL") String EMAIL, @WebParam(name = "DIRECCION") String DIRECCION) {
        String datos = dao.add(ID_USUARIO, NOMBRES, APELLIDOS, EMAIL, DIRECCION);
        return datos;
    }

    /**
     * Web service operation
     */

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizarContacto")
    public String actualizarContacto(@WebParam(name = "ID") int ID, @WebParam(name = "ID_USUARIO") int ID_USUARIO, @WebParam(name = "NOMBRES") String NOMBRES, @WebParam(name = "APELLIDOS") String APELLIDOS, @WebParam(name = "EMAIL") String EMAIL, @WebParam(name = "DIRECCION") String DIRECCION) {
        String datos = dao.edit(ID, ID_USUARIO, NOMBRES, APELLIDOS, EMAIL, DIRECCION);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarContacto")
    public Contactos eliminarContacto(@WebParam(name = "ID") int ID) {
        Contactos contact = dao.delete(ID);
        return contact;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarContactoID")
    public Contactos listarContactoID(@WebParam(name = "ID") int ID) {
        Contactos contact = dao.listarContactoID(ID);
        
        return contact;
    }
    
}
