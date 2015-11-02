package com.example.adrians.splash;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adrian S on 02/11/2015.
 */
public class MenuAdapter extends ArrayAdapter<String>{

    private Context context;
    private ArrayList<String> datos;
    public MenuAdapter(Context context, ArrayList<String> datos) {
        super(context, 0, datos);
        this.context=context;
        this.datos=datos;
    }
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            convertView=inflater.inflate(R.layout.item_lista_perfil,null,true);


        }
        ImageView imagen=(ImageView) convertView.findViewById(R.id.imageViewperfil);
        TextView texto=(TextView) convertView.findViewById(R.id.textView);



       //APLICAR LAS DISTINTAS IMAGENES SEGUN LA POSICION
        switch(datos.get(position)) {
            case "Perfil": imagen.setImageResource (R.drawable.ic_face_black_24dp); //insertar icono
                texto.setText(" "+datos.get(position));
                texto.setBackgroundColor(Color.parseColor("#FFDD86")); //cambiar el color del fondo pantalla
                imagen.setBackgroundColor(Color.parseColor("#C0A663")); //cambiar el color del fondo de imagen

                break;
            case "Juego": imagen.setImageResource (R.drawable.ic_games_black_24dp);
                texto.setText(" " + datos.get(position));
                texto.setBackgroundColor(Color.parseColor("#F7A58C"));
                imagen.setBackgroundColor(Color.parseColor("#B76147"));
                break;
            case "Intrucciones": imagen.setImageResource (R.drawable.ic_insert_drive_file_black_24dp);
                texto.setText(" "+datos.get(position));
                texto.setBackgroundColor(Color.parseColor("#A7F589"));
                imagen.setBackgroundColor(Color.parseColor("#6DA458"));
                break;
            case "Info":imagen.setImageResource(R.drawable.ic_info_black_24dp);
                texto.setText(" "+datos.get(position));
                texto.setBackgroundColor(Color.parseColor("#B4E0DC"));
                imagen.setBackgroundColor(Color.parseColor("#4CA8A0"));
                break;
        }


        return convertView;
    }


}
