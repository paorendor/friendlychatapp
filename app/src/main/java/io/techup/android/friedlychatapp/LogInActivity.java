package io.techup.android.friedlychatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.validator.routines.EmailValidator;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        initView();
    }

    private void initView() {

        final Button btnLogin = (Button) findViewById(R.id.btn_login); 
        final EditText edtEmail = (EditText) findViewById(R.id.edt_email); 
        final EditText edtPassword = (EditText) findViewById(R.id.edt_password); 
        final Button btnRegister = (Button) findViewById(R.id.btn_register); 
        final TextView tvforgotpassword = (TextView) findViewById(R.id.tv_forgotpassword); 



        if (btnLogin != null) {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edtEmail != null) {
                        String email = edtEmail.getText().toString();
                        if (!isValidEmail( email)) {
                            edtEmail.setError("Please Enter your password");
                            return;
                        }
                        if (edtPassword != null) {
                            String password = edtPassword.getText().toString();
                            if (password.length() == 0) {
                                edtPassword.setError("Please enter your password.");
                                return;
                            }

                            if (password.length() < 6) {
                                edtPassword.setError("Please enter at least 6 characters.");
                                return;
                            }
                        }

                        Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
            });
        }


        if (btnRegister != null) {
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
                    startActivity(intent);

                }
            });


        }

        if (tvforgotpassword != null) {
            tvforgotpassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(LogInActivity.this, ForgotPasswordActivity.class);
                    startActivity(intent);
                }
            });
        }

    }

    private boolean isValidEmail(String email) {
        return !email.isEmpty() && EmailValidator.getInstance().isValid(email);
    }

    }


}
