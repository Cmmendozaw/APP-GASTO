package com.example.appgastos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appgastos.Utilidades.Utilidades;

import java.io.UTFDataFormatException;

public class MainActivity extends AppCompatActivity {

    ConexionSQLHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conn= new ConexionSQLHelper(getApplicationContext(), Utilidades.BASE_DE_DATOS,null,Utilidades.DB_VERSION);
    }
    public void nuevoUsuario(View view){
        String actionName = "android.intent.action.NuevoUsuarioActivity";
        Intent intent = new Intent(MainActivity.this,NuevoUsuarioActivity.class);
        startActivity(intent);

        Toast.makeText(this,"Ingreso para nuevo regsistro",Toast.LENGTH_SHORT).show();
    }

    public void login(View view){
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={((EditText)findViewById(R.id.etxtUser)).getText().toString().trim()};
        Toast.makeText(getApplicationContext(),parametros[0],Toast.LENGTH_LONG).show();
        String[] campos={Utilidades.CAMPO_UCOD, Utilidades.CAMPO_UNICK,Utilidades.CAMPO_UNOM,Utilidades.CAMPO_UAPE,Utilidades.CAMPO_UPASS};

        try {
            Cursor cursor =db.query(Utilidades.TB_USUARIO,campos,Utilidades.CAMPO_UNICK+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            //while (cursor.moveToNext()) {
                /*Toast.makeText(getApplicationContext(),"Consulta = "+cursor.getString(0)
                        +" "+cursor.getString(1)+" "+cursor.getString(2),Toast.LENGTH_LONG).show();*/
                //creamos un alertdialog para recordar su registro
                /*AlertDialog.Builder dialogNotfica = new AlertDialog.Builder(this);
                dialogNotfica.setTitle("Registro");
                dialogNotfica.setMessage("Consulta = "+cursor.getString(4)
                        +" "+cursor.getString(1)+" "+cursor.getString(2));
                dialogNotfica.setCancelable(false);
                dialogNotfica.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //onBackPressed();
                    }
                });
                dialogNotfica.show();

                 */
            //}

            /*Cursor cursor =db.query(Utilidades.TB_USUARIO,campos,Utilidades.CAMPO_UNICK+"=?",parametros,null,null,null);
            cursor.moveToFirst();*/

            if (cursor.getString(1).equals(((EditText)findViewById(R.id.etxtUser)).getText().toString().trim())
                    && cursor.getString(4).equals(((EditText)findViewById(R.id.etxtContraseña)).getText().toString().trim())){

                Toast.makeText(getApplicationContext(),"El usuario si existe",Toast.LENGTH_SHORT).show();
                cursor.close();
                Intent intent = new Intent(MainActivity.this,MenuInicialActivity.class);
                startActivity(intent);

            }else Toast.makeText(getApplicationContext(),"Usuario o Contraseña incorrecta",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El usuario no existe",Toast.LENGTH_SHORT).show();

        }
    }
}
