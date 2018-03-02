package com.example.tigani.testmvp.Model;

import com.example.tigani.testmvp.Registeration.RegisterationActivity;

/**
 * Created by tigani on 11/11/2017.
 */

public class RegisterationData
{
    private String name,password,phone,companyname;

    public RegisterationData(String name, String phone, String password, String companyname)
    {
        this.name        = name;
        this.phone       = phone;
        this.password    = password;
        this.companyname = companyname;
    }

    public RegisterationData(RegisterationActivity registerationActivity)
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
