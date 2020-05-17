package coursera.registrodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;

public class Confirmar extends AppCompatActivity implements View.OnClickListener {
    TextView nomape,fechN, email, telef, descp;
    Button editar, confirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        nomape = (TextView) findViewById(R.id.confNomApe);
        fechN = (TextView) findViewById(R.id.confFech);
        email = (TextView) findViewById(R.id.confEmail);
        telef = (TextView) findViewById(R.id.confTelef);
        descp = (TextView) findViewById(R.id.confDesc);
        editar = (Button) findViewById(R.id.btnEditar);
        confirmar = (Button) findViewById(R.id.btnConf);
        editar.setOnClickListener(this);
        confirmar.setOnClickListener(this);

        Bundle datos = getIntent().getExtras();
        nomape.setText(datos.getString("NomApe",""));
        fechN.setText(datos.getString("Fech",""));
        telef.setText(datos.getString("telef",""));
        email.setText(datos.getString("email",""));
        descp.setText(datos.getString("descr",""));
    }

    @Override
    public void onClick(View v) {
        Intent irRegistro = new Intent(this,MainActivity.class);
        if(v == editar){
            irRegistro.putExtra("opcion",1);
            irRegistro.putExtra("NomApe",nomape.getText().toString());
            irRegistro.putExtra("Fech",fechN.getText().toString());
            irRegistro.putExtra("telef",telef.getText().toString());
            irRegistro.putExtra("email",email.getText().toString());
            irRegistro.putExtra("descr",descp.getText().toString());
        }else if(v == confirmar){
            Toast.makeText(Confirmar.this,"Datos Guardados",Toast.LENGTH_LONG).show();
            irRegistro.putExtra("opcion",2);
        }
        startActivity(irRegistro);
        finish();
    }
}
