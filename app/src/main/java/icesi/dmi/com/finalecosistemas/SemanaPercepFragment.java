package icesi.dmi.com.finalecosistemas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SemanaPercepFragment extends Fragment {


    ListView lv_semana;
    SemanaPercepAdapter customAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_semana, container, false);

        lv_semana = view.findViewById(R.id.lv_semanas);
        customAdapter = new SemanaPercepAdapter(this);

        lv_semana.setAdapter(customAdapter);
        String titulo1 = "titulo1";
        String titulo2 = "titulo2";
        String titulo3 = "titulo3";
        String s1clase1 = "s1clase1";
        String s1clase2 = "s1clase2";


        String s2clase1 = "s2clase1";
        String s2clase2 = "s2clase2";

        String s3clase1 = "s3clase1";
        String s3clase2 = "s3clase2";


        SemanaClassPercep newSemana1 = new SemanaClassPercep(titulo1);
        customAdapter.agregarImagen(newSemana1);

        SemanaClassPercep newS1clase1 = new SemanaClassPercep(s1clase1);
        customAdapter.agregarImagen(newS1clase1);


        SemanaClassPercep newS1clase2 = new SemanaClassPercep(s1clase2);
        customAdapter.agregarImagen(newS1clase2);



        SemanaClassPercep newSemana2 = new SemanaClassPercep(titulo2);
        customAdapter.agregarImagen(newSemana2);

        SemanaClassPercep newS2clase1 = new SemanaClassPercep(s2clase1);
        customAdapter.agregarImagen(newS2clase1);


        SemanaClassPercep newS2clase2 = new SemanaClassPercep(s2clase2);
        customAdapter.agregarImagen(newS2clase2);




        SemanaClassPercep newSemana3 = new SemanaClassPercep(titulo3);
        customAdapter.agregarImagen(newSemana3);


        SemanaClassPercep newS3clase1 = new SemanaClassPercep(s3clase1);
        customAdapter.agregarImagen(newS3clase1);


        SemanaClassPercep newS3clase2 = new SemanaClassPercep(s3clase2);
        customAdapter.agregarImagen(newS3clase2);



        return view;

    }

}

