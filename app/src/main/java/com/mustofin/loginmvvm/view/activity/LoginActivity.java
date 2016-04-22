package com.mustofin.loginmvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mustofin.loginmvvm.R;
import com.mustofin.loginmvvm.databinding.ActivityLoginBinding;
import com.mustofin.loginmvvm.model.ModelUser;
import com.mustofin.loginmvvm.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        viewModel = new LoginViewModel(this);
        binding.setViewmodel(viewModel);
    }
}
