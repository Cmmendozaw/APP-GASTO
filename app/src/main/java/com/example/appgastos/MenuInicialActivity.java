package com.example.appgastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuInicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
    }

    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btnRegistroGastos:
                miIntent=new Intent(MenuInicialActivity.this,null);
                break;
            case R.id.btnRegistroIngresos:
                miIntent=new Intent(MenuInicialActivity.this,null);
                break;
            case R.id.btnRegistrarMedio:
                miIntent=new Intent(MenuInicialActivity.this,RegistroTarjetasActivity.class);
                break;
            case R.id.btnVerTarjetas:
                miIntent=new Intent(MenuInicialActivity.this,null);
                break;
            case R.id.btnReporteGastos:
                miIntent=new Intent(MenuInicialActivity.this,null);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }

    }
}
