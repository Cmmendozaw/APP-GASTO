package com.example.appgastos.entidades;

import java.io.Serializable;
import java.lang.ref.SoftReference;

public class Usuario implements Serializable {

    private int user_nick;
    private String user_pass;
    private String user_nom;
    private String user_ape;

    public Usuario() {

    }

    public Usuario(int user_nick, String user_pass, String user_nom, String user_ape) {
        this.user_nick = user_nick;
        this.user_pass = user_pass;
        this.user_nom = user_nom;
        this.user_ape = user_ape;
    }

    public int getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(int user_nick) {
        this.user_nick = user_nick;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_nom() {
        return user_nom;
    }

    public void setUser_nom(String user_nom) {
        this.user_nom = user_nom;
    }

    public String getUser_ape() {
        return user_ape;
    }

    public void setUser_ape(String user_ape) {
        this.user_ape = user_ape;
    }
}
