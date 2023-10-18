package ca.gbc.assignment1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private TextView textFullName;
    private TextView textStudentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textFullName = findViewById(R.id.textFullName);
        textStudentID = findViewById(R.id.textStudentID);

        // Set text to TextViews using string resources
        textFullName.setText(getString(R.string.about_full_name));
        textStudentID.setText(getString(R.string.about_student_id));
    }
}

