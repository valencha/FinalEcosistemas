package icesi.dmi.com.finalecosistemas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class RespuestasFragmentPercep extends Fragment{


    Button btn_respuesta;

    FirebaseDatabase db;

    ExpandableHeightListView lv_respuestas;

    FirebaseListAdapter<Respuesta> listAdapter;






    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.respuesta, container, false);


        btn_respuesta = view.findViewById(R.id.btn_responder);


        lv_respuestas= view.findViewById(R.id.lv_respuestas);





        db = FirebaseDatabase.getInstance();


        final DatabaseReference reference = db.getReference();



        Query respuestas= reference.child("usuarios").child("respuestasPercep");

        final  FirebaseListOptions<Respuesta> options= new FirebaseListOptions.Builder<Respuesta>().setLayout(R.layout.renglonrespuesta2).setQuery(respuestas, Respuesta.class).build();

        listAdapter = new FirebaseListAdapter<Respuesta>(options) {


            @Override
            protected void populateView(@NonNull View v, @NonNull Respuesta model, final int position) {

                final TextView tvlikes= v.findViewById(R.id.tv_like);
                TextView nombre = v.findViewById(R.id.tv_nombre);
                TextView descripcion = v.findViewById(R.id.tv_pregunta);


                nombre.setText(model.getName());
                descripcion.setText(model.getRespuesta());




                listAdapter.getRef(position).child("puntuaResPercep").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String likes= Integer.toString((int) dataSnapshot.getChildrenCount());
                        tvlikes.setText(likes);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        };



        lv_respuestas.setAdapter(listAdapter);




        btn_respuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EditaRetornoPercep()).commit();

            }
        });


        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

        //iniciar adaptador
        listAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        listAdapter.stopListening();
    }

}
