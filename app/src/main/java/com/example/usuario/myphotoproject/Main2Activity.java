package com.example.usuario.myphotoproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = (TextView) findViewById(R.id.textresultado);
        boolean primerafoto = true;
        String mensaje = textView.getText().toString();
        int contadorfotos = 1;
        SharedPreferences sp = getSharedPreferences("gustofotos", Context.MODE_PRIVATE);

        for (int i = 0;i<=2;i++){

         //Boolean votos = sharedPreferences.getBoolean("Votos "+i, true);
           // String mensajefuera = String.valueOf(sp.getBoolean("Contador"+i ,true));


            if(sp.getBoolean("Contador"+i,false))
            {
                if(primerafoto)
                {
                    mensaje = "Los likes han ido para la: "+contadorfotos;
                }
                else
                {
                    mensaje = mensaje + ", la foto nº: " + contadorfotos;
                }
                contadorfotos++;
                primerafoto = false;
            }else{
                contadorfotos++;
            }
        }

        if(primerafoto)
        {
            mensaje = "Muy mal";
        }

        textView.setText(mensaje);
    }

}
