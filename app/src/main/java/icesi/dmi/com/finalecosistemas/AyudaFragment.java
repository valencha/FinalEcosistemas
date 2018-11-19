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

        ArrayList<String> listComoUsar = new ArrayList<>();
        ArrayList<String> preguntasFrecuentes = new ArrayList<>();

        listAyuda.add("como");
        listAyuda.add("preguntas");


        listComoUsar.add("que");
        listComoUsar.add("como");
          preguntasFrecuentes.add("pregunta1");



        mapChild.put(listAyuda.get(0),listComoUsar);
        mapChild.put(listAyuda.get(1),preguntasFrecuentes);

        adapter = new ExplAdapter(this,listAyuda,mapChild);
        expandableListView.setAdapter(adapter);

    }
}


