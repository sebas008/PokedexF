package com.example.pokedexf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokedexf.DAO.UsuarioDAO;
import com.example.pokedexf.Model.Usuario;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private TextView tvRegistrese;
    private EditText etNombreUsuario;
    private EditText etPasswordUsuario;
    private Button btIngresar;

    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.etNombreUsuario = findViewById(R.id.etUsuario);
        this.etPasswordUsuario = findViewById(R.id.etPassword);
        this.btIngresar = findViewById(R.id.btIngresar);
        this.tvRegistrese = findViewById(R.id.tvRegistrese);

        this.btIngresar.setOnClickListener(this);
        this.tvRegistrese.setOnClickListener(this);

        this.usuarioDAO = new UsuarioDAO(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btIngresar) {

            Usuario usu = new Usuario();
            usu.setEmail(this.etNombreUsuario.getText().toString());
            usu.setPassword(this.etPasswordUsuario.getText().toString());

            Usuario logueo = usuarioDAO.validarLogueo(usu);

            if (logueo != null) {
                Toast.makeText(Login.this, "Usuario logueado correctamente", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(Login.this, "Hubo problemas al validar el usuario", Toast.LENGTH_LONG).show();
            }
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);

        } else if (v.getId() == R.id.tvRegistrese) {
                Intent i = new Intent(Login.this, RegistroPersonas.class);
                startActivity(i);

        }
    }
}
