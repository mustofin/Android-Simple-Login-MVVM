package com.mustofin.loginmvvm.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mustofin.loginmvvm.model.ModelUser;
import com.mustofin.loginmvvm.view.activity.MainActivity;

/**
 * Created by tofin on 21/04/16.
 */
public class LoginViewModel implements ViewModel {
    private Context context;

    public ObservableField<String> loginMessage;
    public ObservableInt loginMessageVisibility;
    private String editTextUsernameValue = "";
    private String editTextPasswordValue = "";

    public LoginViewModel(Context context) {
        this.context = context;
        this.loginMessage = new ObservableField<>("");
        this.loginMessageVisibility = new ObservableInt(View.INVISIBLE);
    }

    public void loginAuthentication(View view){
        if ( (editTextUsernameValue.equals("admin")) && (editTextPasswordValue.equals("ihir"))) {
            loginMessage.set("");
            loginMessageVisibility.set(View.INVISIBLE);
            ModelUser user = new ModelUser(editTextUsernameValue, editTextPasswordValue);
            context.startActivity(MainActivity.newIntent(context, user));

        }else if ( (editTextUsernameValue.equals("")) || (editTextPasswordValue.equals(""))) {
            loginMessage.set("Username or Password can't be empty!");
            loginMessageVisibility.set(View.VISIBLE);

        } else {
            loginMessage.set("Username = admin \n Password = ihir");
            loginMessageVisibility.set(View.VISIBLE);
        }
    }

    public TextWatcher getUsernameUpdate(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextUsernameValue = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
    }

    public TextWatcher getPasswordUpdate(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextPasswordValue= s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
    }

    @Override
    public void destroy() {

    }
}
