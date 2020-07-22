/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Emmanuel
 */
public class Contactos {
    int ID;
    int ID_USUARIO;
    String NOMBRES;
    String APELLIDOS;
    String EMAIL;
    String DIRECCION;

    public Contactos() {
    }

    public Contactos(int ID, int ID_USUARIO, String NOMBRES, String APELLIDOS, String EMAIL, String DIRECCION) {
        this.ID = ID;
        this.ID_USUARIO = ID_USUARIO;
        this.NOMBRES = NOMBRES;
        this.APELLIDOS = APELLIDOS;
        this.EMAIL = EMAIL;
        this.DIRECCION = DIRECCION;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }
    
}
