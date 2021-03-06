package icesi.dmi.com.finalecosistemas;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class SemanaEcoAdapter extends BaseAdapter{
    ArrayList<SemanaClassEco> semanaClassEcos;
    Fragment fragment;


    public SemanaEcoAdapter(Fragment fragment){
        this.fragment = fragment;
        semanaClassEcos = new ArrayList<>();

    }

    @Override
    public int getCount() {
        return semanaClassEcos.size();
    }

    @Override
    public Object getItem(int i) {
        return semanaClassEcos.get(i);
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


       String tipo= semanaClassEcos.get(position).getTipo();


    if(tipo.equals("titulo1")){
           img_list.setImageResource(R.drawable.s1);


        }    else  if (tipo.equals("s1clase1") ) {

        img_list.setImageResource(R.drawable.s1clase1eco);

        img_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                fragment.getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Clase1Ecosistemas()).commit();
            }
        });

    }

    else  if (tipo.equals("s1clase2") ) {

        img_list.setImageResource(R.drawable.s1clase2eco);

    }





        else if (tipo.equals("titulo2") ) {

        img_list.setImageResource(R.drawable.s2);

        }


    else  if (tipo.equals("s2clase1") ) {

        img_list.setImageResource(R.drawable.s2clase1eco);

    }

    else  if (tipo.equals("s2clase2") ) {

        img_list.setImageResource(R.drawable.s2clase2eco);

    }



    else  if (tipo.equals("titulo3") ) {

            img_list.setImageResource(R.drawable.s3);

        }

    else  if (tipo.equals("s3clase1") ) {

        img_list.setImageResource(R.drawable.s3clase1eco);

    }

    else  if (tipo.equals("s3clase2") ) {

        img_list.setImageResource(R.drawable.s3clase2eco);

    }





      //  System.out.println(gene);


        return renglon;
    }

    public void agregarImagen(SemanaClassEco semanaClassEco){

       semanaClassEcos.add(semanaClassEco);


    }


}
