package com.example.tigani.testmvp.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tigani.testmvp.DashBoard.DashboardActivity;
import com.example.tigani.testmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener{

    Button Login;
    EditText phone,password;
    TextView Registeration;
    LoginContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Views();
        presenter = new Loginpresenter(this);



    }

    private void Views()
    {
        phone = (EditText) findViewById(R.id.editText_phone);
        password = (EditText) findViewById(R.id.editText_pass);
        Login = (Button) findViewById(R.id.button_login);
        Registeration = (TextView) findViewById(R.id.textView_registeration);
        Login.setOnClickListener(this);
        Registeration.setOnClickListener(this);
    }

    @Override
    public void ShowError(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void NavigateToDashboard()
    {
        Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
        startActivity(intent);
        finish();
    }



    @Override
    public void ShowErrorFromServer(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v)
    {
      switch (v.getId())
      {
          case R.id.button_login:
          presenter.LoginUser(phone.getText().toString().trim(),password.getText().toString().trim());
          break;

          case R.id.textView_registeration:
          NavigateToDashboard();
          break;
      }
    }
}
