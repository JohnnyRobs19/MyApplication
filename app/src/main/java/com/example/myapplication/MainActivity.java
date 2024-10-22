package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView contactNumTextView;
    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    contactNumTextView=findViewById(R.id.textView13);
    updateButton=findViewById(R.id.button);

    updateButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Create an AlertDialog to prompt the user for new contact number
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Update Contact Number");

            // Set up the input field inside the dialog
            final EditText input = new EditText(MainActivity.this);
            input.setInputType(InputType.TYPE_CLASS_PHONE);
            input.setText(contactNumTextView.getText().toString());
            builder.setView(input);

            // Set up the dialog buttons
            builder.setPositiveButton("Save", (dialog, which) -> {
                // Update the contact number TextView with the new value
                String updatedContactNum = input.getText().toString();
                contactNumTextView.setText(updatedContactNum);
            });

            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            // Show the dialog
            builder.show();
        }
    });
    }
}