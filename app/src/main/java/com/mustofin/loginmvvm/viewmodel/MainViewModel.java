package com.mustofin.loginmvvm.viewmodel;

import android.content.Context;

import com.mustofin.loginmvvm.model.ModelUser;

/**
 * Created by tofin on 22/04/16.
 */
public class MainViewModel {
    private Context context;
    private ModelUser user;

    public MainViewModel(Context context, ModelUser user) {
        this.context = context;
        this.user = user;
    }

    public String getUsername(){
        return user.username;
    }
    public String getPassword(){
        return user.password;
    }
}
