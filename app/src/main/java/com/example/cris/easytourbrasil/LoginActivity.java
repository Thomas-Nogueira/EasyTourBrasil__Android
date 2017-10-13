package com.example.cris.easytourbrasil;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private final static int TIME_SPLASH = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        //Instância o button
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);

                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();
                if(login.equals("admin")&&senha.equals("123")){
                    alert("Login realizado com sucesso!");
                    new Handler().postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            //Código rodará depois do tempo definido.
                            Intent dashboard = new Intent (LoginActivity.this, MapsActivity.class);
                            startActivity(dashboard);
                            //finish();
                        }
                    },TIME_SPLASH);
                }else{
                    alert("Login ou Senha inválido.");
                }
            }
        });
    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
