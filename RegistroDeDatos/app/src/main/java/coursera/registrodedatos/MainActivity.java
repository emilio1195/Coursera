package coursera.registrodedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Datos datosPrecargar = new Datos("","","","","");
    EditText nomape, email, telef, descp;
    TextView fechaN;
    Button fechNac, registrar;
    String txtFech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomape= (EditText) findViewById(R.id.nombape);
        fechaN= (TextView) findViewById(R.id.txtFecha);
        fechNac= (Button) findViewById(R.id.pickerFN);
        telef= (EditText) findViewById(R.id.telef);
        email= (EditText) findViewById(R.id.email);
        descp= (EditText) findViewById(R.id.descripcion);
        registrar = (Button) findViewById(R.id.registrar);

        Bundle datosPre = getIntent().getExtras();
        if (datosPre != null){
            if (datosPre.getInt("opcion",0) == 1){ ///si se eligio editar campos, se precargan los datos del objeto Datos
                nomape.setText(datosPre.getString("NomApe",""));
                fechaN.setText(datosPre.getString("Fech",""));
                telef.setText(datosPre.getString("telef",""));
                email.setText(datosPre.getString("email",""));
                descp.setText(datosPre.getString("descr",""));

            }else  if (datosPre.getInt("opcion",0) == 2){   ///Si los datos enviados fueron corrctos se limpian los campos
                nomape.setText("");
                fechaN.setText("");
                txtFech="";
                telef.setText("");
                email.setText("");
                descp.setText("");
            }
        }

        registrar.setOnClickListener(new View.OnClickListener() {  //Al colocar ingresar se va a la ventana de confirmacion
            @Override
            public void onClick(View v) {
                if(nomape.getText().toString()!= ""  && fechaN.getText().toString() != "" && telef.getText().toString() != ""
                        && email.getText().toString() != "" && descp.getText().toString() != "" ){ //restriccion campos vacios

                    Intent ventanaConfirmar = new Intent(MainActivity.this, Confirmar.class);
                    ventanaConfirmar.putExtra("NomApe",nomape.getText().toString());
                    ventanaConfirmar.putExtra("Fech",txtFech);
                    ventanaConfirmar.putExtra("telef",telef.getText().toString());
                    ventanaConfirmar.putExtra("email",email.getText().toString());
                    ventanaConfirmar.putExtra("descr",descp.getText().toString());
                    startActivity(ventanaConfirmar);
                    finish();
                }else
                    Toast.makeText(MainActivity.this,"Datos Incompletos",Toast.LENGTH_SHORT).show();

            }
        });

        fechNac.setOnClickListener(new View.OnClickListener() {  ////Listenes del icono de calendario, para abrir el pickCalendar
            int dia, mes, año;
            @Override
            public void onClick(View v) {
                /////pedimos los valores actuales del calendario
                final Calendar dialogCaalendar = Calendar.getInstance();
                dia = dialogCaalendar.get(Calendar.DAY_OF_MONTH);
                mes = dialogCaalendar.get(Calendar.MONTH);
                año = dialogCaalendar.get(Calendar.YEAR);
                ////////se llama al PickerDialosFecha y se guarda el dato en la variable cuando se da el evento de seleccion
                DatePickerDialog pickerFecha= new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtFech=dayOfMonth + "/" + (month + 1) + "/" + year; //convertimos indirectamente en Texto
                        fechaN.setText(txtFech);
                    }
                },dia,mes,año);
                pickerFecha.show();
            }
        });
    }

}
