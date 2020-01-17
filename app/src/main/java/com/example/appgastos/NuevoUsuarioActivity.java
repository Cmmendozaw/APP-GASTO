package com.example.appgastos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appgastos.Utilidades.Utilidades;

public class NuevoUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);
    }


    public void registrarUsuarios(View view){

        if (((EditText)findViewById(R.id.etxtApellido)).getText().toString().length() > 0
            && ((EditText)findViewById(R.id.etxtPassword)).getText().toString().length() > 0
            && ((EditText)findViewById(R.id.etxtNombres)).getText().toString().length() > 0){

            ConexionSQLHelper conn = new ConexionSQLHelper(this, Utilidades.BASE_DE_DATOS, null, Utilidades.DB_VERSION);
            SQLiteDatabase db = conn.getWritableDatabase();

            ContentValues values = new ContentValues();

            String nick,letraNombres;
            nick = "";
            letraNombres =  ((EditText)findViewById(R.id.etxtNombres)).getText().toString().trim();

            for (int contador=0; letraNombres.length() > contador;contador++){
                if (contador==0){
                    nick = nick + letraNombres.charAt(contador);
                }else if (letraNombres.charAt(contador) == ' '){
                    nick = nick + letraNombres.charAt(contador+1);
                    break;
                }
            }

            letraNombres = ((EditText)findViewById(R.id.etxtApellido)).getText().toString().trim();

            for (int contador=0; letraNombres.length() > contador;contador++){
                if (letraNombres.charAt(contador) == ' '){
                    break;
                }
                nick = nick + letraNombres.charAt(contador);
            }

            values.put(Utilidades.CAMPO_UNICK, nick);
            values.put(Utilidades.CAMPO_UPASS, ((EditText) findViewById(R.id.etxtPassword)).getText().toString());
            values.put(Utilidades.CAMPO_UNOM, ((EditText) findViewById(R.id.etxtNombres)).getText().toString().trim());
            values.put(Utilidades.CAMPO_UAPE, ((EditText) findViewById(R.id.etxtApellido)).getText().toString().trim());

            Long idResultante = db.insert(Utilidades.TB_USUARIO, Utilidades.CAMPO_UCOD, values);

            Toast.makeText(getApplicationContext(), "Nuevo Registro " + idResultante, Toast.LENGTH_SHORT).show();
            //creamos un alertdialog para recordar su registro
            AlertDialog.Builder dialogNotfica = new AlertDialog.Builder(this);
            dialogNotfica.setTitle("Registro");
            dialogNotfica.setMessage("Se registró al usuario "+nick);
            dialogNotfica.setCancelable(false);
            dialogNotfica.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onBackPressed();
                }
            });
            dialogNotfica.show();

            db.close();
        }else Toast.makeText(this,"Debe completar todos los campos para realizar el registro",Toast.LENGTH_LONG).show();
    }
}
