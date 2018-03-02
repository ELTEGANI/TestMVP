package com.example.tigani.testmvp.Login;



/**
 * Created by tigani on 11/10/2017.
 */

public interface LoginContract
{
    interface  View
    {
        void ShowError(String msg);
        void NavigateToDashboard();
        void ShowErrorFromServer(String msg);
    }

    interface  Presenter
    {
        void LoginUser(String phone,String password);
        void CheckLogin(String phonenumber, String dataFromUserPhonenumber);
    }
}
