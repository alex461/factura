package com.alex.proyectoprueba.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alex.proyectoprueba.R;
import com.alex.proyectoprueba.model.Pojo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText ediContri, ediRif, ediNombre, ediApellido, ediCedula;
    private TextInputEditText edicodigoProducto, ediProducto, ediCantidad, ediPrecio;
    private String empres,rif,nombre,apellido,cedula;

    private Button btAgregar,btTotal;
    private Double num3;
    private double total=0;
    private ArrayList<Pojo> datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cast();
        datos=new ArrayList<>();

    }

    private void crearDatos() {
        datos.add(new Pojo(edicodigoProducto.getText().toString(),
                ediCantidad.getText().toString(),
                ediPrecio.getText().toString(),ediProducto.getText().toString()));
    }

    public void btAgregar(View view) {
            if(validarCampos()==true){
            Double num1 = Double.parseDouble(ediCantidad.getText().toString());
            Double num2 = Double.parseDouble(ediPrecio.getText().toString());

            if(num1>0&&num1<100) {

                num3=num1*num2;
                total+=num3;
                crearDatos();

                btTotal.setText(String.valueOf(R.string.total+ total));
                btTotal.setEnabled(true);
            }else {
                Toast.makeText(this, R.string.validadorCantidad, Toast.LENGTH_SHORT).show();
            }

            }else {
                Toast.makeText(this, R.string.validadorCampos, Toast.LENGTH_SHORT).show();

            }

            }


    public void btTotal(View view) {

        empres=ediContri.getText().toString();
        rif=ediRif.getText().toString();
        nombre=ediNombre.getText().toString();
        apellido=ediApellido.getText().toString();
        cedula=ediCedula.getText().toString();

        Intent i = new Intent(MainActivity.this,Main2Activity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("s",datos);
        bundle.putString("e",empres);
        bundle.putString("r",rif);
        bundle.putString("n",nombre);
        bundle.putString("c",cedula);
        bundle.putString("a",apellido);
        bundle.putString("total",""+total);

        i.putExtras(bundle);
        startActivity(i);
        }


    private void cast() {
        ediContri=findViewById(R.id.ediContri);
        ediRif=findViewById(R.id.ediRif);
        ediNombre=findViewById(R.id.ediNombre);
        ediApellido=findViewById(R.id.ediApellido);
        ediCedula=findViewById(R.id.ediCedula);
        edicodigoProducto=findViewById(R.id.edicodigoProducto);
        ediProducto=findViewById(R.id.ediProducto);
        ediCantidad=findViewById(R.id.ediCantidad);
        ediPrecio=findViewById(R.id.ediPrecio);
        btAgregar=findViewById(R.id.btAgregar);
        btTotal=findViewById(R.id.btTotal);

    }

    private boolean validarCampos(){
        if(ediContri.getText().toString().isEmpty()||
                ediRif.getText().toString().isEmpty()||
                ediNombre.getText().toString().isEmpty()||
                ediApellido.getText().toString().isEmpty()||
                ediCedula.getText().toString().isEmpty()||
                edicodigoProducto.getText().toString().isEmpty()||
                ediProducto.getText().toString().isEmpty()||
                ediCantidad.getText().toString().isEmpty()||
                ediPrecio.getText().toString().isEmpty()
                ){
            return false;
        }else{
            return true;
        }
    }

}
