package br.com.ternarius.atividade;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextlog;
    private EditText editTextpass;
    private Button btnlog;
    private TextView txtrecusuario;
    private Switch switchlogado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchlogado = findViewById(R.id.switchlogado);

        txtrecusuario = findViewById(R.id.txtrecusuario);

        btnlog = findViewById(R.id.btnlog);

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextlog = findViewById(R.id.log);
                editTextpass = findViewById(R.id.pass);

                String login = editTextlog.getText().toString();
                String senha = editTextpass.getText().toString();


                if (login.equals("senai") && senha.equals("senai")) {

                    abrircadatro();
                    mensagem("login efetuado com sucesso");
                    finish();
                }else {
                    mensagem("login ou senha incorreto");
                }
            }
        });

        txtrecusuario.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                mensagem("Senha: senai | Login: senai");

                return true;
            }
        });


    }

    public void mensagem(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    public void abrircadatro() {

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }
}
