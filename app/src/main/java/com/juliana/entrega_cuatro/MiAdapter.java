package com.juliana.entrega_cuatro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdapter extends RecyclerView.Adapter<MiAdapter.MyViewHolder> {
    Context context;
    ArrayList<Empleado>list;


    public MiAdapter(Context context,ArrayList<Empleado> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.entrada_empleados,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Empleado empleado = list.get(position);
        holder.nombre.setText(empleado.getNombre());
        holder.cargo.setText(empleado.getCargo());
        holder.correo.setText(empleado.getCorreo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,cargo,correo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.texto_Nombre);
            cargo = itemView.findViewById(R.id.texto_Cargo);
            correo = itemView.findViewById(R.id.texto_Correo);
        }
    }
}
