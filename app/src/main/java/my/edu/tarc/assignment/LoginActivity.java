package my.edu.tarc.assignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText)findViewById(R.id.editTextUsername);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        final SharedPreferences pref = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        if (pref.getBoolean("login_key", false)){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        Button buttonSignIn = (Button)findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                if (username.equalsIgnoreCase("admin") && password.equals("admin123")){


                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username", username);
                    editor.putBoolean("login_key", true);
                    editor.apply();

                    Toast.makeText(getApplicationContext(),
                            "Login Successful.",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Oops! Login failed, invalid username or password.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
