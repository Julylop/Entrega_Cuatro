package com.juliana.entrega_cuatro;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListaEmpleados extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Empleado>list;
    DatabaseReference databaseReference;
    MiAdapter adapter;


    @Override
    public void onBackPressed(){
      super.onBackPressed();
      startActivity(new Intent(ListaEmpleados.this, MainActivity.class));
      finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_empleados);

        recyclerView = findViewById(R.id.recycleView);
        databaseReference = FirebaseDatabase.getInstance().getReference("empleados");
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MiAdapter(this,list);
        recyclerView.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Empleado empleado = dataSnapshot.getValue(Empleado.class);
                    list.add(empleado);

                }
                adapter.notifyDataSetChanged();
                
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}