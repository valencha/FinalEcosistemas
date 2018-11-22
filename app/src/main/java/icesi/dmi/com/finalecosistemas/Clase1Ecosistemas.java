package icesi.dmi.com.finalecosistemas;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class Clase1Ecosistemas extends Fragment{

    Button btn_lanzarBoomerang;
    TextView tv_boomerangs;
    ExpandableHeightListView lv_preguntas;
    FirebaseDatabase db;

    FirebaseListAdapter<Pregunta> listAdapter;



        public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
            final View view=inflater.inflate(R.layout.s1claseunoeco, container, false);

            btn_lanzarBoomerang = view.findViewById(R.id.btn_lanzar);

            lv_preguntas= view.findViewById(R.id.lv_preguntas);

            tv_boomerangs = view.findViewById(R.id.tv_boomerangs);

            db = FirebaseDatabase.getInstance();



            DatabaseReference reference = db.getReference();


            Query preguntas= reference.child("usuarios").child("preguntas");

           final FirebaseListOptions<Pregunta> options= new FirebaseListOptions.Builder<Pregunta>().setLayout(R.layout.renglonrespuesta).setQuery(preguntas, Pregunta.class).build();




            listAdapter = new FirebaseListAdapter<Pregunta>(options) {


                @Override
                protected void populateView(@NonNull View v, @NonNull Pregunta model, final int position) {

                    Button btn_megusta = v.findViewById(R.id.btn_like);
                    TextView pregunta = v.findViewById(R.id.tv_pregunta);
                    TextView etiqueta= v.findViewById(R.id.tv_etiqueta);


                   final TextView tvLikes= v.findViewById(R.id.tv_like);


                   pregunta.setText(model.getPregunta());

                   etiqueta.setText(model.getEtiqueta());

                    db.getReference().child("usuarios").child("preguntas").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String views = Integer.toString((int) dataSnapshot.getChildrenCount()) ;

                            tv_boomerangs.setText(views);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                    btn_megusta.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listAdapter.getRef(position).child("puntua").push().setValue("F");
                        }
                    });


                    listAdapter.getRef(position).child("puntua").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String likes= Integer.toString((int) dataSnapshot.getChildrenCount());
                            tvLikes.setText(likes);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });





                }
            };

            lv_preguntas.setAdapter(listAdapter);






            btn_lanzarBoomerang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new CreaPreguntaEco()).commit();

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
