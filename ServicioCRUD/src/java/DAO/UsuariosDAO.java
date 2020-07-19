/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Interfaces.ICrudUsuarios;
import Modelos.Usuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emmanuel
 */
public class UsuariosDAO implements ICrudUsuarios{

    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    Conexion cn = new Conexion();
    
    @Override
    public List listarUsuarios() {
        List<Usuarios> listaUsuarios = new ArrayList<>();
        String sql = "select * from usuarios";
        try{
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Usuarios u = new Usuarios();
                u.setID(rs.getInt("ID"));
                u.setNOMBRES(rs.getString("NOMBRES"));
                u.setAPELLIDOS(rs.getString("APELLIDOS"));
                u.setEMAIL(rs.getString("EMAIL"));
                u.setPASSWORD(rs.getString("PASSWORD"));
                listaUsuarios.add(u);
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
        return listaUsuarios;
    }

    @Override
    public Usuarios listarID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(String NOMBRES, String APELLIDOS, String EMAIL, String PASSWORD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(int ID, String NOMBRES, String APELLIDOS, String EMAIL, String PASSWORD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuarios delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
