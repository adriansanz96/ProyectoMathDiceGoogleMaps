package com.example.adrians.splash;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PerfilFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    PerfilActivity perfil = (PerfilActivity) getActivity();

    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    protected static final String TAG="Localizando";

    public EditText localizacion;

    //Fichero de guardado
    private Uri fileUri;

    //Tipos definidos
    public static final int MEDIA_TYPE_IMAGE = 1;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    PerfilFragmentListener mListener;
    // Container Activity must implement this interface
    public interface PerfilFragmentListener {
        public void onListSelected(int position);//El Activity lo va a tener que definir


    }

    public PerfilFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);



        //LOCALIZACION
        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

//PREFERECIAS
        final EditText nombre = (EditText) v.findViewById(R.id.editText3);
        final EditText apellidos = (EditText)v.findViewById(R.id.editText4);


        //Capturamos las preferencias de Usuario

        final SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());


        nombre.setText(pref.getString("nombre",""));
        apellidos.setText(pref.getString("apellidos", ""));

        final Button guardar=(Button)v.findViewById(R.id.button3);

        guardar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor prefPerfil = pref.edit();
                        prefPerfil.putString("nombre", nombre.getText().toString());
                        prefPerfil.putString("apellidos", apellidos.getText().toString());
                        prefPerfil.commit();


                    }
                }
        );




    //CAMARA
        //Lanzamos la cámara
        final Button boton=(Button) v.findViewById(R.id.button2);
        boton.setOnClickListener(new Button.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         // create Intent to take a picture and return control to the calling application
                                         Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                                         fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
                                         camara.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

                                         // start the image capture Intent
                                         startActivityForResult(camara, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

                                                 //Colocamos el nombre del fichero
                                                     //final EditText localizacion = (EditText) findViewById(R.id.editText5);
                                                     //localizacion.setText(fileUri.getPath());
                                         //Añadimos la imagen al ImageView
                                         final ImageView imagenperfil = (ImageView) getView().findViewById(R.id.imageView3);
                                         Uri imgUri = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/MyCameraApp/IMG_PERFIL.jpg");
                                         imagenperfil.setImageURI(imgUri);

                                     }
                                 }
        );

        return v;
    }

//LOCALIZACION

    public void onConnected(Bundle bundle) {

        Log.i(TAG,"Conectado con exito");
        try {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);
            if (mLastLocation != null) {
                localizacion = (EditText) getView().findViewById(R.id.editText5);
                localizacion.setText("Latitud: " + String.valueOf(mLastLocation.getLatitude() + " Longitud: " +
                        String.valueOf(mLastLocation.getLongitude())));
            }
        }catch (SecurityException e){
            Log.i(TAG,"Denegada la localización");
        }
    }


    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Finalizado o Suspendido");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        localizacion = (EditText) getView().findViewById(R.id.editText5);
        localizacion.setText("Error en la conexion");
        Log.i(TAG, "Error en la conexion " + connectionResult.getErrorMessage());
    }

    public void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    public void onStop() {
        if(mGoogleApiClient.isConnected())
            mGoogleApiClient.disconnect();
        super.onStop();
    }

//CAMARA
    /** Create a file Uri for saving an image or video */
    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_PERFIL.jpg");
        }  else {
            return null;
        }

        return mediaFile;
    }

    @Override
    public void onAttach(Context context ) {
        super.onAttach(context);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception

        try {
            mListener = (PerfilFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnPerfilFragmentListenerListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; //Cerrar para no haya errores
    }

    //INNER CLASS
    private class nuestroListener implements AdapterView.OnItemClickListener{
        public void onItemClick (AdapterView<?> parent, View view, int position, long id){
            //String de la posicion clickada
            String item = (String) parent.getItemAtPosition(position);
            //Toast.makeText(MainActivity.this,item,Toast.LENGTH_LONG).show();
            //Paso de informacion
            mListener.onListSelected(position);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
