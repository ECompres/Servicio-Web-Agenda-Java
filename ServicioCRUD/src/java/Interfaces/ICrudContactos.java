/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Contactos;
import java.util.List;

/**
 *
 * @author Emmanuel
 */
public interface ICrudContactos {
    
    public List listarContactos(int id);
    public Contactos listarID(int id);
    public String add(int ID_USUARIO, String NOMBRES, String APELLIDOS, String EMAIL, String DIRECCION);
    public String edit(int ID, int ID_USUARIO, String NOMBRES, String APELLIDOS, String EMAIL, String DIRECCION);
    public Contactos delete(int id);
}
