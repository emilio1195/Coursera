package edu.uda.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        TextView txtabout = (TextView) findViewById(R.id.txtAbout);
        txtabout.setText("Me llamo Emilio Burbano, tengo 23 años, Soy de Ecuador, vivo en la ciudad de Cuenca, una de las mejores ciudades del mundo. \n" +
                "Soy estudiante en Ingenieria Electronica en la Universidad del Azuay, estoy a pocos meses de Graduarme donde me di cuenta que la programacion \n" +
                "es lo mio, me pierdo todo un dia solo averiguando cosas como funciona e intentando mejorar dichas tecnicas, por ello estoy en este curso para mejorar en mis habilidades.");
    }
}
