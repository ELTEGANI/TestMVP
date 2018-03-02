package com.example.tigani.testmvp.Registeration;

/**
 * Created by tigani on 11/11/2017.
 */

public interface RegisterationContract
{

   interface View
   {
       void Showemptyfield(String msg);
       void NavigationToLogin();
   }

   interface Presenter
   {
       void ValidateUsers(String name, String phone, String password, String companyname);
       void RegisterUsers(String name, String phone, String password, String companyname);
   }

}
