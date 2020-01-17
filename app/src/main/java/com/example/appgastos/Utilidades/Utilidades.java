package com.example.appgastos.Utilidades;

public class Utilidades {

    //base de datos
    public static final String BASE_DE_DATOS = "bd_gastos";
    public static final int DB_VERSION = 1;

    //Campos de la tabla Usuario
    public static final String TB_USUARIO ="tb_usuario";
    public static final String CAMPO_UCOD = "user_cod";
    public static final String CAMPO_UNICK = "user_nick";
    public static final String CAMPO_UPASS = "user_pass";
    public static final String CAMPO_UNOM = "user_nom";
    public static final String CAMPO_UAPE = "user_ape";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE IF NOT EXISTS "+TB_USUARIO+" ("+CAMPO_UCOD+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_UNICK+" TEXT, "+CAMPO_UPASS+" TEXT, "+CAMPO_UNOM+" TEXT, "+CAMPO_UAPE+" TEXT)";

}
