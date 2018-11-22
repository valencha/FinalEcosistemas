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
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreaPreguntaArqui extends Fragment {

    EditText edt_pregunta, edt_etiqueta;
    FirebaseDatabase database;
    Button btn_lanzar,btn_entendido;
    Switch sw_anonimo;
    String anonimo;
    Dialog epicDialog;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.editorpreguntaarqui, container, false);


        database = FirebaseDatabase.getInstance();

        DatabaseReference reference = database.getReference();




        edt_etiqueta = view.findViewById(R.id.edt_etiqueta);

        edt_pregunta = view.findViewById(R.id.edt_pregunta);

        btn_lanzar = view.findViewById(R.id.btn_lanzar);

        sw_anonimo = view.findViewById(R.id.sw_anonimo);



        epicDialog = new Dialog( view.getContext());

        if(sw_anonimo.isChecked()){
            anonimo = "Anonimo";


        }else {
            anonimo= "Nombre";
        }



        btn_lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pregunta = edt_pregunta.getText().toString();
                String etiqueta = edt_etiqueta.getText().toString();

                Pregunta preg= new Pregunta();
                preg.setPregunta(pregunta);
                preg.setEtiqueta(etiqueta);
               preg.setName(anonimo);


                DatabaseReference publicar = database.getReference();

                publicar.child("usuarios").child("preguntasArqui").push().setValue(preg);
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
                        new Clase1Arquitectura()).commit();
            }
        });


        epicDialog.show();



    }

}
