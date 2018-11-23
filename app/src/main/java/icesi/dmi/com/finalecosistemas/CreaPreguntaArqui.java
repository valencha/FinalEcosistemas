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

public class CreaPreguntaArqui extends Fragment {

    EditText edt_pregunta, edt_etiqueta;
    FirebaseDatabase database;
    Button btn_lanzar,btn_entendido;
    Switch sw_anonimo;
    Dialog epicDialog;
    String tipo;

    Boolean switchState;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.editorpreguntaarqui, container, false);


        database = FirebaseDatabase.getInstance();

        DatabaseReference reference = database.getReference();

        tipo="";


        edt_etiqueta = view.findViewById(R.id.edt_etiqueta);

        edt_pregunta = view.findViewById(R.id.edt_pregunta);

        btn_lanzar = view.findViewById(R.id.btn_lanzar);

        sw_anonimo = view.findViewById(R.id.sw_anonimo);




        epicDialog = new Dialog( view.getContext());



        btn_lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pregunta = edt_pregunta.getText().toString();
                String etiqueta = edt_etiqueta.getText().toString();

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


                Pregunta preg= new Pregunta();
                preg.setPregunta(pregunta);
                preg.setEtiqueta(etiqueta);
                preg.setName(tipo);
                preg.setFecha(fecha);


                database.getReference().child("usuarios").child("preguntasArqui").push().setValue(preg);
                ShowDialog();

            }
        });



        return view;
    }

    private void ShowDialog() {
        epicDialog.setContentView(R.layout.epic_popup_boomerang);



        btn_entendido = epicDialog.findViewById(R.id.btn_entendido);


        btn_entendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Clase1Arqui()).commit();
            }
        });


        epicDialog.show();



    }

    public Boolean getSwitchState() {
        return switchState;
    }

    public void setSwitchState(Boolean switchState) {
        this.switchState = switchState;
    }
}
