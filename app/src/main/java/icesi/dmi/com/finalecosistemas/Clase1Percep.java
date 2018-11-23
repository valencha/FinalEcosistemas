package icesi.dmi.com.finalecosistemas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class Clase1Percep extends Fragment{

    Button btn_lanzarBoomerang;
    TextView tv_boomerangs;
    ExpandableHeightListView lv_preguntas;
    FirebaseDatabase db;
    Boolean dioLike;
    FirebaseListAdapter<Pregunta> listAdapter;




        public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
            final View view=inflater.inflate(R.layout.s1claseunopercep, container, false);

            dioLike=false;



            btn_lanzarBoomerang = view.findViewById(R.id.btn_lanzar);

            lv_preguntas= view.findViewById(R.id.lv_preguntas);

            tv_boomerangs = view.findViewById(R.id.tv_boomerangs);

            db = FirebaseDatabase.getInstance();

            db.getReference().child("usuarios").child("preguntasPercep").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String views = dataSnapshot.getChildrenCount()+"";

                    tv_boomerangs.setText(views);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



            final DatabaseReference reference = db.getReference();


            Query preguntas= reference.child("usuarios").child("preguntasPercep");

            final  FirebaseListOptions<Pregunta> options= new FirebaseListOptions.Builder<Pregunta>().setLayout(R.layout.renglonrespuesta).setQuery(preguntas, Pregunta.class).build();

            listAdapter = new FirebaseListAdapter<Pregunta>(options) {


                @Override
                protected void populateView(@NonNull View v, @NonNull Pregunta model, final int position) {

                    ImageView btn_megusta = v.findViewById(R.id.btn_like);
                    final TextView pregunta = v.findViewById(R.id.tv_pregunta);
                    final TextView etiqueta= v.findViewById(R.id.tv_etiqueta);
                    final TextView nombre = v.findViewById(R.id.tv_nombre);
                    final  TextView time = v.findViewById(R.id.tv_time);
                   ImageView foto = v.findViewById(R.id.foto);



                   final TextView tvLikes= v.findViewById(R.id.tv_like);


                   pregunta.setText(model.getPregunta());
                   etiqueta.setText(model.getEtiqueta());
                   nombre.setText(model.getName());
                   time.setText(model.getFecha());


                  if(model.getName()=="Anónimo"){
                   foto.setImageResource(R.drawable.fotoanonimo);

                 }else{
                foto.setImageResource(R.drawable.fotopordefecto);
                 }



                    if(dioLike==false) {
                     btn_megusta.setOnClickListener(new View.OnClickListener() {
                      @Override
                        public void onClick(View v) {
                          listAdapter.getRef(position).child("puntuaPercep").push().setValue("F");


                     }
                      });

                    dioLike=true;
                 }else if (dioLike==true) {
                        btn_megusta.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                DatabaseReference drMegusta = FirebaseDatabase.getInstance().getReference("preguntasPercep").child("puntuaPercep");
                                drMegusta.removeValue();


                            }
                        });
                        dioLike=false;

                    }


                    lv_preguntas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                           getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new RespuestasFragmentPercep()).commit();



                        }

                    });

                    listAdapter.getRef(position).child("puntuaPercep").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String megusta = Integer.toString((int) dataSnapshot.getChildrenCount());

                            tvLikes.setText(megusta);


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
                            new CreaPreguntaPercep()).commit();

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
