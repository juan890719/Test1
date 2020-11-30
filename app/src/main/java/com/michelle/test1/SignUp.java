package com.michelle.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SignUp extends AppCompatActivity {

    private EditText password;
    private EditText account;
    private Intent intent_back;
    private Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        account = findViewById(R.id.account);
        password = findViewById(R.id.password);
        intent_back = new Intent(this,MainActivity.class);
        sign_up = findViewById(R.id.s_u);
        sign_up.setOnClickListener(new View.OnClickListener() {
            private Runnable mutiThread = () -> {
                try {
                    //宣告HTTP連線物件
                    URL url = new URL("http://127.0.0.1/GetData.php");
                    //建立HttpURLConnection物件
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    //設定連線方式為POST
                    connection.setRequestMethod("POST");
                    //允許輸出
                    connection.setDoOutput(true);
                    //允許輸入
                    connection.setDoInput(true);
                    //不使用快取
                    connection.setUseCaches(false);
                    //開始連線
                    connection.connect();

                    //建立取得回應物件

                } catch (Exception e) {

                }
            };

            @Override
            public void onClick(View v) {
                Thread thread = new Thread(mutiThread);
                thread.start();
            }
        });
    }
    public void back(View view){
        startActivity(intent_back);
    }
}