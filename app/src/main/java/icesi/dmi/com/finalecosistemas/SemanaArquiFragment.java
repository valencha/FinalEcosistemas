package icesi.dmi.com.finalecosistemas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SemanaArquiFragment extends Fragment {


    ListView lv_semana;
    SemanaArquiAdapter customAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_semanaarqui, container, false);

        lv_semana = view.findViewById(R.id.lv_semanas);
        customAdapter = new SemanaArquiAdapter(this);

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


        SemanaClassArqui newSemana1 = new SemanaClassArqui(titulo1);
        customAdapter.agregarImagen(newSemana1);

        SemanaClassArqui newS1clase1 = new SemanaClassArqui(s1clase1);
        customAdapter.agregarImagen(newS1clase1);


        SemanaClassArqui newS1clase2 = new SemanaClassArqui(s1clase2);
        customAdapter.agregarImagen(newS1clase2);



        SemanaClassArqui newSemana2 = new SemanaClassArqui(titulo2);
        customAdapter.agregarImagen(newSemana2);

        SemanaClassArqui newS2clase1 = new SemanaClassArqui(s2clase1);
        customAdapter.agregarImagen(newS2clase1);


        SemanaClassArqui newS2clase2 = new SemanaClassArqui(s2clase2);
        customAdapter.agregarImagen(newS2clase2);






        SemanaClassArqui newSemana3 = new SemanaClassArqui(titulo3);
        customAdapter.agregarImagen(newSemana3);


        SemanaClassArqui newS3clase1 = new SemanaClassArqui(s3clase1);
        customAdapter.agregarImagen(newS3clase1);


        SemanaClassArqui newS3clase2 = new SemanaClassArqui(s3clase2);
        customAdapter.agregarImagen(newS3clase2);

        return view;

    }

}

