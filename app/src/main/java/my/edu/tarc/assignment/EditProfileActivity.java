package my.edu.tarc.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditProfileActivity extends AppCompatActivity {
    private EditText editTextName, editTextContactNo, editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextContactNo = (EditText)findViewById(R.id.editTextContactNo);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);

        Intent intent = getIntent();
        editTextName.setText(intent.getStringExtra(SettingsActivity.PROFILE_NAME));
        editTextContactNo.setText(intent.getStringExtra(SettingsActivity.PROFILE_CONTACT_NO));
        editTextEmail.setText(intent.getStringExtra(SettingsActivity.PROFILE_EMAIL));

        Button buttonSave = (Button)findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String contactNo = editTextContactNo.getText().toString();
                String email = editTextEmail.getText().toString();
                finish();
            }
        });
    }
}
