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
public class UsuariosDAO implements ICrudUsuarios {

    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    Conexion cn = new Conexion();
    int res;
    String msj;

    @Override
    public List listarUsuarios() {
        List<Usuarios> listaUsuarios = new ArrayList<>();
        String sql = "select * from usuarios";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setID(rs.getInt("ID"));
                u.setNOMBRES(rs.getString("NOMBRES"));
                u.setAPELLIDOS(rs.getString("APELLIDOS"));
                u.setEMAIL(rs.getString("EMAIL"));
                u.setPASSWORD(rs.getString("PASSWORD"));
                u.setTIPO_USUARIO(rs.getInt("TIPO_USUARIO"));
                listaUsuarios.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return listaUsuarios;
    }

    @Override
    public Usuarios listarID(int id) {
        String sql = "select * from usuarios where id =" + id;
        Usuarios user = new Usuarios();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setID(rs.getInt("ID"));
                user.setNOMBRES(rs.getString("NOMBRES"));
                user.setAPELLIDOS(rs.getString("APELLIDOS"));
                user.setEMAIL(rs.getString("EMAIL"));
                user.setPASSWORD(rs.getString("PASSWORD"));
                user.setTIPO_USUARIO(rs.getInt("TIPO_USUARIO"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return user;
    }

    @Override
    public String add(String NOMBRES, String APELLIDOS, String EMAIL, String PASSWORD, int TIPO_USUARIO) {
        String sql = "INSERT INTO usuarios(NOMBRES,APELLIDOS,EMAIL,PASSWORD,TIPO_USUARIO) values(?,?,?,?,?)";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, NOMBRES);
            pst.setString(2, APELLIDOS);
            pst.setString(3, EMAIL);
            pst.setString(4, PASSWORD);
            pst.setInt(5, TIPO_USUARIO);
            res = pst.executeUpdate();
            if (res == 1) {
                msj = "Usuario agregado";
            } else {
                msj = "Error";
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return msj;
    }

    @Override
    public String edit(int ID, String NOMBRES, String APELLIDOS, String EMAIL, String PASSWORD, int TIPO_USUARIO) {
        String sql = "update usuarios set NOMBRES = ?, APELLIDOS=?,EMAIL=?,PASSWORD=?,TIPO_USUARIO=? where ID =" + ID;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, NOMBRES);
            pst.setString(2, APELLIDOS);
            pst.setString(3, EMAIL);
            pst.setString(4, PASSWORD);
            pst.setInt(5, TIPO_USUARIO);
            res = pst.executeUpdate();
            if (res == 1) {
                msj = "Usuario actualizado";
            } else {
                msj = "Error";
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return msj;
    }

    @Override
    public Usuarios delete(int id) {
        String sql = "delete from usuarios where id=" + id;
        Usuarios user = new Usuarios();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return user;
    }

    @Override
    public Usuarios logIn(String EMAIL, String PASSWORD) {
        Usuarios user = new Usuarios();
        try {
            con = cn.getConnection();
            String sql = "select ID,NOMBRES,APELLIDOS,EMAIL,PASSWORD,TIPO_USUARIO from usuarios where EMAIL=? and PASSWORD=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, EMAIL);
            pst.setString(2, PASSWORD);

            rs = pst.executeQuery();
            while (rs.next()) {
                user.setID(rs.getInt("ID"));
                user.setNOMBRES(rs.getString("NOMBRES"));
                user.setAPELLIDOS(rs.getString("APELLIDOS"));
                user.setEMAIL(rs.getString("EMAIL"));
                user.setPASSWORD(rs.getString("PASSWORD"));
                user.setTIPO_USUARIO(rs.getInt("TIPO_USUARIO"));
                return user;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return user;
    }

}
