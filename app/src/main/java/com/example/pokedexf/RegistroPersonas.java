package com.example.pokedexf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pokedexf.DAO.UsuarioDAO;
import com.example.pokedexf.Model.Usuario;


public class RegistroPersonas extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmailUsuario;
    private EditText etNombreUsuario;
    private EditText etApellidoUsuario;
    private EditText etPasswordUsuario01;
    private EditText etPasswordUsuario02;
    private Button btRegistrar;

    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etEmailUsuario = findViewById(R.id.etEmail);
        this.etNombreUsuario = findViewById(R.id.etNombreUsuario);
        this.etApellidoUsuario = findViewById(R.id.etApellidosUsuario);
        this.etPasswordUsuario01 = findViewById(R.id.etPassword01);
        this.etPasswordUsuario02 = findViewById(R.id.etPassword02);
        this.btRegistrar = findViewById(R.id.btRegistrar);
        this.btRegistrar.setOnClickListener(this);
        this.usuarioDAO = new UsuarioDAO(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btRegistrar){
            Usuario usu = new Usuario();
            usu.setEmail(this.etEmailUsuario.getText().toString());
            usu.setNombre(this.etNombreUsuario.getText().toString());
            usu.setApellido(this.etApellidoUsuario.getText().toString());
            usu.setPassword(this.etPasswordUsuario01.getText().toString());

            long rowId = this.usuarioDAO.insertarUsuario(usu);

            if(rowId > 0){
                Toast.makeText(RegistroPersonas.this, "Usuario registrado correctamente", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(RegistroPersonas.this, "Hubo problemas al registrar el usuario", Toast.LENGTH_LONG).show();
            }

            Intent i = new Intent(RegistroPersonas.this, Login.class);
            startActivity(i);
        }


    }
}
