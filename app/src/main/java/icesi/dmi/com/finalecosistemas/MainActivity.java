package icesi.dmi.com.finalecosistemas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity {
    ImageView img_1;
    EditText edt_name, edt_pass;
    Button btn_ingresar;
    TextView tv_noCuenta,tv_olvido;
    FirebaseDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseDatabase.getInstance();
        img_1= findViewById(R.id.img_1);
        edt_name= findViewById(R.id.edt_name);
        edt_pass=findViewById(R.id.edt_pass);
        tv_noCuenta= findViewById(R.id.tv_noCuenta);
        tv_olvido= findViewById(R.id.tv_olvido);
        btn_ingresar= findViewById(R.id.btn_ingresar);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario(edt_name.getText().toString(),edt_pass.getText().toString());
                db.getReference().child("usuarios").push().setValue(usuario);


                startActivity(new Intent(getApplicationContext(),Home.class));
                finish();

            }
        });






    }
}
