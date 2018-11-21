package icesi.dmi.com.finalecosistemas;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class SemanaArquiAdapter extends BaseAdapter{
    ArrayList<SemanaClassArqui> semanaClassArquis;
    Fragment fragment;


    public SemanaArquiAdapter(Fragment fragment){
        this.fragment = fragment;
        semanaClassArquis = new ArrayList<>();

    }

    @Override
    public int getCount() {
        return semanaClassArquis.size();
    }

    @Override
    public Object getItem(int i) {
        return semanaClassArquis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position , final View view, ViewGroup viewGroup) {

        LayoutInflater inflater= fragment.getLayoutInflater();



        View renglon=inflater.inflate(R.layout.listsemana, null,false);

        final ImageView img_list=renglon.findViewById(R.id.imgList);





       String tipo= semanaClassArquis.get(position).getTipo();


    if(tipo.equals("titulo1")){
           img_list.setImageResource(R.drawable.s1);


        }    else  if (tipo.equals("s1clase1") ) {

        img_list.setImageResource(R.drawable.s1clase1arqui);

        img_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                fragment.getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Clase1Arquitectura()).commit();
            }
        });

    }

    else  if (tipo.equals("s1clase2") ) {

        img_list.setImageResource(R.drawable.s1clase2arqui);

    }





        else if (tipo.equals("titulo2") ) {

        img_list.setImageResource(R.drawable.s2);

        }


       else  if (tipo.equals("titulo3") ) {

            img_list.setImageResource(R.drawable.s3);

        }




      //  System.out.println(gene);


        return renglon;
    }

    public void agregarImagen(SemanaClassArqui semanaClassArqui){

       semanaClassArquis.add(semanaClassArqui);


    }


}
