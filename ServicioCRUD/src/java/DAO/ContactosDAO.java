/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.ICrudContactos;
import Modelos.Contactos;
import java.util.List;

/**
 *
 * @author Emmanuel
 */
public class ContactosDAO implements ICrudContactos{

    @Override
    public List listarContactos(int ID_USUARIO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(int ID_USUARIO, String NOMBRES, String APELLIDOS, String EMAIL, String DIRECCION) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(int ID, int ID_USUARIO, String NOMBRES, String APELLIDOS, String EMAIL, String DIRECCION) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contactos delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
