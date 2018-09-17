package com.alex.proyectoprueba.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alex.proyectoprueba.R;
import com.alex.proyectoprueba.model.Pojo;

import java.util.List;

public class MyAdaptador extends RecyclerView.Adapter<MyAdaptador.MiViewHolder> {

    private List<Pojo> facturas;
    private int layout;
    private Activity activity;

    public MyAdaptador(List<Pojo> facturas, int layout, Activity activity) {
        this.facturas = facturas;
        this.layout = layout;
        this.activity = activity;
    }

    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        MiViewHolder vh = new MiViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {
        holder.bind(facturas.get(position));

    }

    @Override
    public int getItemCount() {
        return facturas.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder{


        private TextView card3;

        private TextView card6;
        private TextView card7;
        private TextView card8;


        public MiViewHolder(View itemView) {
            super(itemView);


            card3 = itemView.findViewById(R.id.tcodigo);
            card6 =itemView.findViewById(R.id.tcantXpro);
            card7 = itemView.findViewById(R.id.tproTotal);
            card8=itemView.findViewById(R.id.tdescripcion);

        }

        public void bind(Pojo pojo){

            card3.setText("CODIGO: "+pojo.getEdicodigoProducto());

            card6.setText(pojo.getEdiCantidad()+" x "+Double.parseDouble(pojo.getEdiPrecio()));
            card7.setText(""+Double.parseDouble(pojo.getEdiCantidad())*Double.parseDouble(pojo.getEdiPrecio()));
            card8.setText(pojo.getEdiDescripcion());


        }
    }




}

