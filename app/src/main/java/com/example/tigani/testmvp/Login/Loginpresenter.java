package com.example.tigani.testmvp.Login;

import android.content.Intent;
import android.util.Log;

import com.example.tigani.testmvp.Model.ApiClient;
import com.example.tigani.testmvp.Model.ApiServiceLogin;
import com.example.tigani.testmvp.Model.LoginData;
import com.example.tigani.testmvp.Model.loginpojo;
import com.example.tigani.testmvp.Registeration.RegisterationActivity;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by tigani on 11/10/2017.
 */

public class Loginpresenter implements LoginContract.Presenter
{
    private LoginContract.View view;
    private LoginData loginData;
    private ApiServiceLogin apiservicelogin;

    public Loginpresenter (LoginContract.View view)
    {
         this.view = view;
         apiservicelogin = ApiClient.Apilogin();
    }

    @Override
    public void LoginUser(String phone, String password)
    {
        loginData = new LoginData(phone,password);
        if(loginData.getPhonenumber().isEmpty() || loginData.getPhonenumber().isEmpty())
        {
            view.ShowError("Empty Field");
        }
        else
        {
            CheckLogin(loginData.getPhonenumber(),loginData.getPhonenumber());
        }
    }

    @Override
    public void CheckLogin(String phonenumber, String Phonenumber)
    {
        Call<loginpojo> call = apiservicelogin.getlogin(phonenumber,Phonenumber);
        call.enqueue(new Callback<loginpojo>()
        {
            @Override
            public void onResponse(Call<loginpojo> call, retrofit2.Response<loginpojo> response)
            {
                if(!response.body().isError())
                {
                    view.NavigateToDashboard();
                }
                else
                {
                    view.ShowErrorFromServer(response.body().getErrorMsg());
                }
            }
            @Override
            public void onFailure(Call<loginpojo> call, Throwable t)
            {
                Log.d("tag", "onFailure: "+t.toString());
            }
        });
    }
}
