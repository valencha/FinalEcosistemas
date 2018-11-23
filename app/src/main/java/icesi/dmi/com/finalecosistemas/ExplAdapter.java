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

        if(tipo.equals("preguntas")){
            imageView.setImageResource(R.drawable.preguntasfre);


        }  else{
            imageView.setImageResource(R.drawable.iniciaren);


        }


            return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {


        String tipo= (String) getChild(groupPosition,childPosition);

        LayoutInflater inflater= context.getLayoutInflater();
       view=inflater.inflate(R.layout.elv_child, null,false);

        ImageView tv_imagen = view.findViewById(R.id.img_ayuda);

        if(tipo.equals("pregunta1")){
            tv_imagen.setImageResource(R.drawable.como);


        }
        if(tipo.equals("pregunta2")){
            tv_imagen.setImageResource(R.drawable.quepasa);


        }


        if(tipo.equals("pregunta3")){
            tv_imagen.setImageResource(R.drawable.pasa);


        }


        if(tipo.equals("pregunta4")){
            tv_imagen.setImageResource(R.drawable.quemas);


        }


        if(tipo.equals("ques")){
            tv_imagen.setImageResource(R.drawable.ques);


        }


        if(tipo.equals("utilizar")){
            tv_imagen.setImageResource(R.drawable.comoutilizar);


        }







        return view;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
