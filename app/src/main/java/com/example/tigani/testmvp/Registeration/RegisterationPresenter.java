package com.example.tigani.testmvp.Registeration;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.tigani.testmvp.Model.ApiClient;
import com.example.tigani.testmvp.Model.ApiServiceRegisteration;
import com.example.tigani.testmvp.Model.RegisterationData;
import com.example.tigani.testmvp.Model.ResgisterationPojo;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by tigani on 11/11/2017.
 */

public class RegisterationPresenter implements RegisterationContract.Presenter
{
    private RegisterationContract.View view;
    private RegisterationData registerationData;
    private ApiServiceRegisteration apiServiceRegisteration;

    public RegisterationPresenter (RegisterationContract.View view)
    {
        this.view = view;
        apiServiceRegisteration = ApiClient.Apiregisteration();
    }

    @Override
    public void ValidateUsers(String name, String phone, String password, String companyname)
    {
        registerationData = new RegisterationData(name,phone,password,companyname);
        if(registerationData.getName().isEmpty()||registerationData.getPhone().isEmpty()||registerationData.getPassword().isEmpty()||registerationData.getCompanyname().isEmpty())
        {
            view.Showemptyfield("Please Fill Empty Field");
        }
        else
        {
            RegisterUsers(registerationData.getName(),registerationData.getPhone(),registerationData.getPassword(),registerationData.getCompanyname());
        }
    }

    @Override
    public void RegisterUsers(String name, String phone, String password, String companyname)
    {
        Call<ResgisterationPojo> call = apiServiceRegisteration.getResponse(name,phone,password,companyname);
        call.enqueue(new Callback<ResgisterationPojo>()
        {
            @Override
            public void onResponse(Call<ResgisterationPojo> call, retrofit2.Response<ResgisterationPojo> response)
            {
                Log.d("tag", "onResponse: "+response.code());
                if(!response.body().isError())
                {
                    view.Showemptyfield(response.body().getErrorMsg());
                }
                else
                {
                    view.NavigationToLogin();
                }
            }
            @Override
            public void onFailure(Call<ResgisterationPojo> call, Throwable t)
            {
                Log.d("tag", "onFailure: "+t.toString());
            }
        });
    }


}
