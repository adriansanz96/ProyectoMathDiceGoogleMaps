package com.example.adrians.splash;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends Activity implements ListFragment.ListFragmentListener{
private MediaPlayer reproductor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (findViewById(R.id.framelayout_dinamico) != null) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            // Cargamos el fragment del texto
            PerfilFragment perfil = new PerfilFragment();
            //CApturamos el cargador dinámico
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            // Reemplazamos la noticia
            transaction.replace(R.id.framelayout_dinamico, perfil);
            transaction.addToBackStack(null);
            // REalizamos el reemplazo
            transaction.commit();
        }

        //MUSICA DE FONDO
        reproductor= MediaPlayer.create(this,R.raw.musicadefondo);
        reproductor.setLooping(true);
        reproductor.start();




        //PANTALLA COMPLETA
        if (savedInstanceState != null) {
        }
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);

    }

    protected void onDestroy(){
        super.onDestroy();
        if (reproductor.isPlaying()){
            reproductor.stop();
            reproductor.release();
        }
    }


    public void onListSelected(int position,String item) {
        if (findViewById(R.id.framelayout_dinamico) != null) {
            //PARA TABLETS
            if (item == "Perfil") {

                PerfilFragment fragment1 = new PerfilFragment();
                getFragmentManager().beginTransaction().replace(R.id.framelayout_dinamico, fragment1).commit();
            }
            if (item == "Juego") {

                JuegoFragment fragment = new JuegoFragment();
                getFragmentManager().beginTransaction().replace(R.id.framelayout_dinamico, fragment).commit();

            }
            if (item == "Intrucciones") {
            }
            if (item == "Info") {
            }


            //Hacer desaparecer el TextView
            //TextView textview = (TextView) findViewById(R.id.textView2);
            //textview.setText("");

        } else {//PARA MÓVILES
            Intent mainIntent = new Intent(this,Menu2.class);
            mainIntent.putExtra("item", item);
            startActivity(mainIntent);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
