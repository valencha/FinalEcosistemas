package icesi.dmi.com.finalecosistemas;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.xmlpull.v1.XmlPullParser;


public class Clase1Ecosistemas extends Fragment{

    Button btn_lanzarBoomerang,btn_megusta;
    TextView tv_likes;
    ListView lv_preguntas;
    FirebaseDatabase database;

    FirebaseListAdapter<Pregunta> adapter;



        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.s1claseunoeco, container, false);




            btn_lanzarBoomerang = view.findViewById(R.id.btn_lanzar);

            lv_preguntas= view.findViewById(R.id.lv_preguntas);

            tv_likes = view.findViewById(R.id.tv_like);


            database = FirebaseDatabase.getInstance();




            DatabaseReference reference = database.getReference();


            Query ref= database.getReference().child("preguntas").child("megusta");

            FirebaseListOptions<Pregunta> options= new FirebaseListOptions.Builder<Pregunta>().setLayout(R.layout.renglonrespuesta).setQuery(ref, Pregunta.class).build();




            adapter= new FirebaseListAdapter<Pregunta>(options) {
                @Override

                protected void populateView(@NonNull View v, @NonNull Pregunta model, int position) {
                    TextView renglon_pregunta= v.findViewById(R.id.tv_pregunta);

                    Button btn_likes = v.findViewById(R.id.btn_like);


                    renglon_pregunta.setText(model.pregunta);


                  btn_likes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            database.getReference().child("preguntas").child("megusta").push().setValue("F");

                        }
                    });



                }
            };

            lv_preguntas.setAdapter(adapter);






            database.getReference().child("preguntas").child("megusta").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    String likes = dataSnapshot.getChildrenCount() +"";
                    tv_likes.setText(likes);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            btn_lanzarBoomerang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new CreaPregunta()).commit();

                }
            });
            return view;

    }




                @Override
    public void onStart() {
        super.onStart();
        //iniciar adaptador
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }



}
