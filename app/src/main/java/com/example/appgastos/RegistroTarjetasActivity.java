package com.example.appgastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroTarjetasActivity extends AppCompatActivity {

    private EditText etxtFechaCierre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tarjetas);

        etxtFechaCierre = findViewById(R.id.etxtFechaCierre);
        etxtFechaCierre.addTextChangedListener(fechaIngresada);

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(etxtFechaCierre, smf);
        etxtFechaCierre.addTextChangedListener(mtw);

    }


    private TextWatcher fechaIngresada = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.e("beforeTextChanged","S "+s.toString());
        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.e("onTextChanged","Star "+start +"Count "+count +"before "+before+" CharSequence "+s.toString());

        }

        public void afterTextChanged(Editable s) {
            Log.e("afterTextChanged","S "+s.toString());
            if (s.length() == 0) {

            } else{
                    if (validarFecha(etxtFechaCierre.getText().toString())){
                        etxtFechaCierre.setError(null);
                    }else etxtFechaCierre.setError("Fecha incorrecta");
            }
        }
    };

    private Boolean validarFecha(String recibido){
        Log.e("Que recibo en el validar fecha","S "+recibido);
        DateFormat sdf = new SimpleDateFormat("dd-MM");
        sdf.setLenient(false);
        try {
            Date result =  sdf.parse(recibido);
            if (recibido.length()<5){
                return false;
            }

        } catch (ParseException e) {
            return false;
        }
        return true;
    }



}
