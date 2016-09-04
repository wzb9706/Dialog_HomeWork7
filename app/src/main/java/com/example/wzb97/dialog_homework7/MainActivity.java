package com.example.wzb97.dialog_homework7;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button t1,t2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set();
    }
    private void set(){
        t1=(Button)findViewById(R.id.testDialog1);
        t2=(Button)findViewById(R.id.testDialog2);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setTitle("提示").setMessage("用户名:abc"+'\n'+"密码:123")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View a=View.inflate(MainActivity.this,R.layout.login,null);
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setView(a).setTitle("Login").setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText e1=(EditText)a.findViewById(R.id.name);
                        EditText e2=(EditText)a.findViewById(R.id.password);
                        Log.d("点击", "e1:"+e1.getText().toString()+" e2:"+e2.getText().toString());
                        if(e1.getText().toString().equals("abc")&&e2.getText().toString().equals("123")){
                            Toast.makeText(MainActivity.this,"Login success!",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Wrong name or wrong password!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder.show();
            }
        });
    }
}

