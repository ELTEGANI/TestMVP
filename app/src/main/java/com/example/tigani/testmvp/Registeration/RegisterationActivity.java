package com.example.tigani.testmvp.Registeration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tigani.testmvp.DashBoard.DashboardActivity;
import com.example.tigani.testmvp.Login.LoginActivity;
import com.example.tigani.testmvp.R;

public class RegisterationActivity extends AppCompatActivity implements RegisterationContract.View,View.OnClickListener
{
    Button register;
    EditText name,password,phone,companyname;
    RegisterationContract.Presenter registerationPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        Views();
        registerationPresenter = new RegisterationPresenter(this);

    }

    public void Views()
    {
        name = (EditText) findViewById(R.id.editText_name);
        password = (EditText) findViewById(R.id.editText_passsword);
        phone = (EditText) findViewById(R.id.editText_phone);
        companyname = (EditText) findViewById(R.id.editText_companyname);
        register = (Button) findViewById(R.id.button_registeration);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
               case R.id.button_registeration:
                registerationPresenter.ValidateUsers(name.getText().toString(),password.getText().toString(),phone.getText().toString(),companyname.getText().toString());
                break;
        }
    }

    @Override
    public void Showemptyfield(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void NavigationToLogin()
    {
        Intent intent = new Intent(RegisterationActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
