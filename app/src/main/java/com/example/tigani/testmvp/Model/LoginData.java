package com.example.tigani.testmvp.Model;

/**
 * Created by tigani on 11/10/2017.
 */

public class LoginData
{
    private String Phonenumber;
    private String Password;

    public LoginData(String phone, String password)
    {
        this.Phonenumber = phone;
        this.Password    = password;
    }


    public String getPhonenumber()
    {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.Phonenumber = phonenumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password)
    {
        this.Password = password;
    }
}
