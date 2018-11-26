package icesi.dmi.com.finalecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class JuegaFragment extends Fragment {

    Button btnPlay;
    EditText code;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_juega, container, false);

        btnPlay = view.findViewById(R.id.btnPlay);

        code = view.findViewById(R.id.code);

        String codigo= code.getText().toString();


            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent intent = new Intent(JuegaFragment.this, JuegoPregunta.class);
                    Intent intent = new Intent(getActivity(), JuegaPregunta.class);
                    startActivity(intent);
                    //getContext().finish();
                }
            });



        return view;
    }


}
