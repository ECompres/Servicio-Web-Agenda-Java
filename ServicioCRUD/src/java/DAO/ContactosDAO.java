    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Interfaces.ICrudContactos;
import Modelos.Contactos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emmanuel
 */
public class ContactosDAO implements ICrudContactos {

    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    Conexion cn = new Conexion();
    int res;
    String msj;

    @Override
    public List listarContactos(int id) {
        List<Contactos> listaContactos = new ArrayList<>();
        String sql = "select * from contactos where ID_USUARIO=" + id;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Contactos u = new Contactos();
                u.setID(rs.getInt("ID"));
                u.setID_USUARIO(rs.getInt("ID_USUARIO"));
                u.setNOMBRES(rs.getString("NOMBRES"));
                u.setAPELLIDOS(rs.getString("APELLIDOS"));
                u.setEMAIL(rs.getString("EMAIL"));
                u.setDIRECCION(rs.getString("DIRECCION"));
                listaContactos.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return listaContactos;
    }

    @Override
    public Contactos listarID(int id) {
        String sql = "select * from contactos where id =" + id;
        Contactos contacto = new Contactos();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                contacto.setID(rs.getInt("ID"));
                contacto.setID_USUARIO(rs.getInt("ID_USUARIO"));
                contacto.setNOMBRES(rs.getString("NOMBRES"));
                contacto.setAPELLIDOS(rs.getString("APELLIDOS"));
                contacto.setEMAIL(rs.getString("EMAIL"));
                contacto.setDIRECCION(rs.getString("DIRECCION"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return contacto;
    }

    @Override
    public String add(int ID_USUARIO, String NOMBRES, String APELLIDOS, String EMAIL, String DIRECCION) {
        String sql = "INSERT INTO contactos(ID_USUARIO,NOMBRES,APELLIDOS,EMAIL,DIRECCION) values(?,?,?,?,?)";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, ID_USUARIO);
            pst.setString(2, NOMBRES);
            pst.setString(3, APELLIDOS);
            pst.setString(4, EMAIL);
            pst.setString(5, DIRECCION);
            res = pst.executeUpdate();
            if (res == 1) {
                msj = "Contacto agregado";
            } else {
                msj = "Error";
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return msj;
    }

    @Override
    public String edit(int ID, int ID_USUARIO, String NOMBRES, String APELLIDOS, String EMAIL, String DIRECCION) {
        String sql = "update contactos set ID_USUARIO=?,NOMBRES = ?,APELLIDOS=?,EMAIL=?,DIRECCION=? where ID =" + ID;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, ID_USUARIO);
            pst.setString(2, NOMBRES);
            pst.setString(3, APELLIDOS);
            pst.setString(4, EMAIL);
            pst.setString(5, DIRECCION);
            res = pst.executeUpdate();
            if (res == 1) {
                msj = "Contacto actualizado";
            } else {
                msj = "Error";
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return msj;
    }

    @Override
    public Contactos delete(int id) {
        String sql = "delete from contactos where id=" + id;
        Contactos user = new Contactos();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return user;
    }

}
