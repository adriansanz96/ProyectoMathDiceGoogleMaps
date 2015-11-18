package com.example.adrians.splash;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JuegoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JuegoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JuegoFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView num1;
    private TextView num2;
    private TextView operador;
    private TextView resultado;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JuegoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JuegoFragment newInstance(String param1, String param2) {
        JuegoFragment fragment = new JuegoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;


    }

    public JuegoFragment() {
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
        View v = inflater.inflate(R.layout.fragment_juego, container, false);


        num1 = (TextView) v.findViewById(R.id.num1);
        num2 = (TextView) v.findViewById(R.id.num2);
        operador = (TextView) v.findViewById(R.id.operador);
        resultado = (TextView) v.findViewById(R.id.resultado);



        //DADOS ROJOS
        final ImageView rojo1 = (ImageView) v.findViewById(R.id.rojo1);//Primer dado rojo
        final ImageView rojo2 = (ImageView) v.findViewById(R.id.rojo2);//Segundo dado rojo

        final int primerorojo = (int) (Math.random() * 3) + 1; //creo un número aleatorio para el primer dado rojo con máx de 3 y mín de 1
        final int segundorojo = (int) (Math.random() * 3) + 1; //creo un número aleatorio para el segundo dado rojo con máx de 3 y mín de 1

        if (primerorojo == 1 || segundorojo == 1) { //SI SALE UN 1
            if (primerorojo == 1) {
                rojo1.setImageResource(R.drawable.dado1_3);
                rojo1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num1.setText("1");
                        resultadofinal();
                    }
                });
            }
            if (segundorojo == 1) {
                rojo2.setImageResource(R.drawable.dado1_3);
                rojo2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num1.setText("1");
                        resultadofinal();
                    }
                });
            }
        }
        if (primerorojo == 2 || segundorojo == 2) { //SI SALE UN 2
            if (primerorojo == 2) {
                rojo1.setImageResource(R.drawable.dado2_3);
                rojo1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num1.setText("2");
                        resultadofinal();
                    }
                });
            }
            if (segundorojo == 2) {
                rojo2.setImageResource(R.drawable.dado2_3);
                rojo2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num1.setText("2");
                    }
                });
            }
            resultadofinal();
        }

        if (primerorojo == 3 || segundorojo == 3) { //SI SALE UN 3
            if (primerorojo == 3) {
                rojo1.setImageResource(R.drawable.dado3_3);
                rojo1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num1.setText("3");
                        resultadofinal();
                    }
                });
            }
            if (segundorojo == 3) {
                rojo2.setImageResource(R.drawable.dado3_3);
                rojo2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num1.setText("3");
                        resultadofinal();
                    }
                });
            }
        }

        //DADOS AZULES
        final ImageView azul1 = (ImageView) v.findViewById(R.id.azul1); //Primer dado azul
        final ImageView azul2 = (ImageView) v.findViewById(R.id.azul2); //Segundo dado azul
        final ImageView azul3 = (ImageView) v.findViewById(R.id.azul3); //Tercer dado azul

        final int primeroazul = (int) (Math.random() * 6) + 1;//creo un número aleatorio para el primer dado azul con máx de 6 y mín de 1
        final int segundoazul = (int) (Math.random() * 6) + 1;
        final int terceroazul = (int) (Math.random() * 6) + 1;

        if (primeroazul == 1 || segundoazul == 1 || terceroazul == 1) { //SI SALE UN 1
            if (primeroazul == 1) {
                azul1.setImageResource(R.drawable.dado1_6);
                azul1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("1");
                        resultadofinal();
                    }
                });
            }
            if (segundoazul == 1) {
                azul2.setImageResource(R.drawable.dado1_6);
                azul2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("1");
                        resultadofinal();
                    }
                });
            }
            if (terceroazul == 1) {
                azul3.setImageResource(R.drawable.dado1_6);
                azul3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("1");
                        resultadofinal();
                    }
                });
            }
        }

        if (primeroazul == 2 || segundoazul == 2 || terceroazul == 2) { //SI SALE UN 2
            if (primeroazul == 2) {
                azul1.setImageResource(R.drawable.dado2_6);
                azul1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("2");
                        resultadofinal();
                    }
                });
            }
            if (segundoazul == 2) {
                azul2.setImageResource(R.drawable.dado2_6);
                azul2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("2");
                        resultadofinal();
                    }
                });
            }
            if (terceroazul == 2) {
                azul3.setImageResource(R.drawable.dado2_6);
                azul3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("2");
                        resultadofinal();
                    }
                });
            }
        }

        if (primeroazul == 3 || segundoazul == 3 || terceroazul == 3) { //SI SALE UN 3
            if (primeroazul == 3) {
                azul1.setImageResource(R.drawable.dado3_6);
                azul1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("3");
                        resultadofinal();
                    }
                });
            }
            if (segundoazul == 3) {
                azul2.setImageResource(R.drawable.dado3_6);
                azul2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("3");
                        resultadofinal();
                    }
                });
            }
            if (terceroazul == 3) {
                azul3.setImageResource(R.drawable.dado3_6);
                azul3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("3");
                        resultadofinal();
                    }
                });
            }
        }

        if (primeroazul == 4 || segundoazul == 4 || terceroazul == 4) { //SI SALE UN 4
            if (primeroazul == 4) {
                azul1.setImageResource(R.drawable.dado4_6);
                azul1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("4");
                        resultadofinal();
                    }
                });
            }
            if (segundoazul == 4) {
                azul2.setImageResource(R.drawable.dado4_6);
                azul2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("4");
                        resultadofinal();
                    }
                });
            }
            if (terceroazul == 4) {
                azul3.setImageResource(R.drawable.dado4_6);
                azul3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("4");
                        resultadofinal();
                    }
                });
            }
        }

        if (primeroazul == 5 || segundoazul == 5 || terceroazul == 5) { //SI SALE UN 5
            if (primeroazul == 5) {
                azul1.setImageResource(R.drawable.dado5_6);
                azul1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("5");
                        resultadofinal();
                    }
                });
            }
            if (segundoazul == 5) {
                azul2.setImageResource(R.drawable.dado5_6);
                azul2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("5");
                        resultadofinal();
                    }
                });
            }
            if (terceroazul == 5) {
                azul3.setImageResource(R.drawable.dado5_6);
                azul3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("5");
                        resultadofinal();
                    }
                });
            }
        }

        if (primeroazul == 6 || segundoazul == 6 || terceroazul == 6) { //SI SALE UN 6
            if (primeroazul == 6) {
                azul1.setImageResource(R.drawable.dado6_6);
                azul1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("6");
                        resultadofinal();
                    }
                });
            }
            if (segundoazul == 6) {
                azul2.setImageResource(R.drawable.dado6_6);
                azul2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("6");
                        resultadofinal();
                    }
                });
            }
            if (terceroazul == 6) {
                azul3.setImageResource(R.drawable.dado6_6);
                azul3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        num2.setText("6");
                        resultadofinal();
                    }
                });
            }

        }


    //DODECAEDRO
        final ImageView dodecaedro = (ImageView) v.findViewById(R.id.dodecaedro);
        final int aleatorio = (int) (Math.random() * 12) + 1;//creo un número aleatorio para el dodecaedro con máx de 12 y mín de 1

        if (aleatorio == 1){dodecaedro.setImageResource(R.drawable.dode1);}
        if (aleatorio == 2){dodecaedro.setImageResource(R.drawable.dode2);}
        if (aleatorio == 3){dodecaedro.setImageResource(R.drawable.dode3);}
        if (aleatorio == 4){dodecaedro.setImageResource(R.drawable.dode4);}
        if (aleatorio == 5){dodecaedro.setImageResource(R.drawable.dode5);}
        if (aleatorio == 6){dodecaedro.setImageResource(R.drawable.dode6);}
        if (aleatorio == 7){dodecaedro.setImageResource(R.drawable.dode7);}
        if (aleatorio == 8){dodecaedro.setImageResource(R.drawable.dode8);}
        if (aleatorio == 9){dodecaedro.setImageResource(R.drawable.dode9);}
        if (aleatorio == 10){dodecaedro.setImageResource(R.drawable.dode10);}
        if (aleatorio == 11){dodecaedro.setImageResource(R.drawable.dode11);}
        if (aleatorio == 12){dodecaedro.setImageResource(R.drawable.dode12);}


    //OPERADORES
        //suma
        final ImageView suma = (ImageView) v.findViewById(R.id.suma);
            suma.setImageResource(R.drawable.suma);
            suma.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    operador.setText("+");
                    resultadofinal();
                }
            });
       //resta
        final ImageView resta = (ImageView) v.findViewById(R.id.resta);
            resta.setImageResource(R.drawable.resta);
            resta.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    operador.setText("-");
                    resultadofinal();

                }
            });
        return v;

    }

    //Creo una clase para el resultado final, de esta forma
public void resultadofinal() {
    String operacion = operador.getText().toString();
    int n1 = Integer.parseInt(num1.getText().toString());
    int n2 = Integer.parseInt(num2.getText().toString());
    if (operacion == "-") {
        resultado.setText(String.valueOf(n1 - n2));
    }
    if (operacion == "+") {
        resultado.setText(String.valueOf(n1 + n2));
    }
}

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
