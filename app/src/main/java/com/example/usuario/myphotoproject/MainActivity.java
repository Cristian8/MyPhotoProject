package com.example.usuario.myphotoproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.*;


public class MainActivity extends AppCompatActivity {
    int gusta = 0;
    int no_gusta = 0;
    private int[] array_imag = {R.drawable.ic_img_20150404_124327,R.drawable.ic_img_20150404_131241,R.drawable.ic_wapa};
    private int contador;
    private static int tamanio = 0;

    @Override
    protected void onStart() {
        Log.d("MIMENSAJE","Entro en onStart");
        super.onStart();

    }

    @Override
    protected void onResume() {
        Log.d("MIMENSAJE","Entro en onResume");
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("Contador", contador);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null){
            Log.d("MENSAJE", "BUNDLE vacio");
        }else{//bundle != null
            Log.d("MENSAJE", "BUNDLE con cosas");
            contador = bundle.getInt("Contador");
        }
        setContentView(R.layout.activity_main);
        Button boton1 = (Button) findViewById(R.id.botonsi);
        Button boton2 = (Button) findViewById(R.id.botonno);

        ImageView imagen = (ImageView)findViewById(R.id.imagen);
        imagen.setImageResource(array_imag[contador]);
        tamanio = array_imag.length;
        Log.d("MIMENSAJE", "Seteada la foto inicial");

        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (R.id.botonsi == view.getId()){
                    String mensajeSi = getResources().getString(R.string.mensajemegusta);
                    Toast toast = Toast.makeText(MainActivity.this,mensajeSi,Toast.LENGTH_SHORT);
                    toast.show();

                    SharedPreferences sp = getSharedPreferences("gustofotos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed = sp.edit();
                    ed.putBoolean("Contador"+contador, true);
                    Log.d("MIMENSAJE",contador+"");
                    Log.d("Mimensaje", String.valueOf(sp.getBoolean("gustofoto"+contador,true)));
                    ed.commit();
                    //contador = restar(contador);

                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    contador++;
                    if (contador == tamanio){
                        startActivity(intent);
                    }

                    ImageView imagen = (ImageView)findViewById(R.id.imagen);
                    imagen.setImageResource(array_imag[contador]);
                    Log.d("MIMENSAJE", "Ha tocado el botonSi");





                }
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (R.id.botonno == view.getId()){
                    String mensajeNo = getResources().getString(R.string.mensajenomegusta);
                    Toast toast = Toast.makeText(MainActivity.this,mensajeNo,Toast.LENGTH_SHORT);
                    toast.show();
                    SharedPreferences sp = getSharedPreferences("gustofotos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed = sp.edit();
                    Log.d("MIMENSAJE",contador+"");
                    ed.putBoolean("Contador"+contador, false);
                    Log.d("Mimensaje", String.valueOf(sp.getBoolean("gustofoto"+contador,false)));
                    ed.commit();

                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    //*contador = restar(contador);
                    contador++;
                    if (contador == tamanio){
                        startActivity(intent);
                    }
                    ImageView imagen = (ImageView)findViewById(R.id.imagen);
                    imagen.setImageResource(array_imag[contador]);
                    Log.d("MIMENSAJE", "Ha tocado el botonNo");


                }
            }
        });


    }
   /* public static int restar(int numero){
        if (tamanio == numero){
            numero= 0;
        }
            return numero;

    }*/
    /*public void btn1(View v){
        gusta++;
        Toast.makeText(this,"Me gustas"+ gusta,Toast.LENGTH_SHORT).show();
    }*/
   /* public void btn2(View v){
        no_gusta++;
        Toast.makeText(this,"No me gustas"+no_gusta,Toast.LENGTH_SHORT).show();
    }*/
}
