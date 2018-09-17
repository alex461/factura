package com.alex.proyectoprueba.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alex.proyectoprueba.R;
import com.alex.proyectoprueba.adaptador.MyAdaptador;
import com.alex.proyectoprueba.model.Pojo;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView rv;
    private MyAdaptador rvAdapter;
    private List<Pojo> datos;
    private TextView empres,rif,nombre,cedula,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cast();

        rv = findViewById(R.id.recicler);

        LinearLayoutManager linearLayoutM = new LinearLayoutManager(this);
        linearLayoutM.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutM);


        Bundle bundleObject=getIntent().getExtras();
        datos=(ArrayList<Pojo>) bundleObject.getSerializable("s");
        String bempresa = bundleObject.getString("e");
        String brif = bundleObject.getString("r");
        String bnombre = bundleObject.getString("n");
        String bapellido = bundleObject.getString("a");
        String bcedula = bundleObject.getString("c");
        String btotal = bundleObject.getString("total");



        empres.setText(bempresa);
        rif.setText(brif);
        nombre.setText("Cliente: "+bnombre+" "+bapellido);
        cedula.setText("CI: "+bcedula);
        total.setText("TOTAL "+btotal);




        rvAdapter = new MyAdaptador(datos, R.layout.card_item, this);
        rv.setAdapter(rvAdapter);


    }

    private void cast() {
        empres=findViewById(R.id.textNombreEmpresa);
        rif=findViewById(R.id.textNombreRif);
        nombre=findViewById(R.id.textNombrecliente);
        cedula=findViewById(R.id.textNombrecedula);
        total=findViewById(R.id.textTotal);
    }


}
