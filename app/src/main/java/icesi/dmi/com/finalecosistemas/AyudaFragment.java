package icesi.dmi.com.finalecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AyudaFragment extends Fragment {

    private ExpandableListView expandableListView;
    private ExplAdapter adapter;
    private ArrayList<String >listAyuda;
    private Map<String, ArrayList<String>>mapChild;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ayuda, container, false);


        expandableListView = view.findViewById(R.id.expl);
        listAyuda = new ArrayList<>();
        mapChild = new HashMap<>();

        cargarDatos();
        return view;
    }


    private void cargarDatos(){


        ArrayList<String> preguntasFrecuentes = new ArrayList<>();
        ArrayList<String> listComoUsar = new ArrayList<>();


        listAyuda.add("preguntas");
        listAyuda.add("como");
        preguntasFrecuentes.add("pregunta1");
        preguntasFrecuentes.add("pregunta2");
        preguntasFrecuentes.add("pregunta3");
        preguntasFrecuentes.add("pregunta4");
       listComoUsar.add("ques");
        listComoUsar.add("utilizar");


        mapChild.put(listAyuda.get(0),preguntasFrecuentes);
        mapChild.put(listAyuda.get(1),listComoUsar);


        adapter = new ExplAdapter(this,listAyuda,mapChild);
        expandableListView.setAdapter(adapter);

    }
}


