package icesi.dmi.com.finalecosistemas;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditaRetornoArqui extends Fragment {

    EditText edt_respuesta;
    FirebaseDatabase database;
    Button btn_lanzar,btn_entendido;
    Switch sw_anonimo;
    Dialog epicDialog;
    Boolean switchState;
    String tipo;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.retornopreguntaarqui, container, false);


        tipo=" ";
        database = FirebaseDatabase.getInstance();

        DatabaseReference reference = database.getReference();

        edt_respuesta = view.findViewById(R.id.edt_respuesta);


        btn_lanzar = view.findViewById(R.id.btn_responder);

        sw_anonimo = view.findViewById(R.id.sw_anon);


        epicDialog = new Dialog( view.getContext());



        btn_lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String respuesta = edt_respuesta.getText().toString();



                switchState =sw_anonimo.isChecked();

                if(switchState){
                    tipo="Anónimo";


                }else{
                    tipo = "Nombre";
                }


                Calendar c =Calendar.getInstance();

                SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
                String strDate = mdformat.format(c.getTime());
                String fecha = strDate;



                Respuesta res= new Respuesta();

                res.setRespuesta(respuesta);
                res.setName(tipo);
                res.setFecha(fecha);


                database.getReference().child("usuarios").child("respuestasArqui").push().setValue(res);
                ShowDialog();

            }
        });



        return view;
    }

    private void ShowDialog() {
        epicDialog.setContentView(R.layout.epic_popup_retorno);



        btn_entendido = epicDialog.findViewById(R.id.btn_entendido);


        btn_entendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RespuestasFragmentArqui()).commit();
            }
        });


        epicDialog.show();



    }
}
