package br.com.ternarius.atividade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.InputMismatchException;

public class Main2Activity extends AppCompatActivity {

    EditText edtnome;
    EditText edtemail;
    EditText edtcpf;
    Button concluir;
    Button avancar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtnome = findViewById(R.id.edtnome);
        edtemail = findViewById(R.id.edtemail);
        edtcpf = findViewById(R.id.edtcpf);
        concluir = findViewById(R.id.concluir);
        avancar = findViewById(R.id.avancar);

        avancar.setVisibility(View.GONE);

        edtcpf.addTextChangedListener(Mask.insert(Mask.MaskType.CPF, edtcpf));


        concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cpf = Mask.unmask(edtcpf.getText().toString());
                String nome = edtnome.getText().toString();
                String email = edtemail.getText().toString();

                if (Mask.isCPF(cpf)&& isEmail(email) && isName(nome)) {

                    mensagem("Informações validas, AVANCE!\n", imprimeCPF(cpf));

                    edtcpf.setText(imprimeCPF(cpf));

                    avancar.setVisibility(View.VISIBLE);


                    }else if(!isName(nome)){

                            mensagem("Erro, Nome invalido !!!\n");

                            edtnome.setText("");

                            }else if(!isEmail(email)){

                                mensagem("Erro, Email invalido !!!\n");

                                edtemail.setText("");

                                }else if(!Mask.isCPF(cpf)) {

                                    mensagem("Erro, CPF invalido !!!\n"+cpf);

                                    edtcpf.setText("");
                                }
            }
        });


        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirBemVindo();
            }
        });
    }




    public void mensagem(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
    public void mensagem(String s, String t){
        Toast.makeText(this,s+t,Toast.LENGTH_LONG).show();
    }

    public void abrirBemVindo() {

        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);

    }

    public static String imprimeCPF(String CPF) {
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }


    public boolean isName(String s){
        if (s.length()> 6){
            return true;
        }else {
            return false;
        }
    }

    public boolean isEmail(String s){

        if(s.indexOf("@") != -1 && s.indexOf(".com") != -1 && s.length()> 14){
            return true;
        }else{
            return false;
        }

    }

}


