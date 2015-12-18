package com.example.adrians.splash;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Adrian S on 11/11/2015.
 */
public class Menu2 extends Activity implements PerfilFragment.PerfilFragmentListener{

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        // Recogemos los datos del primer activity
        String extras = getIntent().getExtras().getString("item");

//PARA MOVILES
        if (extras.equals("Perfil")) {
            PerfilFragment fragment1 = new PerfilFragment();
            getFragmentManager().beginTransaction().replace(R.id.framelayout_menu2, fragment1).commit();
        }
        if (extras.equals("Juego")) {
            JuegoFragment fragment = new JuegoFragment();
            getFragmentManager().beginTransaction().replace(R.id.framelayout_menu2, fragment).commit();

        }
        if (extras.equals("Intrucciones")) {
        }
        if (extras.equals ("Info")) {
        }
    }

    @Override
    public void onListSelected(int position) {

    }
}
