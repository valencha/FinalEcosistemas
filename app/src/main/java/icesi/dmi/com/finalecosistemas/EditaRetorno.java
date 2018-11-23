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

public class EditaRetorno extends Fragment {

    EditText edt_respuesta;
    FirebaseDatabase database;
    Button btn_lanzar,btn_entendido;
    Switch sw_anonimo;
    Dialog epicDialog;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.retornopregunta, container, false);


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

                Respuesta preg= new Respuesta();

                preg.setRespuesta(respuesta);


                database.getReference().child("usuarios").child("respuestas").push().setValue(preg);
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
                        new RespuestasFragment()).commit();
            }
        });


        epicDialog.show();



    }
}
