package com.juliana.entrega_cuatro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btnInsertar, btnVer;
    EditText nombre,cargo,correo;
    DatabaseReference DatabaseEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsertar = findViewById(R.id.btnInsertar);
        btnVer = findViewById(R.id.btnVer);
        nombre = findViewById(R.id.nombre);
        cargo = findViewById(R.id.cargo);
        correo = findViewById(R.id.correo);
        DatabaseEmpleados = FirebaseDatabase.getInstance().getReference();



        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }

        });

        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListaEmpleados.class));
                finish();
            }
        });

    }

    private void InsertData() {
        String nombre_empleado = nombre.getText().toString();
        String cargo_empleado = cargo.getText().toString();
        String correo_empleado = correo.getText().toString();
        String id = DatabaseEmpleados.push().getKey();

        Empleado empleado = new Empleado(nombre_empleado,cargo_empleado,correo_empleado);
        DatabaseEmpleados.child("empleados").child(id).setValue(empleado)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Datos del empleado insertados ", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

}