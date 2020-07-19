/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Usuarios;
import java.util.List;

/**
 *
 * @author Emmanuel
 */
public interface ICrudUsuarios {
    public List listarUsuarios();
    public Usuarios listarID(int id);
    public String add(String NOMBRES, String APELLIDOS, String EMAIL, String PASSWORD);
    public String edit(int ID, String NOMBRES, String APELLIDOS, String EMAIL, String PASSWORD);
    public Usuarios delete(int id);
}
