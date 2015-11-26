package com.example.adrians.splash;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Principal extends Activity implements ListFragment.ListFragmentListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        //PANTALLA COMPLETA
        if (savedInstanceState == null) {
        }
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);

    }


    public void onListSelected(int position,String item) {


        //PARA MÓVILES
        //Intent intent = new Intent(Principal.this, Menu2.class);
        //startActivity(intent);

        //PARA TABLETS

        if (item == "Perfil")  {

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
            TextView textview = (TextView) findViewById(R.id.textView2);
            textview.setText("");

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
