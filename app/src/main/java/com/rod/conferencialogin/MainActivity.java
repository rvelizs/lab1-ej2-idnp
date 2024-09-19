package com.rod.conferencialogin;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.rod.conferencialogin.databinding.ActivityMainBinding;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        EditText edNombres = binding.edTxtNombres;
        EditText edApellidos = binding.edTxtApellidos;
        EditText edCorreo = binding.edTxtCorreo;
        EditText edCelular = binding.edTxtCelular;
        EditText edSangre = binding.edTxtGS;
        Button btnRegister = binding.btnRegistrar;
        Button btnMostrarD = binding.btnMostrarDatos;

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombres = edNombres.getText().toString();
                String apellidos = edApellidos.getText().toString();
                String correo = edCorreo.getText().toString();
                String celular = edCelular.getText().toString();
                String sangre = edSangre.getText().toString();

                String data = nombres + "," + apellidos + "," + correo + "," + celular + "," + sangre;

                try {
                    FileOutputStream fos = openFileOutput("datos_censo.txt", MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                    Log.d("MainActivity", "Datos registrados correctamente");
                } catch (Exception e) {
                    Log.e("MainActivity", "Error al registrar datos", e);
                }
            }
        });


    }
}