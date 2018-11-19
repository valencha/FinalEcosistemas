package icesi.dmi.com.finalecosistemas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class ExplAdapter extends BaseExpandableListAdapter {

    private ArrayList<String>listAyuda;
    private Map<String, ArrayList<String>>mapChild;
    private AyudaFragment context;

    public ExplAdapter(AyudaFragment context, ArrayList<String> listAyuda, Map<String, ArrayList<String>> mapChild) {
        this.context = context;
        this.listAyuda = listAyuda;
        this.mapChild = mapChild;

    }

    @Override
    public int getGroupCount() {
        return listAyuda.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mapChild.get(listAyuda.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listAyuda.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapChild.get(listAyuda.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {


        LayoutInflater inflater= context.getLayoutInflater();
        view=inflater.inflate(R.layout.elv_group, null,false);

        ImageView imageView = view.findViewById(R.id.imGroup);

        String tipo= (String) getGroup(groupPosition);

        if(tipo.equals("como")){
            imageView.setImageResource(R.drawable.como);


        }    else  if (tipo.equals("preguntas") ) {
            imageView.setImageResource(R.drawable.preguntasfre);


        }


            return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        String num = "";
        String titulo ="";
        String descripcion = "";

        String tipo= (String) getGroup(groupPosition);

        LayoutInflater inflater= context.getLayoutInflater();
       view=inflater.inflate(R.layout.elv_child, null,false);

        TextView tv_num = view.findViewById(R.id.tv_num);
        TextView tv_titulo = view.findViewById(R.id.tv_titulo);
        TextView tv_descripcion = view.findViewById(R.id.tv_descripcion);

        if(tipo.equals("que")){
            num = "1";
            titulo= "¿Qué es Boomerang?";
            descripcion = "Boomerang es una plataforma de preguntas y respuestas que busca unir a los alumnos " +
                    "con sus docentes durante el proceso de aprendizaje activo. Esto lo logra a partir de una sección " +
                    "donde los alumnos pueden manifestar sus dudas a sus demás compañeros y al docente, a la vez que este último " +
                    "puede evaluar a sus estudiantes por medio de cuestionarios que le permiten ver el nivel de comprensión de un tema en especifico.";
        }

     else{
            num = "1";
            titulo= "¿Qué es Boomerang?";
            descripcion = "Boomerang es una plataforma de preguntas y respuestas que busca unir a los alumnos " +
                    "con sus docentes durante el proceso de aprendizaje activo. Esto lo logra a partir de una sección " +
                    "donde los alumnos pueden manifestar sus dudas a sus demás compañeros y al docente, a la vez que este último " +
                    "puede evaluar a sus estudiantes por medio de cuestionarios que le permiten ver el nivel de comprensión de un tema en especifico.";


        }

        if(tipo.equals("como")){
            num = "1";
            titulo= "¿Qué es Boomerang?";
            descripcion = "Boomerang es una plataforma de preguntas y respuestas que busca unir a los alumnos " +
                    "con sus docentes durante el proceso de aprendizaje activo. Esto lo logra a partir de una sección " +
                    "donde los alumnos pueden manifestar sus dudas a sus demás compañeros y al docente, a la vez que este último " +
                    "puede evaluar a sus estudiantes por medio de cuestionarios que le permiten ver el nivel de comprensión de un tema en especifico.";
        }

        tv_num.setText(num);
        tv_titulo.setText(titulo);
        tv_descripcion.setText(descripcion);


        return view;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
